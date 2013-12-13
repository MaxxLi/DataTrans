/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.LabMeasurement;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface LabMeasurementDAO {
    LabMeasurement create(LabMeasurement labMeasurement) throws AppException;
    void bulkCreate(List<LabMeasurement> list) throws AppException;
    LabMeasurement get(Short id) throws AppException;
    void save(LabMeasurement labMeasurement) throws AppException;
    void delete(LabMeasurement labMeasurement) throws AppException;	

    List<LabMeasurement> listAll() throws AppException;	
    

    Short maxID() throws AppException;
    List<LabMeasurement> listByID(Short firstID, Short lastID ) throws AppException;
}
