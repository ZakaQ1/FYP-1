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
import com.example.n_template.ui.Models.Send_Challenges_model;

import java.util.ArrayList;

public class Receive_Challenges_adapter extends RecyclerView.Adapter<Receive_Challenges_adapter.ViewHolder>{

    ArrayList<Send_Challenges_model> list;
    Context context;

    public Receive_Challenges_adapter(ArrayList<Send_Challenges_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_receive_challenges, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Send_Challenges_model model = list.get(position);

        holder.txtv_name.setText(model.getSender_team_name());
        holder.txtv_type.setText(model.getSender_team_type());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtv_name, txtv_type;
        Button btn_accept, btn_reject, btn_viewteam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtv_name = itemView.findViewById(R.id.txtv_name_challenges);
            txtv_type = itemView.findViewById(R.id.txtv_type_challenges);

            btn_accept = itemView.findViewById(R.id.btn_accept_sample_challenges);
            btn_reject = itemView.findViewById(R.id.btn_reject_sample_challenges);
            btn_viewteam = itemView.findViewById(R.id.btn_view_team_sample_challenges);



        }
    }
}
