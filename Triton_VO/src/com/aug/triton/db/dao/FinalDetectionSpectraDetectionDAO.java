/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.FinalDetectionSpectraDetection;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface FinalDetectionSpectraDetectionDAO {
    FinalDetectionSpectraDetection create(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException;
    FinalDetectionSpectraDetection get(Long id) throws AppException;
    void save(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException;
    void delete(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException;



    List<FinalDetectionSpectraDetection> listAll() throws AppException;


    FinalDetectionSpectraDetection getLastBySampleTime(Timestamp sampleTime)throws AppException;    

    Long maxID() throws AppException;
    List<FinalDetectionSpectraDetection> listByID(Long firstID, Long lastID ) throws AppException;
}
