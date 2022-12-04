package com.example.gym;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AboutDialog extends DialogFragment {
    private Button submit;
    private Button cancel;
    private ImageView firstStar;
    private ImageView secondStar;
    private ImageView thirdStar;
    private ImageView fourthStar;
    private ImageView fifthStar;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.about_dialog_activity,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(view);
        builder.setTitle("About WiseTechnology");
        builder.setView(view);

        init(view);
        setOnClickListeners();

        return builder.create();
    }

    public void init(View view){
        submit = view.findViewById(R.id.SubmitBtn);
        cancel = view.findViewById(R.id.cancelAbout);
        firstStar = view.findViewById(R.id.firstStart);
        secondStar = view.findViewById(R.id.secondStart);
        thirdStar = view.findViewById(R.id.thirdStart);
        fourthStar = view.findViewById(R.id.fourthStart);
        fifthStar = view.findViewById(R.id.fifthStart);
    }

    public void setOnClickListeners(){
        firstStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStar.setColorFilter(getResources().getColor(R.color.yellow));
                secondStar.setColorFilter(getResources().getColor(R.color.grey));
                thirdStar.setColorFilter(getResources().getColor(R.color.grey));
                fourthStar.setColorFilter(getResources().getColor(R.color.grey));
                fifthStar.setColorFilter(getResources().getColor(R.color.grey));
            }
        });
        secondStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStar.setColorFilter(getResources().getColor(R.color.yellow));
                secondStar.setColorFilter(getResources().getColor(R.color.yellow));
                thirdStar.setColorFilter(getResources().getColor(R.color.grey));
                fourthStar.setColorFilter(getResources().getColor(R.color.grey));
                fifthStar.setColorFilter(getResources().getColor(R.color.grey));
            }
        });
        thirdStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStar.setColorFilter(getResources().getColor(R.color.yellow));
                secondStar.setColorFilter(getResources().getColor(R.color.yellow));
                thirdStar.setColorFilter(getResources().getColor(R.color.yellow));
                fourthStar.setColorFilter(getResources().getColor(R.color.grey));
                fifthStar.setColorFilter(getResources().getColor(R.color.grey));
            }
        });
        fourthStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStar.setColorFilter(getResources().getColor(R.color.yellow));
                secondStar.setColorFilter(getResources().getColor(R.color.yellow));
                thirdStar.setColorFilter(getResources().getColor(R.color.yellow));
                fourthStar.setColorFilter(getResources().getColor(R.color.yellow));
                fifthStar.setColorFilter(getResources().getColor(R.color.grey));
            }
        });
        fifthStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstStar.setColorFilter(getResources().getColor(R.color.yellow));
                secondStar.setColorFilter(getResources().getColor(R.color.yellow));
                thirdStar.setColorFilter(getResources().getColor(R.color.yellow));
                fourthStar.setColorFilter(getResources().getColor(R.color.yellow));
                fifthStar.setColorFilter(getResources().getColor(R.color.yellow));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Thank you for the feedback", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
    }
}
