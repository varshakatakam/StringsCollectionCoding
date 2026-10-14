package com.coding.dto;

public class SessionSummary_P12 {
    private String userId;
    private int sessionMinutes;

    public SessionSummary_P12(String userId,int sessionMinutes){
        this.userId=userId;
        this.sessionMinutes=sessionMinutes;
    }
    public String getUserId(){
        return userId;
    }
    public int getSessionMinutes(){
        return sessionMinutes;
    }
    @Override
    public String toString(){
        return userId+"Session="+sessionMinutes+"mins";
    }
}
