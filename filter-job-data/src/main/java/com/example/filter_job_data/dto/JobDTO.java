package com.example.filter_job_data.dto;

public class JobDTO {
    private String timestamp;
    private String employer;
    private String location;
    private String jobTitle;
    private Double yearsAtEmployer;
    private Double yearsOfExperience;
    private Double salary;
    private Double signingBonus;
    private Double annualBonus;
    private Double annualStockValueOrBonus;
    private String gender;
    private String additionalComments;

    // Getters and Setters
    public String getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getYearsAtEmployer() {
        return yearsAtEmployer;
    }

    public void setYearsAtEmployer(Double yearsAtEmployer) {
        this.yearsAtEmployer = yearsAtEmployer;
    }

    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSigningBonus() {
        return signingBonus;
    }

    public void setSigningBonus(Double signingBonus) {
        this.signingBonus = signingBonus;
    }

    public Double getAnnualBonus() {
        return annualBonus;
    }

    public void setAannualBonus(Double annualBonus) {
        this.annualBonus = annualBonus;
    }

    public Double getAnnualStockValueOrBonus() {
        return annualStockValueOrBonus;
    }

    public void setAnnualStockValueOrBonus(Double annualStockValueOrBonus) {
        this.annualStockValueOrBonus = annualStockValueOrBonus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
}
