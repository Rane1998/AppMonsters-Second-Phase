package com.example.utravel;

public class UserDetail {

    private String name,room,checkin,checkout,phone,budget;
    private String people;

    public UserDetail() {

    }

    public UserDetail(String name, String phone, String budget, String people, String room, String checkin, String checkout) {
        this.name = name;
        this.phone = phone;
        this.budget = budget;
        this.people = people;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
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
}
