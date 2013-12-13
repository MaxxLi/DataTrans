/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.TocReading;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface TocReadingDAO {
    TocReading create(TocReading tocReading) throws AppException;
    void bulkCreate(List<TocReading> list) throws AppException;
    TocReading get(Long id) throws AppException;
    void save(TocReading tocReading) throws AppException;
    void delete(TocReading tocReading) throws AppException;	

    List<TocReading> listAll() throws AppException;	
    List<TocReading> list(int firstResult, int maxResults) throws AppException;	    
    List<TocReading> getTocReadingByTime(Timestamp from, Timestamp to) throws AppException;  
    TocReading getLatestReading(Timestamp sampleTime) throws AppException;

    Long maxID() throws AppException;
    List<TocReading> listByID(Long firstID, Long lastID ) throws AppException;
}
