package com.project.springboot.todo.taskMicroservice.services;

import com.project.springboot.todo.taskMicroservice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
