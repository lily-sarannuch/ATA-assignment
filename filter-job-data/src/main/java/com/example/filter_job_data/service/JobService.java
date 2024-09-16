package com.example.filter_job_data.service;

import com.example.filter_job_data.dto.JobDTO;
import com.example.filter_job_data.entity.Job;
import com.example.filter_job_data.repository.JobRepository;
import com.example.filter_job_data.specification.JobSpecification;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Job> jobs = jobRepository.findAll(specification);

        // Filter by sparse fields
        return jobs.stream()
                .map(job -> filterFields(job, fields))
                .collect(Collectors.toList());
    }

    private JobDTO filterFields(Job job, String[] fields) {
        JobDTO jobDTO = new JobDTO();

        if (fields == null) {
            // Return all fields if no specific fields are requested
            jobDTO.setJobTitle(job.getJobTitle());
            jobDTO.setSalary(job.getSalary());
            jobDTO.setGender(job.getGender());
        } else {
            for (String field : fields) {
                switch (field) {
                    case "jobTitle":
                        jobDTO.setJobTitle(job.getJobTitle());
                        break;
                    case "salary":
                        jobDTO.setSalary(job.getSalary());
                        break;
                    case "gender":
                        jobDTO.setGender(job.getGender());
                        break;
                }
            }
        }

        return jobDTO;
    }
}