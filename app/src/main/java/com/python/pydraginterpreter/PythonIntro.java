package com.python.pydraginterpreter;

import android.os.Bundle;

import com.python.pydraginterpreter.databinding.ActivityPythonIntroBinding;

public class PythonIntro extends DrawerBase {



    ActivityPythonIntroBinding activityPythonIntroBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPythonIntroBinding = ActivityPythonIntroBinding.inflate(getLayoutInflater());
        setContentView(activityPythonIntroBinding.getRoot());
        allocateActivityTitle("Python Introduction");
    }
}