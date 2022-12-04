package com.example.gym;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ExercisesRecViewAdapter extends RecyclerView.Adapter<ExercisesRecViewAdapter.ViewHolder> {
    private static final String TAG = "ExercisesRecViewAdapter";
    ArrayList<Exercise> exercises = new ArrayList<>();
    private String type = "";
    private Context context;

    public ExercisesRecViewAdapter(Context context) {
        this.context = context;
    }

    public ExercisesRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.exercise_rec_view, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.name.setText(exercises.get(i).getName());
        viewHolder.description.setText(exercises.get(i).getDescription().substring(0, 35)+"...");

        Glide.with(context)
                .asBitmap()
                .load(exercises.get(i).getPictureUrl())
                .into(viewHolder.picture);

        if(type == ""){
            viewHolder.done.setVisibility(View.INVISIBLE);
            viewHolder.done.setEnabled(false);
        }

        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MoreDetailsActivity.class);
                /*
                intent.putExtra(context.getString(R.string.name),exercises.get(i).getName());
                intent.putExtra(context.getString(R.string.description),exercises.get(i).getDescription());
                intent.putExtra(context.getString(R.string.picture),exercises.get(i).getPictureUrl());
                intent.putExtra(context.getString(R.string.selectedExercise), exercises.get(i));
                */
                Bundle bundle = new Bundle();
                bundle.putParcelable(context.getString(R.string.Exercise), exercises.get(i));
                intent.putExtra(context.getString(R.string.bundle), bundle);

                context.startActivity(intent);

            }
        });

        int position = i;

        viewHolder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(type != ""){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Warning");
                    builder.setMessage("Do you really want to deleted this activity ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (type){
                                case "monday":
                                    if(DataBase.myMondayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        Toast.makeText(context, "Not Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "tuesday":
                                    if(DataBase.myTuesdayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "wednesday":
                                    if(DataBase.myWednesdayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "thursday":
                                    if(DataBase.myThursdayActivity.remove(exercises.get(position))){
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "friday":
                                    if(DataBase.myFridayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "saturday":
                                    if(DataBase.mySaturdayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case "sunday":
                                    if(DataBase.mySundayActivity.remove(exercises.get(position))){
                                        notifyDataSetChanged();
                                        Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        notifyDataSetChanged();
    }

    public void setType(String type) {
        this.type = type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView picture;
        private TextView description;
        private RadioButton done;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            picture = itemView.findViewById(R.id.picture);
            description = itemView.findViewById(R.id.description);
            done = itemView.findViewById(R.id.done);
            parent = itemView.findViewById(R.id.trainingCard);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
