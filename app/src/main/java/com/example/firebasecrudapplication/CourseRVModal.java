package com.example.firebasecrudapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseRVModal implements Parcelable {
    private String courseName, coursePrice, courseSuitedFor, courseImg, courseLink, courseDesc;
    private String courseID;


    public CourseRVModal(){

    }

    public CourseRVModal(String courseName, String coursePrice, String courseSuitedFor, String courseImg, String courseLink, String courseDesc, String courseID) {
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.courseSuitedFor = courseSuitedFor;
        this.courseImg = courseImg;
        this.courseLink = courseLink;
        this.courseDesc = courseDesc;
        this.courseID = courseID;
    }

    protected CourseRVModal(Parcel in) {
        courseName = in.readString();
        coursePrice = in.readString();
        courseSuitedFor = in.readString();
        courseImg = in.readString();
        courseLink = in.readString();
        courseDesc = in.readString();
        courseID = in.readString();
    }

    public static final Creator<CourseRVModal> CREATOR = new Creator<CourseRVModal>() {
        @Override
        public CourseRVModal createFromParcel(Parcel in) {
            return new CourseRVModal(in);
        }

        @Override
        public CourseRVModal[] newArray(int size) {
            return new CourseRVModal[size];
        }
    };

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseSuitedFor() {
        return courseSuitedFor;
    }

    public void setCourseSuitedFor(String courseSuitedFor) {
        this.courseSuitedFor = courseSuitedFor;
    }

    public String getCourseImg() {
        return courseImg;
    }

    public void setCourseImg(String courseImg) {
        this.courseImg = courseImg;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(courseName);
        parcel.writeString(coursePrice);
        parcel.writeString(courseSuitedFor);
        parcel.writeString(courseImg);
        parcel.writeString(courseLink);
        parcel.writeString(courseDesc);
        parcel.writeString(courseID);
    }
}
