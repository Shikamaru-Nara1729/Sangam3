package com.example.lenovo.sangam3;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

public class Modelhotel implements ParentObject {
    private int image;
    private String name;
    private UUID id;
    private List<Object> mchildrenlist;

    public UUID getId() {
        return id;
    }


    public Modelhotel(int image, String name) {
        this.image = image;
        this.name = name;
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mchildrenlist;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mchildrenlist = list;

    }
}
