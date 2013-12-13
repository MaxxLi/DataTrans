/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorBaseline;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SensorBaselineDAOImpl extends DAO implements SensorBaselineDAO {
    @Override
    public SensorBaseline create(SensorBaseline sensorBaseline) throws AppException {
        try {
            begin();
            getSession().save(sensorBaseline);
            commit();
            return sensorBaseline;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SensorBaseline get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorBaseline s where s.id = :id");
            q.setShort("id", id);
            SensorBaseline sensorBaseline = (SensorBaseline) q.uniqueResult();
            return sensorBaseline;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SensorBaseline sensorBaseline) throws AppException {
        try {
            begin();
            getSession().update(sensorBaseline);
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
    public void delete(SensorBaseline sensorBaseline) throws AppException {
        try {
            begin();
            getSession().delete(sensorBaseline);
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
    public List<SensorBaseline> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorBaseline");
            List<SensorBaseline> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public SensorBaseline getBaselineBySensorName(String sensorName) throws AppException {
        try {
            Query q = getSession().createQuery("from SensorBaseline s where s.sensor.name = :sensorName ");
            q.setString("sensorName", sensorName);
            SensorBaseline s = (SensorBaseline)q.uniqueResult();
            return s;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public Short maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SensorBaseline");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorBaseline> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorBaseline s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SensorBaseline> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
