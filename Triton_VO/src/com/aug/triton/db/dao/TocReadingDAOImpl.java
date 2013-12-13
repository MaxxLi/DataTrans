/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.TocReading;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class TocReadingDAOImpl extends DAO implements TocReadingDAO {

    @Override
    public TocReading create(TocReading tocReading) throws AppException {
        try {
            begin();
            getSession().save(tocReading);
            commit();
            getSession().flush();
            getSession().clear();
            return tocReading;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public TocReading get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from TocReading s where s.id = :id ");
            q.setLong("id", id);
            
            TocReading tocReading = (TocReading) q.uniqueResult();
            return tocReading;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(TocReading tocReading) throws AppException {
        try {
            begin();
            getSession().update(tocReading);
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
    public void delete(TocReading tocReading) throws AppException {
        try {
            begin();
            getSession().delete(tocReading);
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
    public List<TocReading> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from TocReading");
            List<TocReading> list = q.list();
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<TocReading> list(int firstResult, int maxResults) throws AppException {
        try{






            Query q = getSession().createQuery("from TocReading");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<TocReading> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }        
    
    public TocReading getLatestReading(Timestamp sampleTime) throws AppException {
        try {
            Query q = getSession().createQuery("from TocReading t "
                    + "where t.sampleTime <= :sampleTime order by id desc");
            q.setTimestamp("sampleTime", sampleTime);            
            q.setMaxResults(1);
            TocReading tocReading = (TocReading)q.uniqueResult();
            return tocReading;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<TocReading> getTocReadingByTime(Timestamp from, Timestamp to) throws AppException {
        try {
            Query q = getSession().createQuery( "from TocReading t " +
                    "where t.sampleTime>=:from and t.sampleTime<=:to");
            q.setTimestamp("from", from);
            q.setTimestamp("to", to);
            List<TocReading> list = q.list();
            return list;
        } catch (HibernateException he) {
            throw he;
        }
    }
   
    

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from TocReading");
        Long s = (long) 0;
        if (q.uniqueResult() != null) {
            s = (Long) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<TocReading> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from TocReading s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<TocReading> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
