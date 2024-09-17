package com.example.filter_job_data.specification;

import com.example.filter_job_data.entity.Job;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobSpecification {

    public static Specification<Job> getSpecification(Map<String, String> filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filters.containsKey("timestamp")) {
                predicates.add(criteriaBuilder.equal(root.get("timestamp"), filters.get("timestamp")));
            }

            if (filters.containsKey("employer")) {
                predicates.add(criteriaBuilder.equal(root.get("employer"), filters.get("employer")));
            }

            if (filters.containsKey("location")) {
                predicates.add(criteriaBuilder.equal(root.get("location"), filters.get("location")));
            }

            if (filters.containsKey("job_title")) {
                predicates.add(criteriaBuilder.equal(root.get("jobTitle"), filters.get("job_title")));
            }

            if (filters.containsKey("yearsAtEmployer")) {
                predicates.add(criteriaBuilder.equal(root.get("yearsAtEmployer"), filters.get("yearsAtEmployer")));
            }

            if (filters.containsKey("yearsOfExperience")) {
                predicates.add(criteriaBuilder.equal(root.get("yearsOfExperience"), filters.get("yearsOfExperience")));
            }

            if (filters.containsKey("salary")) {
                predicates.add(criteriaBuilder.equal(root.get("salary"), filters.get("salary")));
            }

            if (filters.containsKey("signingBonus")) {
                predicates.add(criteriaBuilder.equal(root.get("signingBonus"), filters.get("signingBonus")));
            }

            if (filters.containsKey("annualBonus")) {
                predicates.add(criteriaBuilder.equal(root.get("annualBonus"), filters.get("annualBonus")));
            }

            if (filters.containsKey("annualStockValueOrBonus")) {
                predicates.add(criteriaBuilder.equal(root.get("annualStockValueOrBonus"), filters.get("annualStockValueOrBonus")));
            }

            if (filters.containsKey("gender")) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), filters.get("gender")));
            }
            
            if (filters.containsKey("additionalComments")) {
                predicates.add(criteriaBuilder.equal(root.get("additionalComments"), filters.get("additionalComments")));
            }

            if (filters.containsKey("salary[gte]")) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), Double.valueOf(filters.get("salary[gte]"))));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}