package com.example.calebseeling.foodcrush;

import android.content.Intent;
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
    private static final LatLng Erichweinert = new LatLng(52.5480293, 13.42803809999998);
    private static final LatLng Dunckerstraße4 = new LatLng(52.54103, 13.420150000000035);
    private static final LatLng Alexanderplatz = new LatLng(52.5219184, 13.413214700000026);
    private static final LatLng Hufelandstraße100 = new LatLng(52.5296989, 13.437045200000057);
    private Button Button_Create;
    private Marker mErichweinert;
    private Marker mDunckerstraße4;
    private Marker mAlexanderplatz;
    private Marker mHufelandstraße100;
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

        Intent intent = getIntent();
        String name = intent.getCharExtra() ;

        Cash.setText(Payment + "");
        Wanted.setText(generater_bar.getWanted());
















    }
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        // Add some markers to the map, and add a data object to each marker.
        mHufelandstraße100 = mMap.addMarker(new MarkerOptions()
                .position(Hufelandstraße100)
                .title("Perth"));
        mErichweinert = mMap.addMarker(new MarkerOptions()
                .position(Erichweinert)
                .title("Perth"));
        mAlexanderplatz = mMap.addMarker(new MarkerOptions()
                .position(Alexanderplatz)
                .title("Perth"));
        mDunckerstraße4 = mMap.addMarker(new MarkerOptions()
                .position(Dunckerstraße4)
                .title("Perth"));


    }
}
