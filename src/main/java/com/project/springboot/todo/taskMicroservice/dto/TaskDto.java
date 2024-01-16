package com.project.springboot.todo.taskMicroservice.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String task;
    private String description;
//    private String userId;
}
