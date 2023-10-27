package com.projectmanagementservice.api.model;

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
    @Nullable
    private List<Long> memberIds;
    @Nullable
    private List<ImageDto> images;
}
