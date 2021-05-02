package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ChangeEmail extends Main{
    private Button Return, Logout, Submit;
    private EditText Email, NewEmail;
    private String EmailStr, NewEmailStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_email);

        Return = findViewById(R.id.returnbutton3);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeEmail.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
        Logout = findViewById(R.id.logoutbutton3);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ChangeEmail.this,"Log-out successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ChangeEmail.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
        Submit = findViewById(R.id.submitbutton2);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = findViewById(R.id.reeditPassword);
                NewEmail = findViewById(R.id.reeditEmail);
                EmailStr = Email.getText().toString();
                NewEmailStr = NewEmail.getText().toString();
                if(TextUtils.isEmpty(EmailStr)){
                    Email.setError("Enter New Email");
                    return;
                }
                else if(TextUtils.isEmpty(NewEmailStr)){
                    NewEmail.setError("Re-Enter Password");
                    return;
                }
                else if(!EmailStr.equals(NewEmailStr)){
                    NewEmail.setError("Emails Don't Match");
                    return;
                }
                Toast.makeText(ChangeEmail.this,"Successfully Changed Email",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ChangeEmail.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
