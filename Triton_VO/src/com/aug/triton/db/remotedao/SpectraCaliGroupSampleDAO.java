/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraCaliGroupSample;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraCaliGroupSampleDAO {
    SpectraCaliGroupSample create(SpectraCaliGroupSample spectraCaliGroupSample) throws AppException;
    void bulkCreate(List<SpectraCaliGroupSample> list) throws AppException;
    SpectraCaliGroupSample get(int id) throws AppException;
    void save(SpectraCaliGroupSample spectraCaliGroupSample) throws AppException;
    void delete(SpectraCaliGroupSample SpectraCaliGroupSample) throws AppException;	

    List<SpectraCaliGroupSample> listAll() throws AppException;  
    List<SpectraCaliGroupSample> listByGroupId(int groupId) throws AppException;

    int maxID() throws AppException;
    List<SpectraCaliGroupSample> listByID(int firstID, int lastID ) throws AppException;
}
