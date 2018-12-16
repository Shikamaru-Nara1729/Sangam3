package com.example.lenovo.sangam3;

public class Tour_accessor {
    private int image1;
    private String name1;
    private String info;

    public Tour_accessor(int image1, String name1,String info) {
        this.image1 = image1;
        this.name1 = name1;
        this.info=info;
     }
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getInfo(){ return info;}
}

