package com.airtribe.learntrack.ui;

final class MenuPrinter {
    private MenuPrinter() {
    }

    static void printMainMenu() {
        System.out.println();
        System.out.println("===== LearnTrack =====");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    static void printStudentMenu() {
        System.out.println();
        System.out.println("--- Student Management ---");
        System.out.println("1. Add new student");
        System.out.println("2. View all students");
        System.out.println("3. Search student by ID");
        System.out.println("4. Update student");
        System.out.println("5. Deactivate student");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    static void printCourseMenu() {
        System.out.println();
        System.out.println("--- Course Management ---");
        System.out.println("1. Add new course");
        System.out.println("2. View all courses");
        System.out.println("3. Search course by ID");
        System.out.println("4. Update course");
        System.out.println("5. Deactivate course");
        System.out.println("6. Activate course");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }

    static void printEnrollmentMenu() {
        System.out.println();
        System.out.println("--- Enrollment Management ---");
        System.out.println("1. Enroll student in a course");
        System.out.println("2. View all enrollments");
        System.out.println("3. View enrollments for a student");
        System.out.println("4. Mark enrollment as completed");
        System.out.println("5. Mark enrollment as cancelled");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");
    }
}
