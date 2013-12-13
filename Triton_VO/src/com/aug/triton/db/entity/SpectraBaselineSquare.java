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
public class SpectraBaselineSquare implements java.io.Serializable {
    private int id;
    private Double rowWavelength;
    private Double columnWavelength;
    private Double squareMean;
    private Timestamp updated;
    
    public SpectraBaselineSquare() {        
    }
    
    public SpectraBaselineSquare(int id, Double rowWavelength, Double columnWavelength) {
        this.id = id;
        this.rowWavelength = rowWavelength;
        this.columnWavelength = columnWavelength;
    }
    
    public SpectraBaselineSquare(int id, Double rowWavelength, Double columnWavelength, Double squareMean, Timestamp updated ) {
        this.id = id;
        this.rowWavelength = rowWavelength;
        this.columnWavelength = columnWavelength;
        this.squareMean= squareMean;
        this.updated = updated;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Double getRowWavelength() {
        return this.rowWavelength;
    }
    
    public void setRowWavelength(Double rowWavelength) {
        this.rowWavelength = rowWavelength;
    }

    public Double getColumnWavelength() {
        return this.columnWavelength;
    }
    
    public void setColumnWavelength(Double columnWavelength) {
        this.columnWavelength = columnWavelength;
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
