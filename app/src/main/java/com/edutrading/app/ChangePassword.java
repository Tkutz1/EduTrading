package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ChangePassword extends Main{
    public Button Return, Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        Return = findViewById(R.id.returnbutton3);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangePassword.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
        Logout = findViewById(R.id.logoutbutton3);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ChangePassword.this, "Log-out successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ChangePassword.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
