/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraDetection;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraDetectionDAOImpl extends DAO implements SpectraDetectionDAO{
    
    @Override
    public SpectraDetection create(SpectraDetection spectraDetection) throws AppException {
        try {
            begin();
            getSession().save(spectraDetection);
            commit();
            return spectraDetection;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SpectraDetection> list) throws AppException {
        try {
            begin();
            for(SpectraDetection s: list)
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
    public SpectraDetection get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SpectraDetection s where s.id = :id ");
            q.setLong("id", id);
            
            SpectraDetection spectraDetection = (SpectraDetection) q.uniqueResult();
            return spectraDetection;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SpectraDetection spectraDetection) throws AppException {
        try {
            begin();
            getSession().update(spectraDetection);
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
    public void delete(SpectraDetection spectraDetection) throws AppException {
        try {
            begin();
            getSession().delete(spectraDetection);
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
    public List<SpectraDetection> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SpectraDetection");
            List<SpectraDetection> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SpectraDetection getLatestSpectraDetection(Timestamp sampleTime) throws AppException {
        try {
            Query q = getSession().createQuery("from SpectraDetection s "
                    + "where s.sampleTime <= :sampleTime " 
                    + "and s.anomaly is not null order by sampleTime desc ");
            q.setTimestamp("sampleTime", sampleTime);
            List<SpectraDetection> list = q.list();
            if ((list != null) && (list.size()>0)) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }


    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SpectraDetection");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraDetection> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraDetection s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<SpectraDetection> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
