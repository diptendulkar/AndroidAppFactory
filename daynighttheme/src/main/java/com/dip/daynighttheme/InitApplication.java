package com.dip.daynighttheme;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class InitApplication extends Application {
    public static final String NIGHT_MODE = "NIGHT_MODE";
    private boolean isNightModeEnabled = false;
    SharedPreferences mPrefs;

    private static InitApplication singleton = null;

    public static InitApplication getInstance() {

        if(singleton == null)
        {
            singleton = new InitApplication();
        }
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
       // mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mPrefs = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        this.isNightModeEnabled = mPrefs.getBoolean(NIGHT_MODE, false);
    }

    public boolean isNightModeEnabled() {
        return isNightModeEnabled;
    }

    public void setIsNightModeEnabled(boolean isNightModeEnabled) {
        this.isNightModeEnabled = isNightModeEnabled;

        //TODO App Crash Here
//        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(mPrefs!=null) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean(NIGHT_MODE, isNightModeEnabled);
            editor.apply();
        }
    }
}
