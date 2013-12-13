/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

/**
 *
 * @author AUG
 */
public class SystemConfig implements java.io.Serializable {


     private short id;
     private String parameterName;
     private String parameterValue;

    public SystemConfig() {
    }

	
    public SystemConfig(short id) {
        this.id = id;
    }

    public SystemConfig(short id, String parameterName, String parameterValue) {
       this.id = id;
       this.parameterName = parameterName;
       this.parameterValue = parameterValue;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public String getParameterName() {
        return this.parameterName;
    }
    
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
    
    public String getParameterValue() {
        return this.parameterValue;
    }
    
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
        
}
