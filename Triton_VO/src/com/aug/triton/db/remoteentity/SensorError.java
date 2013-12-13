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
public class SensorError {
     private short id;
     private Sensor sensor;
     private Timestamp startTime;
     private int duration;
     private String message;
     
     
     public SensorError() {
     }
     
     public SensorError(short id, Sensor sensor, Timestamp startTime, int duration, String message) {
         this.id = id;
         this.sensor = sensor;
         this.startTime = startTime;
         this.duration = duration;
         this.message = message;
     }
     
     public void setId(short id){
         this.id = id;
     }
     
     public void setSensor(Sensor sensor){
         this.sensor = sensor;
     }
     
     public void setStartTime(Timestamp startTime){
         this.startTime = startTime;
     }
     
     public void setDuration (int duration){
         this.duration = duration;
     }
     
     public void setMessage (String message){
         this.message = message;
     }
     
     public short getId(){
         return this.id;
     }
     
     public Sensor getSensor(){
         return this.sensor;
     }
     
     public Timestamp getStartTime(){
         return this.startTime;
     }
     
     public int getDuration(){
         return this.duration;
     }
     
     public String getMessage(){
         return this.message;
     }
}
