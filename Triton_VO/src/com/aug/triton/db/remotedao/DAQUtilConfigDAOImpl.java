/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.DAQUtilConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class DAQUtilConfigDAOImpl extends DAO implements DAQUtilConfigDAO {

    @Override
    public DAQUtilConfig create(DAQUtilConfig daqUtilConfig) throws AppException {
        try {
            begin();
            getSession().save(daqUtilConfig);
            commit();
            return daqUtilConfig;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<DAQUtilConfig> list) throws AppException {
        try {
            begin();
            for(DAQUtilConfig s: list)
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
    public DAQUtilConfig get(int id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from DAQUtilConfig u where u.id = :id");
            q.setInteger("id", id);
            DAQUtilConfig daqUtilConfig = (DAQUtilConfig) q.uniqueResult();
            return daqUtilConfig;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(DAQUtilConfig daqUtilConfig) throws AppException {
        try {
            begin();
            getSession().update(daqUtilConfig);
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
    public void delete(DAQUtilConfig daqUtilConfig) throws AppException {
        try {
            begin();
            getSession().delete(daqUtilConfig);
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
    public List<DAQUtilConfig> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from DAQUtilConfig");
            List<DAQUtilConfig> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<DAQUtilConfig> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from DAQUtilConfig");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<DAQUtilConfig> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public DAQUtilConfig getUtilConfigByName(String name) throws AppException {
        try {
            Query q = getSession().createQuery("from DAQUtilConfig u where u.utilName = :utilName");
            q.setString("utilName", name);
            DAQUtilConfig daqUtilConfig = (DAQUtilConfig) q.uniqueResult();
            return daqUtilConfig;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }        
    }

    @Override
    public int maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from DAQUtilConfig");
                int s = 0;
        if (q.uniqueResult()!= null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<DAQUtilConfig> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from DAQUtilConfig s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<DAQUtilConfig> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
