package com.example.lenovo.sangam3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class resAdapter extends RecyclerView.Adapter<resAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Modelres> mlist;

    public resAdapter(Context context, ArrayList<Modelres> list) {
        this.context = context;
        mlist = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_res_items, viewGroup, false);

        MyViewHolder viewHolder = new MyViewHolder(view);


        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, int i) {

        Modelres resitems = mlist.get(i);

        ImageView image = viewHolder.img;
        TextView text = viewHolder.txt;
        TextView text1 = viewHolder.txt1;

        image.setImageResource(resitems.getImage());
        text.setText(resitems.getName());
        text1.setText(resitems.getLocation());


    }

    //@Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txt1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
            txt1 = itemView.findViewById(R.id.txt1);


        }
    }

}
