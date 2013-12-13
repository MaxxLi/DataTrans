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
public class SensorBaseline implements java.io.Serializable {
    private short id;
    private Sensor sensor;
    private Float mean;
    private Float std;
    private Timestamp updated;
    
    public SensorBaseline() {        
    }
    
    public SensorBaseline(short id, Sensor sensor) {
        this.id = id;
        this.sensor = sensor;
    }
    
    public SensorBaseline(short id, Sensor sensor, Float mean, Float std, Timestamp updated ) {
        this.id = id;
        this.sensor = sensor;
        this.mean= mean;
        this.std = std;
        this.updated = updated;
    }
    
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public Sensor getSensor() {
        return this.sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    public Float getMean() {
        return this.mean;
    }
    
    public void setMean(Float mean) {
        this.mean = mean;
    }
    
    public Float getStd() {
        return this.std;
    }
    
    public void setStd (Float std) {
        this.std = std;
    }
    
}
