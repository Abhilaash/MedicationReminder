package com.hackgmu.medicationreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.*;

public class AddMedication extends AppCompatActivity {
    private ArrayList<medication> Medicines = new ArrayList<medication>();
    medication newMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

        medicationAdapter adapter = new medicationAdapter(this, Medicines);
        adapter.setNotifyOnChange(true);
        ListView Medications = findViewById(R.id.ListMeds);
        Medications.setAdapter(adapter);

        // Create a tab listener that is called when the user changes tabs.
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("MedTable");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Medication");
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("Events");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Schedule");
        tabHost.addTab(spec);

        ImageButton button = findViewById(R.id.addMedication);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText medicationEditText = (EditText) findViewById(R.id.MedicationName);
                EditText medicationAmountEditText = (EditText) findViewById(R.id.NumTabletsTotal);
                if ((medicationEditText != null) && (medicationAmountEditText.getText() != null)) {
                    String medicationName = medicationEditText.getText().toString();
                    int medicationAmount = Integer.parseInt(medicationAmountEditText.getText().toString());
                    newMed = new medication(medicationName, medicationAmount);
                    Medicines.add(newMed);
                    Log.e(newMed.getName(), newMed.getNum() + "");
                    medicationEditText.setText("");
                    medicationAmountEditText.setText("");
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please fill out the entire form", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }


}
