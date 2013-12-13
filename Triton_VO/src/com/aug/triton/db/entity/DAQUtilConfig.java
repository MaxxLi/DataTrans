/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author AUG
 */
public class DAQUtilConfig implements java.io.Serializable {
    private int id;
    private String device;
    private String outputString;
    private int numLines;
    private String utilName;
    private Set DAQUtilConfigLineNames = new HashSet(0);
    
    public DAQUtilConfig(){
        
    }
    
    public DAQUtilConfig(int id, String device, String outputString, int numLines, String utilName, Set DAQUtilConfigLineNames){
        this.id = id;
        this.device = device;
        this.outputString = outputString;
        this.numLines = numLines;
        this.utilName = utilName;
        this.DAQUtilConfigLineNames = DAQUtilConfigLineNames;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setDevice(String device){
        this.device = device;
    }
    
    public String getDevice(){
        return this.device;
    }
    
    public void setOutputString(String outputString){
        this.outputString = outputString;
    }
    
    public String getOutputString(){
        return this.outputString;
    }
    
    public void setNumLines(int numLines){
        this.numLines = numLines;
    }
    
    public int getNumLines(){
        return this.numLines;
    }
    
    public void setUtilName(String utilName){
        this.utilName = utilName;
    }
    
    public String getUtilName(){
        return this.utilName;
    }
    
    public void setDAQUtilConfigLineNames(Set DAQUtilConfigLineNames){
        this.DAQUtilConfigLineNames = DAQUtilConfigLineNames;
    }
    
    public Set getDAQUtilConfigLineNames(){
        return this.DAQUtilConfigLineNames;
    }
}
