package com.secondtonone.jk.jiraclone.application.task.commands;

import com.secondtonone.jk.jiraclone.domain.task.dto.SimpleTaskViewDto;
import com.secondtonone.jk.jiraclone.domain.task.enums.Status;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.TaskRepository;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetAllTaskForUserCommand {
    private final TaskRepository taskRepository;

    public GetAllTaskForUserCommand(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<SimpleTaskViewDto> execute(UUID userId) {
        return taskRepository.findByAssigneeIdAndStatusIn(userId, Arrays.asList(Status.IN_PROGRESS, Status.OPEN))
                .stream().map(SimpleTaskViewDto::buildDto)
                .collect(Collectors.toSet());
    }


}
