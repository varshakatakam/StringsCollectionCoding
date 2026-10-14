package com.coding.dto;

public class Employee_P9 {
    private String name;
    private String department;
    private int experience;
    private double rating;

public Employee_P9( String name,String department, int experience,double rating){
    this.name=name;
    this.department=department;
    this.experience=experience;
    this.rating=rating;
  }
  public String getName(){
    return name;
  }
  public String getDepartment(){
    return department;
  }
  public int getExperience(){
    return experience;
  }
  public double getRating(){
    return rating;
  }
  @Override
    public String toString(){
    return name +"-"+department+"-Experience="+experience+"-Rating="+rating;
  }
}
