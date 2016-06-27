package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.MyTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucian on 23/06/16.
 */
@Service("tasksService")
public class TasksServiceImpl implements TasksService {
    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private org.activiti.engine.TaskService taskService;


    @Override
    public List<MyTask> getAllTasks() {
        List<Task> tasks = taskService.createTaskQuery().active().list();

        List<MyTask> myTasks = new ArrayList<>();
        for (Task t: tasks){

            myTasks.add(new MyTask(t.getId(),t.getName(),t.getAssignee(), t.getCategory(), t.getExecutionId(), t.getDescription(), t.getTaskDefinitionKey()));
        }

        return myTasks;
    }
}
