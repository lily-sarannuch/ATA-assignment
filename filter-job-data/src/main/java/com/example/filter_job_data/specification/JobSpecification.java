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

            if (filters.containsKey("job_title")) {
                predicates.add(criteriaBuilder.equal(root.get("jobTitle"), filters.get("job_title")));
            }

            if (filters.containsKey("gender")) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), filters.get("gender")));
            }

            if (filters.containsKey("salary[gte]")) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), Double.valueOf(filters.get("salary[gte]"))));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}