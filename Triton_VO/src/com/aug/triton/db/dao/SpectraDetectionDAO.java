/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraDetection;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraDetectionDAO {
    SpectraDetection create(SpectraDetection spectraDetection) throws AppException;
    SpectraDetection get(Long id) throws AppException;
    void save(SpectraDetection spectraDetection) throws AppException;
    void delete(SpectraDetection spectraDetection) throws AppException;



    List<SpectraDetection> listAll() throws AppException;


    SpectraDetection getLatestSpectraDetection(Timestamp sampleTime) throws AppException;

    Long maxID() throws AppException;
    List<SpectraDetection> listByID(Long firstID, Long lastID ) throws AppException;
}
