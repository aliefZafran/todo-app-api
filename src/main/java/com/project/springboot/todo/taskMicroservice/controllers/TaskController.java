package com.project.springboot.todo.taskMicroservice.controllers;

import com.project.springboot.todo.taskMicroservice.entity.Task;
import com.project.springboot.todo.taskMicroservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/test")
    public String returnString(){
        return "Working";
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        return new ResponseEntity<List<Task>>(taskService.getTasks(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<Optional<Task>> getSingleTask(@PathVariable Long taskId){
        Optional<Task> task = taskService.getTask(taskId);
        if(task.isPresent()){
            return new ResponseEntity<Optional<Task>>(taskService.getTask(taskId), HttpStatus.OK);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId){
        return new ResponseEntity<Task>(taskService.updateTask(taskId), HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTask(){
        taskService.deleteAllTask();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
