package com.example.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class myPlanActivity extends AppCompatActivity {
    private RecyclerView monRecView;
    private RecyclerView tueRecView;
    private RecyclerView wedRedView;
    private RecyclerView thuRecView;
    private RecyclerView friRecView;
    private RecyclerView satRecView;
    private RecyclerView sunRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plan);

        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();

    }

    public void init(){
        DataBase dataBase = new DataBase();

        monRecView = findViewById(R.id.monRecView);
        tueRecView = findViewById(R.id.tueRecView);
        wedRedView = findViewById(R.id.wedRecView);
        thuRecView = findViewById(R.id.thuRecView);
        friRecView = findViewById(R.id.friRecView);
        satRecView = findViewById(R.id.satRecView);
        sunRecView = findViewById(R.id.sunRecView);

        ExercisesRecViewAdapter adapterMon = new ExercisesRecViewAdapter(this);
        adapterMon.setType("monday");
        monRecView.setAdapter(adapterMon);
        monRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterMon.setExercises(DataBase.myMondayActivity);

        ExercisesRecViewAdapter adapterTue = new ExercisesRecViewAdapter(this);
        adapterTue.setType("tuesday");
        tueRecView.setAdapter(adapterTue);
        tueRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterTue.setExercises(DataBase.myTuesdayActivity);

        ExercisesRecViewAdapter adapterWed = new ExercisesRecViewAdapter(this);
        adapterWed.setType("wednesday");
        wedRedView.setAdapter(adapterWed);
        wedRedView.setLayoutManager(new LinearLayoutManager(this));
        adapterWed.setExercises(DataBase.myWednesdayActivity);

        ExercisesRecViewAdapter adapterThu = new ExercisesRecViewAdapter(this);
        adapterThu.setType("thursday");
        thuRecView.setAdapter(adapterThu);
        thuRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterThu.setExercises(DataBase.myThursdayActivity);

        ExercisesRecViewAdapter adapterFri = new ExercisesRecViewAdapter(this);
        adapterFri.setType("friday");
        friRecView.setAdapter(adapterFri);
        friRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterFri.setExercises(DataBase.myFridayActivity);

        ExercisesRecViewAdapter adapterSat = new ExercisesRecViewAdapter(this);
        adapterSat.setType("saturday");
        satRecView.setAdapter(adapterSat);
        satRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterSat.setExercises(DataBase.mySaturdayActivity);

        ExercisesRecViewAdapter adapterSun = new ExercisesRecViewAdapter(this);
        adapterSun.setType("sunday");
        sunRecView.setAdapter(adapterSun);
        sunRecView.setLayoutManager(new LinearLayoutManager(this));
        adapterSun.setExercises(DataBase.mySundayActivity);
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