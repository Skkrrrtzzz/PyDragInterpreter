package com.python.pydraginterpreter;

import android.os.Bundle;

import com.python.pydraginterpreter.databinding.ActivityMainLearnBinding;

public class MainLearn extends DrawerBase {

    //Activity main binding kasi ay nasa main activity main sya
    //kung sa PythonComment sya dpt ay ActivityPythonCommentBinding
    ActivityMainLearnBinding MainLearnBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainLearnBinding = ActivityMainLearnBinding.inflate(getLayoutInflater());
        setContentView(MainLearnBinding.getRoot());
        allocateActivityTitle("MainLearn");
    }
}