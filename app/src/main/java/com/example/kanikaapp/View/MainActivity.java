package com.example.kanikaapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.kanikaapp.R;


public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private CardView cardView1;
    private CardView cardView2;

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.image4, R.drawable.image11, R.drawable.images12,R.drawable.image13};
        v_flipper= findViewById(R.id.v_flipper);

//        startBtn = (Button) findViewById(R.id.startButton);
//
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, com.example.kanikaapp.View.SignupActivity.class));
//            }
//        });
        cardView1= findViewById(R.id.v_user);
        cardView2= findViewById(R.id.v_shareholder);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        for (int image:images){
            flipperImages(image);
        }

    }
    public void flipperImages(int image){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.setAutoStart(true);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

}


