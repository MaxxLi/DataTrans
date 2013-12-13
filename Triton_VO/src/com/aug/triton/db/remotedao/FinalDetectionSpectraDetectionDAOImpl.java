/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.FinalDetectionSpectraDetection;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class FinalDetectionSpectraDetectionDAOImpl extends DAO implements FinalDetectionSpectraDetectionDAO {
    @Override
    public FinalDetectionSpectraDetection create(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException {
        try {
            begin();
            getSession().save(finalDetectionSpectraDetection);
            commit();
            return finalDetectionSpectraDetection;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }    
        finally{
            close();
        }    
    }
    
    @Override
    public void bulkCreate(List<FinalDetectionSpectraDetection> list) throws AppException {
        try {
            begin();
            for(FinalDetectionSpectraDetection s: list)
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
    public FinalDetectionSpectraDetection get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from FinalDetectionSpectraDetection f where f.id = :id");
            q.setLong("id", id);
            FinalDetectionSpectraDetection finalDetectionSpectraDetection = (FinalDetectionSpectraDetection) q.uniqueResult();
            return finalDetectionSpectraDetection;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void save(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException {
        try {
            begin();
            getSession().update(finalDetectionSpectraDetection);
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
    public void delete(FinalDetectionSpectraDetection finalDetectionSpectraDetection) throws AppException {
        try {
            begin();
            getSession().delete(finalDetectionSpectraDetection);
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
    public List<FinalDetectionSpectraDetection> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from FinalDetectionSpectraDetection");
            List<FinalDetectionSpectraDetection> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }	
    
    @Override
    public FinalDetectionSpectraDetection getLastBySampleTime(Timestamp sampleTime)throws AppException {
        try{			
            Query q = getSession().createQuery("from FinalDetectionSpectraDetection f " +
                    "where f.sampleTime <= :sampleTime order by sampleTime desc ");
            q.setTimestamp("sampleTime", sampleTime);
            q.setMaxResults(1);
            List<FinalDetectionSpectraDetection> list = q.list();
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
              			"select max(id) from FinalDetectionSpectraDetection");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<FinalDetectionSpectraDetection> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from FinalDetectionSpectraDetection s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<FinalDetectionSpectraDetection> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
