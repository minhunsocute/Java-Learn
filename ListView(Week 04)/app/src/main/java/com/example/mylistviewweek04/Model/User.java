package com.example.mylistviewweek04.Model;

public class User {
    private String name;
    private String phoneNumber;
    private Integer avatar;
    public User(String name, String phoneNumber, Integer avatar) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public Integer getAvatar() {return avatar;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
}
