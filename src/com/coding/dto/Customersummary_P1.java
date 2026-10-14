package com.coding.dto;

public class Customersummary_P1 {

    private String customerId;
    private double totalCredits;
    private double totalDebits;
    private double balance;

    public Customersummary_P1(String customerId, double totalCredits, double totalDebits, double balance){
        this.customerId=customerId;
        this.totalCredits=totalCredits;
        this.totalDebits=totalDebits;
        this.balance=balance;
    }

    public String getCustomerId(){
        return customerId;
    }

    public double getTotalCredit(){
        return totalCredits;
    }

    public double getTotalDebit(){
        return totalDebits;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        return customerId+
                "->Credits="+totalCredits+
                ", Debits="+totalDebits+
                ", Balance="+balance;
    }
}
