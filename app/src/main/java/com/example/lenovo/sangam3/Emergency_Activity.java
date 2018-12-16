package com.example.lenovo.sangam3;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Emergency_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String[] contacts = {"Police", "Ambulance", "Fire Brigade"};
    DrawerLayout dl;
    String [] numbers = {"9012513090", "9936707796", "7521097192"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_activity);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        tb.setTitle("Emergency");
        setSupportActionBar(tb);

        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);


        dl = (DrawerLayout) findViewById(R.id.dl);
        ActionBarDrawerToggle ABT;
        ABT = new ActionBarDrawerToggle(this, dl, tb, R.string.open, R.string.close);

        dl.addDrawerListener(ABT);
        ABT.syncState();

        final ListView listView = (ListView) findViewById(R.id.contact_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String number = "tel:" + numbers[position];
                 Intent intent = new Intent(Intent.ACTION_CALL);
                 intent.setData(Uri.parse(number));
                if (ActivityCompat.checkSelfPermission(Emergency_Activity.this,  Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
        }
    });
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
