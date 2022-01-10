package com.example.n_template.ui.Models;

public class Join_team_model {

    String team_name;
    String Team_ID;
    String team_type;

    public String getTeam_type() {
        return team_type;
    }

    public Join_team_model(String team_name, String team_type) {
        this.team_name = team_name;
        this.team_type = team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public String getTeam_captain_id() {
        return team_captain_id;
    }

    public void setTeam_captain_id(String team_captain_id) {
        this.team_captain_id = team_captain_id;
    }

    String team_captain_id ;

    public String getTeam_ID() {
        return Team_ID;
    }

    public void setTeam_ID(String team_ID) {
        Team_ID = team_ID;
    }

    public Join_team_model(String team_name) {
        this.team_name = team_name;
    }

    public Join_team_model(){}

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}