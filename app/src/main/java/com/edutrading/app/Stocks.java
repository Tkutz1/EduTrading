package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Stocks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button Return, Logout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stocks);
        Return = findViewById(R.id.button5);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Stocks.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        Logout = findViewById(R.id.button6);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Stocks.this,"Log-out successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Stocks.this, Main.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
