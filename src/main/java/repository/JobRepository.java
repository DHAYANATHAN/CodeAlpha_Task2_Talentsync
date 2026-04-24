package com.talentsync.talentsync.repository;

import com.talentsync.talentsync.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByCategory(String category);

    List<Job> findByLocation(String location);

    List<Job> findByJobType(String jobType);

    List<Job> findBySkillsRequiredContaining(String skill);
}