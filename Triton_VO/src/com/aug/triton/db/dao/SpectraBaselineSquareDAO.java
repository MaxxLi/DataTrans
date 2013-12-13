/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraBaselineSquare;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraBaselineSquareDAO {
    SpectraBaselineSquare create(SpectraBaselineSquare spectraBaselineSquare) throws AppException;
    SpectraBaselineSquare get(int id) throws AppException;
    void save(SpectraBaselineSquare spectraBaselineSquare) throws AppException;
    void delete(SpectraBaselineSquare spectraBaselineSquare) throws AppException;



    List<SpectraBaselineSquare> listAll() throws AppException;


    

    int maxID() throws AppException;
    List<SpectraBaselineSquare> listByID(int firstID, int lastID ) throws AppException;
}
