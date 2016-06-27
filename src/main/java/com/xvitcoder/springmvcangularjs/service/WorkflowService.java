package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.MyProcess;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;


public interface WorkflowService {
    List<MyProcess> getAllProcesses();

    public void addWorkflow(String workflow);

    public void deleteWorkflow(String workflow);
}
