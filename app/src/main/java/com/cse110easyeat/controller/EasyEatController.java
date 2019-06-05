package com.cse110easyeat.controller;

import android.content.Context;
import android.util.Log;

import com.cse110easyeat.accountservices.User;
import com.cse110easyeat.api.service.APIHandlerService;
import com.cse110easyeat.api.service.GooglePlacesAPIServices;
import com.cse110easyeat.database.injector.DatabaseHandlerInjector;
import com.cse110easyeat.database.service.DatabaseHandlerService;
import com.cse110easyeat.database.service.FirebaseHandlerService;
import com.cse110easyeat.database.injector.FirebaseHandlerInjector;

import java.util.ArrayList;

/* Weave the API and Database together */
public class EasyEatController {
    private DatabaseHandlerService databaseService;
    // TODO: Take care of the API injectors
    private APIHandlerService apiService;
    private static final String TAG = "EasyEatController";

    /* Constructors - use the corresponding injectors */
    public EasyEatController(Context ctx) {
        apiService = new GooglePlacesAPIServices();
        apiService.initializeAPIClient(ctx);
        // Replace this injector if need to change
        DatabaseHandlerInjector dbInjector = new FirebaseHandlerInjector();
        databaseService = dbInjector.getDataBaseHandlerService();
        databaseService.connectToDatabase();
    }

    // Login function that verifies information
    public boolean loginUser(String email, String password) {
        boolean loginState = false;
        String modifiedEmailStr = email.replaceAll(".","_");
        ArrayList<User> res = databaseService.getDataFromDatabase(modifiedEmailStr);
        if (res.isEmpty()) {
            Log.d(TAG, "Email not recorded inside the database");
            // TODO: SEND A PROMPT TO THE USER TO SIGNUP
        } else {
            Log.d(TAG, "Found match");
            if (res.get(0).getPassword().equals(password)) {
                Log.d(TAG, "Password matches - user should be logged in");
                loginState = true;
                // TODO: log in the user
            } else {
                Log.d(TAG, "Password does not match - prompt the user to try again");
                // TODO: SEND THE USER AN INVALID EMAIL OR PASSWORD
            }
        }
        return loginState;
    }

    // Display
    public void registerUser(String email, String password, String fullName) {
        User newUser = new User(email, password, fullName);
        databaseService.writeToDatabase(newUser);
        Log.d(TAG, "Registered a new user");
    }



}
