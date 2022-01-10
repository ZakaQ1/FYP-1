package com.example.n_template.ui.Models;

public class View_team_model {
    String playername;
    String role_of_player;
    String Profile_Url;

    public String getProfile_Url() {
        return Profile_Url;
    }

    public void setProfile_Url(String profile_Url) {
        Profile_Url = profile_Url;
    }

    public String getPlayer_id() {
        return Player_id;
    }

    public void setPlayer_id(String player_id) {
        Player_id = player_id;
    }

    String Player_id;
    int pic;
    public  View_team_model(){}

    public View_team_model(String playername, String role, int pic) {
        this.playername = playername;
        this.role_of_player = role;
        this.pic = pic;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getRole_of_player() {
        return role_of_player;
    }

    public void setRole_of_player(String role_of_player) {
        this.role_of_player = role_of_player;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}