package workshop.bank.entity;

import java.util.*;
import workshop.bank.exception.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int accountCounter = 1000;

    public Account createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + accountCounter++;
        SavingsAccount acc = new SavingsAccount(accNum, ownerName, balance, interestRate);
        accounts.add(acc);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc);
        return acc;
    }

    public Account createCheckingAccount(String ownerName, double balance, double limit) {
        String accNum = "AC" + accountCounter++;
        CheckingAccount acc = new CheckingAccount(accNum, ownerName, balance, limit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
        return acc;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
    }

    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {
        Account src = findAccount(fromAcc);
        Account dest = findAccount(toAcc);
        src.withdraw(amount);
        dest.deposit(amount);
        System.out.println(String.format("%.1f원이 %s에서 %s로 송금되었습니다.", amount, fromAcc, toAcc));
    }

    public void showAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        accounts.forEach(System.out::println);
        System.out.println("===================");
    }
}