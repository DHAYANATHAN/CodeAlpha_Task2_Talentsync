package com.talentsync.talentsync.model;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;
    private Long userId;
    private String status;

    // ✅ Default Constructor
    public Application() {
    }

    // ✅ Parameterized Constructor
    public Application(Long jobId, Long userId, String status) {
        this.jobId = jobId;
        this.userId = userId;
        this.status = status;
    }

    // ✅ GETTERS

    public Long getId() {
        return id;
    }

    public Long getJobId() {
        return jobId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    // ✅ SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}