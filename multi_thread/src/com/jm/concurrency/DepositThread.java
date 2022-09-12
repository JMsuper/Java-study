package com.jm.concurrency;

public class DepositThread implements Runnable{

    public Account account;

    DepositThread(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account){
            for(int i = 0; i < 1000; i++){
                account.deposit(1000);
            }
            account.inquiry();
        }
    }
}
