package com.universitysystem;

public class Course {
	// Instance variables
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledCount;

    // Static variable to track all enrollments
    private static int totalEnrolledStudents = 0;

    // Constructor
    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledCount = 0;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    // Static getter
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    // Enroll a student in this course
    public boolean enrollStudent() {
        if (enrolledCount < maxCapacity) {
            enrolledCount++;
            totalEnrolledStudents++;
            return true; // successful enrollment
        } else {
            return false; // course full
        }
    }
}
