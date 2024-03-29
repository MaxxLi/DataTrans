package com.aug.triton.db.remoteentity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA


import java.sql.Timestamp;

/**
 * SensorReading generated by hbm2java
 */
public class SensorReading  implements java.io.Serializable {


     private long id;
//     private short sensorId;
     private Sensor sensor;
     private SensorReadingGroup sensorReadingGroup;
     private Boolean isDetected;
     private Boolean isUploaded;
     private Double confidence;
     private Double reading;

    public SensorReading() {
    }

	
//    public SensorReading(long id, short sensorId, Date sampleTime) {
//        this.id = id;
//        this.sensorId = sensorId;
//        this.sampleTime = sampleTime;
//    }
    public SensorReading(long id, Sensor sensor, SensorReadingGroup sensorReadingGroup) {
        this.id = id;
        this.sensor = sensor;
        this.sensorReadingGroup = sensorReadingGroup;
    }

    public SensorReading(long id, Sensor sensor, SensorReadingGroup sensorReadingGroup, 
            Boolean isDetected, Double confidence, Boolean isUploaded, Double reading) {
       this.id = id;
       this.sensor = sensor;
       this.sensorReadingGroup = sensorReadingGroup;
       this.isDetected = isDetected;
       this.confidence = confidence;
       this.reading = reading;
       this.isUploaded = isUploaded;
       
    }
   
//    public SensorReading(long id, short sensorId, Date sampleTime, Boolean isDetected, Float confidence, Boolean isUploaded, Float reading) {
//       this.id = id;
//       this.sensorId = sensorId;
//       this.sampleTime = sampleTime;
//       this.isDetected = isDetected;
//       this.confidence = confidence;
//       this.isUploaded = isUploaded;
//       this.reading = reading;
//    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Sensor getSensor() {
        return this.sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
//    public short getSensorId() {
//        return this.sensorId;
//    }
//    
//    public void setSensorId(short sensorId) {
//        this.sensorId = sensorId;
//    }
    
    public SensorReadingGroup getSensorReadingGroup() {
        return this.sensorReadingGroup;
    }
    
    public void setSensorReadingGroup(SensorReadingGroup sensorReadingGroup) {
        this.sensorReadingGroup = sensorReadingGroup;
    }
    public Boolean getIsDetected() {
        return this.isDetected;
    }
    
    public void setIsDetected(Boolean isDetected) {
        this.isDetected = isDetected;
    }
    public Double getConfidence() {
        return this.confidence;
    }
    
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }
    public Double getReading() {
        return this.reading;
    }
    
    public void setReading(Double reading) {
        this.reading = reading;
    }

    public Boolean getIsUploaded(){
        return this.isUploaded;
    }

    public void setIsUploaded(Boolean isUploaded){
        this.isUploaded = isUploaded;
    }


}


