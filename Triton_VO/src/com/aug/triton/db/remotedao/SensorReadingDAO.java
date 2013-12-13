/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SensorReading;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorReadingDAO {
    SensorReading create(SensorReading sensorReading) throws AppException;
    void bulkCreate(List<SensorReading> list) throws AppException;
    SensorReading get(Long id) throws AppException;
    void save(SensorReading sensorReading) throws AppException;
    void delete(SensorReading sensorReading) throws AppException;

    List<SensorReading> listAll() throws AppException;	
    List<SensorReading> list(int firstResult, int maxResults) throws AppException;	    
    List<SensorReading> getSensorReadingByNameAndTime(String sensorName, Timestamp from, Timestamp to) throws AppException;    

    Long maxID() throws AppException;
    List<SensorReading> listByID(Long firstID, Long lastID ) throws AppException;
}
