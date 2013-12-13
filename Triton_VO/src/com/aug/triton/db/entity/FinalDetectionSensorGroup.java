/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;


/**
 *
 * @author AUG
 */
public class FinalDetectionSensorGroup  implements java.io.Serializable {
     private long id;
     private FinalDetectionResult finalDetection;
     private SensorReadingGroup sensorGroup;
     
     public FinalDetectionSensorGroup() {         
     }
     
     public FinalDetectionSensorGroup(long id, FinalDetectionResult finalDetection, 
             SensorReadingGroup sensorGroup) {
         this.id = id;
         this.finalDetection = finalDetection;
         this.sensorGroup = sensorGroup;
     }
     
     public long getId() {
         return this.id;
     }
     
     public void setId(long id) {
         this.id = id;
     }
     
     public FinalDetectionResult getFinalDetection() {
         return this.finalDetection;
     }
     
     public void setFinalDetection(FinalDetectionResult finalDetectionResult) {
         this.finalDetection = finalDetectionResult;
     }
     
     public SensorReadingGroup getSensorGroup() {
         return this.sensorGroup;
     }
     
     public void setSensorGroup (SensorReadingGroup sensorReadingGroup) {
         this.sensorGroup = sensorReadingGroup;
     }
}
