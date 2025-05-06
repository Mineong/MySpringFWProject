package mylab.bank.control;

import mylab.bank.entity.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = bank.createSavingsAccount("김민정", 10000, 3.0);
        Account a2 = bank.createCheckingAccount("이말자", 20000, 5000);
        Account a3 = bank.createSavingsAccount("김김", 30000, 2.0);

        bank.showAllAccounts();

        a1.deposit(5000);

        try {
            a2.withdraw(3000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        if (a1 instanceof SavingsAccount) {
            ((SavingsAccount) a1).applyInterest();
        }

        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        bank.showAllAccounts();

        try {
            a2.withdraw(10000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}