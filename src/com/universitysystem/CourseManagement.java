package com.universitysystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseManagement {
	 // List of all courses in the system
    private static List<Course> courses = new ArrayList<>();

    // Add a new course
    public static void addCourse(String code, String name, int maxCapacity) {
        Course course = new Course(code, name, maxCapacity);
        courses.add(course);
        System.out.println("Course added: " + name);
    }

    // Enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        if (course.enrollStudent()) {
            student.enrollCourse(course);
            System.out.println(student.getName() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Cannot enroll. Course " + course.getCourseName() + " is full.");
        }
    }

    // Assign grade to a student
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        System.out.println("Grade " + grade + " assigned to " + student.getName() + " for " + course.getCourseName());
    }

    // Calculate overall grade for a student
    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = student.getCourseGrades();
        if (grades.isEmpty()) return 0;

        double total = 0;
        int count = 0;
        for (Double grade : grades.values()) {
            if (grade != null) {
                total += grade;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    // Optional: list all courses
    public static void listCourses() {
        System.out.println("Available Courses:");
        for (Course c : courses) {
            System.out.println(c.getCourseCode() + " - " + c.getCourseName() + " (" + c.getEnrolledCount() + "/" + c.getMaxCapacity() + ")");
        }
    }

    // Optional: get course by code
    public static Course getCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}
