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
import com.example.n_template.ui.Models.Join_Request_model;
import com.example.n_template.ui.Models.Send_Challenges_model;

import java.util.ArrayList;

public class Send_Request_adapter extends RecyclerView.Adapter<Send_Request_adapter.ViewHolder>{

    ArrayList<Join_Request_model> list;
    Context context;

    public Send_Request_adapter(ArrayList<Join_Request_model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_send_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Join_Request_model join_request_model = list.get(position);

        holder.txtv_name.setText(join_request_model.getReceiver_teamname());
        holder.txtv_role.setText(join_request_model.getReceiver_teamtype());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtv_name, txtv_role;
        Button btn_reject;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtv_name = itemView.findViewById(R.id.txt_team_name_sent_request);
            txtv_role = itemView.findViewById(R.id.txt_team_type_sent_request);

            btn_reject = itemView.findViewById(R.id.btn_reject_sample_request);

        }
    }
}
