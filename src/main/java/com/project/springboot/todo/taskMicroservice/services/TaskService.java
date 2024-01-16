package com.project.springboot.todo.taskMicroservice.services;

import com.project.springboot.todo.taskMicroservice.dto.TaskDto;
import com.project.springboot.todo.taskMicroservice.entity.Task;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    //create a new task
    public Task createTask(TaskDto task){
        if(task.getTask() != null){
            Task newTask = new Task();
            newTask.setTask(task.getTask());
            newTask.setDescription(task.getDescription());
            newTask.setIsComplete(false);
            return taskRepository.save(newTask);
        }else{
            throw new IllegalArgumentException("Task cannot be null");
        }
    }

    //get all tasks
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    //find a task by id
    public Optional<Task> findTaskbyId(Integer taskId){
        if(taskId != null){
            return taskRepository.findById(taskId);
        }else{
            throw new IllegalArgumentException("Invalid task id");
        }

    }

    //check task whether complete or not
    public Task checkTask(Integer taskId){
        Optional<Task> getTask = taskRepository.findById(taskId);
        if(getTask.isPresent()){
            Task task = getTask.get();
            task.setIsComplete(true);
            return taskRepository.save(task);
        }
        else{
            throw new EntityNotFoundException("Task not found with ID: " + taskId);
        }
    }

    //delete a task
    public void deleteTask(Integer taskId){
        if(taskId != null){
            taskRepository.deleteById(taskId);
        }else{
            throw new IllegalArgumentException("Invalid task id");
        }
    }

    //delete all task
    public void deleteAllTask(){
        taskRepository.deleteAll();
    }
}
