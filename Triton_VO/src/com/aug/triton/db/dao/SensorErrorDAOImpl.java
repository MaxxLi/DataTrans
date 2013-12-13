/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorError;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.sql.Timestamp;
/**
 *
 * @author AUG
 */
public class SensorErrorDAOImpl extends DAO implements SensorErrorDAO {
    
    @Override
    public SensorError create(SensorError sensorError) throws AppException {
        try {
            begin();
            getSession().save(sensorError);
            commit();
            return sensorError;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SensorError get(short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorError s where s.id = :id ");
            q.setShort("id", id);
            
            SensorError sensorError = (SensorError) q.uniqueResult();
            return sensorError;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SensorError sensorError) throws AppException {
        try {
            begin();
            getSession().update(sensorError);
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
    public void delete(SensorError sensorError) throws AppException {
        try {
            begin();
            getSession().delete(sensorError);
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
    public List<SensorError> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorError");
            List<SensorError> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<SensorError> list(int firstResult, int maxResults) throws AppException {
        try{






            Query q = getSession().createQuery("from SensorError");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<SensorError> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }    
    
    @Override
    public SensorError getBySensorIdAndTime(int id, Timestamp time) throws AppException {
        try{
            Query q = getSession().createQuery("from SensorError where sensor_id = :id and start_time = :time");
            q.setLong("id", id);
            q.setTimestamp("time", time);
            SensorError sensorError = (SensorError) q.uniqueResult();
            return sensorError;
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public Short maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SensorError");
        Short s = (short)0;
        if (q.uniqueResult() != null) {
            s = (Short) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorError> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorError s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SensorError> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
