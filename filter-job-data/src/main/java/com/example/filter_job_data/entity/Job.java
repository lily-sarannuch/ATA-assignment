package com.example.filter_job_data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "employer")
    private String employer;

    @Column(name = "location")
    private String location;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "yearsAtEmployer")
    private Double yearsAtEmployer;

    @Column(name = "yearsOfExperience")
    private Double yearsOfExperience;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "signingBonus")
    private Double signingBonus;

    @Column(name = "annualBonus")
    private Double annualBonus;

    @Column(name = "annualStockValueOrBonus")
    private Double annualStockValueOrBonus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "additionalComments")
    private String additionalComments;
}