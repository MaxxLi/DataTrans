/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SensorError;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import java.sql.Timestamp;
/**
 *
 * @author AUG
 */
public interface SensorErrorDAO {
    
    SensorError create(SensorError sensorError) throws AppException;
    void bulkCreate(List<SensorError> list) throws AppException;
    SensorError get(short id) throws AppException;
    void save(SensorError sensorError) throws AppException;
    void delete(SensorError sensorError) throws AppException;	

    List<SensorError> listAll() throws AppException;	
    List<SensorError> list(int firstResult, int maxResults) throws AppException;
    
    SensorError getBySensorIdAndTime(int id, Timestamp time) throws AppException;

    Short maxID() throws AppException;
    List<SensorError> listByID(Short firstID, Short lastID ) throws AppException;
}
