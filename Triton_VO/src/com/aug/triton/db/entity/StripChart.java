/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import java.sql.Timestamp;

/**
 *
 * @author AUG
 */
public class StripChart implements java.io.Serializable {
     private long id;
     private Double intensity;
     private Short channel;
     private Timestamp sampleTime;
     
    public StripChart() {
    }

	
    public StripChart(long id) {
        this.id = id;
    }
    
    public StripChart(long id, Double intensity, Short channel, Timestamp sampleTime) {
       this.id = id;
       this.intensity = intensity;
       this.channel = channel;
       this.sampleTime = sampleTime;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Double getIntensity() {
        return this.intensity;
    }
    
    public void setIntensity(Double intensity) {
        this.intensity = intensity;
    }
    
    public Short getChannel() {
        return this.channel;
    }
    
    public void setChannel(Short channel) {
        this.channel = channel;
    }
    
    public Timestamp getSampleTime() {
        return this.sampleTime;
    }
    
    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }

}
