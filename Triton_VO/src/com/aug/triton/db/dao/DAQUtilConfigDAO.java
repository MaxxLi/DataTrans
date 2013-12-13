/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.DAQUtilConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface DAQUtilConfigDAO {
    DAQUtilConfig create(DAQUtilConfig daqUtilConfig) throws AppException;
    DAQUtilConfig get(int id) throws AppException;
    void save(DAQUtilConfig daqUtilConfig) throws AppException;
    void delete(DAQUtilConfig daqUtilConfig) throws AppException;



    List<DAQUtilConfig> listAll() throws AppException;


    List<DAQUtilConfig> list(int firstResult, int maxResults) throws AppException;


    DAQUtilConfig getUtilConfigByName(String name) throws AppException;

    int maxID() throws AppException;
    List<DAQUtilConfig> listByID(int firstID, int lastID ) throws AppException;
    
}
