package com.example.utravel;

public class UserDetail {

    private String name,room,checkin,checkout,phone,budget,location;


    public UserDetail() {

    }
    public UserDetail(String name, String phone,String location, String budget,String room, String checkin, String checkout) {
        this.name = name;
        this.phone = phone;
        this.budget = budget;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.location = location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
