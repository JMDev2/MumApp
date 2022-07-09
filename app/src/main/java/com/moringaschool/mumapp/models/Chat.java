package com.moringaschool.mumapp.models;

import com.moringaschool.mumapp.UserFirebase;

import java.io.Serializable;

public class Chat implements Serializable {
    private int SenderID;
    private int ReceiverID;
    private String Message;
    private int ID;
String receiver;
    String sender;
    String createdAt;

    public Chat() {
    }

    public Chat(String message, String receiver, String sender, String createdAt) {
        Message = message;
        this.receiver = receiver;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public Chat(int senderID, int receiverID, String message, int ID) {
        SenderID = senderID;
        ReceiverID = receiverID;
        Message = message;
        this.ID = ID;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    public int getSenderID() {
        return SenderID;
    }

    public void setSenderID(int senderID) {
        SenderID = senderID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int receiverID) {
        ReceiverID = receiverID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
