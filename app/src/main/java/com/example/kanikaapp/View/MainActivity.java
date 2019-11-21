package com.example.kanikaapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.kanikaapp.R;


public class MainActivity extends AppCompatActivity {

    private Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startButton);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.kanikaapp.View.SignupActivity.class));
            }
        });

        TextView textview = (TextView)findViewById(R.id.txt);
        Animation textAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        textview.startAnimation(textAnim);

        textAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation textAnim) {
            }

            @Override
            public void onAnimationRepeat(Animation textAnim) {
            }

            @Override
            public void onAnimationEnd(Animation textAnim) {
                startActivity(new Intent(MainActivity.this, com.example.kanikaapp.View.LoginActivity.class));
            }
        });


    }

}


