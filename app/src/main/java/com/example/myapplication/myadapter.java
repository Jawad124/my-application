package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> {

   private ArrayList<items> mylist;

    public myadapter(ArrayList<items> mylist){

        this.mylist=mylist;
    }



    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rows,parent,false);

        return (viewholder) new  myadapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            items object1 = this.mylist.get(position);
            holder.imgsrc.setImageResource(object1.getimgsrc());
            holder.t1.setText(object1.gettxt1());
            holder.t2.setText(object1.gettxt2());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{
       public ImageView imgsrc;
       public TextView t1;
       public TextView t2;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            imgsrc=itemView.findViewById(R.id.img);


        }
    }
}
