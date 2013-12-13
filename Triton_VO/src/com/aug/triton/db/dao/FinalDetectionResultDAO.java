/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.FinalDetectionResult;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface FinalDetectionResultDAO {
    FinalDetectionResult create(FinalDetectionResult finalDetectionResult) throws AppException;
    FinalDetectionResult get(Long id) throws AppException;
    void save(FinalDetectionResult finalDetectionResult) throws AppException;
    void delete(FinalDetectionResult finalDetectionResult) throws AppException;



    List<FinalDetectionResult> listAll() throws AppException;


    List<FinalDetectionResult> listBySampletime(Timestamp start, Timestamp end)throws AppException;
    FinalDetectionResult getLastBySampleTime(Timestamp sampleTime)throws AppException;


    Long maxID() throws AppException;
    List<FinalDetectionResult> listByID(Long firstID, Long lastID ) throws AppException;
}
