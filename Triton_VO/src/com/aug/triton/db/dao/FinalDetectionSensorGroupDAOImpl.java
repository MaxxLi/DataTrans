/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.FinalDetectionSensorGroup;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class FinalDetectionSensorGroupDAOImpl extends DAO implements FinalDetectionSensorGroupDAO {
    @Override
    public FinalDetectionSensorGroup create(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException {
        try {
            begin();
            getSession().save(finalDetectionSensorGroup);
            commit();
            return finalDetectionSensorGroup;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }        
    }
    
    @Override
    public FinalDetectionSensorGroup get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from FinalDetectionSensorGroup f where f.id = :id");
            q.setLong("id", id);
            FinalDetectionSensorGroup finalDetectionSensorGroup = (FinalDetectionSensorGroup) q.uniqueResult();
            return finalDetectionSensorGroup;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void save(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException {
        try {
            begin();
            getSession().update(finalDetectionSensorGroup);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void delete(FinalDetectionSensorGroup finalDetectionSensorGroup) throws AppException {
        try {
            begin();
            getSession().delete(finalDetectionSensorGroup);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<FinalDetectionSensorGroup> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from FinalDetectionSensorGroup");
            List<FinalDetectionSensorGroup> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }


    
    @Override
    public FinalDetectionSensorGroup getLastBySampleTime(Timestamp sampleTime)throws AppException {
        try{






            Query q = getSession().createQuery("from FinalDetectionSensorGroup f " +
                    "where f.sampleTime <= :sampleTime order by sampleTime desc ");
            q.setTimestamp("sampleTime", sampleTime);
            q.setMaxResults(1);
            List<FinalDetectionSensorGroup> list = q.list();
            if ((list != null) && (list.size() > 0)) {
                return list.get(0);
            } else {
                return null; 
            }
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from FinalDetectionSensorGroup");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<FinalDetectionSensorGroup> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from FinalDetectionSensorGroup s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<FinalDetectionSensorGroup> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
