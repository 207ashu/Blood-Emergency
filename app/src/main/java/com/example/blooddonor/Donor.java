package com.example.blooddonor;

public class Donor {

    public String name;
    public String email;
    public String gender;
    public String bloodGroup;
    public String number;

    // Default constuctor required for calls to
    // DataSnapshot.getValue(User.class)
    public Donor(){

    }

    public Donor(String name, String email, String gender, String bloodGroup, String number){

        this.name = name;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.number = number;

    }
}
