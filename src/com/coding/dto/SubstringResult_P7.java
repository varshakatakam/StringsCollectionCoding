package com.coding.dto;

public class SubstringResult_P7 {
    private String substring;
    private int length;

    public SubstringResult_P7(String substring,int length){
        this.substring=substring;
        this.length=length;
    }
    public String getSubstring(){
        return substring;
    }
    public int getLength(){
        return length;
    }
    @Override
    public String toString(){
        return substring + "\nLength="+length;
    }
}
