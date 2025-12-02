package org.springboot.taskmanager.contollers;

import org.springboot.taskmanager.entities.TaskEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private Map<Integer,TaskEntity> tasks = new HashMap<>();

    @PostMapping
    public boolean createTask(@RequestBody TaskEntity newTask){
        tasks.put(newTask.getId(), newTask);
        return true;
    }


    @GetMapping("/getAll")
    public List<TaskEntity> getAll(){
        return new ArrayList<>(tasks.values());
    }

    @GetMapping("id/{id}")
    public TaskEntity getById(@PathVariable int id){
        if(tasks.get(id) == null)return null ;
        return tasks.get(id);
    }


    @DeleteMapping("/id/{id}")
    public TaskEntity deleteTaskById(@PathVariable int id){
        if(tasks.get(id) == null)return null;
        TaskEntity deletedTask = tasks.get(id);
        tasks.remove(id);
        return deletedTask;
    }

    @PutMapping("/id/{id}")
    public TaskEntity updateTaskById(@PathVariable int id, @RequestBody TaskEntity newTask){
        tasks.put(id,newTask);
        return tasks.get(id);
    }
}

