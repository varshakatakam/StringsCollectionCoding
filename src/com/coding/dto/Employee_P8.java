package com.coding.dto;

public class Employee_P8 {

    private int id;
    private String name;
    private Integer managerId;

    public Employee_P8(int id, String name, Integer managerId){
        this.id=id;
        this.name=name;
        this.managerId=managerId;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getManagerId(){
        return managerId;
    }
}
