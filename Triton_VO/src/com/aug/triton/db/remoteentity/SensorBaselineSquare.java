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
public class SensorBaselineSquare implements java.io.Serializable {
    private short id;
    private Sensor rowSensor;
    private Sensor columnSensor;
    private Double squareMean;
    private Timestamp updated;
    
    public SensorBaselineSquare() {        
    }
    
    public SensorBaselineSquare(short id, Sensor rowSensor, Sensor columnSensor) {
        this.id = id;
        this.rowSensor = rowSensor;
        this.columnSensor = columnSensor;
    }
    
    public SensorBaselineSquare(short id, Sensor rowSensor, Sensor columnSensor, Double squareMean, Timestamp updated ) {
        this.id = id;
        this.rowSensor = rowSensor;
        this.columnSensor = columnSensor;
        this.squareMean= squareMean;
        this.updated = updated;
    }
    
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public Sensor getRowSensor() {
        return this.rowSensor;
    }
    
    public void setRowSensor(Sensor rowSensor) {
        this.rowSensor = rowSensor;
    }

    public Sensor getColumnSensor() {
        return this.columnSensor;
    }
    
    public void setColumnSensor(Sensor columnSensor) {
        this.columnSensor = columnSensor;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    public Double getSquareMean() {
        return this.squareMean;
    }
    
    public void setSquareMean(Double squareMean) {
        this.squareMean = squareMean;
    }
    
}
