/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;


/**
 *
 * @author AUG
 */
public class SensorCali implements java.io.Serializable{
    private short id;
    private String lastCalibrated;
    private Double offset;
    private Double readingAdjustment;
    private Double shuntResistance;
    private Double maxCurrent;
    private Double minCurrent;
    private String deviceChannel;
    private Double slope;
    private Sensor sensor;

    public SensorCali() {
    }

	
    public SensorCali(short id) {
        this.id = id;
    }

    public SensorCali(short id, String lastCalibrated, Double offset, Double readingAdjustment, 
                Double shuntResistance, Double maxCurrent, Double maxVal, 
                Double minCurrent, Double minVal, 
                String deviceChannel, Sensor sensor ) {
       this.id = id;
       this.lastCalibrated = lastCalibrated;
       this.offset = offset;
       this.readingAdjustment = readingAdjustment;
       this.shuntResistance = shuntResistance;
       this.maxCurrent = maxCurrent;
       this.minCurrent = minCurrent;
       this.deviceChannel = deviceChannel;
       this.sensor = sensor;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public String getlastCalibrated() {
        return this.lastCalibrated;
    }
    
    public void setlastCalibrated(String lastCalibrated) {
        this.lastCalibrated = lastCalibrated;
    }
    
    public Double getoffset(){
        return this.offset;
    }
    
    public void setoffset(Double offset){
        this.offset = offset;
    }
    
    public Double getreadingAdjustment(){
        return this.readingAdjustment;
    }
    
    public void setreadingAdjustment(Double readingAdjustment){
        this.readingAdjustment = readingAdjustment;
    }
    
    public Double getshuntResistance(){
        return this.shuntResistance;
    }
    
    public void setshuntResistance(Double shuntResistance){
        this.shuntResistance = shuntResistance;
    }
    
    public Double getmaxCurrent(){
        return this.maxCurrent;
    }
    
    public void setmaxCurrent(Double maxCurrent){
        this.maxCurrent = maxCurrent;
    }
    
    public Double getminCurrent(){
        return this.minCurrent;
    }
    
    public void setminCurrent(Double minCurrent){
        this.minCurrent = minCurrent;
    }
    
    public Sensor getsensor() {
        return this.sensor;
    }
    
    public void setsensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
    public String getdeviceChannel() {
        return this.deviceChannel;
    }
    
    public void setdeviceChannel(String deviceChannel) {
        this.deviceChannel = deviceChannel;
    }
    
    public Double getSlope() {
        return this.slope;
    }
    
    public void setSlope(Double slope) {
        this.slope = slope;
    }
    
}
