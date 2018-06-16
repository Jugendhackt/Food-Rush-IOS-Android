package com.example.calebseeling.foodcrush;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by calebseeling on 16.06.18.
 */

    public class Server_databse {
    private static final String TAG = "Server_databse";
    // Create URL
    URL githubEndpoint = new URL("http://151.216.9.33:3000/bestellungen");

    // Create connection
    HttpURLConnection myConnection =
            (HttpURLConnection) githubEndpoint.openConnection();


    public Server_databse() throws IOException {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                myConnection.setRequestProperty("Accept",
                        "application/vnd.github.v3+json");
                myConnection.setRequestProperty("Contact-Me",
                        "hathibelagal@example.com");
                try {
                    if (myConnection.getResponseCode() == 200) {
                        InputStream responseBody = null;
                        try {
                            responseBody = myConnection.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            InputStreamReader responseBodyReader =
                                    new InputStreamReader(responseBody, "UTF-8");
                            JsonReader jsonReader = new JsonReader(responseBodyReader);
                            jsonReader.beginArray(); // Start processing the JSON object
                            while (jsonReader.hasNext()) { // Loop through all keys


Log.d(TAG,"Hi:" + jsonReader.nextString());


                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                       Log.d(TAG, "Error");
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        });

    }


}


