package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Dashboard extends Main {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout profile, alert, tips, Stock,logout;
        TextView nameText;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        nameText = findViewById(R.id.textView1);
        nameText.setText("Loading...");
        Intent i = getIntent();
        Bundle b = i.getExtras();


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

        //Alert button
          alert = (LinearLayout) findViewById(R.id.messagelayout2);
          alert.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  openAlerts();
              }
          });

        Stock = (LinearLayout) findViewById(R.id.StockButton);
        Stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStocks();
            }
        });

        // Tips button
        tips = (LinearLayout) findViewById(R.id.tipbutton);
        tips.setOnClickListener(new View.OnClickListener() {
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
    //Stocks button
    public void openStocks(){
        Intent intent = new Intent(Dashboard.this, Stocks.class);
        startActivity(intent);
        finish();
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