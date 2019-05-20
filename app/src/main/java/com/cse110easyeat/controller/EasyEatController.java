package com.cse110easyeat.controller;

import android.content.Context;

import com.cse110easyeat.api.service.APIHandlerService;
import com.cse110easyeat.api.service.GooglePlacesAPIServices;
import com.cse110easyeat.database.injector.DatabaseHandlerInjector;
import com.cse110easyeat.database.service.DatabaseHandlerService;
import com.cse110easyeat.database.service.FirebaseHandlerService;
import com.cse110easyeat.database.injector.FirebaseHandlerInjector;

/* Weave the API and Database together */
public class EasyEatController {
    private DatabaseHandlerService databaseService;
    // TODO: Take care of the API injectors
    private APIHandlerService apiService;
    private static final String TAG = "EasyEatController";

    /* Constructors - use the corresponding injectors */
    public EasyEatController(Context ctx) {
        // Replace this injector if need to change
        DatabaseHandlerInjector dbInjector = new FirebaseHandlerInjector();
        databaseService = dbInjector.getDataBaseHandlerService();
        // Injector for API handler
        apiService = new GooglePlacesAPIServices();
        apiService.initializeAPIClient(ctx);
    }

    // Login function that verifies information


    // Display




}
