package com.airtribe.learntrack.util;

public final class IdGenerator {
    private static int studentIdCounter = 100;
    private static int courseIdCounter = 200;
    private static int enrollmentIdCounter = 300;

    private IdGenerator() {
    }

    public static int getNextStudentId() {
        studentIdCounter++;
        return studentIdCounter;
    }

    public static int getNextCourseId() {
        courseIdCounter++;
        return courseIdCounter;
    }

    public static int getNextEnrollmentId() {
        enrollmentIdCounter++;
        return enrollmentIdCounter;
    }
}
