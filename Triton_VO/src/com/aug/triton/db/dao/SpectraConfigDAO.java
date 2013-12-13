/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraConfigDAO {
    SpectraConfig create(SpectraConfig spectraConfig) throws AppException;
    SpectraConfig get(Short id) throws AppException;
    void save(SpectraConfig spectraConfig) throws AppException;
    void delete(SpectraConfig spectraConfig) throws AppException;



    List<SpectraConfig> listAll() throws AppException;


    

    Short maxID() throws AppException;
    List<SpectraConfig> listByID(Short firstID, Short lastID ) throws AppException;
}
