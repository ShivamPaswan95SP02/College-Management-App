package com.example.engineeringportalvbspu.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.engineeringportalvbspu.R;
import com.example.engineeringportalvbspu.faculty.AddTeacher;
import com.example.engineeringportalvbspu.faculty.TeacherAdapter;
import com.example.engineeringportalvbspu.faculty.TeacherData;
import com.example.engineeringportalvbspu.faculty.UpdateFaculty;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView itDepartment,csDepartment, electricalDepartment, mechanicalDepartment,ECEDepartment,EIEDepartment,mathDepartment,physicsDepartment,chemistryDepartment,humanitiesDepartment;
    private LinearLayout itNoData,csNoData, electricalNoData,mechanicalNoData,ECENoData,EIENoData,mathNoData,physNoData,chemistryNoData,humanNoData;
    private List<UserTeacherData> list1, list2, list3 , list4,list5,list6,list7,list8,list9,list10;
    private UserTeacherAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        itDepartment = view.findViewById(R.id.itDepartment);
        csDepartment = view.findViewById(R.id.csDepartment);
        electricalDepartment = view.findViewById(R.id.electricalDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        ECEDepartment = view.findViewById(R.id.ECEDepartment);
        EIEDepartment = view.findViewById(R.id.EIEDepartment);
        mathDepartment = view.findViewById(R.id.mathDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);
        humanitiesDepartment= view.findViewById(R.id.humanitiesDepartment);


        itNoData = view.findViewById(R.id.itNoData);
        csNoData = view.findViewById(R.id.csNoData);
        electricalNoData = view.findViewById(R.id.electricalNoData);
        mechanicalNoData = view.findViewById(R.id.mechanicalNoData);
        ECENoData = view.findViewById(R.id.ECENoData);
        EIENoData = view.findViewById(R.id.EIENoData);
        mathNoData = view.findViewById(R.id.mathNoData);
        physNoData = view.findViewById(R.id.physNoData);
        chemistryNoData = view.findViewById(R.id.chemistryNoData);
        humanNoData= view.findViewById(R.id.humanNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        itDepartment();
        csDepartment();
        electricalDepartment();
        mechanicalDepartment();
        ECEDepartment();
        EIEDepartment();
        mathDepartment();
        physicsDepartment();
        chemistryDepartment();
        humanitiesDepartment();

        return view;
    }


    private void itDepartment() {
        dbRef = reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);
                }else {
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list2.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list2, getContext());
                    itDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void electricalDepartment() {
        dbRef = reference.child("Electrical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    electricalNoData.setVisibility(View.VISIBLE);
                    electricalDepartment.setVisibility(View.GONE);
                }else {
                    electricalNoData.setVisibility(View.GONE);
                    electricalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list3.add(data);
                    }
                    electricalDepartment.setHasFixedSize(true);
                    electricalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list3, getContext());
                    electricalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {
                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list4.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list4, getContext());
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void ECEDepartment(){
        dbRef = reference.child("ECE Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ECENoData.setVisibility(View.VISIBLE);
                    ECEDepartment.setVisibility(View.GONE);
                }else {
                    ECENoData.setVisibility(View.GONE);
                    ECEDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list5.add(data);
                    }
                    ECEDepartment.setHasFixedSize(true);
                    ECEDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list5, getContext());
                    ECEDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void EIEDepartment() {
        dbRef = reference.child("EIE Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    EIENoData.setVisibility(View.VISIBLE);
                    EIEDepartment.setVisibility(View.GONE);
                }else {
                    EIENoData.setVisibility(View.GONE);
                    EIEDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list6.add(data);
                    }
                    EIEDepartment.setHasFixedSize(true);
                    EIEDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list6, getContext());
                    EIEDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void mathDepartment() {
        dbRef = reference.child("math Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mathNoData.setVisibility(View.VISIBLE);
                    mathDepartment.setVisibility(View.GONE);
                }else {
                    mathNoData.setVisibility(View.GONE);
                    mathDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list7.add(data);
                    }
                    mathDepartment.setHasFixedSize(true);
                    mathDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list7, getContext());
                    mathDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void physicsDepartment() {
        dbRef = reference.child("physics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    physNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }else {
                    physNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list8.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list8,getContext());
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void chemistryDepartment() {
        dbRef = reference.child("chemistry Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                }else {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list9.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list9, getContext());
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void humanitiesDepartment() {
        dbRef = reference.child("humanities Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    humanNoData.setVisibility(View.VISIBLE);
                    humanitiesDepartment.setVisibility(View.GONE);
                }else {
                    humanNoData.setVisibility(View.GONE);
                    humanitiesDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UserTeacherData data = snapshot.getValue(UserTeacherData.class);
                        list10.add(data);
                    }
                    humanitiesDepartment.setHasFixedSize(true);
                    humanitiesDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new UserTeacherAdapter(list10, getContext());
                    humanitiesDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}