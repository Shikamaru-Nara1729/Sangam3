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

public class tourAdapter extends RecyclerView.Adapter<tourAdapter.MyViewHolder1> {

    private Context context;
    private ArrayList<Tour_accessor> mlist1;

    public tourAdapter(Context context, ArrayList<Tour_accessor> list) {
        this.context = context;
        mlist1 = list;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view1 = layoutInflater.inflate(R.layout.display_card, viewGroup, false);
        MyViewHolder1 viewHolder1 = new MyViewHolder1(view1);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder1 viewHolder1, int i) {
        Tour_accessor tour_items = mlist1.get(i);

        ImageView image1 = viewHolder1.img;
        TextView text1 = viewHolder1.txt;
        TextView info = viewHolder1.info;
        image1.setImageResource(tour_items.getImage1());
        text1.setText(tour_items.getName1());
        info.setText(tour_items.getInfo());
    }

    @Override
    public int getItemCount() {
        return mlist1.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView info;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.info_img);
            txt = itemView.findViewById(R.id.info_title);
            info = itemView.findViewById(R.id.info_text);
        }
    }

}