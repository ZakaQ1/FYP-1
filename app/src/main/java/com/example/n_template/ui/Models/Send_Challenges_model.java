package com.example.n_template.ui.Models;

public class Send_Challenges_model {

    String Receiver_team_name;
    String Receiver_team_type;
    String Receiverid;
    String Senderid;
    String Sender_team_name;

    public String getSender_team_name() {
        return Sender_team_name;
    }

    public void setSender_team_name(String sender_team_name) {
        Sender_team_name = sender_team_name;
    }

    public String getSender_team_type() {
        return Sender_team_type;
    }

    public void setSender_team_type(String sender_team_type) {
        Sender_team_type = sender_team_type;
    }

    String Sender_team_type ;

    public Send_Challenges_model() {
    }

    public String getReceiver_team_name() {
        return Receiver_team_name;
    }

    public void setReceiver_team_name(String receiver_team_name) {
        Receiver_team_name = receiver_team_name;
    }

    public String getReceiver_team_type() {
        return Receiver_team_type;
    }

    public void setReceiver_team_type(String receiver_team_type) {
        Receiver_team_type = receiver_team_type;
    }

    public String getReceiverid() {
        return Receiverid;
    }

    public void setReceiverid(String receiverid) {
        Receiverid = receiverid;
    }

    public String getSenderid() {
        return Senderid;
    }

    public void setSenderid(String senderid) {
        Senderid = senderid;
    }

    public Send_Challenges_model(String receiver_team_name, String receiver_team_type, String receiverid, String senderid) {
        Receiver_team_name = receiver_team_name;
        Receiver_team_type = receiver_team_type;
        Receiverid = receiverid;
        Senderid = senderid;
    }
}
