package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.Inflater;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> implements Filterable {

   private ArrayList<items> mylist;
   private ArrayList<items> backuplist=new ArrayList<>();

    public myadapter(ArrayList<items> mylist){

        this.mylist=mylist;
        this.backuplist.addAll(mylist);
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

    @Override
    public Filter getFilter() {
        return itemsfilter;
    }
    private Filter itemsfilter =  new Filter() {
        //it runs on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<items> templist = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                templist.addAll(backuplist);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (items loop : backuplist) {
                    if (loop.gettxt1().contains(filter)) {
                        templist.add(loop);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = templist;
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mylist.clear();
            mylist.addAll((Collection<? extends items>) results.values);
            notifyDataSetChanged();
        }
    };
    class viewholder extends RecyclerView.ViewHolder{
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
