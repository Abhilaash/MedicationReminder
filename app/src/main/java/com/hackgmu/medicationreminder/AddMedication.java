package com.hackgmu.medicationreminder;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

public class AddMedication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medication);

        // Create a tab listener that is called when the user changes tabs.
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec spec = tabHost.newTabSpec("One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Two");
        tabHost.addTab(spec);
        spec = tabHost.newTabSpec("Schedule");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Two");
        tabHost.addTab(spec);
    }
}
