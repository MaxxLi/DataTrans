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
public class SpectraCaliGroup implements java.io.Serializable {
    private int id;
    private Cont cont;
    private Timestamp sampleTime;
    private TapRef tapRef;
    private Boolean isSelected;
    private Integer peakWavelength;
    private Double slope;
    private Double intercept;
    
    public SpectraCaliGroup() {         
    }
     
    public SpectraCaliGroup(int id){
        this.id = id;
    }
    
    public SpectraCaliGroup(int id, Cont cont, Timestamp sampleTime, TapRef tapRef,
            Boolean isSelected, Integer peakWavelength, Double slope, Double intercept){
        this.id = id;
        this.cont = cont;
        this.sampleTime = sampleTime;
        this.tapRef = tapRef;
        this.isSelected = isSelected;
        this.peakWavelength = peakWavelength;
        this.slope = slope;
        this.intercept = intercept;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Cont getCont() {
        return this.cont;
    }
    
    public void setCont(Cont cont) {
        this.cont = cont;
    }
    
    public Timestamp getSampleTime () {
        return this.sampleTime;
    }
    
    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }
    
    public TapRef getTapRef() {
        return this.tapRef;
    }
    
    public void setTapRef(TapRef tapRef) {
        this.tapRef = tapRef;
    }
    
    public Boolean getIsSelected() {
        return this.isSelected;
    }
    
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    public Integer getPeakWavelength() {
        return this.peakWavelength;
    }
    
    public void setPeakWavelength(Integer peakWavelength) {
        this.peakWavelength = peakWavelength;
    }
    
    public Double getSlope() {
        return this.slope;
    }
    
    public void setSlope(Double slope){
        this.slope = slope;
    }
    
    public Double getIntercept() {
        return this.intercept;
    }
    
    public void setIntercept(Double intercept) {
        this.intercept = intercept;
    }
}
