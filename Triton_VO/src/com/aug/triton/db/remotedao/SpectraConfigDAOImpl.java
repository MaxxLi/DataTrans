/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraConfig;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraConfigDAOImpl extends DAO implements SpectraConfigDAO {

    @Override
    public SpectraConfig create(SpectraConfig spectraConfig) throws AppException {
        try {
            begin();
            getSession().save(spectraConfig);
            commit();
            return spectraConfig;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SpectraConfig> list) throws AppException {
        try {
            begin();
            for(SpectraConfig s: list)
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
    public SpectraConfig get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SpectraConfig s where s.id = :id");
            q.setShort("id", id);
            SpectraConfig spectraConfig = (SpectraConfig) q.uniqueResult();
            return spectraConfig;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SpectraConfig spectraConfig) throws AppException {
        try {
            begin();
            getSession().update(spectraConfig);
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
    public void delete(SpectraConfig spectraConfig) throws AppException {
        try {
            begin();
            getSession().delete(spectraConfig);
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
    public List<SpectraConfig> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SpectraConfig");
            List<SpectraConfig> list = q.list();			
            return list; 
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
              			"select max(id) from SpectraConfig");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraConfig> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraConfig s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<SpectraConfig> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
