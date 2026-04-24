package com.talentsync.talentsync.repository;

import com.talentsync.talentsync.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByJobIdAndUserId(Long jobId, Long userId);
    List<Application> findByUserId(Long userId);
}