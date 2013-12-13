/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.TapRef;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface TapRefDAO {
    TapRef create(TapRef tapRef) throws AppException;
    void bulkCreate(List<TapRef> list) throws AppException;
    TapRef get(int id) throws AppException;
    void save(TapRef tapRef) throws AppException;
    void delete(TapRef tapRef) throws AppException;	

    List<TapRef> listAll() throws AppException;	 
    TapRef getLatestTapRef(Timestamp sampleTime) throws AppException;

    int maxID() throws AppException;
    List<TapRef> listByID(int firstID, int lastID ) throws AppException;
}
