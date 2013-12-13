/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SystemConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SystemConfigDAO {
    SystemConfig create(SystemConfig systemConfig) throws AppException;
    void bulkCreate(List<SystemConfig> list) throws AppException;
    SystemConfig get(Short id) throws AppException;
    void save(SystemConfig systemConfig) throws AppException;
    void delete(SystemConfig systemConfig) throws AppException;	

    List<SystemConfig> listAll() throws AppException;	
    SystemConfig getSystemConfigByParameterName(String parameterName) throws AppException;

    Short maxID() throws AppException;
    List<SystemConfig> listByID(Short firstID, Short lastID ) throws AppException;
}
