package com.example.lenovo.sangam3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

public class ModelhotelViewHolder extends ParentViewHolder {

    ImageView image;
    TextView txt;
    TextView txt1;


    public ModelhotelViewHolder(View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.img);
        txt = itemView.findViewById(R.id.txt);
        txt1 = itemView.findViewById(R.id.txt1);

    }
}
