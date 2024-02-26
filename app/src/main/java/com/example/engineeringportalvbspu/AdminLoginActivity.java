package com.example.engineeringportalvbspu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {
    Button BtnLogin;
    EditText EdtAdminId, EdtAdminPassword;
    FirebaseAuth mAuth;
    TextView btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        getSupportActionBar().hide();

        EdtAdminId=findViewById(R.id.EdtAdminId);
        EdtAdminPassword=findViewById(R.id.EdtAdminPassword);
        BtnLogin=findViewById(R.id.BtnLogin);
        btn_reset=findViewById(R.id.btn_reset);
        mAuth=FirebaseAuth.getInstance();


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = EdtAdminId.getText().toString().trim();
                String password = EdtAdminPassword.getText().toString().trim();
                if (email.isEmpty()) {
                    EdtAdminId.setError("Email is empty");
                    EdtAdminId.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    EdtAdminId.setError("Enter the valid email");
                    EdtAdminId.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    EdtAdminPassword.setError("Password is empty");
                    EdtAdminPassword.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    EdtAdminPassword.setError("Length of password is more than 6");
                    EdtAdminPassword.requestFocus();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task ->
                {
                    if (task.isSuccessful()) {
                        Intent intent = new Intent(AdminLoginActivity.this,admin_main.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AdminLoginActivity.this, "Please Check Your login Credentials", Toast.LENGTH_SHORT).show();
                    }

                });
            }
            });

   btn_reset.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if(EdtAdminId.length() ==0)
           {
               Toast.makeText(AdminLoginActivity.this, "Please Enter Your Email ID", Toast.LENGTH_SHORT).show();
           }
           else
           {
               FirebaseAuth.getInstance().setLanguageCode("en"); // Set to English
               FirebaseAuth.getInstance().sendPasswordResetEmail(EdtAdminId.getText().toString());
               Toast.makeText(AdminLoginActivity.this, "Reset request sent on your email", Toast.LENGTH_SHORT).show();
           }
       }
   });

        }


}
