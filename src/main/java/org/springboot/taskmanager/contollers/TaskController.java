package org.springboot.taskmanager.contollers;

import org.springboot.taskmanager.entities.TaskEntity;
import org.springboot.taskmanager.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController (TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/getAll")
    public List<TaskEntity> getAll(){
        return new ArrayList<>(taskService.getTasks());
    }

    @GetMapping("")
    public TaskEntity getById(int id){
        if(taskService.getTasksById(id) == null)return null ;
        return taskService.getTasksById(id);
    }

    @PostMapping("")
    public void saveTask(String name, String description){

    }
}
