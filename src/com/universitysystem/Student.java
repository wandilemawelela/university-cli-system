package com.universitysystem;

import java.util.HashMap;
import java.util.Map;

public class Student {
	 // Encapsulated instance variables
    private String name;
    private String id;
    private Map<Course, Double> courseGrades;

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courseGrades = new HashMap<>();
    }

    // Getters and setters (encapsulation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }

    // Enroll student in a course
    public void enrollCourse(Course course) {
        if (!courseGrades.containsKey(course)) {
            courseGrades.put(course, null); // grade not assigned yet
        }
    }

    // Assign grade for a course
    public void assignGrade(Course course, double grade) {
        if (courseGrades.containsKey(course)) {
            courseGrades.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }
}
