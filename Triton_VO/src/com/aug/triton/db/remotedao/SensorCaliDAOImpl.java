/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SensorCali;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
/**
 *
 * @author AUG
 */
public class SensorCaliDAOImpl extends DAO implements SensorCaliDAO {
    
    @Override
    public SensorCali create(SensorCali sensorCali) throws AppException{
        try {
            begin();
            getSession().save(sensorCali);
            commit();
            getSession().flush();
            getSession().clear();
            return sensorCali;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SensorCali> list) throws AppException {
        try {
            begin();
            for(SensorCali s: list)
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
    public SensorCali get(short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorCali s where s.id = :id ");
            q.setShort("id", id);
            
            SensorCali sensorCali = (SensorCali) q.uniqueResult();
            return sensorCali;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public SensorCali get(String type) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SensorCali s where s.sensor.name = :type ");
            q.setString("type", type);
            
            SensorCali sensorCali = (SensorCali) q.uniqueResult();
            return sensorCali;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SensorCali sensorCali) throws AppException {
        try {
            begin();
            getSession().update(sensorCali);
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
    public void delete(SensorCali sensorCali) throws AppException {
        try {
            begin();
            getSession().delete(sensorCali);
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
    public List<SensorCali> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SensorCali order by id asc");
            List<SensorCali> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
    }

    @Override
    public List<SensorCali> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from SensorCali");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<SensorCali> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public Short maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SensorCali");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SensorCali> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SensorCali s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SensorCali> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
