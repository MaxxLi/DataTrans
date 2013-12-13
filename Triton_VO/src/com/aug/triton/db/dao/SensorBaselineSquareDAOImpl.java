/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SensorBaselineSquare;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SensorBaselineSquareDAOImpl extends DAO implements SensorBaselineSquareDAO {
    @Override
    public SensorBaselineSquare create(SensorBaselineSquare sensorBaselineSquare) throws AppException {
        try {
            begin();
            getSession().save(sensorBaselineSquare);
            commit();
            return sensorBaselineSquare;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SensorBaselineSquare get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorBaselineSquare s where s.id = :id");
            q.setShort("id", id);
            SensorBaselineSquare sensorBaselineSquare = (SensorBaselineSquare) q.uniqueResult();
            return sensorBaselineSquare;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SensorBaselineSquare sensorBaselineSquare) throws AppException {
        try {
            begin();
            getSession().update(sensorBaselineSquare);
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
    public void delete(SensorBaselineSquare sensorBaselineSquare) throws AppException {
        try {
            begin();
            getSession().delete(sensorBaselineSquare);
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
    public List<SensorBaselineSquare> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorBaselineSquare");
            List<SensorBaselineSquare> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
    }
    
    @Override
    public SensorBaselineSquare getBaselineSquareBySensorName(String rowSensorName, String columnSensorName) throws AppException {
        try {
            Query q = getSession().createQuery("from SensorBaselineSquare s where s.rowSensor.name = :rowSensorName " +
                    " and s.columnSensor.name = :columnSensorName");
            q.setString("rowSensorName", rowSensorName);
            q.setString("columnSensorName", columnSensorName);
            SensorBaselineSquare s = (SensorBaselineSquare)q.uniqueResult();
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
              			"select max(id) from SensorBaselineSquare");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorBaselineSquare> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorBaselineSquare s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SensorBaselineSquare> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
