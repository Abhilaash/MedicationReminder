package com.hackgmu.medicationreminder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddMedication extends AppCompatActivity {
    private ArrayList<medication> Medicines = new ArrayList<>();
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
        TabHost tabHost = findViewById(R.id.tabHost);
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
                EditText medicationEditText = findViewById(R.id.MedicationName);
                EditText medicationAmountEditText = findViewById(R.id.NumTabletsTotal);
                if ((medicationEditText != null) && (!medicationAmountEditText.getText().toString().equals("") && medicationAmountEditText.getText().toString().length() > 0)) {
                    String medicationName = medicationEditText.getText().toString();
                    int medicationAmount = Integer.parseInt(medicationAmountEditText.getText().toString());
                    newMed = new medication(medicationName, medicationAmount);
                    Medicines.add(newMed);
                    medicationEditText.setText("");
                    medicationAmountEditText.setText("");
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Medications");
                    myRef.push().setValue(newMed);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please fill out the entire form", Toast.LENGTH_SHORT);
                    toast.show();
                }
                InputMethodManager imm = (InputMethodManager) AddMedication.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (null != AddMedication.this.getCurrentFocus())
                    imm.hideSoftInputFromWindow(AddMedication.this.getCurrentFocus()
                            .getApplicationWindowToken(), 0);
            }
        });
    }


}
