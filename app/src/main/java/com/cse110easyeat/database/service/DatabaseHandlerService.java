package com.cse110easyeat.database.service;

import com.cse110easyeat.accountservices.User;

import java.util.ArrayList;

public interface DatabaseHandlerService {
    void connectToDatabase();

    boolean writeToDatabase(final User data);
    ArrayList<User> getDataFromDatabase(final String userId);
}
