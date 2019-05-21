package com.cse110easyeat.accountservices;

public class User {
    String userId;
    String email;
    String password;
    String firstName;
    String lastName;
//    String[] favoriteRestaurants;

    public User(String email, String password, String firstName, String lastName) {
        String modifiedEmailStr = email.replaceAll(".","_");
        this.userId = modifiedEmailStr + "_" + firstName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    // Empty default ctor for Firebase
    public User() {}

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
