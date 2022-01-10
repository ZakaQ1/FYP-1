package com.example.n_template.ui.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.n_template.Database.Firebase_database_operations;
import com.example.n_template.Detail_player;
import com.example.n_template.MainActivity;
import com.example.n_template.My_Teams;
import com.example.n_template.R;
import com.example.n_template.ui.Models.View_team_model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class View_team_adapter extends RecyclerView.Adapter<View_team_adapter.view_holder> {

    Context context;
    ArrayList<View_team_model> list;
    boolean check = false;
    Firebase_database_operations opt;
    DatabaseReference databaseReference;

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_view_team, parent, false);
        return new View_team_adapter.view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {

        View_team_model model = list.get(position);
        holder.name.setText(model.getPlayername());
        holder.role.setText(model.getRole_of_player());
        Picasso.get().load(model.getProfile_Url()).into(holder.pic);
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detail_player.class);
                intent.putExtra("playerid", model.getPlayer_id());
                context.startActivity(intent);
            }
        });
        holder.drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alertDialog = new AlertDialog.Builder(context)
//set icon
                        .setIcon(android.R.drawable.ic_dialog_alert)
//set title
                        .setTitle("Drop Player")
//set message
                        .setMessage("Are you sure to drop this player")
//set positive button
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                databaseReference = FirebaseDatabase.getInstance().getReference("Players").child(model.getPlayer_id());
                                databaseReference.removeValue();
                                Intent intent = new Intent(context, My_Teams.class);
                                context.startActivity(intent);
                                ((Activity) context).finish();
                            }
                        })

//set negative button

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //set what should happen when negative button is clicked
                                Toast.makeText(context, "Nothing Happened", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public View_team_adapter(Context context, ArrayList<View_team_model> list, Boolean check) {
        this.context = context;
        this.list = list;
        this.check = check;
    }

    public class view_holder extends RecyclerView.ViewHolder {
        TextView name, role;
        Button drop, detail;
        ImageView pic;

        public view_holder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.view_team_sample_name);
            role = itemView.findViewById(R.id.view_team_sample_role);
            drop = itemView.findViewById(R.id.btn_leaveteam_sample_myteams);
            detail = itemView.findViewById(R.id.btn_viewteam_sample_myteams);
            pic = itemView.findViewById(R.id.profile_image_sample_view_team);

            if (check == false) {
                drop.setVisibility(View.GONE);
                detail.setVisibility(View.GONE);

            }
        }
    }
}