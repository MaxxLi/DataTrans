/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.FinalDetectionResult;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class FinalDetectionResultDAOImpl extends DAO implements FinalDetectionResultDAO {

    @Override
    public FinalDetectionResult create(FinalDetectionResult finalDetectionResult) throws AppException {
        try {
            begin();
            getSession().save(finalDetectionResult);
            commit();
            return finalDetectionResult;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public FinalDetectionResult get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from FinalDetectionResult f where f.id = :id");
            q.setLong("id", id);
            FinalDetectionResult finalDetectionResult = (FinalDetectionResult) q.uniqueResult();
            return finalDetectionResult;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(FinalDetectionResult finalDetectionResult) throws AppException {
        try {
            begin();
            getSession().update(finalDetectionResult);
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
    public void delete(FinalDetectionResult finalDetectionResult) throws AppException {
        try {
            begin();
            getSession().delete(finalDetectionResult);
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
    public List<FinalDetectionResult> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from FinalDetectionResult");
            List<FinalDetectionResult> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<FinalDetectionResult> listBySampletime(Timestamp start, Timestamp end) throws AppException {
        try{






            Query q = getSession().createQuery("from FinalDetectionResult  f where f.sampleTime >= :start and f.sampleTime <= :end");
            q.setTimestamp("start", start);
            q.setTimestamp("end", end);
            List<FinalDetectionResult> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public FinalDetectionResult getLastBySampleTime(Timestamp sampleTime) throws AppException{
        try{






            Query q = getSession().createQuery("from FinalDetectionResult f where f.sampleTime <= :sampleTime order by sampleTime desc ");
            q.setTimestamp("sampleTime", sampleTime);
            q.setMaxResults(1);
            List<FinalDetectionResult> list = q.list();
            q = null;
            if ((list != null) && (list.size() > 0)) {
                return list.get(0);
            } else {
                return null; 
            }
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from FinalDetectionResult");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<FinalDetectionResult> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from FinalDetectionResult s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<FinalDetectionResult> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
