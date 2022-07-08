package com.moringaschool.mumapp;

public class UserFirebase {
    String name, lastMessage, lastMsgTime,phoneNo, country,email;
  String imageUrl;
  String pushId;
  int posts;
  int following;
  int followers;

    public UserFirebase(String name, String lastMessage, String lastMsgTime, String phoneNo, String country, String email, String imageUrl, int posts, int following, int followers) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMsgTime = lastMsgTime;
        this.phoneNo = phoneNo;
        this.country = country;
        this.email = email;
        this.imageUrl = imageUrl;
        this.posts = posts;
        this.following = following;
        this.followers = followers;
    }

    public UserFirebase(String name, String lastMessage, String lastMsgTime, String phoneNo, String country, String email, String imageUrl, String pushId, int posts, int following, int followers) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMsgTime = lastMsgTime;
        this.phoneNo = phoneNo;
        this.country = country;
        this.email = email;
        this.imageUrl = imageUrl;
        this.pushId = pushId;
        this.posts = posts;
        this.following = following;
        this.followers = followers;
    }

//    public UserFirebase(String name, String lastMessage, String lastMsgTime, String phoneNo, String country, String imageUrl) {
//        this.name = name;
//        this.lastMessage = lastMessage;
//        this.lastMsgTime = lastMsgTime;
//        this.phoneNo = phoneNo;
//        this.country = country;
//        this.imageUrl = imageUrl;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserFirebase() {
    }
}
