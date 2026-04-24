package com.talentsync.talentsync.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private String userType;

    private String skills;
    private String location;
    private String resume;

    private String degree;
    private String branch;
    private String college;
    private Integer studyYear;
    private Integer passingYear;

    private String company;
    private String jobRole;
    private String experienceDuration;

    public User() {}

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getUserType() { return userType; }

    public void setUserType(String userType) { this.userType = userType; }

    public String getSkills() { return skills; }

    public void setSkills(String skills) { this.skills = skills; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getResume() { return resume; }

    public void setResume(String resume) { this.resume = resume; }

    public String getDegree() { return degree; }

    public void setDegree(String degree) { this.degree = degree; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    public String getCollege() { return college; }

    public void setCollege(String college) { this.college = college; }

    public Integer getStudyYear() { return studyYear; }

    public void setStudyYear(Integer studyYear) { this.studyYear = studyYear; }

    public Integer getPassingYear() { return passingYear; }

    public void setPassingYear(Integer passingYear) { this.passingYear = passingYear; }

    public String getCompany() { return company; }

    public void setCompany(String company) { this.company = company; }

    public String getJobRole() { return jobRole; }

    public void setJobRole(String jobRole) { this.jobRole = jobRole; }

    public String getExperienceDuration() { return experienceDuration; }

    public void setExperienceDuration(String experienceDuration) { this.experienceDuration = experienceDuration; }
}