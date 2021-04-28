package com.edutrading.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private EditText email_SI, password_SI;
    private Button SignUp_SI, LogIn_SI;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        firebaseAuth = FirebaseAuth.getInstance();
        email_SI = findViewById(R.id.editTextEmailLI);
        password_SI = findViewById(R.id.editTextPasswordLI);
        LogIn_SI = findViewById(R.id.buttonLogInLI);
        progressDialog = new ProgressDialog(this);
        SignUp_SI= findViewById(R.id.buttonRegisterLI);



        LogIn_SI.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Login();

            }


        });

        SignUp_SI.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Main.this, Signup.class);
                startActivity(intent);
                finish();
            }



        });

    }


    private void Login(){
        String email = email_SI.getText().toString();
        String password = password_SI.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_SI.setError("Enter Your Email");
            return;
        }
        else if(TextUtils.isEmpty(password)){
            password_SI.setError("Enter Your Password");
            return;
        }

        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    final FirebaseAuth auth = FirebaseAuth.getInstance();
                    final FirebaseUser userAuth = auth.getCurrentUser();
                    final String uid = userAuth.getUid();
                    Toast.makeText(Main.this,"Log-in successful",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main.this, Dashboard.class);
                    Log.d("MainActivity", "jumping to find user function...");




                    intent.putExtra("userID", uid);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(Main.this,"Log In fail!",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }



}
