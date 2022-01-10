package com.example.n_template.ui.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n_template.R;
import com.example.n_template.Team;
import com.example.n_template.View_team;
import com.example.n_template.ui.Models.My_Teams_model;
import com.example.n_template.ui.Models.View_team_model;

import java.util.ArrayList;

public class My_Teams_adapter extends RecyclerView.Adapter<My_Teams_adapter.view_holder> {

    Context context;
    ArrayList<Team> list;

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_myteams,parent,false);
        return new My_Teams_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        Team model = list.get(position);

       holder.tname.setText(model.getTeam_name());
       holder.t_type.setText(model.getTeam_type());
       holder.t_strenght.setText(model.getTeam_strenght());

        holder.viewteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, View_team.class);
                intent.putExtra("my_team_capt_id",model.getTeam_captain_id());
                context.startActivity(intent);
            }
        });
        holder.leaveteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You Are No More Part of the team", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public My_Teams_adapter(Context context, ArrayList<Team> list) {
        this.context = context;
        this.list = list;
    }


    public class view_holder extends RecyclerView.ViewHolder
    {
        TextView tname, status , t_type , t_strenght;
        Button viewteam,leaveteam;

        public view_holder(@NonNull View itemView) {
            super(itemView);

            tname = itemView.findViewById(R.id.txtv_tname__myteams);
            status = itemView.findViewById(R.id.txtv_staus_myteams);
            viewteam = itemView.findViewById(R.id.btn_viewteam_sample_myteams);
            leaveteam = itemView.findViewById(R.id.btn_leaveteam_sample_myteams);
            t_type = itemView.findViewById(R.id.txtv_t_type_myteams);
            t_strenght = itemView.findViewById(R.id.txtv_tstrenght__myteams);
        }


    }
}