package com.example.n_template.ui.Adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.Fragments.SendRequestFragment;
import com.example.n_template.Fragments.Send_ChallengeFragment;
import com.example.n_template.R;
import com.example.n_template.View_team;
import com.example.n_template.View_team_for_joiners;
import com.example.n_template.ui.Models.Join_team_model;

import java.util.ArrayList;

public class join_team_list_adapter extends RecyclerView.Adapter<join_team_list_adapter.view_holder> {

    Context context;
    ArrayList<Join_team_model> list;

    Firebase_database_operations opt;

    public join_team_list_adapter(Context context, ArrayList<Join_team_model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public join_team_list_adapter.view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_join_team_list,parent,false);
        return new join_team_list_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull join_team_list_adapter.view_holder holder, int position) {

        Join_team_model model = list.get(position);
        holder.team_name.setText(model.getTeam_name());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, View_team_for_joiners.class);
                intent.putExtra("team_id",model.getTeam_captain_id());
                context.startActivity(intent);
            }
        });

        holder.join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opt = new Firebase_database_operations();
                opt.send_request(model.getTeam_captain_id(),model.getTeam_type(),model.getTeam_name());

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class view_holder extends RecyclerView.ViewHolder
    {
        TextView team_name;
        Button join , view;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            team_name = itemView.findViewById(R.id.team_list_sample_name);
            join = itemView.findViewById(R.id.joinTeam_btn_sample_join_team);
            view = itemView.findViewById(R.id.viewTeam_btn_sample_join_team);

        }
    }
}