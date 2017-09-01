package com.example.liquormania;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by jrecinos on 11/27/15.
 */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }

}
