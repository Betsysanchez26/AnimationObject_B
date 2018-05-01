package com.example.betsysanchez.animationobject_b;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;
    Button acelerate, anticipate,combination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
        acelerate = findViewById(R.id.btnAcelerate);
        anticipate = findViewById(R.id.btnAnticipate);
        combination = findViewById(R.id.btnCombitation);

        acelerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight - imageView.getHeight();
                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        imageView, "y", 0, targetY)
                        .setDuration(1000);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(300L);
                animator.start();
            }
        });
        anticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight - imageView.getHeight();
                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        imageView, "y", targetY, 0)
                        .setDuration(1000);
                animator.setInterpolator(new AnticipateInterpolator());
                animator.setDuration(300L);
                animator.start();
            }
        });
        combination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int screenHeight = canvas.getHeight();
                int targetY = screenHeight - imageView.getHeight();

                ObjectAnimator animator = ObjectAnimator.ofFloat(
                        imageView, "y", 0, targetY)
                        .setDuration(1000);
                animator.setInterpolator(new OvershootInterpolator());
                animator.start();
            }
        });
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", targetY, 0)
                .setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

}
