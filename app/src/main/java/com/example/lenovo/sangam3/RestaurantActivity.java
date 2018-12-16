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
import android.widget.LinearLayout;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    RecyclerView recyclerView;
    ArrayList<Modelres> modelres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);

        dl = (DrawerLayout) findViewById(R.id.dl);
        ActionBarDrawerToggle ABT;
        ABT = new ActionBarDrawerToggle(this, dl, tb, R.string.open, R.string.close);

        dl.addDrawerListener(ABT);
        ABT.syncState();

        recyclerView = findViewById(R.id.recyclerview);

        modelres = new ArrayList<>();

        modelres.add(new Modelres(R.drawable.food, "Chechis Restaurant", "Address: MNNIT Allahabad Campus, Teliarganj, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food1, "Rajashi Restaurant", "Address: Shantipuram Awas Yojna, Sector-F, Shantipuram Rd, Phaphamau, Near Rapid Action Force Campus, Allahabad, Uttar Pradesh 211013"));
        modelres.add(new Modelres(R.drawable.food2, "Tripathi Restaurant", "Address: IIIT Chauraha, Indian Institute of Information Technology, Jhalwa, Allahabad, Uttar Pradesh 211011"));
        modelres.add(new Modelres(R.drawable.food3, "New jyoti Restaurant", "Address: 3B, Azad Market, Teliyarganj, Allahabad, Uttar Pradesh 211004"));
        modelres.add(new Modelres(R.drawable.food4, "Millenium Restaurant", "Address: 169/2, Teliyerganj, Allahabad, Allahabad, Uttar Pradesh 211004"));
        modelres.add(new Modelres(R.drawable.food5, "Friendz corner", "Address: INFRONT OF SBI MNNIT(JAMUNA GATE), SH 9, Barrister Mullah Colony, Rasulabad, Teliarganj, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food7, "Blackout Restaurant", "Address: Barrister Mullah Colony, Teliarganj, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food8, "Temptation Ultimate", "Address: 15 Katra Road Balrampur House, Allahabad, Uttar Pradesh 221004"));
        modelres.add(new Modelres(R.drawable.food9, "Aahar Restaurant", "Address: 76/4A, Stanley Rd, Kamla Nagar, Civil Lines, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food10, "Devanshi Resataurant", "Address: Master Zahurul Hasan Rd, Old Katra, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food11, "Rishiraj Restaurant", "Address: Allahabad,, Allahabad University, Old Katra, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food12, "Kalika Hotel", "Address: Old Katra, Allahabad, Uttar Pradesh 211002"));
        modelres.add(new Modelres(R.drawable.food13, "Yadav Restaurant", "Address: Katra, Allahabad, Uttar Pradesh 211002"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayouManager = linearLayoutManager;
        recyclerView.setLayoutManager(rvLiLayouManager);

        resAdapter adapter = new resAdapter(this, modelres);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        switch (Item.getItemId()) {
            case R.id.hotels:
                Intent intent1 = new Intent(this, HotelsActivity.class);
                startActivity(intent1);
                break;
            case R.id.res:
                Intent intent3 = new Intent(this, RestaurantActivity.class);
                startActivity(intent3);
                break;
            case R.id.tour:
                Intent intent2 = new Intent(this, TourActivity.class);
                startActivity(intent2);
                break;
            case R.id.about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
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
