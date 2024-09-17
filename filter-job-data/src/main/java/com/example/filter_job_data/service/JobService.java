package com.example.filter_job_data.service;

import com.example.filter_job_data.dto.JobDTO;
import com.example.filter_job_data.entity.Job;
import com.example.filter_job_data.repository.JobRepository;
import com.example.filter_job_data.specification.JobSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobDTO> getJobs(Map<String, String> filters, String[] fields, String sortBy, String sortType) {
        Specification<Job> specification = JobSpecification.getSpecification(filters);

         Sort sort = Sort.by(Sort.Direction.fromString(sortType), sortBy);
        List<Job> jobs = jobRepository.findAll(specification, PageRequest.of(0, 10, sort)).getContent();

        // Filter by sparse fields
        return jobs.stream()
                .map(job -> filterFields(job, fields))
                .collect(Collectors.toList());
    }

    private JobDTO filterFields(Job job, String[] fields) {
        JobDTO jobDTO = new JobDTO();

        if (fields == null) {
            // Return all fields if no specific fields are requested
            jobDTO.setTimeStamp(job.getTimestamp());
            jobDTO.setEmployer(job.getEmployer());
            jobDTO.setLocation(job.getLocation());
            jobDTO.setJobTitle(job.getJobTitle());
            jobDTO.setYearsAtEmployer(job.getYearsAtEmployer());
            jobDTO.setYearsOfExperience(job.getYearsOfExperience());
            jobDTO.setSalary(job.getSalary());
            jobDTO.setSigningBonus(job.getSigningBonus());
            jobDTO.setAannualBonus(job.getAnnualBonus());
            jobDTO.setAnnualStockValueOrBonus(job.getAnnualStockValueOrBonus());
            jobDTO.setGender(job.getGender());
            jobDTO.setAdditionalComments(job.getAdditionalComments());
        } else {
            for (String field : fields) {
                switch (field) {
                    case "timestamp":
                        jobDTO.setTimeStamp(job.getTimestamp());
                        break;
                    case "employer":
                        jobDTO.setEmployer(job.getEmployer());
                        break;
                    case "location":
                        jobDTO.setLocation(job.getLocation());
                        break;
                    case "jobTitle":
                        jobDTO.setJobTitle(job.getJobTitle());
                        break;
                    case "yearsAtEmployer":
                        jobDTO.setYearsAtEmployer(job.getYearsAtEmployer());
                        break;
                    case "yearsOfExperience":
                        jobDTO.setYearsOfExperience(job.getYearsOfExperience());
                        break;
                    case "salary":
                        jobDTO.setSalary(job.getSalary());
                        break;
                    case "signingBonus":
                        jobDTO.setSigningBonus(job.getSigningBonus());
                        break;
                    case "annualBonus":
                        jobDTO.setAannualBonus(job.getAnnualBonus());
                        break;
                    case "annualStockValueOrBonus":
                        jobDTO.setAnnualStockValueOrBonus(job.getAnnualStockValueOrBonus());
                        break;
                    case "gender":
                        jobDTO.setGender(job.getGender());
                        break;
                    case "additionalComments":
                        jobDTO.setAdditionalComments(job.getAdditionalComments());
                        break;
                }
            }
        }

        return jobDTO;
    }
}