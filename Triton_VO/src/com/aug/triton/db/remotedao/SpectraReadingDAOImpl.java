/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraReading;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraReadingDAOImpl extends DAO implements SpectraReadingDAO{
    @Override
    public SpectraReading create(SpectraReading spectraReading) throws AppException {
        try {
            begin();
            getSession().save(spectraReading);
            commit();
            return spectraReading;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SpectraReading> list) throws AppException {
        try {
            begin();
            for(SpectraReading s: list)
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
    public SpectraReading get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SpectraReading s where s.id = :id ");
            q.setLong("id", id);
            
            SpectraReading spectraReading = (SpectraReading) q.uniqueResult();
            return spectraReading;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SpectraReading spectraReading) throws AppException {
        try {
            begin();
            getSession().update(spectraReading);
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
    public void delete(SpectraReading spectraReading) throws AppException {
        try {
            begin();
            getSession().delete(spectraReading);
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
    public List<SpectraReading> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SpectraReading");
            List<SpectraReading> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SpectraReading");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraReading> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraReading s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<SpectraReading> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
