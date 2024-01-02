package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.util.List.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO THE GRADE CALCULATOR");

        try {
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
        }catch (InputMismatchException exception){
            System.out.println("You have to enter a number");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}