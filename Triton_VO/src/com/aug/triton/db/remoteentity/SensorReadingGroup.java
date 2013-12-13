/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author AUG
 */
public class SensorReadingGroup implements java.io.Serializable {

     private long id;
     private Timestamp sampleTime;
     private Set sensorReadings = new HashSet(0);

    public SensorReadingGroup() {
    }

	
    public SensorReadingGroup(long id) {
        this.id = id;
    }
    
    public SensorReadingGroup(long id, Timestamp sampleTime, Set sensorReadings) {
       this.id = id;
       this.sampleTime = sampleTime;
       this.sensorReadings = sensorReadings;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Timestamp getSampleTime() {
        return this.sampleTime;
    }
    
    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }
    public Set getSensorReadings() {
        return this.sensorReadings;
    }
    
    public void setSensorReadings(Set sensorReadings) {
        this.sensorReadings = sensorReadings;
    }
}
