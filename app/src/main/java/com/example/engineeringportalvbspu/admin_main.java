package com.example.engineeringportalvbspu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.engineeringportalvbspu.faculty.UpdateFaculty;
import com.example.engineeringportalvbspu.notice.DeleteNoticeActivity;
import com.example.engineeringportalvbspu.notice.UploadNotice;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class admin_main extends AppCompatActivity implements View.OnClickListener {


    FirebaseAuth mAuth;

CardView uploadNotice ,addGalleryImage,addEbook,faculty,deleteNotice,newAdminRg,BtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_main);
        uploadNotice=findViewById(R.id.addNotice);
        addGalleryImage =findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNotice = findViewById(R.id.deleteNotice);
        newAdminRg=findViewById(R.id.newAdminRg);
        BtnLogout=findViewById(R.id.BtnLogout);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        newAdminRg.setOnClickListener(this);
        BtnLogout.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){


            case R.id.addNotice:
                intent=new Intent(admin_main.this, UploadNotice.class);
                startActivity(intent);
                break;

            case R.id.addGalleryImage:
                 intent=new Intent(admin_main.this,UploadImage.class);
                startActivity(intent);
                break;

            case R.id.addEbook:
                intent=new Intent(admin_main.this,UploadPdfActivity.class);
                startActivity(intent);
                break;

            case R.id.faculty:
                intent=new Intent(admin_main.this, UpdateFaculty.class);
                startActivity(intent);
                break;
            case R.id.deleteNotice:
                intent=new Intent(admin_main.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.newAdminRg:
                intent=new Intent(admin_main.this, AdminRegistrationActivity.class);
                startActivity(intent);
                break;

            case R.id.BtnLogout:
                mAuth.signOut();
                finish();
                intent=new Intent(admin_main.this, MainActivity.class);
                startActivity(intent);

                break;

        }

    }
}