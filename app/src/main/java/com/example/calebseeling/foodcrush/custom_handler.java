package com.example.calebseeling.foodcrush;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by calebseeling on 16.06.18.
 */

public class custom_handler extends AppCompatActivity implements OnMapReadyCallback {

    private TextView Name;
    private TextView Info;
    private TextView Wanted;
    private TextView Cash;
    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
    private Button Button_Create;
    private Marker mPerth;
    private MapFragment mMapFragment;
    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_handler_page);

        Cash = (TextView) findViewById(R.id.Cash);
        Wanted = (TextView) findViewById(R.id.Wanted);
       int Payment = generater_bar.getPayment();

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        Cash.setText(Payment + "");
        Wanted.setText(generater_bar.getWanted());
















    }
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        // Add some markers to the map, and add a data object to each marker.
        mPerth = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .title("Perth"));


    }
}
