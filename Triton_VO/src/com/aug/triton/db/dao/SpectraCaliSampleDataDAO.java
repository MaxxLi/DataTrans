/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraCaliSampleData;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraCaliSampleDataDAO {
    SpectraCaliSampleData create(SpectraCaliSampleData spectraCaliSampleData) throws AppException;
    SpectraCaliSampleData get(long id) throws AppException;
    void save(SpectraCaliSampleData spectraCaliSampleData) throws AppException;
    void delete(SpectraCaliSampleData SpectraCaliSampleData) throws AppException;



    List<SpectraCaliSampleData> listAll() throws AppException;   
    List<SpectraCaliSampleData> listSampleDataBySampleId(long sampleId) throws AppException;

    Long maxID() throws AppException;
    List<SpectraCaliSampleData> listByID(long firstID, long lastID ) throws AppException;
}
