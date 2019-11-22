package com.example.kanikaapp.View;

import androidx.appcompat.app.AppCompatActivity;

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

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.spareparts1, R.drawable.spareparts2, R.drawable.spareparts3};
        v_flipper= findViewById(R.id.v_flipper);

//        startBtn = (Button) findViewById(R.id.startButton);
//
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, com.example.kanikaapp.View.SignupActivity.class));
//            }
//        });
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


