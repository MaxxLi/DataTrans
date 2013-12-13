/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorBaseline;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorBaselineDAO {
    SensorBaseline create(SensorBaseline sensorBaseline) throws AppException;
    SensorBaseline get(Short id) throws AppException;
    void save(SensorBaseline sensorBaseline) throws AppException;
    void delete(SensorBaseline sensorBaseline) throws AppException;



    List<SensorBaseline> listAll() throws AppException;


    SensorBaseline getBaselineBySensorName(String sensorName) throws AppException;
    

    Short maxID() throws AppException;
    List<SensorBaseline> listByID(Short firstID, Short lastID ) throws AppException;
}
