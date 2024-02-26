package com.example.engineeringportalvbspu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminRegistrationActivity extends AppCompatActivity {

    Button BtnRegistration,BtnLogin;
    EditText EdtAdminId, EdtAdminPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);
        getSupportActionBar().hide();

        EdtAdminId=findViewById(R.id.EdtAdminId);
        EdtAdminPassword=findViewById(R.id.EdtAdminPassword);
        BtnRegistration=findViewById(R.id.BtnRegistration);
        BtnLogin=findViewById(R.id.BtnLogin);
        mAuth=FirebaseAuth.getInstance();
        BtnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = EdtAdminId.getText().toString().trim();
                String password= EdtAdminPassword.getText().toString().trim();
                if(email.isEmpty())
                {
                    EdtAdminId.setError("Email is empty");
                    EdtAdminId.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    EdtAdminId.setError("Enter the valid email address");
                    EdtAdminId.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    EdtAdminPassword.setError("Enter the password");
                    EdtAdminPassword.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    EdtAdminPassword.setError("Length of the password should be more than 6");
                    EdtAdminPassword.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(AdminRegistrationActivity.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(AdminRegistrationActivity.this,"Not Allowed Try again",Toast.LENGTH_SHORT).show();
                        }
                    }
        });

            }
        });


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(AdminRegistrationActivity.this,AdminLoginActivity.class);
                startActivity(intent2);
            }
        });
    }
}