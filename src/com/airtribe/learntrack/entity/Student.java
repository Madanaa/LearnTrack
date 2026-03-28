package com.airtribe.learntrack.entity;

public class Student extends Person {
    private String batch;
    private boolean active;

    public Student() {
    }

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        this(id, firstName, lastName, "not-provided@learntrack.local", batch, active);
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " [" + batch + "]";
    }

    @Override
    public String toString() {
        return "Student{id=" + getId()
                + ", name='" + getDisplayName() + '\''
                + ", email='" + getEmail() + '\''
                + ", active=" + active
                + '}';
    }
}
