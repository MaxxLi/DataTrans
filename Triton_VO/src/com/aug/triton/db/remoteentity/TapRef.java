package com.aug.triton.db.remoteentity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TapRef generated by hbm2java
 */
public class TapRef  implements java.io.Serializable {


     private int id;
     private Timestamp sampleTime;
     private Set tapRefDatas = new HashSet(0);

    public TapRef() {
    }

	
    public TapRef(int id) {
        this.id = id;
    }
    public TapRef(int id, Timestamp sampleTime, Set tapRefDatas) {
       this.id = id;
       this.sampleTime = sampleTime;
       this.tapRefDatas = tapRefDatas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getSampleTime() {
        return this.sampleTime;
    }
    
    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }
    public Set getTapRefDatas() {
        return this.tapRefDatas;
    }
    
    public void setTapRefDatas(Set tapRefDatas) {
        this.tapRefDatas = tapRefDatas;
    }




}


