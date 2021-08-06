package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changing action bar title
        getSupportActionBar().setTitle("Home");

    }
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    @RequiresApi(api = M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.dial_item:

                Intent intentDial =new Intent(Intent.ACTION_DIAL);
                intentDial.setData(Uri.parse("tel:"+"0784111637"));
                if (Build.VERSION.SDK_INT >= M) {
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);;
                    }
                }
                intentDial.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDial);


                return true;
            case R.id.email_item:
               // startActivity(new Intent(this, Screen.class));
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                String to []={"raleooliver@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"hey");
                intent.putExtra(Intent.EXTRA_TEXT,"Vaccine");
                intent.setType("message/rfc822");
                startActivity(intent);

                //takes you to the website
                // Intent intentObj = new Intent(Intent.ACTION_VIEW);
                //intentObj.setData(Uri.parse("https://www.abhiandroid.com"));
                //  startActivity(intentObj);

                return true;
            case R.id.code_item:
                Intent intentCode = new Intent(MainActivity.this, DisplayCodeActivity.class);
                startActivity(intentCode);
                return true;
            case R.id.about_item:
                Intent intentabout= new Intent(MainActivity.this, AboutVaccineActivity.class);
                startActivity(intentabout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void vaccine(View view) {
        Intent intent = new Intent(MainActivity.this, VaccineActivity.class);
        startActivity(intent);
    }
    public void register(View view) {
        Intent intent = new Intent(MainActivity.this, VaccineRegisterActivity.class);
        startActivity(intent);
    }
    public void personalInfo(View view) {
        Intent intent = new Intent(MainActivity.this, PersonalDetailsActivity.class);
        startActivity(intent);
    }
    public void appointment(View view) {
        Intent intent = new Intent(MainActivity.this, AppointmentActivity.class);
        startActivity(intent);
    }
}