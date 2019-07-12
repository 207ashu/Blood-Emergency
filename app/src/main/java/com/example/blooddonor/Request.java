package com.example.blooddonor;

public class Request {
    private String requesterName;
    private String hospital;
    private String bloodGroup;
    private String number;

    public Request(){

    }
    public Request(String requesterName, String hospital, String bloodGroup, String number){
        this.requesterName = requesterName;
        this.hospital = hospital;
        this.bloodGroup = bloodGroup;
        this.number = number;
    }
}
