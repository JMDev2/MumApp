package com.moringaschool.mumapp.models;

public class Chat {
    private int SenderID;
    private int ReceiverID;
    private String Message;
    private int ID;


    public Chat(int senderID, int receiverID, String message, int ID) {
        SenderID = senderID;
        ReceiverID = receiverID;
        Message = message;
        this.ID = ID;
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
