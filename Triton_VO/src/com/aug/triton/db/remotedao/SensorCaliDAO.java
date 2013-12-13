/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SensorCali;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorCaliDAO {
    SensorCali create(SensorCali sensorCali) throws AppException;
    void bulkCreate(List<SensorCali> list) throws AppException;
    SensorCali get(short id) throws AppException;
    SensorCali get(String id) throws AppException;
    void save(SensorCali sensor) throws AppException;
    void delete(SensorCali sensor) throws AppException;	

    List<SensorCali> listAll() throws AppException;	
    List<SensorCali> list(int firstResult, int maxResults) throws AppException;

    Short maxID() throws AppException;
    List<SensorCali> listByID(Short firstID, Short lastID ) throws AppException;
}
