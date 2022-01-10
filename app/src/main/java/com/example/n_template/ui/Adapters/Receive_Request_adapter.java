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
import com.example.n_template.My_Teams;
import com.example.n_template.R;
import com.example.n_template.ui.Models.Join_Request_model;
import com.example.n_template.ui.Models.Send_Challenges_model;

import java.util.ArrayList;

public class Receive_Request_adapter extends RecyclerView.Adapter<Receive_Request_adapter.ViewHolder>{
    ArrayList<Join_Request_model> list;
    Context context;
    Firebase_database_operations opt ;
    public Receive_Request_adapter(ArrayList<Join_Request_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_send_receive_request, parent, false);
        return new Receive_Request_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Join_Request_model join_request_model = list.get(position);

        holder.txtv_name.setText(join_request_model.getSender_name());
        holder.txtv_role.setText(join_request_model.getSender_role());
        holder.btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opt = new Firebase_database_operations();
                opt.Add_player_By_Request(join_request_model.getSender_name(),join_request_model.getSender_age(),join_request_model.getSender_role(),join_request_model.getSender_address(),join_request_model.getSender_phone_number());
                Intent intent = new Intent(context, My_Teams.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtv_name, txtv_role;
        Button btn_accept, btn_reject, btn_viewteam;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtv_name = itemView.findViewById(R.id.txtv_name_request);
            txtv_role = itemView.findViewById(R.id.txtv_role_request);

            btn_accept = itemView.findViewById(R.id.btn_accept_sample_request);
            btn_reject = itemView.findViewById(R.id.btn_reject_sample_request);
            btn_viewteam = itemView.findViewById(R.id.btn_view_team_sample_request);
        }
    }
}
