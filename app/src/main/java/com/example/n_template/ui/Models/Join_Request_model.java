package com.example.n_template.ui.Models;

public class Join_Request_model {

    String Sender_id;
    String Receiver_id;
    String Receiver_teamname;
    String Receiver_teamtype;
    String Sender_teamtype;
    String Sender_name;
    String Sender_role;
    String Sender_address;
    String Sender_age;
    String Sender_image;
    String Sender_phone_number;

    public String getSender_id() {
        return Sender_id;
    }

    public void setSender_id(String sender_id) {
        Sender_id = sender_id;
    }

    public String getReceiver_id() {
        return Receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        Receiver_id = receiver_id;
    }

    public String getReceiver_teamname() {
        return Receiver_teamname;
    }

    public void setReceiver_teamname(String receiver_teamname) {
        Receiver_teamname = receiver_teamname;
    }

    public String getReceiver_teamtype() {
        return Receiver_teamtype;
    }

    public void setReceiver_teamtype(String receiver_teamtype) {
        Receiver_teamtype = receiver_teamtype;
    }

    public String getSender_teamtype() {
        return Sender_teamtype;
    }

    public void setSender_teamtype(String sender_teamtype) {
        Sender_teamtype = sender_teamtype;
    }

    public String getSender_name() {
        return Sender_name;
    }

    public void setSender_name(String sender_name) {
        Sender_name = sender_name;
    }

    public String getSender_role() {
        return Sender_role;
    }

    public void setSender_role(String sender_role) {
        Sender_role = sender_role;
    }

    public String getSender_address() {
        return Sender_address;
    }

    public void setSender_address(String sender_address) {
        Sender_address = sender_address;
    }

    public String getSender_age() {
        return Sender_age;
    }

    public void setSender_age(String sender_age) {
        Sender_age = sender_age;
    }

    public String getSender_image() {
        return Sender_image;
    }

    public void setSender_image(String sender_image) {
        Sender_image = sender_image;
    }

    public String getSender_phone_number() {
        return Sender_phone_number;
    }

    public void setSender_phone_number(String sender_phone_number) {
        Sender_phone_number = sender_phone_number;
    }

    public  Join_Request_model(){}
    public Join_Request_model(String sender_id, String receiver_id, String receiver_teamname, String receiver_teamtype, String sender_teamtype, String sender_name, String sender_role, String sender_address, String sender_age, String sender_image, String sender_phone_number) {
        Sender_id = sender_id;
        Receiver_id = receiver_id;
        Receiver_teamname = receiver_teamname;
        Receiver_teamtype = receiver_teamtype;
        Sender_teamtype = sender_teamtype;
        Sender_name = sender_name;
        Sender_role = sender_role;
        Sender_address = sender_address;
        Sender_age = sender_age;
        Sender_image = sender_image;
        Sender_phone_number = sender_phone_number;
    }
}
