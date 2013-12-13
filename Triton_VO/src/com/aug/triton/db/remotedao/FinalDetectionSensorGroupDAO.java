/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.FinalDetectionSensorGroup;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface FinalDetectionSensorGroupDAO {
    FinalDetectionSensorGroup create(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException;
    void bulkCreate(List<FinalDetectionSensorGroup> list) throws AppException;
    FinalDetectionSensorGroup get(Long id) throws AppException;
    void save(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException;
    void delete(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException;	

    List<FinalDetectionSensorGroup> listAll() throws AppException;	
    FinalDetectionSensorGroup getLastBySampleTime(Timestamp sampleTime)throws AppException;


    Long maxID() throws AppException;
    List<FinalDetectionSensorGroup> listByID(Long firstID, Long lastID ) throws AppException;
}
