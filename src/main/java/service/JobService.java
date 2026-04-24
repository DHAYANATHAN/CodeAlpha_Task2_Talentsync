package com.talentsync.talentsync.service;

import com.talentsync.talentsync.model.Job;
import com.talentsync.talentsync.model.User;
import com.talentsync.talentsync.repository.JobRepository;
import com.talentsync.talentsync.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    // CREATE JOB
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // GET ALL JOBS
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // 🔥 IMPORTANT (NEW) → GET JOB BY ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public List<Job> getJobsByCategory(String category) {
        return jobRepository.findByCategory(category);
    }

    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    public List<Job> getJobsByJobType(String jobType) {
        return jobRepository.findByJobType(jobType);
    }

    public List<Job> searchJobsBySkill(String skill) {
        return jobRepository.findBySkillsRequiredContaining(skill);
    }

    public List<Job> recommendJobs(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return new ArrayList<>();
        }

        String skills = user.getSkills();
        String[] skillList = skills.split(",");

        Set<Job> recommendedJobs = new HashSet<>();

        for (String skill : skillList) {
            recommendedJobs.addAll(
                    jobRepository.findBySkillsRequiredContaining(skill.trim())
            );
        }

        return new ArrayList<>(recommendedJobs);
    }

    public String notifyUserByEmail(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return "User not found";
        }

        List<Job> jobs = recommendJobs(userId);

        if (jobs.isEmpty()) {
            return "No matching jobs";
        }

        StringBuilder message = new StringBuilder();
        message.append("Hi ").append(user.getName()).append(",\n\n");
        message.append("We found jobs for you:\n\n");

        for (Job job : jobs) {
            message.append("Title: ").append(job.getTitle()).append("\n");
            message.append("Company: ").append(job.getCompany()).append("\n");
            message.append("Location: ").append(job.getLocation()).append("\n\n");
        }

        return "Email sent successfully!";
    }
}