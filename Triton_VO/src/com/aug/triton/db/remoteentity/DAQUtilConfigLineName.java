/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

/**
 *
 * @author AUG
 */
public class DAQUtilConfigLineName {
    private int id;
    private DAQUtilConfig DAQUtilConfig;
    private String lineName;
    private int index;
    
    public DAQUtilConfigLineName(){
        
    }
    
    public DAQUtilConfigLineName(int id, DAQUtilConfig DAQUtilConfig, String lineName, int index){
        this.id = id;
        this.DAQUtilConfig = DAQUtilConfig;
        this.lineName = lineName;
        this.index = index;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setDAQUtilConfig(DAQUtilConfig daqUtilConfig){
        this.DAQUtilConfig = daqUtilConfig;
    }
    
    public DAQUtilConfig getDAQUtilConfig(){
        return this.DAQUtilConfig;
    }
    
    public void setLineName(String lineName){
        this.lineName = lineName;
    }
    
    public String getLineName(){
        return this.lineName;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public int getIndex(){
        return this.index;
    }
}
