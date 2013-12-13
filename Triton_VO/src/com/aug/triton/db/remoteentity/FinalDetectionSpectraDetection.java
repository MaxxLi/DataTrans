/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remoteentity;

/**
 *
 * @author AUG
 */
public class FinalDetectionSpectraDetection implements java.io.Serializable {
     private long id;
     private FinalDetectionResult finalDetection;
     private SpectraDetection spectraDetection;
     
     public FinalDetectionSpectraDetection() {         
     }
     
     public FinalDetectionSpectraDetection(long id, FinalDetectionResult finalDetection, 
             SpectraDetection spectraDetection) {
         this.id = id;
         this.finalDetection = finalDetection;
         this.spectraDetection = spectraDetection;
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
     
     public SpectraDetection getSpectraDetection() {
         return this.spectraDetection;
     }
     
     public void setSpectraDetection (SpectraDetection spectraDetection) {
         this.spectraDetection = spectraDetection;
     }
    
}
