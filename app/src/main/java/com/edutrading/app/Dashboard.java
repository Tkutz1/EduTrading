package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.firebase.auth.FirebaseAuth;


public class Dashboard extends Main {
    private TextView nameText;
    private LinearLayout profile, alert, map, calendar, addsession,sessionList,logout;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        nameText = findViewById(R.id.textView1);
        nameText.setText("Loading...");
        Intent i = getIntent();
        Bundle b = i.getExtras();


        map = (LinearLayout) findViewById(R.id.maplayout4);
        map.setEnabled(false);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this,"Tips4 successful",Toast.LENGTH_LONG).show();
                openTips();
            }
        });

        //Logout button
        logout = (LinearLayout) findViewById(R.id.logoutsess6);
        logout.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
             LogOut();
            }
        });



        //Profile button
        profile = (LinearLayout) findViewById(R.id.profilelaylout1);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        //Message button
          alert = (LinearLayout) findViewById(R.id.messagelayout2);
          alert.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  openAlerts();
              }
          });

        // Tips button
        profile = (LinearLayout) findViewById(R.id.tipbutton);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTips();
            }
        });
    }

    //Logout button
    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Dashboard.this,"Log-out successful",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Dashboard.this, Main.class);
        startActivity(intent);
        finish();
    }
    //Map button
    public void openMapActivity(){

    }
    // Stocks Button
    public void openTips() {
        Intent intent = new Intent(Dashboard.this, Tips.class);
        startActivity(intent);
        finish();
    }
    //Alerts button
    public void openAlerts(){
        Intent intent = new Intent(Dashboard.this, Alerts.class);
        startActivity(intent);
        finish();
    }
    //Profile button
    public void openProfile(){
        Intent intent = new Intent(Dashboard.this, Profile.class);
        startActivity(intent);
        finish();
    }

}