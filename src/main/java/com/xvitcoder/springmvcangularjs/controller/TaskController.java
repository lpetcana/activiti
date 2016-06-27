package com.xvitcoder.springmvcangularjs.controller;

import com.xvitcoder.springmvcangularjs.beans.MyTask;
import com.xvitcoder.springmvcangularjs.service.TasksService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TasksService taskService;

    @RequestMapping("/tasklist.json")
    public @ResponseBody List<MyTask> getTaskList() {
        return taskService.getAllTasks();
    }

    @RequestMapping("/layout")
    public String getTaskPartialPage() {
        return "tasks/layout";
    }

    @RequestMapping("/taskEdit")
    public String getTaskDetailPartialPage() {
        System.out.println("loading task edit page");
        return "tasks/taskEdit";
    }
}
