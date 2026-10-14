package com.coding.dto;

public class InventoryMismatch_P6 {

    private String productId;
    private int expectedQuantity;
    private int actualQuantity;

    public InventoryMismatch_P6(String productId, int expectedQuantity, int actualQuantity) {
        this.productId = productId;
        this.expectedQuantity = expectedQuantity;
        this.actualQuantity = actualQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getExpectedQuantity() {
        return expectedQuantity;
    }

    public int getActualQuantity() {
        return actualQuantity;
    }
    @Override
    public String toString(){
        return productId+"->Quantity Mismatch\n"+"Expected="+expectedQuantity+"Actual="+actualQuantity;
    }
}
