package com.project.springboot.todo.taskMicroservice.services;

import com.project.springboot.todo.taskMicroservice.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

//    @Autowired
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }

    //create a new task
    public Task createTask(Task task){
        if(task != null){
            task.setIsComplete(false);
            return taskRepository.save(task);
        }else{
            throw new IllegalArgumentException("Task cannot be null");
        }

    }

    //get all tasks
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    //find a task by id
    public Optional<Task> getTask(Long taskId){
        if(taskId != null){
            return taskRepository.findById(taskId);
        }else{
            throw new IllegalArgumentException("Invalid task id");
        }

    }

    //update a task
    public Task updateTask(Long taskId){
        Optional<Task> getTask = taskRepository.findById(taskId);
        if(getTask.isPresent()){
            Task task = getTask.get();
            task.setIsComplete(true);
            return taskRepository.save(task);
        }
        else{
            return null;
        }
    }

    //delete a task
    public void deleteTask(Long taskId){
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
