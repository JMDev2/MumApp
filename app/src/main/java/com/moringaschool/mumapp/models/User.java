package com.moringaschool.mumapp.models;

public class User {
    private int id;
    private String name;
    private String lastMessage;
    private String lastMsgTime;
    private String phoneNo;
    private String conutry;
    private int imagid;


    public User(int id, String name, String lastMessage, String lastMsgTime, String phoneNo, String conutry, int imagid) {
        this.id = id;
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMsgTime = lastMsgTime;
        this.phoneNo = phoneNo;
        this.conutry = conutry;
        this.imagid = imagid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(String lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getConutry() {
        return conutry;
    }

    public void setConutry(String conutry) {
        this.conutry = conutry;
    }

    public int getImagid() {
        return imagid;
    }

    public void setImagid(int imagid) {
        this.imagid = imagid;
    }
}
