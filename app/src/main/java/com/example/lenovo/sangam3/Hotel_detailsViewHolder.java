package com.example.lenovo.sangam3;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class Hotel_detailsViewHolder extends ChildViewHolder {

    public TextView details1, details2;

    public Hotel_detailsViewHolder(View itemView) {
        super(itemView);

        details1 = (TextView)itemView.findViewById(R.id.text1);
        details2 = (TextView)itemView.findViewById(R.id.text2);
    }
}
