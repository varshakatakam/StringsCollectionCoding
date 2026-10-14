package com.coding.dto;

public class WordCount_P4 {

    private String word;
    private int count;

    public WordCount_P4(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString(){
        return word + "=" + count;
    }
}
