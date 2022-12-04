package com.example.gym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MoreDetailsActivity extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private ImageView picture;
    private TextView moreDetails;
    private Button addBtn;

    Exercise selectedExercise;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializer();

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            selectedExercise = bundle.getParcelable(getString(R.string.Exercise));

            name.setText(selectedExercise.getName());
            description.setText(selectedExercise.getDescription());
            Glide.with(this)
                    .asBitmap()
                    .load(selectedExercise.getPictureUrl())
                    .into(picture);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        setOnClickListeners();
    }

    public void initializer() {
        name = findViewById(R.id.nameTextView);
        description = findViewById(R.id.largeDescription);
        picture = findViewById(R.id.image);
        moreDetails = findViewById(R.id.moreInfo);
        addBtn = findViewById(R.id.addButton);
    }

    public void setOnClickListeners() {
        moreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreDetailsActivity.this, navigatorActivity.class);
                intent.putExtra("url", "http://google.com/");
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("chosenExercise",selectedExercise);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                AddingFragment fragment = new AddingFragment();
                fragment.setArguments(bundle);
                ft.replace(R.id.containerFragment,fragment);
                ft.commit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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