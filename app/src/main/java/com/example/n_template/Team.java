package com.example.n_template;

public class Team {
    String team_name , team_strenght , team_captain_id, team_type;

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_strenght() {
        return team_strenght;
    }

    public void setTeam_strenght(String team_strenght) {
        this.team_strenght = team_strenght;
    }

    public String getTeam_captain_id() {
        return team_captain_id;
    }


    public void setTeam_captain_id(String team_captain_id) {
        this.team_captain_id = team_captain_id;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public Team() {
    }

    public Team(String team_name, String team_strenght, String team_captain_no, String team_type) {
        this.team_name = team_name;
        this.team_strenght = team_strenght;
        this.team_captain_id = team_captain_no;
        this.team_type = team_type;
    }

    public Team(String team_name, String team_strenght, String team_type) {
        this.team_name = team_name;
        this.team_strenght = team_strenght;
        this.team_type = team_type;
    }
}