package com.xvitcoder.springmvcangularjs.controller;


import com.xvitcoder.springmvcangularjs.beans.MyProcess;
import com.xvitcoder.springmvcangularjs.service.WorkflowService;
import org.activiti.engine.*;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lucian on 14/06/16.
 */
@Controller
@RequestMapping("/workflows")
public class WorkflowController {
    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private ProcessEngine processEngine;

    @RequestMapping("/workflowlist.json")
    public @ResponseBody List<MyProcess> getWorkflowList(){
        return workflowService.getAllProcesses();
    }


   /* public @ResponseBody List<String> getWorkflowList() {


       *//* ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        if (processEngine!=null) {
            System.out.println("nu e null");
        } else {
            System.out.println("CHIAR E NULL");
        }*//*
        List<String> wfs = new ArrayList<String>();


        try {
            ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault()
                    .buildProcessEngine();

            if (processEngine != null) {
                System.out.println("nu e null - 2");
            } else {
                System.out.println("CHIAR E NULL -2");
            }

            RepositoryService repositoryService = processEngine.getRepositoryService();

            RuntimeService runtimeService = processEngine.getRuntimeService();

            TaskService taskService = processEngine.getTaskService();
            ManagementService managementService = processEngine.getManagementService();
            IdentityService identityService = processEngine.getIdentityService();
            HistoryService historyService = processEngine.getHistoryService();
            FormService formService = processEngine.getFormService();


            //List deployments = repositoryService.createDeploymentQuery().list();
            List deployments = repositoryService.createProcessDefinitionQuery().list();
            for (Object l : deployments) {
                ProcessDefinitionEntity pe = (ProcessDefinitionEntity) l;
                System.out.println(pe.getName() + " " + pe.getKey());

                wfs.add(pe.getDeploymentId()+" "+pe.getId()+ " " + pe.getName() + " " + pe.getKey());
            }

            List deployments2 = repositoryService.createModelQuery().list();
            for (Object l : deployments2) {
                ModelEntity me = (ModelEntity) l;
                System.out.println(me.getName());
                //System.out.println(l.toString());
            }


            System.out.println(deployments2.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            return wfs;

        }


    }
*/
    public void deployModel(){
        try{
            ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault()
                    .buildProcessEngine();
            RepositoryService repositoryService = processEngine.getRepositoryService();
            repositoryService.createDeployment()
                    .addClasspathResource("vacation.bpmn20.xml")
                    .deploy();

            System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
        }
        catch (Exception ex){

        }
    }


    @RequestMapping(value = "/addWorkflow/{workflow}", method = RequestMethod.POST)
    public
    @ResponseBody
    void addWorkflow(@PathVariable("workflow") String workflow) {
        workflowService.addWorkflow(workflow);
    }

    @RequestMapping(value = "/removeWorkflow/{workflow}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void removeWorkflow(@PathVariable("workflow") String workflow) {
        workflowService.deleteWorkflow(workflow);
    }

    @RequestMapping("/layout")
    public String getWfPartialPage() {
        return "workflows/layout";
    }

    @RequestMapping("/www.json")
    public
    @ResponseBody
    String doAction() {
        try {
            System.out.println("***********");
            //deployModel();
            System.out.println("***********");


            //ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
            //RepositoryService repositoryService = processEngine.getRepositoryService();
            RuntimeService runtimeService = processEngine.getRuntimeService();

            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("employeeName", "lucian");
            variables.put("numberOfDays", new Integer(4));
            variables.put("vacationMotivation", "e caldura mare!");

            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);


            //ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest");

            TaskService taskService = processEngine.getTaskService();
            List<Task> tasks = taskService.createTaskQuery().active().list();//taskAssigneeLike("lucian").list();

            for (Task task : tasks) {
                System.out.println("Task available: " +task.getId() + " " + task.getName() + " " + task.getAssignee());

                if (task.getId().equals("52505")) {
                    Map<String, Object> taskVariables = new HashMap<String, Object>();
                    taskVariables.put("vacationApproved", "true");
                    taskVariables.put("managerMotivation", "have fun!");
                    taskService.complete(task.getId(), taskVariables);

/*
                   Map<String, Object> variables = new HashMap<String, Object>();
                    //variables.put("employeeName", "lucian");
                    //variables.put("numberOfDays", new Integer(2));
                    variables.put("resendRequest", false);
                    //variables.put("vacationMotivation", "vreau concediu ba!");
                    taskService.complete(task.getId(), variables);
                }*/
                }
            }

/*

            Task task = tasks.get(0);

if (task.getId().equals("17507")){
            Map<String, Object> taskVariables = new HashMap<String, Object>();
            taskVariables.put("vacationApproved", "false");
            taskVariables.put("managerMotivation", "We have a tight deadlinex!");
            taskService.complete(task.getId(), taskVariables);
}*/





        } catch (Exception ex) {
            System.out.println("Exceptie");
            System.out.println(ex.getMessage());
        } finally {

            System.out.println("do that");
            return "do that";

        }


    }
}
