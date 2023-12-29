package org.example;

import java.util.List;
import java.util.Scanner;

import static java.util.List.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("How many subjects: ");

        Scanner scanner = new Scanner(System.in);

        int subjects = scanner.nextInt();

        List<Subject> subjectList = of(
                new Subject("Maths"),
                new Subject("Physics"),
                new Subject("History"),
                new Subject("Geography"),
                new Subject("English"),
                new Subject("French")
        );
        double marksSum = 0;

        for (int i=1; i<=subjects; i++) {
            System.out.println("Mark for subject-" + i + ":");
            Scanner scanner1 = new Scanner(System.in);
            double subjectMark = scanner1.nextDouble();
            marksSum+=subjectMark;
        }

        double averagePercentage = marksSum / subjectList.size();


        System.out.println("Total of subjects: " + subjects + '\n'+ "Sum of marks: " + marksSum + '\n'+ "Average percentage: " + averagePercentage + "%" + '\n');

    }
}