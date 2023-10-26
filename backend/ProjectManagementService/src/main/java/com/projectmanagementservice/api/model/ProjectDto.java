package com.projectmanagementservice.api.model;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDto {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Integer budget;
    private String status;
    private Long organizationId;
    private List<Long> memberIds;
    private List<ImageDto> images;
}
