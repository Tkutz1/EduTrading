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
    //private ImageButton profile, message, map, calendar,addsession, sessionList, logout;
    private TextView nameText;
    private LinearLayout profile, message, map, calendar, addsession,sessionList,logout;
    //public static Student user;
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
            }
        });

        //Logout button
        logout = (LinearLayout) findViewById(R.id.logoutsess6);
        logout.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
             //   LogOut();
            }
        });



        //Profile button
        profile = (LinearLayout) findViewById(R.id.profilelaylout1);
        profile.setEnabled(false);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   openProfileActivity();
            }
        });

        //Message button
        message = (LinearLayout) findViewById(R.id.messagelayout2);
        message.setEnabled(false);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    openMessageActivity();
            }
        });

        // Stocks button
        sessionList = (LinearLayout) findViewById(R.id.mysesslayout5);
        sessionList.setEnabled(false);
        sessionList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
          //      openStocks();
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
    public void openStocks() {

    }

    //Message button
    public void openMessageActivity(){

    }


    //Profile button
    public void openProfileActivity(){

    }



}