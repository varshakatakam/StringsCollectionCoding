package com.coding.dto;

public class AccountBalance_P10 {
    private String accountId;
    private double balance;

    public AccountBalance_P10(String accountId,double balance){
        this.accountId=accountId;
        this.balance=balance;
    }
    public String getAccountId(){
        return accountId;
    }
    public double getBalance(){
        return balance;
    }
    @Override
    public String toString(){
        return accountId+"Balance="+balance;
    }
}
