package com.example.lenovo.sangam3;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

public class HotelsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    String [] number = {"Phone: 0532 242 1505", "Phone: 0532 256 0123", "Phone: 093693 52682", "Phone: 099845 02097", "Phone: 070803 05807", "Phone: 0532 256 1000", "Phone: 096958 96531", "Phone: 0532 226 0921", "Phone: 0532 242 0888", "Phone: 080093 77116", "Phone: 0532 226 0631", "Phone: 0532 265 6329", "Phone: 0532 240 0812", "Phone: 087654 28707", "Phone: 0532 240 3777", "Phone: 0532 242 7677"};
    String [] address = {"Address: 4/2, Govind Tower, Stretchy Rd, Civil Lines, Allahabad, Uttar Pradesh 211003", "Address: Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: 22C, S.P. Marg, Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: # 118/16, Mahatma Gandhi Marg, Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: 23C, Thornhill Road, Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: Multi Functional Complex , Civil Lines, Railway Station Compound, Allahabad, Uttar Pradesh 211001", "Address: 72 Near Sulaki Chauraha, Bahadurganj, Allahabad, Uttar Pradesh 211003", "Address: 33 Sardar Patel Marg, Gayatripuram Colony, Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: 70 G /55A /3 Lohia marg,Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: 163/144, South Malaka road, Rambagh, Near Hanuman Mandir Crossing, Allahabad, Uttar Pradesh 211001", "Address: 13, Sardar Patel Marg, Near PVR Cinemas, Civil Lines, Allahabad, Uttar Pradesh 211001", "Address: 73,, Noorullah Rd, Allahabad, Uttar Pradesh 211003", "Address: No.74-A, Johnstonganj, Kamla Nehru Rd, Opposite City Post Office, Allahabad, Uttar Pradesh 211003", "Address: 160 Hewett Road, Rambagh, Near Hanuman Temple, Allahabad, Uttar Pradesh 211003", "Address: 46, Leader Rd, Miurabad, Allahabad, Uttar Pradesh 211003", "Address: Unnamed Road, Civil Lines, Allahabad, Uttar Pradesh 211001"};

    private DrawerLayout dl;
    RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(Bundle outstate)
    {
        super.onSaveInstanceState(outstate);
        ((hotelAdapter)recyclerView.getAdapter()).onSaveInstanceState(outstate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("Hotels");
        setSupportActionBar(tb);

        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);

        dl = (DrawerLayout) findViewById(R.id.dl);
        ActionBarDrawerToggle ABT;
        ABT = new ActionBarDrawerToggle(this, dl, tb, R.string.open, R.string.close);

        dl.addDrawerListener(ABT);
        ABT.syncState();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hotelAdapter adapter = new hotelAdapter(this, initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);

    }

    private List<ParentObject> initData() {
        Hotel_creator hotel_creator = Hotel_creator.get(this);
        List<Modelhotel> modelhotels = hotel_creator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();
        /*
        hotel_details.add(new Hotel_details("Address: 4/2, Govind Tower, Stretchy Rd, Civil Lines, Allahabad, Uttar Pradesh 211003", "Phone: 0532 242 1505"));1
        hotel_details.add(new Hotel_details("Address: Civil Lines, Allahabad, Uttar Pradesh 211001", "Phone: 0532 256 0123"));2
        hotel_details.add(new Hotel_details("Address: 22C, S.P. Marg, Civil Lines, Allahabad, Uttar Pradesh 211001", ));
        hotel_details.add(new Hotel_details("Address: # 118/16, Mahatma Gandhi Marg, Civil Lines, Allahabad, Uttar Pradesh 211001", ));
        hotel_details.add(new Hotel_details("Address: 23C, Thornhill Road, Civil Lines, Allahabad, Uttar Pradesh 211001", ));
        hotel_details.add(new Hotel_details("Address: Multi Functional Complex , Civil Lines, Railway Station Compound, Allahabad, Uttar Pradesh 211001", ))
        hotel_details.add(new Hotel_details("Address: 72 Near Sulaki Chauraha, Bahadurganj, Allahabad, Uttar Pradesh 211003", ))
        hotel_details.add(new Hotel_details("Address: 33 Sardar Patel Marg, Gayatripuram Colony, Civil Lines, Allahabad, Uttar Pradesh 211001", ));
        hotel_details.add(new Hotel_details("Address: 70 G /55A /3 Lohia marg,Civil Lines, Allahabad, Uttar Pradesh 211001", ))
        hotel_details.add(new Hotel_details("Address: 163/144, South Malaka road, Rambagh, Near Hanuman Mandir Crossing, Allahabad, Uttar Pradesh 211001", ));
        hotel_details.add(new Hotel_details("Address: 13, Sardar Patel Marg, Near PVR Cinemas, Civil Lines, Allahabad, Uttar Pradesh 211001", ))
        hotel_details.add(new Hotel_details("Address: 73,, Noorullah Rd, Allahabad, Uttar Pradesh 211003", ))
        hotel_details.add(new Hotel_details("Address: No.74-A, Johnstonganj, Kamla Nehru Rd, Opposite City Post Office, Allahabad, Uttar Pradesh 211003", "Address: 160 Hewett Road, Rambagh, Near Hanuman Temple, Allahabad, Uttar Pradesh 211003", ))
        hotel_details.add(new Hotel_details("Address: 46, Leader Rd, Miurabad, Allahabad, Uttar Pradesh 211003", ));
        hotel_details.add(new Hotel_details("Address: Unnamed Road, Civil Lines, Allahabad, Uttar Pradesh 211001", ));
        */
        int i = 0;
        for(Modelhotel modelhotel: modelhotels)
        {
            List<Object> hotel_details = new ArrayList<>();
            hotel_details.add(new Hotel_details(address[i], number[i]));
            modelhotel.setChildObjectList(hotel_details);
            parentObjects.add(modelhotel);
            i++;
        }
        return parentObjects;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        switch (Item.getItemId()) {
            case R.id.hotels:
                Intent intent = new Intent(this, HotelsActivity.class);
                startActivity(intent);
                break;
            case R.id.res:
                Intent intent1 = new Intent(this, RestaurantActivity.class);
                startActivity(intent1);
                break;
            case R.id.tour:
                Intent intent2 = new Intent(this, TourActivity.class);
                startActivity(intent2);
                break;
            case R.id.about:
                Intent intent3 = new Intent(this, AboutActivity.class);
                startActivity(intent3);
                break;
            case R.id.emergency:
                Intent intent4 = new Intent(this, Emergency_Activity.class);
                startActivity(intent4);
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
