package com.example.n_template.Database;

import androidx.annotation.NonNull;

import com.example.n_template.Team;
import com.example.n_template.ui.Models.Join_Request_model;
import com.example.n_template.ui.Models.Send_Challenges_model;
import com.example.n_template.ui.Models.addplayer_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Firebase_database_operations {

    DatabaseReference database_Teams;
    Team team22 = new Team();
    static String Team_Name;
    static int playecount = 1;
    static String Team_id_1;
    FirebaseAuth auth;
    addplayer_model player_info_model , player_info_model2;
    Team team = new Team();
    Send_Challenges_model model;
    Join_Request_model join_request_model;



//    database_Teams = FirebaseDatabase.getInstance().getReference("Teams");
//    String Team_id =  database_Teams.push().getKey();


    public void create_team(Team obj) {

//        HashMap<String,Object> hashMap = new HashMap<String,Object>();
//        hashMap.put("Team ID",obj.getTeam_id());
//        hashMap.put("Team Name",obj.getTeam_name());
//        hashMap.put("Type",obj.getTeam_type());
//        hashMap.put("Strength", obj.getTeam_strenght());
//
        auth = FirebaseAuth.getInstance();
        String user_id = auth.getUid();
        database_Teams = FirebaseDatabase.getInstance().getReference("Teams");
        Team_id_1 = database_Teams.push().getKey();
//        String team_name , team_strenght , team_captain_id, team_type;

        Team_Name = obj.getTeam_name();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Team_ID", Team_id_1);
        hashMap.put("team_name", obj.getTeam_name());
        hashMap.put("team_type", obj.getTeam_type());
        hashMap.put("team_strenght", obj.getTeam_strenght());
        hashMap.put("team_captain_id", user_id);
        database_Teams.child(user_id).setValue(hashMap);
        playecount = 1;


    }


    public String Add_player(addplayer_model obj) {

        auth = FirebaseAuth.getInstance();
        String UserID = auth.getUid();
        database_Teams = FirebaseDatabase.getInstance().getReference("Players");
        String Player_id = database_Teams.push().getKey();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Team_ID", Team_id_1);
        hashMap.put("Captain_id",UserID);
        hashMap.put("playername", obj.getPlayername());
        hashMap.put("role_of_player", obj.getRole_of_player());
        hashMap.put("age", obj.getAge());
        hashMap.put("address", obj.getAddress());
        hashMap.put("phone_number", obj.getPhone_number());
        hashMap.put("Profile_Url",obj.getProfile_url());
        hashMap.put("Player_id",Player_id);
        database_Teams.child(Player_id).setValue(hashMap);
        return  Player_id;


    }

    public Query Retreive_Team_Data() {
        auth = FirebaseAuth.getInstance();
        String userid = auth.getUid().toString();
        Query query = FirebaseDatabase.getInstance().getReference().child("Teams")
                .orderByChild("team_captain_id")
                .equalTo(userid);
        return query;

    }

    public Query Retreive_Team_List() {
        Query query = FirebaseDatabase.getInstance().getReference().child("Teams");
        return query;
    }

    public Query Retreive_Player_Data(String capt_id) {

        Query query = FirebaseDatabase.getInstance().getReference().child("Players")
                .orderByChild("Captain_id")
                .equalTo(capt_id);
        return query;
    }

    public Query Retreive_Player_Detail(String Player_id) {
        auth = FirebaseAuth.getInstance();
        Query query = FirebaseDatabase.getInstance().getReference().child("Players")
                .orderByChild("Player_id")
                .equalTo(Player_id);
        return query;
    }

    public void Upload_image() {


    }

    public boolean alertDelete(String id) {

        if (id == null)
        {
            return false;
        }
        else {
            database_Teams = FirebaseDatabase.getInstance().getReference("Players").child(id);
            database_Teams.removeValue();
            return true;
        }
    }

    public void send_request(String reciver_id, String receiver_teamtype, String receiver_team_name) {

        join_request_model = new Join_Request_model();
        player_info_model = new addplayer_model();
        auth = FirebaseAuth.getInstance();

        Query query = FirebaseDatabase.getInstance().getReference("Players")
                .orderByChild("phone_number")
                .equalTo(auth.getCurrentUser().getPhoneNumber().toString());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    player_info_model = dataSnapshot1.getValue(addplayer_model.class);
                    join_request_model = dataSnapshot1.getValue(Join_Request_model.class);
                }


                HashMap map = new HashMap();
                map.put("Reciever_id", reciver_id);
                map.put("Receiver_teamname", receiver_team_name);
                map.put("Receiver_teamtype", receiver_teamtype);
                map.put("Sender_id", auth.getUid().toString());
                map.put("Sender_teamtype", join_request_model.getSender_teamtype());
                map.put("Sender_name", player_info_model.getPlayername());
                map.put("Sender_role", "All Rounder");
                map.put("Sender_address", player_info_model.getAddress());
                map.put("Sender_age", player_info_model.getAge());
//                map.put("Sender_image", join_request_model.getSender_image());
                map.put("Sender_phone_number", player_info_model.getPhone_number());


                String kerachi = FirebaseDatabase.getInstance().getReference().push().getKey().toString();
                database_Teams = FirebaseDatabase.getInstance().getReference("Requests");
                database_Teams.child(kerachi).setValue(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void send_challenges(String capt_id, String team_type, String team_name) {

        model = new Send_Challenges_model();
        auth = FirebaseAuth.getInstance();
        String UserID = auth.getUid();
        HashMap map = new HashMap();

        Query query = FirebaseDatabase.getInstance().getReference().child("Teams")
                .orderByChild("team_captain_id")
                .equalTo(auth.getUid());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    team = dataSnapshot1.getValue(Team.class);
                }
//                model.setSender_team_name(team.getTeam_name());
//                model.setSender_team_type(team.getTeam_type());

                map.put("Senderid", UserID);
                map.put("Receiverid", capt_id);
                map.put("Receiver_team_type", team_type);
                map.put("Receiver_team_name", team_name);
                map.put("Sender_team_name", team.getTeam_name());
                map.put("Sender_team_type", team.getTeam_type());
                String key = FirebaseDatabase.getInstance().getReference().push().getKey().toString();
                database_Teams = FirebaseDatabase.getInstance().getReference("Challenges");
                database_Teams.child(key).setValue(map);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public Query retrieve_send_challenges(String user_id) {
        Query query = FirebaseDatabase.getInstance().getReference().child("Challenges")
                .orderByChild("Senderid")
                .equalTo(user_id);
        return query;
    }
    public void Add_player_By_Request(String name, String age, String role, String address , String phone ) {

        auth = FirebaseAuth.getInstance();
        database_Teams = FirebaseDatabase.getInstance().getReference("Players");
        String Player_id = database_Teams.push().getKey();
        HashMap hashMap = new HashMap();
        hashMap.put("playername", name);
        hashMap.put("role_of_player", role);
        hashMap.put("age", age);
        hashMap.put("address", address);
        hashMap.put("phone_number", phone);
        hashMap.put("Player_id", Player_id);
        hashMap.put("Captain_id",auth.getUid());
        database_Teams.child(Player_id).setValue(hashMap);
    }

    public Query Find_by_age_18_to_24(){

        Query query = FirebaseDatabase.getInstance().getReference().child("Players")
                .orderByChild("age")
                .startAt(18).endAt(24);

        return query;
    }

//    public Query Find_by_age_30_to_50(){
//
//        player_info_model2 = new addplayer_model();
//        Query query = FirebaseDatabase.getInstance().getReference().child("Players")
//                .orderByChild("age")
//                .startAt("30").endAt("50");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    player_info_model2 = dataSnapshot1.getValue(addplayer_model.class);
//                }
//
//                Query query2 = FirebaseDatabase.getInstance().getReference().child("Teams")
//                        .orderByChild("team_captain_id")
//                        .equalTo( player_info_model2.getCaptain_id());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return query2;
//    }

    public Query Find_by_age_24_to_32(){

        Query query = FirebaseDatabase.getInstance().getReference().child("Players")
                .orderByChild("age")
                .startAt(22).endAt(30);

        return query;
    }

}