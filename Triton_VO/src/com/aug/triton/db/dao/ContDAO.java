/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.Cont;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface ContDAO {
    Cont create(Cont cont) throws AppException;
    Cont get(Short id) throws AppException;
    void save(Cont cont) throws AppException;
    void delete(Cont cont) throws AppException;



    List<Cont> listAll() throws AppException;


    List<Cont> list(int firstResult, int maxResults) throws AppException;


    Cont getContByName(String name) throws AppException;

    Short maxID() throws AppException;
    List<Cont> listByID(Short firstID, Short lastID ) throws AppException;
}
