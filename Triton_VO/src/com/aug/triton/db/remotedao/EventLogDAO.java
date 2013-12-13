/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.EventLog;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface EventLogDAO {
    EventLog create(EventLog eventLog) throws AppException;
    void bulkCreate(List<EventLog> list) throws AppException;
    EventLog get(Long id) throws AppException;
    void save(EventLog eventLog) throws AppException;
    void delete(EventLog eventLog) throws AppException;	

    List<EventLog> listAll() throws AppException;	
    

    Long maxID() throws AppException;
    List<EventLog> listByID(Long firstID, Long lastID ) throws AppException;
}
