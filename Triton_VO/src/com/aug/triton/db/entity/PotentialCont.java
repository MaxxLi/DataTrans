package com.aug.triton.db.entity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA





/**
 * PotentialCont generated by hbm2java
 */
public class PotentialCont  implements java.io.Serializable {


     private long id;
     private Cont cont;
     private SpectraDetection spectraDetection;
     private Float confidence;
     private Float estimatedValue;

    public PotentialCont() {
    }

	
    public PotentialCont(long id, Cont cont, SpectraDetection spectraDetection, Float confidence) {
        this.id = id;
        this.cont = cont;
        this.spectraDetection = spectraDetection;
        this.confidence = confidence;
    }
    public PotentialCont(long id, Cont cont, SpectraDetection spectraDetection, Float confidence, Float estimatedValue) {
       this.id = id;
       this.cont = cont;
       this.spectraDetection = spectraDetection;
       this.confidence = confidence;
       this.estimatedValue = estimatedValue;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Cont getCont() {
        return this.cont;
    }
    
    public void setCont(Cont cont) {
        this.cont = cont;
    }
    public SpectraDetection getSpectraDetection() {
        return this.spectraDetection;
    }
    
    public void setSpectraDetection(SpectraDetection spectraDetection) {
        this.spectraDetection = spectraDetection;
    }
    public float getConfidence() {
        return this.confidence;
    }
    
    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }
    public Float getEstimatedValue() {
        return this.estimatedValue;
    }
    
    public void setEstimatedValue(Float estimatedValue) {
        this.estimatedValue = estimatedValue;
    }




}


