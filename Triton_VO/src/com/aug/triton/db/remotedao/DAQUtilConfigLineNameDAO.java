/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.DAQUtilConfigLineName;
import com.aug.triton.db.exception.AppException;
import java.util.List;
/**
 *
 * @author AUG
 */
public interface DAQUtilConfigLineNameDAO {
    DAQUtilConfigLineName create(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException;
    void bulkCreate(List<DAQUtilConfigLineName> list) throws AppException;
    DAQUtilConfigLineName get(int id) throws AppException;
    void save(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException;
    void delete(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException;	

    List<DAQUtilConfigLineName> listAll() throws AppException;	
    List<DAQUtilConfigLineName> list(int firstResult, int maxResults) throws AppException;	
    List<DAQUtilConfigLineName> getUtilConfigLineNamesByUtilName(String utilName) throws AppException;
    DAQUtilConfigLineName getUtilConfigLineNameByUtilNameAndLineName(String utilName, String lineName) throws AppException;

    int maxID() throws AppException;
    List<DAQUtilConfigLineName> listByID(int firstID, int lastID ) throws AppException;
}
