/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorBaselineSquare;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorBaselineSquareDAO {
    SensorBaselineSquare create(SensorBaselineSquare sensorBaselineSquare) throws AppException;
    SensorBaselineSquare get(Short id) throws AppException;
    void save(SensorBaselineSquare sensorBaselineSquare) throws AppException;
    void delete(SensorBaselineSquare sensorBaselineSquare) throws AppException;



    List<SensorBaselineSquare> listAll() throws AppException;


    SensorBaselineSquare getBaselineSquareBySensorName(String rowSensorName, String columnSensorName) throws AppException;

    Short maxID() throws AppException;
    List<SensorBaselineSquare> listByID(Short firstID, Short lastID ) throws AppException;
}
