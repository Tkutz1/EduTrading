package com.edutrading.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;


public class Signup extends Main {

    private EditText email_SU, password1_SU, password2_SU;
    private Button SignUp_SU, LogIn_SU;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuplayout);
        firebaseAuth = FirebaseAuth.getInstance();
        email_SU = findViewById(R.id.editTextEmailSU);
        password1_SU = findViewById(R.id.editTextTextPasswordSU);
        password2_SU = findViewById(R.id.editTextTextPasswordSU2);
        SignUp_SU = findViewById(R.id.buttonSignUpSU);
        progressDialog = new ProgressDialog(this);
        LogIn_SU = findViewById(R.id.buttonLogInSU);



        SignUp_SU.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Register();
            }
        });

        LogIn_SU.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Signup.this, Main.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void Register(){
        String email = email_SU.getText().toString();
        String password1 = password1_SU.getText().toString();
        String password2 = password2_SU.getText().toString();
        if(TextUtils.isEmpty(email)){
            email_SU.setError("Enter Your Email");
            return;
        }
        else if(TextUtils.isEmpty(password1)){
            password1_SU.setError("Enter Your Password");
            return;
        }
        else if(TextUtils.isEmpty(password2)){
            password2_SU.setError("Re-Enter Your Password");
            return;
        }
        else if(!password1.equals(password2)){
            password2_SU.setError("Passwords Don't Match");
            return;
        }
        else if(password1.length()<6){
            password1_SU.setError("Password should be longer than 6 characters");
            return;
        }
        else if(!isValidEmail(email)){
            email_SU.setError("Invalid Email");
            return;
        }

        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Signup.this,"Successfully Registered",Toast.LENGTH_LONG).show();
            //        Intent intent = new Intent(Signup.this, EnterClasses.class);
                    final FirebaseAuth auth = FirebaseAuth.getInstance();
                    final FirebaseUser user = auth.getCurrentUser();
                    final String uid = user.getUid();
                    Log.d("Signup Activity","UID = "+uid);
                    Intent intent = new Intent(Signup.this, Main.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(Signup.this,"Sign up fail!",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }

    private Boolean isValidEmail(CharSequence target_email){
        return (!TextUtils.isEmpty(target_email)&& Patterns.EMAIL_ADDRESS.matcher(target_email).matches());

    }

}
