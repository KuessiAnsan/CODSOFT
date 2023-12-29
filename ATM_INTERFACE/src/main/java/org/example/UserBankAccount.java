package org.example;

public class UserBankAccount {

    private double balance;

    public UserBankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Boolean withdraw(double amountToWithdraw){
        if (amountToWithdraw < this.balance && amountToWithdraw > 0){
            this.balance-=amountToWithdraw;
            return true;
        }else {
            return false;
        }
    }

    public Boolean deposit(double amountToDeposit){
        if(amountToDeposit > 0){
            this.balance+=amountToDeposit;
            return true;
        }else {
            return false;
        }
    }

    public void checkBalance(){
        System.out.println(this.balance);
    }

}
