package com.project.springboot.todo.taskMicroservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping("/test")
    public String returnString(){
        return "Working";
    }
}
