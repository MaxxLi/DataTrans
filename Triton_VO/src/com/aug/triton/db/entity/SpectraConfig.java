/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

/**
 *
 * @author AUG
 */
public class SpectraConfig implements java.io.Serializable {


     private short id;
     private Integer ch0IntegTime;
     private Integer ch1IntegTime;

    public SpectraConfig() {
    }

	
    public SpectraConfig(short id) {
        this.id = id;
    }

    public SpectraConfig(short id, int ch0IntegTime, int ch1IntegTime) {
       this.id = id;
       this.ch0IntegTime = ch0IntegTime;
       this.ch1IntegTime = ch1IntegTime;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    
    public Integer getCh0IntegTime() {
        return this.ch0IntegTime;
    }
    
    public void setCh0IntegTime(Integer ch0IntegTime) {
        this.ch0IntegTime = ch0IntegTime;
    }
    
    public Integer getCh1IntegTime() {
        return this.ch1IntegTime;
    }
    
    public void setCh1IntegTime(Integer ch1IntegTime) {
        this.ch1IntegTime = ch1IntegTime;
    }
        
}
