package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class DisplayCodeActivity extends AppCompatActivity {

    Button display;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_code);

        //changing action bar title
        getSupportActionBar().setTitle("C Language Code");

        textView=findViewById(R.id.textV);
        display=(Button)findViewById(R.id.displaybtn);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="";

                try{
                    InputStream input=getAssets().open("CProgram.c");
                    int size=input.available();
                    byte[] buffer=new byte[size];
                    input.read(buffer);
                    input.close();

                    text = new String(buffer);

                }catch (Exception ex){
                    ex.printStackTrace();

                }
                textView.setText((CharSequence) text);

            }
        });
    }
}