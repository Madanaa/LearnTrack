package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String batch;
    private boolean active;

    public Student() {}

    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email); // super use
        this.batch = batch;
        this.active = active;
    }

    // Getter Setter
    public String getBatch() { return batch; }
    public void setBatch(String batch) { this.batch = batch; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // Method overriding example
    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }
}
