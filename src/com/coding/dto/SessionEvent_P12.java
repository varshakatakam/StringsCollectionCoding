package com.coding.dto;

public class SessionEvent_P12 {
    private String userId;
    private String type;
    private String time;

    public SessionEvent_P12(String userId,String type, String time){
        this.userId=userId;
        this.type=type;
        this.time=time;
    }
    public String getUserId(){
        return userId;
    }
    public String getType(){
        return type;
    }
    public String getTime(){
        return time;
    }

}
