package com.example.firebasecrudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddCourseActivity extends AppCompatActivity {

    private TextInputEditText courseNameEdt,  coursePriceEdt ,courseSuitedForEdt, CourseImgEdt,CourseLinkEdt, CourseDescEdt;
    private Button addCourseBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String courseID; // for update operation


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        coursePriceEdt = findViewById(R.id.idEdtCoursePrice);
        courseSuitedForEdt = findViewById(R.id.idEdtCourseSuitedFor);
        CourseImgEdt = findViewById(R.id.idEdtCourseImageLink);
        CourseLinkEdt = findViewById(R.id.idEdtCourseLink);
        CourseDescEdt = findViewById(R.id.idEdtCourseDesc);
        addCourseBtn = findViewById(R.id.inBtnAddCourse);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Courses");

        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = courseNameEdt.getText().toString();
                String coursePrice = coursePriceEdt.getText().toString();
                String courseSuitedFor = courseSuitedForEdt.getText().toString();
                String courseImg = CourseImgEdt.getText().toString();
                String courseLink = CourseLinkEdt.getText().toString();
                String courseDesc = CourseDescEdt.getText().toString();
                courseID = courseName;
                CourseRVModal courseRVModal = new CourseRVModal(courseName, coursePrice, courseSuitedFor, courseImg, courseLink, courseDesc, courseID);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(courseID).setValue(courseRVModal);
                        Toast.makeText(AddCourseActivity.this, "Course Added Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddCourseActivity.this, MainActivity.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(AddCourseActivity.this, "Error is "+ error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });


    }
}