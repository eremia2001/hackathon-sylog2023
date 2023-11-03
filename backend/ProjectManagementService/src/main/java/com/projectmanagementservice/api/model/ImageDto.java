package com.projectmanagementservice.api.model;

import lombok.Data;

@Data
public class ImageDto {
    private Long id;
    private String name;
    private byte[] bytes;
    private Long projectId;
}
