package com.example.gym;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button yourPlan;
    public Button allActivities;
    public Button aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for animation and all those transactions
        overridePendingTransition(R.anim.in, R.anim.out);

        Initializer();

        setOnClickListeners();
    }

    public void Initializer() {
        yourPlan = findViewById(R.id.seePlanBtn);
        allActivities = findViewById(R.id.seeAllActivities);
        aboutUs = findViewById(R.id.aboutUs);

    }

    public void setOnClickListeners() {
        yourPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, myPlanActivity.class);
                startActivity(intent);

            }
        });

        allActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SeeAllActivitiesActivity.class);
                startActivity(intent);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AboutDialog dialog = new AboutDialog();
                dialog.show(getSupportFragmentManager(), "About WiseTechnology");
            }
        });
    }

    //to allow the transition while using the option buttons

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}