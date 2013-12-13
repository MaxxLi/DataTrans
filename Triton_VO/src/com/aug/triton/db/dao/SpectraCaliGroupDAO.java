/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraCaliGroup;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraCaliGroupDAO {
    SpectraCaliGroup create(SpectraCaliGroup spectraCaliGroup) throws AppException;
    SpectraCaliGroup get(int id) throws AppException;
    void save(SpectraCaliGroup spectraCaliGroup) throws AppException;
    void delete(SpectraCaliGroup spectraCaliGroup) throws AppException;



    List<SpectraCaliGroup> listAll() throws AppException;



    int maxID() throws AppException;
    List<SpectraCaliGroup> listByID(int firstID, int lastID ) throws AppException;
}
