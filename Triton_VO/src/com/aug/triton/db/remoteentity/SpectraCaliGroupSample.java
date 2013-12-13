/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

/**
 *
 * @author AUG
 */
public class SpectraCaliGroupSample implements java.io.Serializable {
    private int id;
    private SpectraCaliGroup spectraCaliGroup;
    private Double concentration;
    
    public SpectraCaliGroupSample() {        
    }
    
    public SpectraCaliGroupSample(int id) {
        this.id = id;
    }
    
    public SpectraCaliGroupSample(int id, SpectraCaliGroup spectraCaliGroup, Double concentration){
        this.id = id;
        this.spectraCaliGroup = spectraCaliGroup;
        this.concentration = concentration;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public SpectraCaliGroup getSpectraCaliGroup() {
        return this.spectraCaliGroup;
    }
    
    public void setSpectraCaliGroup (SpectraCaliGroup spectraCaliGroup) {
        this.spectraCaliGroup = spectraCaliGroup;
    }
    
    public Double getConcentration() {
        return this.concentration;
    }
    
    public void setConcentration(Double concentration) {
        this.concentration = concentration;
    }
}
