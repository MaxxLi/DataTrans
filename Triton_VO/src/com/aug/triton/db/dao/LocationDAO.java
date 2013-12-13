/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

/**
 *
 * @author AUG
 */
import java.util.List;


import com.aug.triton.db.remoteentity.Location;
import com.aug.triton.db.exception.AppException;

public interface LocationDAO {


    Location create(Location loc) throws AppException;


    Location get(Short id) throws AppException;


    void save(Location loc) throws AppException;


    void delete(Location loc) throws AppException;







    List<Location> listAll() throws AppException;




    List<Location> list(int firstResult, int maxResults) throws AppException;

    Short maxID() throws AppException;
    List<Location> listByID(Short firstID, Short lastID ) throws AppException;

}


