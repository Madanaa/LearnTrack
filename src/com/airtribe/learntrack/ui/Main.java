package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();
    private final EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        seedSampleData();
        boolean running = true;

        while (running) {
            MenuPrinter.printMainMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    handleStudentMenu();
                    break;
                case 2:
                    handleCourseMenu();
                    break;
                case 3:
                    handleEnrollmentMenu();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting LearnTrack. Goodbye.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        }
    }

    private void handleStudentMenu() {
        boolean back = false;
        while (!back) {
            MenuPrinter.printStudentMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1:
                    addStudentFlow();
                    break;
                case 2:
                    printStudents(studentService.listStudents());
                    break;
                case 3:
                    searchStudentFlow();
                    break;
                case 4:
                    updateStudentFlow();
                    break;
                case 5:
                    deactivateStudentFlow();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        }
    }

    private void handleCourseMenu() {
        boolean back = false;
        while (!back) {
            MenuPrinter.printCourseMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1:
                    addCourseFlow();
                    break;
                case 2:
                    printCourses(courseService.listCourses());
                    break;
                case 3:
                    searchCourseFlow();
                    break;
                case 4:
                    updateCourseFlow();
                    break;
                case 5:
                    changeCourseStatus(false);
                    break;
                case 6:
                    changeCourseStatus(true);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        }
    }

    private void handleEnrollmentMenu() {
        boolean back = false;
        while (!back) {
            MenuPrinter.printEnrollmentMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1:
                    enrollStudentFlow();
                    break;
                case 2:
                    printEnrollments(enrollmentService.listEnrollments());
                    break;
                case 3:
                    viewEnrollmentsForStudentFlow();
                    break;
                case 4:
                    updateEnrollmentStatusFlow(EnrollmentStatus.COMPLETED);
                    break;
                case 5:
                    updateEnrollmentStatusFlow(EnrollmentStatus.CANCELLED);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu option.");
            }
        }
    }

    private void addStudentFlow() {
        try {
            String firstName = InputValidator.requireNonBlank(readLine("First name: "), "First name");
            String lastName = InputValidator.requireNonBlank(readLine("Last name: "), "Last name");
            String batch = InputValidator.requireNonBlank(readLine("Batch: "), "Batch");
            String email = readLine("Email (leave blank to use overloaded constructor): ").trim();

            Student student;
            if (email.isEmpty()) {
                student = studentService.addStudent(firstName, lastName, batch);
            } else {
                student = studentService.addStudent(firstName, lastName, InputValidator.requireEmail(email), batch);
            }
            System.out.println("Student added successfully: " + student);
        } catch (InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void searchStudentFlow() {
        try {
            int studentId = readPositiveInt("Enter student ID: ", "Student ID");
            Student student = studentService.findStudentById(studentId);
            System.out.println(student);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void updateStudentFlow() {
        try {
            int studentId = readPositiveInt("Enter student ID to update: ", "Student ID");
            String firstName = InputValidator.requireNonBlank(readLine("Updated first name: "), "First name");
            String lastName = InputValidator.requireNonBlank(readLine("Updated last name: "), "Last name");
            String email = InputValidator.requireEmail(readLine("Updated email: "));
            String batch = InputValidator.requireNonBlank(readLine("Updated batch: "), "Batch");
            Student student = studentService.updateStudent(studentId, firstName, lastName, email, batch);
            System.out.println("Student updated successfully: " + student);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void deactivateStudentFlow() {
        try {
            int studentId = readPositiveInt("Enter student ID to deactivate: ", "Student ID");
            Student student = studentService.deactivateStudent(studentId);
            System.out.println("Student deactivated: " + student);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void addCourseFlow() {
        try {
            String courseName = InputValidator.requireNonBlank(readLine("Course name: "), "Course name");
            String description = InputValidator.requireNonBlank(readLine("Description: "), "Description");
            int durationInWeeks = readPositiveInt("Duration in weeks: ", "Duration");
            Course course = courseService.addCourse(courseName, description, durationInWeeks);
            System.out.println("Course added successfully: " + course);
        } catch (InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void searchCourseFlow() {
        try {
            int courseId = readPositiveInt("Enter course ID: ", "Course ID");
            Course course = courseService.findCourseById(courseId);
            System.out.println(course);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void updateCourseFlow() {
        try {
            int courseId = readPositiveInt("Enter course ID to update: ", "Course ID");
            String courseName = InputValidator.requireNonBlank(readLine("Updated course name: "), "Course name");
            String description = InputValidator.requireNonBlank(readLine("Updated description: "), "Description");
            int durationInWeeks = readPositiveInt("Updated duration in weeks: ", "Duration");
            Course course = courseService.updateCourse(courseId, courseName, description, durationInWeeks);
            System.out.println("Course updated successfully: " + course);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void changeCourseStatus(boolean active) {
        try {
            int courseId = readPositiveInt("Enter course ID: ", "Course ID");
            Course course = active ? courseService.activateCourse(courseId) : courseService.deactivateCourse(courseId);
            String action = active ? "activated" : "deactivated";
            System.out.println("Course " + action + ": " + course);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void enrollStudentFlow() {
        try {
            int studentId = readPositiveInt("Enter student ID: ", "Student ID");
            int courseId = readPositiveInt("Enter course ID: ", "Course ID");
            Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
            System.out.println("Enrollment created successfully: " + enrollment);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void viewEnrollmentsForStudentFlow() {
        try {
            int studentId = readPositiveInt("Enter student ID: ", "Student ID");
            List<Enrollment> studentEnrollments = enrollmentService.getEnrollmentsForStudent(studentId);
            printEnrollments(studentEnrollments);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void updateEnrollmentStatusFlow(EnrollmentStatus status) {
        try {
            int enrollmentId = readPositiveInt("Enter enrollment ID: ", "Enrollment ID");
            Enrollment enrollment = enrollmentService.updateEnrollmentStatus(enrollmentId, status);
            System.out.println("Enrollment updated: " + enrollment);
        } catch (EntityNotFoundException | InvalidInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private void printEnrollments(List<Enrollment> enrollments) {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments available.");
            return;
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }

    private int readMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private int readPositiveInt(String prompt, String fieldName) throws InvalidInputException {
        return InputValidator.requirePositiveInt(readLine(prompt), fieldName);
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private void seedSampleData() {
        studentService.addStudent("Asha", "Sharma", "asha.sharma@example.com", "Java-01");
        studentService.addStudent("Rohit", "Mehta", "Java-02");
        courseService.addCourse("Core Java", "Java fundamentals for beginners", 8);
        courseService.addCourse("OOP in Java", "Classes, objects, inheritance, and polymorphism", 6);
    }
}
