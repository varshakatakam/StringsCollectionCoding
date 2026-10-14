package com.coding.dto;

public class LogEntry_P3 {

    private String level;
    private String message;

    public LogEntry_P3(String level, String message) {
        this.level = level;
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
