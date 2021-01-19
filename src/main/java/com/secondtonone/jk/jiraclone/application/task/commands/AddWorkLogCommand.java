package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.application.task.exceptions.TaskNotFoundException;
import com.secondtonone.jk.jiraclone.application.users.exceptions.UserNotFoundException;
import com.secondtonone.jk.jiraclone.domain.task.WorkLog;
import com.secondtonone.jk.jiraclone.domain.task.dto.CreateWorkLogDto;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.WorkLogRepository;

public class AddWorkLogCommand {
    private final TaskRepository taskRepository;
    private final UserAccountRepository userAccountRepository;
    private final WorkLogRepository workLogRepository;

    public AddWorkLogCommand(TaskRepository taskRepository, UserAccountRepository userAccountRepository, WorkLogRepository workLogRepository) {
        this.taskRepository = taskRepository;
        this.userAccountRepository = userAccountRepository;
        this.workLogRepository = workLogRepository;
    }

    public WorkLog execute(CreateWorkLogDto dto, String key) {
        WorkLog workLog = WorkLog.builder()
                .withComment(dto.getComment())
                .withWorked(dto.getWorked())
                .withCreator(userAccountRepository.findById(dto.getCreatorId()).orElseThrow(() -> new UserNotFoundException("User not found")))
                .withDate(dto.getDate())
                .withFrom(dto.getFrom())
                .withTo(dto.getTo())
                .withTask(taskRepository.findByKey(key).orElseThrow(() -> new TaskNotFoundException("Task not found")))
                .build();

        return workLogRepository.save(workLog);
    }
}
