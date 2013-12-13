/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SensorReadingGroup;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SensorReadingGroupDAOImpl extends DAO implements SensorReadingGroupDAO{
    @Override
    public SensorReadingGroup create(SensorReadingGroup sensorReadingGroup) throws AppException {
        try {
            begin();
            getSession().save(sensorReadingGroup);
            commit();
            return sensorReadingGroup;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SensorReadingGroup> list) throws AppException {
        try {
            begin();
            for(SensorReadingGroup   s: list)
            {
                getSession().save(s);
            }
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
    public SensorReadingGroup get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorReadingGroup s where s.id = :id ");
            q.setLong("id", id);
            
            SensorReadingGroup sensorReading = (SensorReadingGroup) q.uniqueResult();
            return sensorReading;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SensorReadingGroup sensorReadingGroup) throws AppException {
        try {
            begin();
            getSession().update(sensorReadingGroup);
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
    public void delete(SensorReadingGroup sensorReadingGroup) throws AppException {
        try {
            begin();
            getSession().delete(sensorReadingGroup);
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
    public List<SensorReadingGroup> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorReadingGroup");
            List<SensorReadingGroup> list = q.list();
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    public SensorReadingGroup getLatestSensorReadingGroupByTime(Timestamp sampleTime) throws AppException {      
        try {
            Query q = getSession().createQuery("from SensorReadingGroup s "
                    + "where s.sampleTime <= :sampleTime order by id desc");
            q.setTimestamp("sampleTime", sampleTime);            
            q.setMaxResults(1);
            SensorReadingGroup sensorReadingGroup = (SensorReadingGroup)q.uniqueResult();
            return sensorReadingGroup;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SensorReadingGroup");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorReadingGroup> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorReadingGroup s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<SensorReadingGroup> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
