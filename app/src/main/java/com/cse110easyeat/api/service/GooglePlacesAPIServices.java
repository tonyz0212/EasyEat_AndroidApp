package com.cse110easyeat.api.service;

import com.android.volley.toolbox.Volley;
import com.cse110easyeat.easyeat;
import android.permission.INTERNET;

import com.cse110easyeat.easyeat.BuildConfig;
import com.cse110easyeat.easyeat.MainActivity;
import android.content.Context;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class GooglePlacesAPIServices implements APIHandlerService {
    private PlacesClient googleClient;
    private Context context;


    public void initializeAPI(Context applicationContext) {
        // TODO:HARD CODING THE API KEY
        context = applicationContext;
        Places.initialize(applicationContext, BuildConfig.PLACES_API_KEY);
        googleClient = Places.createClient(context);
    }

    public String getRestaurantInfo() {
        String result = "";

        int price = 2;
        float miles = 2f;

        float metersPerMile = 1609.34f;

        RequestQueue queue = Volley.newRequestQueue(context).;
        String url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/output?parameters";

        return result;
    }


}
