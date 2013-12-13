/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraBaseline;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface SpectraBaselineDAO {
    SpectraBaseline create(SpectraBaseline spectraBaseline) throws AppException;
    void bulkCreate(List<SpectraBaseline> list) throws AppException;
    SpectraBaseline get(int id) throws AppException;
    void save(SpectraBaseline spectraBaseline) throws AppException;
    void delete(SpectraBaseline spectraBaseline) throws AppException;	

    List<SpectraBaseline> listAll() throws AppException;	    

    int maxID() throws AppException;
    List<SpectraBaseline> listByID(int firstID, int lastID ) throws AppException;
}
