package com.example.lenovo.sangam3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    RecyclerView recyclerView;
    ArrayList<Tour_accessor> tour;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_tour);

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

        tour = new ArrayList<>();

        tour.add(new Tour_accessor(R.drawable.mkm_temple, "Mankameshwar Mandir","Believed to be the site where Sita " +
                "worshipped Lord Shiva during the exile period, this Ram-built temple is a must-visit for a Kumbh-darshan enthusiast"));
        tour.add(new Tour_accessor(R.drawable.pvr, "Civil Lines","Experience the bliss of a cty life in tis religious city" +
                "of Allahabad where one can find a wide variety of brands and names."));
        tour.add(new Tour_accessor(R.drawable.khusro_bagh, "Khusro Bagh","Being just a little away from the " +
                "railway sation of Allahabad, this park has many stone structures with intricate carving and brethtaking symmetry"));
        tour.add(new Tour_accessor(R.drawable.anand_bhawan, "Anand Bhawan","This is a must-see for anyone interested in understanding" +
                "the history of the place and also sports a classy lawn to gaze at."));
        tour.add(new Tour_accessor(R.drawable.fort, "Allahabad Fort","Believed to have been built by Akbar, this huge stone fort" +
                "is a huge attarction amongst the tourist. And it is located close to Sangam."));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayouManager = linearLayoutManager;
        recyclerView.setLayoutManager(rvLiLayouManager);

        tourAdapter adapter = new tourAdapter(this, tour);

        recyclerView.setAdapter(adapter);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        switch (Item.getItemId()) {
            case R.id.home:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.hotels:
                Intent intent1 = new Intent(this, HotelsActivity.class);
                startActivity(intent1);
                break;
            case R.id.res:
                Intent intent3 = new Intent(this, RestaurantActivity.class);
                startActivity(intent3);
                break;
            case R.id.tour:
                Intent intent4 = new Intent(this, TourActivity.class);
                startActivity(intent4);
                // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TourFragment()).commit();
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
