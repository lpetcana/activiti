package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.MyProcess;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntityManager;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("workflowService")
public class WorkflowServiceImpl implements WorkflowService {
    private static List<String> workflowList = new ArrayList<String>();

    @Autowired
    private ProcessEngine processEngine;
    /* @Autowired
     private RepositoryService repositoryService;
     */
    private final static Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

    @Override
    public List<MyProcess> getAllProcesses() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<ProcessDefinition> processesList = repositoryService.createProcessDefinitionQuery().list();


        List<MyProcess> myProcessesList = new ArrayList<>();
        for (ProcessDefinition p : processesList){
            ProcessDefinitionEntity pe = (ProcessDefinitionEntity) p;
            myProcessesList.add(new MyProcess(pe.getName(),pe.getDeploymentId()));
        }
        return myProcessesList;
    }

    @Override
    public void addWorkflow(String workflow) {
        workflowList.add(workflow);
    }

    @Override
    public void deleteWorkflow(String workflow) {
        if (workflowList.contains(workflow)) {
            workflowList.remove(workflow);
        }
    }

}
