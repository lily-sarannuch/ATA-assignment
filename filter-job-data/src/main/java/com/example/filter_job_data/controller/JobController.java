package com.example.filter_job_data.controller;
import com.example.filter_job_data.dto.JobDTO;
import com.example.filter_job_data.entity.Job;
import com.example.filter_job_data.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/job_data")
    public List<JobDTO> getJobData(
            @RequestParam Map<String, String> filters,
            @RequestParam(required = false) String[] fields,
            @RequestParam(defaultValue = "jobTitle") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortType) {
        return jobService.getJobs(filters, fields, sortBy, sortType);
    }
}
