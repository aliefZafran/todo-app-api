package com.project.springboot.todo.taskMicroservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name="task")
    private String task;

    @Column(name="description")
    private String description;

    @Column(name="isComplete")
    private boolean isComplete;

//    @Column(name="userId")
//    private Integer userId;

    public Task(String task, String description, boolean isComplete){
        this.task = task;
        this.description = description;
        this.isComplete = isComplete;
    }

    public boolean getIsComplete(){
        return isComplete;
    }

    public void setIsComplete(boolean isComplete){
        this.isComplete = isComplete;
    }

}
