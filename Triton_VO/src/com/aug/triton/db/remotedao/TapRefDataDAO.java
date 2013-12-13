/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.TapRefData;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface TapRefDataDAO {
    TapRefData create(TapRefData tapRefData) throws AppException;
    void bulkCreate(List<TapRefData> list) throws AppException;
    TapRefData get(Long id) throws AppException;
    void save(TapRefData tapRefData) throws AppException;
    void delete(TapRefData tapRefData) throws AppException;	

    List<TapRefData> listAll() throws AppException;	    
    List<TapRefData> listDataByTapRefId(int tapRefId) throws AppException;

    Long maxID() throws AppException;
    List<TapRefData> listByID(Long firstID, Long lastID ) throws AppException;
}
