package com.ankur.motiongraphy;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Scene;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionManager;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private Scene firstScene;
    private Scene nextScene;
    private Scene currentScene;
    private Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        FrameLayout flContainer = findViewById(R.id.flContainer);
        // Step 1: Create a Scene object for both the starting and ending layout
        firstScene = Scene.getSceneForLayout(flContainer, R.layout.layout_scene_first, this);
        nextScene = Scene.getSceneForLayout(flContainer, R.layout.layout_scene_next, this);
        firstScene.enter();
        currentScene = firstScene;
        // Step 2: Create a Transition object to define what type of animation you want
        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_4);
    }

    @Override
    public void onClick(View view) {
        // Step 3: Call TransitionManager.go() to run animation
        if (currentScene == firstScene) {
            // nextScene.enter();
            TransitionManager.go(nextScene, transition);
            currentScene = nextScene;
        } else {
            // firstScene.enter();
            TransitionManager.go(firstScene, transition);
            currentScene = firstScene;
        }
    }

}