package com.xvitcoder.springmvcangularjs.beans;

import java.util.Map;

/**
 * Created by lucian on 23/06/16.
 */
public class MyTask {
    private String id;
    private String name;
    private String asignee;
    private String category;
    private String executionId;
    private String description;
    private String definitionKey;


    public MyTask(String id, String name, String asignee, String category, String executionId, String description, String definitionKey) {
        this.id = id;
        this.name = name;
        this.asignee = asignee;
        this.category = category;
        this.executionId = executionId;
        this.description = description;
        this.definitionKey = definitionKey;
    }

    public MyTask() {
    }

    public String getDefinitionKey() {
        return definitionKey;
    }

    public void setDefinitionKey(String definitionKey) {
        this.definitionKey = definitionKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAsignee() {
        return asignee;
    }

    public void setAsignee(String asignee) {
        this.asignee = asignee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }
}
