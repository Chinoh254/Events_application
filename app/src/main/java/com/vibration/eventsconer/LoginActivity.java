package com.vibration.eventsconer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText mEmailAddress,mPassword;
    Button mButtonLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        //check if user is signed in (no-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailAddress=(EditText)findViewById(R.id.etUserEmail);
        mPassword=(EditText)findViewById(R.id.etUserPassword);
        mButtonLogin=(Button)findViewById(R.id.btnLogin);
        mAuth=FirebaseAuth.getInstance();

        validate();
    }

    private boolean validate() {
        boolean result=false;

        String getmEmail=mEmailAddress.getText().toString();
        String getmPass=mPassword.getText().toString();

        if (getmEmail.isEmpty()){
            Toast.makeText(this, "Email value is null", Toast.LENGTH_SHORT).show();
        }else if (getmPass.isEmpty()){
            Toast.makeText(this, "Password is null", Toast.LENGTH_SHORT).show();
        }else {
            result=true;
        }
        return result;
    }

    public void LogInUser(View view) {
        if (validate()) {
            String email = mEmailAddress.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Logged in Successful", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(LoginActivity.this, PostEventActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Log in Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        //startActivity(new Intent(LoginActivity.this,PostEventActivity.class));
    }

    public void GoToRegistration(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}
