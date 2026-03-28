package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.EnrollmentStatus;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrollment enrollStudent(int studentId, int courseId)
            throws EntityNotFoundException, InvalidInputException {
        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findCourseById(courseId);

        if (!student.isActive()) {
            throw new InvalidInputException("Inactive students cannot be enrolled.");
        }
        if (!course.isActive()) {
            throw new InvalidInputException("Inactive courses cannot accept enrollments.");
        }
        if (isAlreadyEnrolled(studentId, courseId)) {
            throw new InvalidInputException("This student is already enrolled in the selected course.");
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.getNextEnrollmentId(),
                studentId,
                courseId,
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );
        enrollments.add(enrollment);
        return enrollment;
    }

    public List<Enrollment> listEnrollments() {
        return new ArrayList<>(enrollments);
    }

    public List<Enrollment> getEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        studentService.findStudentById(studentId);
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }

    public Enrollment updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) throws EntityNotFoundException {
        Enrollment enrollment = findEnrollmentById(enrollmentId);
        enrollment.setStatus(status);
        return enrollment;
    }

    public Enrollment findEnrollmentById(int enrollmentId) throws EntityNotFoundException {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentId) {
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " was not found.");
    }

    private boolean isAlreadyEnrolled(int studentId, int courseId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId
                    && enrollment.getCourseId() == courseId
                    && enrollment.getStatus() == EnrollmentStatus.ACTIVE) {
                return true;
            }
        }
        return false;
    }
}
