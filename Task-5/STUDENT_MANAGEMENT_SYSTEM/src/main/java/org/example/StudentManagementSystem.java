package org.example;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private String filename = "students.txt";

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int rollNumber;
        while (true) {
            try {
                System.out.print("Enter roll number: ");
                rollNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid roll number.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student newStudent = new Student(name, rollNumber, grade);
        students.add(newStudent);
        updateFile();
        System.out.println("Student added successfully.");
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter roll number to remove: ");
        int removeRollNumber;
        while (true) {
            try {
                removeRollNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid roll number.");
                scanner.nextLine();
            }
        }

        int finalRemoveRollNumber = removeRollNumber;
        boolean removed = students.removeIf(student -> student.getRollNumber() == finalRemoveRollNumber);
        if (removed) {
            updateFile();
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void modifyStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter roll number to modify: ");
        int modifyRollNumber;
        while (true) {
            try {
                modifyRollNumber = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid roll number.");
                scanner.nextLine();
            }
        }

        for (Student student : students) {
            if (student.getRollNumber() == modifyRollNumber) {
                System.out.print("Enter new name: ");
                String firstName = scanner.nextLine();

                int newRollNumber;
                while (true) {
                    try {
                        System.out.print("Enter new roll number: ");
                        newRollNumber = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid roll number.");
                        scanner.nextLine();
                    }
                }

                System.out.print("Enter new grade: ");
                String newGrade = scanner.nextLine();

                student.setName(firstName);
                student.setRollNumber(newRollNumber);
                student.setGrade(newGrade);

                updateFile();
                System.out.println("Student information modified successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void displayStudentsFromFile() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println(student.toFileString());
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        students.clear();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                students.add(Student.fromFileString(line));
            }
            System.out.println("Data read from file successfully.");
        } catch (FileNotFoundException e) {
        }
    }
}
