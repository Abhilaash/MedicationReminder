package com.hackgmu.medicationreminder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class medicationAdapter extends ArrayAdapter<medication> {
    public medicationAdapter(Context context, ArrayList<medication> medications) {
        super(context, 0, medications);
    }

    @NonNull
    @Override
    public View getView(int position, View medication_and_doses, ViewGroup parent) {
        medication medication = getItem(position);
        if (medication_and_doses == null) {
            medication_and_doses = LayoutInflater.from(getContext()).inflate(R.layout.medication_and_doses, parent, false);
        };
        TextView medicationName = medication_and_doses.findViewById(R.id.medication);
        medicationName.setText(medication.getName());
        TextView medicationNum = medication_and_doses.findViewById(R.id.amount);
        medicationNum.setText(medication.getNum());
        return medication_and_doses;
    }
}

