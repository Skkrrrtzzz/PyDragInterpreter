package com.python.pydraginterpreter;

import android.os.Bundle;

import com.python.pydraginterpreter.databinding.ActivityPythonCommentBinding;

public class PythonComment extends DrawerBase {



    ActivityPythonCommentBinding activityPythonCommentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPythonCommentBinding = ActivityPythonCommentBinding.inflate(getLayoutInflater());
        setContentView(activityPythonCommentBinding.getRoot());
        allocateActivityTitle("Python Comments");
    }
}