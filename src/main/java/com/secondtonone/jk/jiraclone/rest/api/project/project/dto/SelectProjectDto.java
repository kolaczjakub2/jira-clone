package com.secondtonone.jk.jiraclone.rest.api.project.project.dto;

import com.secondtonone.jk.jiraclone.rest.api.users.dto.SimpleUserDto;
import com.secondtonone.jk.jiraclone.domain.project.Project;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;

import java.util.UUID;

public class SelectProjectDto {

    private UUID projectId;
    private String name;
    private String description;
    private String code;
    private SimpleUserDto leader;


    public static Builder builder() {
        return new Builder();
    }

    public static SelectProjectDto of(Project project) {
        return builder()
                .withCode(project.getCode())
                .withDescription(project.getDescription())
                .withName(project.getName())
                .withProjectId(project.getId())
                .withLeader(project.getLeader())
                .build();
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLeader(SimpleUserDto leader) {
        this.leader = leader;
    }

    public SimpleUserDto getLeader() {
        return leader;
    }

    public static final class Builder {
        private UUID projectId;
        private String name;
        private String description;
        private String code;
        private SimpleUserDto leader;

        public SelectProjectDto.Builder withProjectId(UUID projectId) {
            this.projectId = projectId;
            return this;
        }

        public SelectProjectDto.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public SelectProjectDto.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public SelectProjectDto.Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public SelectProjectDto build() {
            var dto = new SelectProjectDto();
            dto.projectId = this.projectId;
            dto.name = this.name;
            dto.description = this.description;
            dto.code = this.code;
            dto.leader = this.leader;
            return dto;

        }

        public SelectProjectDto.Builder withLeader(UserAccount leader) {
            this.leader = SimpleUserDto.builder()
                    .withId(leader.getId())
                    .withFirstName(leader.getFirstName())
                    .withLastName(leader.getLastName()).build();
            return this;
        }
    }
}
