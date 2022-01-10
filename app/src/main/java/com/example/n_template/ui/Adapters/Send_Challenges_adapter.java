package com.example.n_template.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n_template.R;
import com.example.n_template.Team;
import com.example.n_template.ui.Models.Join_team_model;
import com.example.n_template.ui.Models.Send_Challenges_model;
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.ArrayList;

public class Send_Challenges_adapter extends RecyclerView.Adapter<Send_Challenges_adapter.ViewHolder> {

    ArrayList<Send_Challenges_model> list;
    Context context;

    public Send_Challenges_adapter(ArrayList<Send_Challenges_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_sent_chalenges, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Send_Challenges_model model = list.get(position);
        holder.txtv_team_name.setText(model.getReceiver_team_name());
        holder.txtv_team_type.setText(model.getReceiver_team_type());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtv_team_name, txtv_team_type;
        Button cancel_challenges;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtv_team_name = itemView.findViewById(R.id.txt_team_name_sent_challengis);
            txtv_team_type = itemView.findViewById(R.id.txt_team_type_sent_challenges);


            cancel_challenges = itemView.findViewById(R.id.btn_reject_sample_challenges);

//            message = itemView.findViewById(R.id.txtv_name_challenges);
//            accept =itemView.findViewById(R.id.btn_accept_sample_challenges);
//            viewteam =itemView.findViewById(R.id.btn_viewteam_sample_myteams);
//            chat =itemView.findViewById(R.id.btn_chat_sample_challenges);
//            reject =itemView.findViewById(R.id.btn_reject_sample_challenges);
        }
    }
}
