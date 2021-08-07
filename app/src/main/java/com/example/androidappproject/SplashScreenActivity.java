package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    //Animation
    Animation topAnim,bottomAnim;
    ImageView imageView;
    TextView textView,vaccination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //hooks
        imageView=findViewById(R.id.logo_id);
        textView=findViewById(R.id.splashtextview);
        vaccination = findViewById(R.id.vaccinationtxtview);

        //Asigning image and textview to the Animation
        imageView.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);
        vaccination.setAnimation(bottomAnim);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this, LoginActivity .class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}