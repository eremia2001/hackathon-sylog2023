package com.projectmanagementservice.api.model;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Task;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Integer budget;
    private String status;
    private Long organizationId;
    private List<Task> tasks;
    private List<Member> members;
    private List<ImageDto> images;
}
