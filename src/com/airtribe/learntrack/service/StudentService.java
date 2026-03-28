package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student addStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(IdGenerator.getNextStudentId(), firstName, lastName, email, batch, true);
        return addStudent(student);
    }

    public Student addStudent(String firstName, String lastName, String batch) {
        Student student = new Student(IdGenerator.getNextStudentId(), firstName, lastName, batch, true);
        return addStudent(student);
    }

    public List<Student> listStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student with ID " + id + " was not found.");
    }

    public Student updateStudent(int id, String firstName, String lastName, String email, String batch)
            throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
        return student;
    }

    public Student deactivateStudent(int id) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setActive(false);
        return student;
    }
}
