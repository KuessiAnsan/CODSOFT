package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int min = 1;
        int max = 100;
        int maxAttempts = 4;


        char choice;

        do {
            int generatedNumber = (int) (Math.random() * (max - min + 1) + min);
            int attempts = 0;
            try {

                Scanner scanner = new Scanner(System.in);
                for (int i = 0; i <= maxAttempts; i++){

                    System.out.println("Enter your guess: ");

                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == generatedNumber){
                        System.out.println("You won in " + attempts + " attempts");
                        break;
                    }else if (userGuess < generatedNumber){
                        if (attempts == maxAttempts){
                            System.out.println("You lose !");
                            break;
                        }else{
                            System.out.println("Your guess is lower than the actual number!");
                        }
                    }else{
                        if (attempts == maxAttempts){
                            System.out.println("You lose !");
                            break;
                        }else{
                            System.out.println("Your guess is higher than the actual number!");
                        }
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("You should input a number !");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("Do you want to continue (Y | N): ");
                Scanner choiceScanner = new Scanner(System.in);
                choice = choiceScanner.next().charAt(0);
            }
        }while (choice == 'Y' || choice == 'y' );
    }
}