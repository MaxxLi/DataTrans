/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.StripChart;
import com.aug.triton.db.exception.AppException;
import java.util.List;

/**
 *
 * @author AUG
 */
public interface StripChartDAO {
    StripChart create(StripChart stripChart) throws AppException;
    StripChart get(Long id) throws AppException;
    void save(StripChart stripChart) throws AppException;
    void delete(StripChart stripChart) throws AppException;



    List<StripChart> listAll() throws AppException;



    Long maxID() throws AppException;
    List<StripChart> listByID(Long firstID, Long lastID ) throws AppException;
}
