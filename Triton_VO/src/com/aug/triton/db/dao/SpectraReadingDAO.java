/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraReading;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraReadingDAO {
    SpectraReading create(SpectraReading spectraReading) throws AppException;
    SpectraReading get(Long id) throws AppException;
    void save(SpectraReading spectraReading) throws AppException;
    void delete(SpectraReading spectraReading) throws AppException;



    List<SpectraReading> listAll() throws AppException;

    

    Long maxID() throws AppException;
    List<SpectraReading> listByID(Long firstID, Long lastID ) throws AppException;
}
