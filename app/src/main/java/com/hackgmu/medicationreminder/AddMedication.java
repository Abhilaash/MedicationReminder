package com.hackgmu.medicationreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.*;

public class AddMedication extends AppCompatActivity {
    private ArrayList<medication> Medicines = new ArrayList<medication>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

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
                String medicationName = findViewById(R.id.MedicationName).toString();
                int medicationAmount = Integer.parseInt(findViewById(R.id.NumTabletsTotal).toString());
                if ((medicationName != null) && (medicationAmount > -1)) {
                    medication newMed = new medication(medicationName, medicationAmount);
                    Medicines.add(newMed);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please fill out the entire form", Toast.LENGTH_SHORT);
                    toast.setMargin(50, 50);
                    toast.show();
                }
            }
        });
    }


}
