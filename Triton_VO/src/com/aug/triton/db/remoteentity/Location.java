package com.aug.triton.db.remoteentity;
// Generated 3-Nov-2011 2:30:54 PM by Hibernate Tools 3.2.1.GA



/**
 * Location generated by hbm2java
 */
public class Location  implements java.io.Serializable {


     private short id;
     private String address;
     private String intersection;
     private Float latitude;
     private String locationType;
     private Float longitude;
     private String postalCode;
     private String systemName;

    public Location() {
    }

	
    public Location(short id, String systemName) {
        this.id = id;
        this.systemName = systemName;
    }
    public Location(short id, String address, String intersection, Float latitude, String locationType, Float longitude, String postalCode, String systemName) {
       this.id = id;
       this.address = address;
       this.intersection = intersection;
       this.latitude = latitude;
       this.locationType = locationType;
       this.longitude = longitude;
       this.postalCode = postalCode;
       this.systemName = systemName;
    }
   
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getIntersection() {
        return this.intersection;
    }
    
    public void setIntersection(String intersection) {
        this.intersection = intersection;
    }
    public Float getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
    public String getLocationType() {
        return this.locationType;
    }
    
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    public Float getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getSystemName() {
        return this.systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }




}

