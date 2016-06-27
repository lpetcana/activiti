package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.MyTask;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;



public interface TasksService {
    List<MyTask> getAllTasks();
}
