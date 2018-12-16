package com.example.lenovo.sangam3;

public class Modelres {
    private int image;
    private String name;
    private String location;

    public Modelres(int image, String name, String location) {
        this.image = image;
        this.name = name;
        this.location = location;

    }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

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
}
