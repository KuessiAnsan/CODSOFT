package org.example;

public class Student {

    private Long id;

    private String firstName;

    private String lastName;

    private int rollNumber;

    private String grade;

    public Student(Long id, String firstName, String lastName, int rollNumber, String grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
