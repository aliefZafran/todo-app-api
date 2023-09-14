package com.project.springboot.todo.taskMicroservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="task")
    private String task;

    @Column(name="isComplete")
    private boolean isComplete;

    @Column(name="userId")
    private Long userId;

    public void setIsComplete(boolean isComplete){
        this.isComplete = isComplete;
    }

    public boolean getIsComplete(){
        return isComplete;
    }

}
