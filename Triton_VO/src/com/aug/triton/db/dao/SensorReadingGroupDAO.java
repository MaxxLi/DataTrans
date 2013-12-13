/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorReadingGroup;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorReadingGroupDAO {
    SensorReadingGroup create(SensorReadingGroup sensorReadingGroup) throws AppException;
    SensorReadingGroup get(Long id) throws AppException;
    void save(SensorReadingGroup sensorReadingGroup) throws AppException;
    void delete(SensorReadingGroup sensorReadingGroup) throws AppException;



    List<SensorReadingGroup> listAll() throws AppException;


    SensorReadingGroup getLatestSensorReadingGroupByTime(Timestamp from) throws AppException;        

    Long maxID() throws AppException;
    List<SensorReadingGroup> listByID(Long firstID, Long lastID ) throws AppException;
}
