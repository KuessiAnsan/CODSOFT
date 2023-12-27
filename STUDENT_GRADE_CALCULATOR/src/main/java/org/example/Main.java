package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Subject> subjectList = List.of(
                new Subject("Maths"),
                new Subject("Physics"),
                new Subject("History"),
                new Subject("Geography"),
                new Subject("English"),
                new Subject("French")
        );
        double marksSum = 0;

        for (Subject subject:
             subjectList) {
            System.out.println("Mark for " + subject.getName() + ":");
            Scanner scanner = new Scanner(System.in);
            double subjectMark = scanner.nextDouble();
            marksSum+=subjectMark;
        }

        double averagePercentage = marksSum / subjectList.size();

        System.out.println("Average percentage: " + averagePercentage);

    }
}