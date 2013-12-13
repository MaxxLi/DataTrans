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
public class SpectraBaseline implements java.io.Serializable{
    private int id;
    private Double mean;
    private Double wavelength;
    private Timestamp updated;
    
    public SpectraBaseline() {        
    }
    
    public SpectraBaseline(int id) {
        this.id = id;
    }
    
    public SpectraBaseline(int id, Double mean, Double wavelength, Timestamp updated ) {
        this.id = id;
        this.mean= mean;
        this.wavelength = wavelength;
        this.updated = updated;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Timestamp getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    public Double getMean() {
        return this.mean;
    }
    
    public void setMean(Double mean) {
        this.mean = mean;
    }
    
    public Double getWavelength() {
        return this.wavelength;
    }
    
    public void setWavelength (Double wavelength) {
        this.wavelength = wavelength;
    }
    
    
}
