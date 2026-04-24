
package com.talentsync.talentsync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentsync.talentsync.model.Application;
import com.talentsync.talentsync.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    // ✅ APPLY JOB
    public Application applyJob(Application application) {

        // 🔥 CHECK EXISTING APPLICATION
        boolean exists = repo.existsByJobIdAndUserId(
                application.getJobId(),
                application.getUserId()
        );

        if (exists) {
            return null; // already applied
        }

        application.setStatus("APPLIED");
        return repo.save(application);
    }

    // ✅ GET ALL APPLIED JOBS
    public List<Application> getAllApplications() {
        return repo.findAll();
    }

    public List<Application> getApplicationsByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}