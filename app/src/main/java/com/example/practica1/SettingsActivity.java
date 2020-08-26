package com.example.practica1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;


import com.example.practica1.fragments.Fragment_Settings;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
         // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Settings");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        setTheme(R.style.SettingStyle);

         if (findViewById(R.id.fragment_container_settings)!= null){
             if (savedInstanceState != null)
                 return;

             getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_settings,new Fragment_Settings()).commit();

         }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}