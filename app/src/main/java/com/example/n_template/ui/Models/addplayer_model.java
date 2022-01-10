package com.example.n_template.ui.Models;

public class addplayer_model {

    public addplayer_model(){}

    String playername;
    String phone_number;
    String Captain_id;

    public String getCaptain_id() {
        return Captain_id;
    }

    public void setCaptain_id(String captain_id) {
        Captain_id = captain_id;
    }

    int age;
    String address;
    String role_of_player;

    public addplayer_model(String playername, String phone_number, int age, String address, String role_of_player, String profile_url) {
        this.playername = playername;
        this.phone_number = phone_number;
        this.age = age;
        this.address = address;
        this.role_of_player = role_of_player;
        this.profile_url = profile_url;
    }

    public addplayer_model(String playername, String phone_number, int age, String address, String role_of_player, String profile_url, String player_id) {
        this.playername = playername;
        this.phone_number = phone_number;
        this.age = age;
        this.address = address;
        this.role_of_player = role_of_player;
        this.profile_url = profile_url;
        this.player_id = player_id;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    String profile_url;

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    String player_id;


    //without image
    public addplayer_model(String playername, String phone_number, int age, String address, String role_of_player) {
        this.playername = playername;
        this.phone_number = phone_number;
        this.age = age;
        this.address = address;
        this.role_of_player = role_of_player;
    }




    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole_of_player() {
        return role_of_player;
    }

    public void setRole_of_player(String role_of_player) {
        this.role_of_player = role_of_player;
    }




}