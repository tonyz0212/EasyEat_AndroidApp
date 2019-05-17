package com.cse110easyeat.api.service;

import com.cse110easyeat.easyeat;
import android.permission.INTERNET;
import com.squareup.okhttp.*;

import com.cse110easyeat.easyeat.BuildConfig;
import android.content.Context;
import android.util.Log;


public class GooglePlacesAPIServices implements APIHandlerService {
    private static final String TAG = "GooglePlacesAPIServices";

    private static final String apiRequestURL = "https://maps.googleapis.com/maps/api/place" +
            "/textsearch/json?&query=%s&key=%s&location=%f,%f&radius=%f";

    public void initializeAPIClient() {

    }

    // add minprice, maxprice opennow
    // Check if price is an option
    public String getRestaurantInfo(String queryString, int minPrice, int maxPrice,
                                    float latitude, float longitude, float radius) {
        String result = "";
        /* Replace whitespace with plus buttons */
        String modifiedQueryString = queryString.replaceAll("\\s+","+");
        String url = String.format(apiRequestURL, queryString, BuildConfig.PLACES_API_KEY,
                latitude, longitude, radius);

        if (minPrice > 0 && minPrice <= 4) {
            url += "&minPrice=";
            url += minPrice;
        }

        if (maxPrice > 0 && maxPrice <= 4) {
            url += "&maxPrice=";
            url += maxPrice;
        }

        // Send the payload
//        try {
//            Request apiRequest = new Request.Builder().url(url).build();
//            Response apiResponse = apiClientHandler.newCall(apiRequest).execute();
//            result = apiResponse.body().toString();
//            Log.i(TAG, "Api call result" + result);
//        } catch(Exception e) {
//            Log.e(TAG, "Exception when calling api" + e.toString());
//        }

        return result;
    }


}
