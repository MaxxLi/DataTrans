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
public class SpectraCaliSampleData implements java.io.Serializable {
    private long id;
    private SpectraCaliGroupSample sample;
    private Double wavelength;
    private Double absorption;
    
    public SpectraCaliSampleData() {
      
    }
    
    public SpectraCaliSampleData(long id) {
        this.id = id;
    }
    
    public SpectraCaliSampleData(long id, SpectraCaliGroupSample sample,  
            Double wavelength, Double absorption) {
        this.id = id;
        this.sample = sample;
        this.wavelength = wavelength;
        this.absorption = absorption;
    }
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public SpectraCaliGroupSample getSpectraCaliGroupSample() {
        return this.sample;
    }
    
    public void setSpectraCaliGroupSample(SpectraCaliGroupSample sample) {
        this.sample = sample;
    }
    
    public Double getWavelength() {
        return this.wavelength;
    }
    
    public void setWavelength(Double wavelength) {
        this.wavelength = wavelength;
    }
    
    public Double getAbsorption() {
        return this.absorption;
    }
    
    public void setAbsorption (Double absorption) {
        this.absorption = absorption;
    }

}
