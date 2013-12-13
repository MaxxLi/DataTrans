/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.Sensor;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SensorDAOImpl extends DAO implements SensorDAO {

    @Override
    public Sensor create(Sensor sensor) throws AppException {
        try {
            begin();
            getSession().save(sensor);
            commit();
            return sensor;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<Sensor> list) throws AppException {
        try {
            begin();
            for(Sensor s: list)
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
    public Sensor get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from Sensor s where s.id = :id ");
            q.setShort("id", id);
            
            Sensor sensor = (Sensor) q.uniqueResult();
            return sensor;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(Sensor sensor) throws AppException {
        try {
            begin();
            getSession().update(sensor);
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
    public void delete(Sensor sensor) throws AppException {
        try {
            begin();
            getSession().delete(sensor);
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
    public List<Sensor> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from Sensor");
            List<Sensor> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<Sensor> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from Sensor");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<Sensor> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }    

    public Sensor getSensorByName(String sensorName) throws AppException {
        try {
            Query q = getSession().createQuery("from Sensor s where s.name = :sensorName ");
            q.setString("sensorName", sensorName);
            Sensor s = (Sensor)q.uniqueResult();
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
              			"select max(id) from Sensor");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<Sensor> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from Sensor s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<Sensor> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
