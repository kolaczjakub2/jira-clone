package com.secondtonone.jk.jiraclone.domain.project.repositories;

import com.secondtonone.jk.jiraclone.domain.project.task.WorkLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface WorkLogRepository extends JpaRepository<WorkLog, UUID> {
    Set<WorkLog> findAllByTaskKey(String key);
}
