/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorReading;
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
public class SensorReadingDAOImpl extends DAO implements SensorReadingDAO {

    @Override
    public SensorReading create(SensorReading sensorReading) throws AppException {
        try {
            begin();
            getSession().save(sensorReading);
            commit();
            getSession().flush();
            getSession().clear();
            return sensorReading;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SensorReading get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorReading s where s.id = :id ");
            q.setLong("id", id);
            
            SensorReading sensorReading = (SensorReading) q.uniqueResult();
            return sensorReading;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    

    
    
    @Override
    public void save(SensorReading sensorReading) throws AppException {
        try {
            begin();
            getSession().update(sensorReading);
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public void delete(SensorReading sensorReading) throws AppException {
        try {
            begin();
            getSession().delete(sensorReading);
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
    public List<SensorReading> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorReading");
            List<SensorReading> list = q.list();
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<SensorReading> list(int firstResult, int maxResults) throws AppException {
        try{






            Query q = getSession().createQuery("from SensorReading");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<SensorReading> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }    
    

    
    public SensorReading getLatestReadingByName(String sensorName, Timestamp sampleTime) throws AppException {
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        SensorReadingGroup sensorReadingGroup = null;
        try {
            sensorReadingGroup = groupDao.getLatestSensorReadingGroupByTime(sampleTime);
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        if (sensorReadingGroup == null) {
            return null;
        }
        groupDao = null;
        try {
            Query q = getSession().createQuery("from SensorReading s "
                    + "where s.sensorReadingGroup = :sensorReadingGroup "
                    + " and s.sensor.name = :sensorName");
            q.setEntity("sensorReadingGroup", sensorReadingGroup);
            q.setString("sensorName", sensorName);
            SensorReading reading = (SensorReading)q.uniqueResult();
            sensorReadingGroup = null;
            return reading;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    public List<SensorReading> getLatestReading(Timestamp sampleTime) throws AppException {
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        SensorReadingGroup sensorReadingGroup = null;
        try {
            sensorReadingGroup = groupDao.getLatestSensorReadingGroupByTime(sampleTime);
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        if (sensorReadingGroup == null) {
            return null;
        }
        try {
            Query q = getSession().createQuery("from SensorReading s "
                    + "where s.sensorReadingGroup = :sensorReadingGroup ");
            q.setEntity("sensorReadingGroup", sensorReadingGroup);
            List<SensorReading> list = q.list();
            return list;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
 
    @Override
    public List<SensorReading> getSensorReadingByNameAndTime(String sensorName, Timestamp from, Timestamp to) throws AppException {
        try {
            Query q = getSession().createQuery( "from SensorReading s " +
                    "where s.sensor.name = :sensorName and " +
                    "s.sensorReadingGroup.sampleTime>=:from and s.sensorReadingGroup.sampleTime<=:to");
            q.setString("sensorName", sensorName);
            q.setTimestamp("from", from);
            q.setTimestamp("to", to);
            List<SensorReading> list = q.list();
            return list;
        } catch (HibernateException he) {
            throw he;
        }
    }
   
    public double getAggregateSensorReadingByNameAndTime(String sensorName, Timestamp from, Timestamp to, String aggregate) throws AppException {
        try{
            Query q = getSession().createQuery("select " + aggregate + "(reading) from SensorReading s " + 
                    "where s.sensor.name = :sensorName and " +
                    "s.sensorReadingGroup.sampleTime >=:from and s.sensorReadingGroup.sampleTime<=:to");
            q.setString("sensorName", sensorName);
            q.setTimestamp("from", from);
            q.setTimestamp("to", to);
            if (q.uniqueResult() != null){
                Double rtn = (Double) q.uniqueResult();
                return rtn;
            }
            else
                return Integer.MIN_VALUE;
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
        
    }

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SensorReading");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorReading> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorReading s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<SensorReading> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
