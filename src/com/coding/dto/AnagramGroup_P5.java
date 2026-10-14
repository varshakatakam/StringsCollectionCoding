package com.coding.dto;

import java.util.List;

public class AnagramGroup_P5 {

    private List<String>words;

    public AnagramGroup_P5(List<String>words){
        this.words=words;
    }

    public List<String> getWords() {
        return words;
    }
    @Override
    public String toString(){
        return words.toString();
    }
}
