package com.ankur.motiongraphy;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;


public class BContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_b);
        Slide slideTransition = new Slide(Gravity.BOTTOM);
        slideTransition.addTarget(R.id.tvMario);
        slideTransition.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in));
        getWindow().setEnterTransition(slideTransition);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

}