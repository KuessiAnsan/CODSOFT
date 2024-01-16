package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmMachine {

    private UserBankAccount userBankAccount;

    private Scanner scanner;

    public AtmMachine(UserBankAccount userBankAccount, Scanner scanner) {
        this.userBankAccount = userBankAccount;
        this.scanner = scanner;
    }

    public AtmMachine(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public UserBankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAtmOptions(){
        System.out.println("""
                WELCOME TO THE ATM
                1- Withdraw
                2- Deposit
                3- Check balance
                """);
    }

    public void startAtm(){
        char continueOrStop;
        do {
            try {

                displayAtmOptions();
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("How much do you want to withdraw:");
                        double amountToWithdraw = scanner.nextDouble();
                        if (userBankAccount.withdraw(amountToWithdraw)){
                            System.out.println("Withdrawal successful, Remaining amount: " + userBankAccount.getBalance());
                        }else{
                            System.out.println("Withdrawal failed, insufficient funds");
                        }
                    }
                    case 2 -> {
                        System.out.println("How much do you want to deposit:");
                        double amountToDeposit = scanner.nextDouble();
                        if (userBankAccount.deposit(amountToDeposit)){
                            System.out.println("Deposit successful, Balance: " + userBankAccount.getBalance());
                        }else{
                            System.out.println("Deposit failed, inappropriate characters");
                        }
                    }
                    case 3 -> userBankAccount.checkBalance();
                }
            }catch (InputMismatchException exception){
                System.out.println("You have to enter choose in the options");
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }finally {
                System.out.println("Do you want to continue (Y | N) ?");
                continueOrStop = this.scanner.next().charAt(0);
            }

        }while (continueOrStop == 'Y' || continueOrStop == 'y');
    }
}
