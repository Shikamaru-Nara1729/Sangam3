package com.example.lenovo.sangam3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapterHelper;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class hotelAdapter extends ExpandableRecyclerAdapter<ModelhotelViewHolder, Hotel_detailsViewHolder> {
      private Context context;
      private ArrayList<Modelhotel> mlist;

      LayoutInflater inflater;

    public hotelAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ModelhotelViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.listview_layout, viewGroup, false);
        return new ModelhotelViewHolder(view);
    }

    @Override
    public Hotel_detailsViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.hotel_child_view, viewGroup, false);
        return new Hotel_detailsViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ModelhotelViewHolder modelhotelViewHolder, int i, Object o) {

        Modelhotel hotelitems = (Modelhotel)o;

        ImageView image = modelhotelViewHolder.image;
        TextView text = modelhotelViewHolder.txt;

        image.setImageResource(hotelitems.getImage());
        text.setText(hotelitems.getName());

    }

    @Override
    public void onBindChildViewHolder(Hotel_detailsViewHolder hotel_detailsViewHolder, int i, Object o) {

        Hotel_details items = (Hotel_details)o;

        TextView text = hotel_detailsViewHolder.details1;
        TextView text2 = hotel_detailsViewHolder.details2;
        text.setText(items.getDetail1());
        text2.setText(items.getDetail2());

    }

}
