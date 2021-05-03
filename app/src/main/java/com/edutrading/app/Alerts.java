package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Alerts extends AppCompatActivity {
    private Button Return, Logout, Clear;
    private TextView Alert1, Alert2, Alert3, Alert4, Alert5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerts);
        Return = findViewById(R.id.button);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alerts.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        Logout = findViewById(R.id.button3);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Alerts.this, "Log-out successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Alerts.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
        Clear = findViewById(R.id.button4);
        Alert1 = (TextView)findViewById(R.id.textView4);
        Alert2 = (TextView)findViewById(R.id.textView6);
        Alert3 = (TextView)findViewById(R.id.textView9);
        Alert4 = (TextView)findViewById(R.id.textView8);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alert1.setText(" ");
                Alert2.setText(" ");
                Alert3.setText(" ");
                Alert4.setText(" ");
            }
        });
    }
}
