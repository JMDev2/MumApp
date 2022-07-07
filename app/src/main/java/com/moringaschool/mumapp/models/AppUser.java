package com.moringaschool.mumapp.models;

public class AppUser {

    private String email;
    private String username;
    private String phone;

    String pushId;

    public AppUser(String email, String username, String phone) {
        this.email = email;
        this.username = username;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
