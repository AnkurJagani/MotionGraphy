package com.ankur.motiongraphy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View cardView;
    private View imgAnimation;
    private View btnClick;
    private View tvTest;
    private boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardView = findViewById(R.id.cardView);
        imgAnimation = findViewById(R.id.imgAnimation);
        tvTest = findViewById(R.id.tvTest);
        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnClick) {
            btnClickListener();
        }
    }

    private void btnClickListener() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        if (isVisible) {
            TransitionManager.beginDelayedTransition(viewGroup, new Slide(Gravity.TOP));
            cardView.setVisibility(View.INVISIBLE);
            tvTest.setVisibility(View.INVISIBLE);
        } else {
            TransitionManager.beginDelayedTransition(viewGroup, new Slide(Gravity.TOP));
            cardView.setVisibility(View.VISIBLE);
            tvTest.setVisibility(View.VISIBLE);
        }
        isVisible = !isVisible;
    }
}