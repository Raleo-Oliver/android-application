package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AboutVaccineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_vaccine);

        getSupportActionBar().setTitle("About Vaccine");
    }
    public void answer(View view) {
        //takes you to the website
         Intent intentObj = new Intent(Intent.ACTION_VIEW);
        intentObj.setData(Uri.parse("https://www.who.int/news-room/q-a-detail/vaccines-and-immunization-what-is-vaccination?adgroupsurvey={adgroupsurvey}&gclid=EAIaIQobChMIvZr7prqU8gIVF7LVCh2MSwEREAAYAyAAEgI3y_D_BwE"));
          startActivity(intentObj);

    }
}