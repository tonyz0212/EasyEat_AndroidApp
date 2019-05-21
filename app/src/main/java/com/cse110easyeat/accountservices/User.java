package com.cse110easyeat.accountservices;

public class User {
    String userId;
    String email;
    String password;
    String firstName;
    String lastName;
//    String[] favoriteRestaurants;

    public String firstName() {
        return firstName;
    }
    public String getId() {
        return userId;
    }
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getLastName() {return lastName;}
}
