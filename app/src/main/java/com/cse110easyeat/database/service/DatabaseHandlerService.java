package com.cse110easyeat.database.service;

import java.util.ArrayList;

public interface DatabaseHandlerService {
    void connectToDatabase();

    boolean writeToDatabase(final User data);
    ArrayList<User> getDataFromDatabase(final String userName);
}
