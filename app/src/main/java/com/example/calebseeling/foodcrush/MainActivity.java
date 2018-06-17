package com.example.calebseeling.foodcrush;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public generater_bar mGenerater_bar;
    private GoogleMap mMap;
    public static String TAG = "MainActivity";
    private Button Button_Create;

    private ListView listview;
    private ArrayAdapter<generater_bar> adapter;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   Button_Create = (Button) findViewById(R.id.Button_Create);


      // Button_Create.setOnClickListener(new View.OnClickListener() {
      //     @Override
      //     public void onClick(View v) {
      //         Intent intent = new Intent(MainActivity.this, custom_handler.class);
      //         startActivity(intent);


      //     }
      // });

        setSupportActionBar(toolbar);
        ArrayList<generater_bar> arrayList = new ArrayList<>();
  final generater_bar generater = new generater_bar("Adrian" , "COla" , 5 , "13.42803809999998", "52.5480293");
      //  listview = (ListView) findViewById(R.id.listview);

        adapter = new ArrayAdapter<generater_bar>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                generater_bar name = (generater_bar) adapterView.getItemAtPosition(i);
                String wanted = (String) generater.getWanted();
                int payment = (int) generater.getPayment();
                String longitude = (String) generater.getLongitude();
                String latitude = (String) generater.getLatitude();
                Log.d(TAG, "onItemClick: You Clicked on ee" + name.getName() + i);
                Intent intent = new Intent(MainActivity.this , custom_handler.class);
                intent.putExtra("name" , name.getName());
                intent.putExtra("wanted" , wanted);
                intent.putExtra("payment" , payment);
                intent.putExtra("longitude" , longitude);
                intent.putExtra("latitude" , latitude);
                startActivity(intent);
            }
        });
        Log.d(TAG, "Gnerater" + mGenerater_bar.getName());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_anzeige) {
            Intent intent = new Intent(this, Anzeige.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.nav_profil) {
            Intent intent = new Intent(this, Profil.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.nav_cool) {
            Intent intent = new Intent(this, Cool.class);
            startActivity(intent);
        }

        item.setCheckable(false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

  }
