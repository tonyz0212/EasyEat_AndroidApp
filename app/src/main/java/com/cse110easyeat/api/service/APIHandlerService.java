package com.cse110easyeat.api.service;

public interface APIHandlerService {
    // Initializer
    void initializeAPIHandler();

    // Spit out the whole API call result
    String getRestaurantInfo();

    // Perform a call
}

