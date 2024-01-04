package org.example;

public class Student {
    private String name;

    private int rollNumber;

    private String grade;

    public Student(Long id, String name, String lastName, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }

    public String toFileString() {
        return name + "," + rollNumber + "," + grade;
    }

    public static Student fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}
