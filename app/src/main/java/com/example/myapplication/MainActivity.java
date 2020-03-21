package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<items> items_objects = new ArrayList<>();
        items_objects.add(new items(R.drawable.ic_android,"heading 1","good"));
        items_objects.add(new items(R.drawable.ic_android,"heading 2","good"));
        items_objects.add(new items(R.drawable.ic_android,"heading 3","good"));
        items_objects.add(new items(R.drawable.ic_android,"heading 4","good"));

        RecyclerView recycle_list = findViewById(R.id.rc);
        recycle_list.setLayoutManager(new LinearLayoutManager(this));
        recycle_list.setAdapter(new myadapter(items_objects));
    }
}
