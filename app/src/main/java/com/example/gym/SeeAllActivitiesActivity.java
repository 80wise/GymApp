package com.example.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SeeAllActivitiesActivity extends AppCompatActivity {

    private static final String TAG = "SeeAllActivitiesActivity";
    private RecyclerView exerciseRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all_activities_activitiy);

        overridePendingTransition(R.anim.in,R.anim.out);

        // i mange it in the onOptionsItemSelected item that is located down
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");

        exerciseRecView = (RecyclerView) findViewById(R.id.exerciseRecView);

        ExercisesRecViewAdapter adapter = new ExercisesRecViewAdapter(this);
        exerciseRecView.setAdapter(adapter);
        exerciseRecView.setLayoutManager(new LinearLayoutManager(this));

        DataBase dataBase = new DataBase();

        adapter.setExercises(DataBase.getAllActivity());

    }

    public void onClickListeners() {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }
}