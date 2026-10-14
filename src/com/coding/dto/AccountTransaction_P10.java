package com.coding.dto;

public class AccountTransaction_P10 {
    private String accountId;
    private String type;
    private double amount;

    public AccountTransaction_P10(String accountId, String type,double amount){
        this.accountId=accountId;
        this.type=type;
        this.amount=amount;
    }
    public String getAccountId(){
        return accountId;
    }
    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
}
