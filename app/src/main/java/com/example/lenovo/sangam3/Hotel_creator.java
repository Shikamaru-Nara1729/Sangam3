package com.example.lenovo.sangam3;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Hotel_creator {

    static Hotel_creator hotel_creator;
    List<Modelhotel> motel;

    public Hotel_creator(Context context) {
        motel = new ArrayList<>();
        /*
        for(int i = 0; i < 100; i++)
        {
            Modelhotel modelhotel = new Modelhotel(R.drawable.milanpalace, "Hotel Milan Palace", "3.9");
            motel.add(modelhotel);
        }
        */
        motel.add(new Modelhotel(R.drawable.milanpalace, "Hotel Milan Palace"));
        motel.add(new Modelhotel(R.drawable.kanhashyam, "Hotel Kanha Shyam"));
        motel.add(new Modelhotel(R.drawable.vilas, "Hotel vilas"));
        motel.add(new Modelhotel(R.drawable.harshananda, "Hotel Harsh Ananda"));
        motel.add(new Modelhotel(R.drawable.legend, "The Legend Hotel"));
        motel.add(new Modelhotel(R.drawable.polomax, "Hotel Polo Max"));
        motel.add(new Modelhotel(R.drawable.vaishali, "Hotel Vaishali"));
        motel.add(new Modelhotel(R.drawable.yatrik, "Hotel Yatrik"));
        motel.add(new Modelhotel(R.drawable.dpsinn, "Hotel DPS Inn"));
        motel.add(new Modelhotel(R.drawable.mandiram, "Hotel Mandiram"));
        motel.add(new Modelhotel(R.drawable.grandcontinental, "Grand Continental Hotel"));
        motel.add(new Modelhotel(R.drawable.prayag, "Prayag Hotel"));
        motel.add(new Modelhotel(R.drawable.kashi, "Hotel Kashi"));
        motel.add(new Modelhotel(R.drawable.crownpalace, "Hotel Crown Palace"));
        motel.add(new Modelhotel(R.drawable.milanaboutiquehotel, "Milan A-Boutique Hotel"));
        motel.add(new Modelhotel(R.drawable.saket, "Hotel saket"));
    }

    public static Hotel_creator get(Context context)
    {
        if(hotel_creator == null)
            hotel_creator = new Hotel_creator(context);
        return hotel_creator;
    }

    public List<Modelhotel> getAll() {
        return motel;
    }
}
