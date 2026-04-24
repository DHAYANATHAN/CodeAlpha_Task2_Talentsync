package com.talentsync.talentsync.controller;

import com.talentsync.talentsync.model.Application;
import com.talentsync.talentsync.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public Application applyJob(@RequestBody Application application) {
        return applicationService.applyJob(application);
    }

    @GetMapping("/applications/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }
}