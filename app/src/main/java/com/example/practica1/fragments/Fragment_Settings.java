package com.example.practica1.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.practica1.R;

public class Fragment_Settings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
