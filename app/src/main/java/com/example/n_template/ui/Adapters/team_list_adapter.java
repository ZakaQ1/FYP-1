package com.example.n_template.ui.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.Fragments.Send_ChallengeFragment;
import com.example.n_template.R;
import com.example.n_template.View_team;
import com.example.n_template.ui.Models.Join_team_model;
import com.example.n_template.ui.Models.Team_list_model;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;

public class team_list_adapter extends RecyclerView.Adapter<team_list_adapter.view_holder> {

    Firebase_database_operations opt;
    Context context;
    ArrayList<Join_team_model> list;
    static int count = 0;

    public team_list_adapter(Context context, ArrayList<Join_team_model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_team_list, parent, false);
        return new team_list_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        Join_team_model model = list.get(position);
        holder.team_name.setText(model.getTeam_name());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, View_team.class);
                intent.putExtra("team_capt_id", model.getTeam_captain_id());
                context.startActivity(intent);
            }
        });
        holder.challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opt = new Firebase_database_operations();
                opt.send_challenges(model.getTeam_captain_id(), model.getTeam_type(), model.getTeam_name());


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        TextView team_name;
        Button challenge, view;
        NotificationBadge badge;

        public view_holder(@NonNull View itemView) {
            super(itemView);

            badge = itemView.findViewById(R.id.badge_challenges);

            team_name = itemView.findViewById(R.id.team_list_sample_name);
            challenge = itemView.findViewById(R.id.challenge_btn_sample_team_list);
            view = itemView.findViewById(R.id.detail_btn_sample_team_list);

        }
    }

}
