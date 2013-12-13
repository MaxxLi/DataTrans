/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.Sensor;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SensorDAO {
    Sensor create(Sensor sensor) throws AppException;
    Sensor get(Short id) throws AppException;
    void save(Sensor sensor) throws AppException;
    void delete(Sensor sensor) throws AppException;



    List<Sensor> listAll() throws AppException;


    List<Sensor> list(int firstResult, int maxResults) throws AppException;
    

    Short maxID() throws AppException;
    List<Sensor> listByID(Short firstID, Short lastID ) throws AppException;
}
