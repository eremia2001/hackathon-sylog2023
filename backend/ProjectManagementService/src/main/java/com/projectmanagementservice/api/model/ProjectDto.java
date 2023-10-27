package com.projectmanagementservice.api.model;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Task;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProjectDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Integer budget;
    private String status;
    private Long organizationId;
    private List<Task> tasks;
    private List<ImageDto> images;
}
