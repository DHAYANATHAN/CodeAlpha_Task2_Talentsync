package com.talentsync.talentsync.controller;

import com.talentsync.talentsync.model.Job;
import com.talentsync.talentsync.service.JobService;
import com.talentsync.talentsync.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository repo;

    // CREATE JOB
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // GET ALL JOBS
    @GetMapping
    public List<Job> getJobs() {
        return repo.findAll();
    }

    // 🔥 IMPORTANT (NEW) → GET JOB BY ID
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @GetMapping("/category/{category}")
    public List<Job> getJobsByCategory(@PathVariable String category) {
        return jobService.getJobsByCategory(category);
    }

    @GetMapping("/location/{location}")
    public List<Job> getJobsByLocation(@PathVariable String location) {
        return jobService.getJobsByLocation(location);
    }

    @GetMapping("/type/{jobType}")
    public List<Job> getJobsByJobType(@PathVariable String jobType) {
        return jobService.getJobsByJobType(jobType);
    }

    @GetMapping("/search/{skill}")
    public List<Job> searchJobs(@PathVariable String skill) {
        return jobService.searchJobsBySkill(skill);
    }

    @GetMapping("/recommend/{userId}")
    public List<Job> recommendJobs(@PathVariable Long userId) {
        return jobService.recommendJobs(userId);
    }

    @GetMapping("/notify-email/{userId}")
    public String notifyUser(@PathVariable Long userId) {
        return jobService.notifyUserByEmail(userId);
    }
}