package com.hackgmu.medicationreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class AddMedication extends AppCompatActivity {

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
        String medicationName = findViewById(R.id.MedicationName).toString();
        int medicationAmount = Integer.parseInt(findViewById(R.id.NumTabletsTotal).toString());
    }


}
