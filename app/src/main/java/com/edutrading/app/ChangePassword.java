package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ChangePassword extends Main{
    private String Password, NewPassword;
    private EditText PassText, NewPassText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button Return, Logout, Submit;
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
        Submit = findViewById(R.id.submitbutton2);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassText = findViewById(R.id.editPassword);
                NewPassText = findViewById(R.id.reeditPassword);
                Password = PassText.getText().toString();
                NewPassword = NewPassText.getText().toString();
                if(TextUtils.isEmpty(Password)){
                    PassText.setError("Enter New Password");
                    return;
                }
                else if(TextUtils.isEmpty(NewPassword)){
                    NewPassText.setError("Re-Enter Password");
                    return;
                }
                else if(!Password.equals(NewPassword)){
                    NewPassText.setError("Passwords Don't Match");
                    return;
                }
                else if(Password.length()<6){
                    PassText.setError("Password should be longer than 6 characters");
                    return;
                }
                Toast.makeText(ChangePassword.this,"Successfully Changed Password",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ChangePassword.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
