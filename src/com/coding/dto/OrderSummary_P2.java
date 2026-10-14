package com.coding.dto;

public class OrderSummary_P2 {

    private String customerId;
    private int totalOrders;
    private double totalAmount;

    public OrderSummary_P2(String customerId, int totalOrders, double totalAmount) {
        this.customerId = customerId;
        this.totalOrders = totalOrders;
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return customerId +
                "->TotalOrders=" + totalOrders +
                ", TotalAmount=" + totalAmount;
    }
}
