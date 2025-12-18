package com.universitysystem;

import java.util.Scanner;

public class AdminInterface {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Student s1 = new Student("Sipho", "S001");
        Student s2 = new Student("Nomsa", "S002");

        while (!exit) {
            System.out.println("\n--- University Management System ---");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. List Courses");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Course code: ");
                    String code = scanner.nextLine();
                    System.out.print("Course name: ");
                    String name = scanner.nextLine();
                    System.out.print("Maximum capacity: ");
                    int capacity = Integer.parseInt(scanner.nextLine());
                    CourseManagement.addCourse(code, name, capacity);
                    break;

                case "2":
                    System.out.print("Student ID (S001/S002): ");
                    String studentId = scanner.nextLine();
                    Student student = studentId.equals("S001") ? s1 : s2;

                    System.out.print("Course code: ");
                    String courseCode = scanner.nextLine();
                    Course course = CourseManagement.getCourseByCode(courseCode);
                    if (course != null) {
                        CourseManagement.enrollStudent(student, course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case "3":
                    System.out.print("Student ID (S001/S002): ");
                    studentId = scanner.nextLine();
                    student = studentId.equals("S001") ? s1 : s2;

                    System.out.print("Course code: ");
                    courseCode = scanner.nextLine();
                    course = CourseManagement.getCourseByCode(courseCode);

                    if (course != null) {
                        System.out.print("Grade: ");
                        double grade = Double.parseDouble(scanner.nextLine());
                        CourseManagement.assignGrade(student, course, grade);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case "4":
                    System.out.print("Student ID (S001/S002): ");
                    studentId = scanner.nextLine();
                    student = studentId.equals("S001") ? s1 : s2;

                    double overall = CourseManagement.calculateOverallGrade(student);
                    System.out.println(student.getName() + "'s overall grade: " + overall);
                    break;

                case "5":
                    CourseManagement.listCourses();
                    break;

                case "6":
                    exit = true;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
	}

}
