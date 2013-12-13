/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

import java.sql.Timestamp;

/**
 *
 * @author AUG
 */
public class EventLog implements java.io.Serializable {


     private Long id;
     private String message;
     private String logType;
     private Timestamp logTime;

    public EventLog() {
    }

	
    public EventLog(Long id) {
        this.id = id;
    }

    public EventLog(Long id, String message, String logType, Timestamp logTime) {
       this.id = id;
       this.message = message;
       this.logType = logType;
       this.logTime = logTime;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getLogType() {
        return this.logType;
    }
    
    public void setLogType(String logType) {
        this.logType = logType;
    }
    
    public Timestamp getLogTime() {
        return this.logTime;
    }
    
    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
  
}
