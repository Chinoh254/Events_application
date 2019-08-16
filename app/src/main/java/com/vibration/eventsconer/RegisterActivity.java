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

public class RegisterActivity extends AppCompatActivity {
    EditText UserFirstNm,UserSecondNm,UserPassword,ConfirmPassword,UserEmail;
    Button btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser=mAuth.getCurrentUser();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        findIds();
        validate();
    }

    public void RegisterUser(View view) {


        if (validate()) {
            String reg_email = UserEmail.getText().toString().trim();
            String reg_password = UserPassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(reg_email, reg_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Registration was successful", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));

                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration was successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }
    }

    private boolean validate() {
        boolean result = false;
        String getFirstNm = UserFirstNm.getText().toString();
        String getSecondNm = UserSecondNm.getText().toString();
        String getEmail = UserEmail.getText().toString();
        String getPassword = UserPassword.getText().toString();
        String getConfirmPassword = ConfirmPassword.getText().toString();

        if (getFirstNm.isEmpty()) {
            Toast.makeText(this, "The username is Empty", Toast.LENGTH_SHORT).show();
        }else if (getSecondNm.isEmpty()){
            Toast.makeText(this, "The username is Empty", Toast.LENGTH_SHORT).show();
        }else if (getEmail.isEmpty()) {
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
        } else if (getPassword.isEmpty()) {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
        } else if (getConfirmPassword.isEmpty()) {
            Toast.makeText(this, "Confirm password empty", Toast.LENGTH_SHORT).show();
        }
//        else if (getpassword.equals(confirmpassword)){
//            Toast.makeText(this, "Password Mismatched", Toast.LENGTH_SHORT).show();
//        }
        else {
            result = true;
        }
        return result;

    }

    private void findIds() {
        UserFirstNm=(EditText)findViewById(R.id.etFirstNm);
        UserSecondNm=(EditText)findViewById(R.id.etSecondNm);
        UserEmail=(EditText)findViewById(R.id.etUserEmail);
        UserPassword=(EditText)findViewById(R.id.etConfirmPass);
        ConfirmPassword=(EditText)findViewById(R.id.etConfirmPass);
        btnRegister=(Button)findViewById(R.id.btnRegister);
    }
    public void GoToLogin(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}
