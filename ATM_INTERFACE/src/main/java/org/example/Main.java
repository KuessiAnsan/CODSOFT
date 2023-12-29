package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserBankAccount userBankAccount = new UserBankAccount(25000);
        AtmMachine atmMachine = new AtmMachine(userBankAccount, new Scanner(System.in));
        atmMachine.startAtm();
    }
}