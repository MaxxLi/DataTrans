package com.aug.triton.db.remoteentity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA



/**
 * SpectraReading generated by hbm2java
 */
public class SpectraReading  implements java.io.Serializable {


     private long id;
     private SpectraDetection spectraDetection;
     private float wavelength;
     private float absorption;

    public SpectraReading() {
    }

	
    public SpectraReading(long id, float wavelength, float absorption) {
        this.id = id;
        this.wavelength = wavelength;
        this.absorption = absorption;
    }
    public SpectraReading(long id, SpectraDetection spectraDetection, float wavelength, float absorption) {
       this.id = id;
       this.spectraDetection = spectraDetection;
       this.wavelength = wavelength;
       this.absorption = absorption;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public SpectraDetection getSpectraDetection() {
        return this.spectraDetection;
    }
    
    public void setSpectraDetection(SpectraDetection spectraDetection) {
        this.spectraDetection = spectraDetection;
    }
    public float getWavelength() {
        return this.wavelength;
    }
    
    public void setWavelength(float wavelength) {
        this.wavelength = wavelength;
    }
    public float getAbsorption() {
        return this.absorption;
    }
    
    public void setAbsorption(float absorption) {
        this.absorption = absorption;
    }




}


