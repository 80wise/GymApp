package com.example.gym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AddingFragment extends Fragment {
    private static final String TAG = "AddingFragment";

    private Button addBtn;
    private Button cancelBtn;
    private EditText minutesEditText;
    private Spinner daysSpinner;
    private Exercise chosenExercise;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_to_my_activity_fragment, container, false);
        initialization(view);
        ArrayList<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                view.getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                days);
        daysSpinner.setAdapter(adapter);

        setOnClickListeners();

        chosenExercise = this.getArguments().getParcelable("chosenExercise");

        return view;
    }

    private void initialization(View view) {
        addBtn = view.findViewById(R.id.addToMyActivityBtn);
        cancelBtn = view.findViewById(R.id.cancelBtn);
        minutesEditText = view.findViewById(R.id.workOutTime);
        daysSpinner = view.findViewById(R.id.daysSpinner);
    }
    private void setOnClickListeners(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(daysSpinner.getSelectedItemPosition()){
                    case 0:
                        if(DataBase.myMondayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 1 :
                        if(DataBase.myTuesdayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:
                        if(DataBase.myWednesdayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 3 :
                        if(DataBase.myThursdayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 4:
                        if(DataBase.myFridayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 5 :
                        if(DataBase.mySaturdayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 6:
                        if(DataBase.mySundayActivity.add(chosenExercise)){
                            Toast.makeText(view.getContext(), "Successfully added", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(view.getContext(), "Not added", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
                getFragmentManager().beginTransaction().remove(AddingFragment.this).commit();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(AddingFragment.this).commit();
            }
        });
    }
}
