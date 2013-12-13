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
public class LabMeasurement implements java.io.Serializable {
    private short id;
    private Cont cont;
    private Timestamp sampleTime;
    private Timestamp modified;
    private Double reading;
    
    public LabMeasurement() {        
    }
    
    public LabMeasurement(short id, Cont cont) {
        this.id = id;
        this.cont = cont;
    }
    
    public LabMeasurement(short id, Cont cont, Timestamp sampleTime, Timestamp modified, Double reading ) {
        this.id = id;
        this.cont = cont;
        this.sampleTime = sampleTime;
        this.modified = modified;
        this.reading = reading;
    }
    
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public Cont getCont() {
        return this.cont;
    }
    
    public void setCont(Cont cont) {
        this.cont = cont;
    }

    public Timestamp getSampleTime() {
        return this.sampleTime;
    }
    
    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }
    
    public Timestamp getModified() {
        return this.modified;
    }
    
    public void setModified(Timestamp modified) {
        this.modified = modified;
    }
    
    public Double getReading() {
        return this.reading;
    }
    
    public void setReading(Double reading) {
        this.reading = reading;
    }
    
}
