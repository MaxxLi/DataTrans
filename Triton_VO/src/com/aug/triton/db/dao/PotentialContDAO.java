/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.PotentialCont;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface PotentialContDAO {
    PotentialCont create(PotentialCont finalDetectionResultpotentialCont) throws AppException;
    PotentialCont get(Long id) throws AppException;
    void save(PotentialCont potentialCont) throws AppException;
    void delete(PotentialCont potentialCont) throws AppException;



    List<PotentialCont> listAll() throws AppException;


    List<PotentialCont> getLastContaminantListBySampletime(Timestamp sampleTime)throws AppException;
    

    Long maxID() throws AppException;
    List<PotentialCont> listByID(Long firstID, Long lastID ) throws AppException;
}
