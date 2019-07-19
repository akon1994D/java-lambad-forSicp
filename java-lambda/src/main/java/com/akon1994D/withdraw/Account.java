package com.akon1994D.withdraw;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-18
 */
public class Account {

    private AtomicLong balance;

    public Account(long balance) {
        this.balance = new AtomicLong(balance);
    }

    public long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance = new AtomicLong(balance);
    }

    public long withDraw(long amount){
        // return balance = balance -amount; //赋值带来的并发问题
        return balance.accumulateAndGet(amount, (x,y)->x-y);
    }


    public static void main(String[] args) {
        Account account = new Account(10000);
//        System.out.println(account.withDraw(25));
//        System.out.println(account.withDraw(25));

        AccountTaker accountTaker1 = new AccountTaker(account, 1);
        AccountTaker accountTaker2 = new AccountTaker(account, 1);
        new Thread(accountTaker1).start();
        new Thread(accountTaker2).start();
    }



    static class AccountTaker implements Runnable{
        private Account account;
        private long amount;
        private long sum;

        public AccountTaker(Account account, long amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            while (account.withDraw(amount) >=0){
                sum += amount;
            }
            System.out.println(sum);
        }
    }

}
