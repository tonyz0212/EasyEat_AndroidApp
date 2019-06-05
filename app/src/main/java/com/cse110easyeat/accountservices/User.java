package com.cse110easyeat.accountservices;

public class User {
    String userId;
    String email;
    String password;
    String fullName;
//    String[] favoriteRestaurants;

    public User(String email, String password, String fullName) {
        String modifiedEmailStr = email.replaceAll(".","_");
        this.userId = modifiedEmailStr;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    // Empty default ctor for Firebase
    public User() {}

    public String getId() {
        return userId;
    }
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getFullName() {return fullName;}
}
