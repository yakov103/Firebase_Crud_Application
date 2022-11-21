package com.example.firebasecrudapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditCourseActivity extends AppCompatActivity {

    private TextInputEditText courseNameEdt,  coursePriceEdt ,courseSuitedForEdt, CourseImgEdt,CourseLinkEdt, CourseDescEdt;
    private Button updateCourseBtn, deleteCourseBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String courseID; // for update operation
    private CourseRVModal courseRVModal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);
        firebaseDatabase = FirebaseDatabase.getInstance();

        courseNameEdt = findViewById(R.id.idEdtCourseName);
        coursePriceEdt = findViewById(R.id.idEdtCoursePrice);
        courseSuitedForEdt = findViewById(R.id.idEdtCourseSuidtedFor);
        CourseImgEdt = findViewById(R.id.idEdtCourseImageLink);
        CourseLinkEdt = findViewById(R.id.idEdtCourseLink);
        CourseDescEdt = findViewById(R.id.idEdtCourseDesc);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDeleteCourse);
        loadingPB = findViewById(R.id.idPBLoading);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Courses");
        courseRVModal = getIntent().getParcelableExtra("course");
        if (courseRVModal != null){
            courseNameEdt.setText(courseRVModal.getCourseName());
            coursePriceEdt.setText(courseRVModal.getCoursePrice());
            courseSuitedForEdt.setText(courseRVModal.getCourseSuitedFor());
            CourseImgEdt.setText(courseRVModal.getCourseImg());
            CourseLinkEdt.setText(courseRVModal.getCourseLink());
            CourseDescEdt.setText(courseRVModal.getCourseDesc());
            courseID = courseRVModal.getCourseID();
        }

        databaseReference = firebaseDatabase.getReference("Courses").child(courseID);
        updateCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingPB.setVisibility(View.VISIBLE);
                String courseName = courseNameEdt.getText().toString();
                String coursePrice = coursePriceEdt.getText().toString();
                String courseSuitedFor = courseSuitedForEdt.getText().toString();
                String courseImg = CourseImgEdt.getText().toString();
                String courseLink = CourseLinkEdt.getText().toString();
                String courseDesc = CourseDescEdt.getText().toString();
                CourseRVModal courseRVModal = new CourseRVModal(courseName, coursePrice, courseSuitedFor, courseImg, courseLink, courseDesc, courseID);
                databaseReference.setValue(courseRVModal);
                finish();
            }
        });

    }
}