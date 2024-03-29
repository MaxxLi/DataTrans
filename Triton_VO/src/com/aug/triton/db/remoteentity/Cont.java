package com.aug.triton.db.remoteentity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Cont generated by hbm2java
 */
public class Cont  implements java.io.Serializable {


     private short id;
     private String contName;
     private String units;
     private Set potentialConts = new HashSet(0);
     private Boolean read;

    public Cont() {
    }

	
    public Cont(short id, String contName) {
        this.id = id;
        this.contName = contName;
    }
    
    public Cont(short id, String contName, String units, Set potentialConts) {
       this.id = id;
       this.contName = contName;
       this.units = units;
       this.potentialConts = potentialConts;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setRead(Boolean isRead){
        this.read = isRead;
    }
    
    
    public Boolean getRead()
    {
        return this.read;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public String getContName() {
        return this.contName;
    }
    
    public void setContName(String contName) {
        this.contName = contName;
    }
    public String getUnits() {
        return this.units;
    }
    
    public void setUnits(String units) {
        this.units = units;
    }
    public Set getPotentialConts() {
        return this.potentialConts;
    }
    
    public void setPotentialConts(Set potentialConts) {
        this.potentialConts = potentialConts;
    }




}


