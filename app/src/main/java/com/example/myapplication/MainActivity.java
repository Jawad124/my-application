package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private myadapter madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<items> items_objects = new ArrayList<>();
        items_objects.add(new items(R.drawable.ic_android,"jawad","good"));
        items_objects.add(new items(R.drawable.ic_android,"rehan","good"));
        items_objects.add(new items(R.drawable.ic_android,"atif","good"));
        items_objects.add(new items(R.drawable.ic_android,"asghar","good"));
        items_objects.add(new items(R.drawable.ic_android,"shaloom","good"));
        items_objects.add(new items(R.drawable.ic_android,"arham","good"));
        items_objects.add(new items(R.drawable.ic_android,"basit","good"));
        items_objects.add(new items(R.drawable.ic_android,"ronaldo","good"));

        RecyclerView recycle_list = findViewById(R.id.rc);
        recycle_list.setLayoutManager(new LinearLayoutManager(this));
         madapter =new myadapter(items_objects);
        recycle_list.setAdapter(madapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem items = menu.findItem(R.id.searchView);

        android.widget.SearchView searchView = (android.widget.SearchView) items.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_GO);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                madapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }
}
