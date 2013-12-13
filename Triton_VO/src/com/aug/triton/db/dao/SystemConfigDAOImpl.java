/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SystemConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SystemConfigDAOImpl extends DAO implements SystemConfigDAO {

    @Override
    public SystemConfig create(SystemConfig systemConfig) throws AppException {
        try {
            begin();
            getSession().save(systemConfig);
            commit();
            return systemConfig;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SystemConfig get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SystemConfig s where s.id = :id");
            q.setShort("id", id);
            SystemConfig systemConfig = (SystemConfig) q.uniqueResult();
            return systemConfig;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SystemConfig systemConfig) throws AppException {
        try {
            begin();
            getSession().update(systemConfig);
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
            throw new AppException(e.getCause().getMessage());
        }
    }

    @Override
    public void delete(SystemConfig systemConfig) throws AppException {
        try {
            begin();
            getSession().delete(systemConfig);
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
    public List<SystemConfig> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SystemConfig");
            List<SystemConfig> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public SystemConfig getSystemConfigByParameterName(String parameterName) throws AppException {
        try {
            Query q = getSession().createQuery(
                    "from SystemConfig s where lower(s.parameterName) = lower(:parameterName)");
            q.setString("parameterName", parameterName);
            SystemConfig systemConfig = (SystemConfig) q.uniqueResult();
            if (systemConfig == null){
            }
            return systemConfig;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    public List<SystemConfig> getListSystemConfigByParameterName(String parameterName) throws AppException {
        try {
            Query q = getSession().createQuery(
                    "from SystemConfig s where s.parameterName = :parameterName");
            q.setString("parameterName", parameterName);
            List<SystemConfig> list = q.list();
            return list;
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
              			"select max(id) from SystemConfig");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SystemConfig> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SystemConfig s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SystemConfig> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
