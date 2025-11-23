package org.springboot.taskmanager.services;

import org.springboot.taskmanager.entities.TaskEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline){
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }
    public List<TaskEntity> getTasks(){
        return tasks;
    }
    public TaskEntity getTasksById(int id){
        for(TaskEntity task:tasks){
            if(task.getId() == id)return task;
        }
        return null;
    }
}
