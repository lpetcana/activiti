package com.xvitcoder.springmvcangularjs.beans;

/**
 * Created by lucian on 23/06/16.
 */
public class MyProcess {

    private String name;
    private String id;

    public MyProcess(String name, String id){
        this.name=name;
        this.id=id;
    }

    public MyProcess(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
