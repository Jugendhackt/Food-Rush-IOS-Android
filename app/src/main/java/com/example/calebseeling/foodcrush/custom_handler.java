package com.example.calebseeling.foodcrush;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by calebseeling on 16.06.18.
 */

public class custom_handler extends AppCompatActivity {
    private TextView Name;
    private TextView Info;
    private TextView Wanted;
    private TextView Cash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_handler_page);

        Cash = (TextView) findViewById(R.id.Cash);
        Wanted = (TextView) findViewById(R.id.Wanted);
       int Payment = generater_bar.getPayment();


        Cash.setText(Payment + "");
        Wanted.setText(generater_bar.getWanted());
















    }
}
