package com.example.filter_job_data.dto;

public class JobDTO {
    private String jobTitle;
    private Double salary;
    private String gender;

    // Getters and Setters
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
