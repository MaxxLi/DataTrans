/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.PotentialCont;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class PotentialContDAOImpl extends DAO implements PotentialContDAO {
    @Override
    public PotentialCont create(PotentialCont potentialCont) throws AppException {
        try {
            begin();
            getSession().save(potentialCont);
            commit();
            return potentialCont;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<PotentialCont> list) throws AppException {
        try {
            begin();
            for(PotentialCont s: list)
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
    public PotentialCont get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from PotentialCont p where p.id = :id");
            q.setLong("id", id);
            PotentialCont potentialCont = (PotentialCont) q.uniqueResult();
            return potentialCont;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(PotentialCont potentialCont) throws AppException {
        try {
            begin();
            getSession().update(potentialCont);
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
    public void delete(PotentialCont potentialCont) throws AppException {
        try {
            begin();
            getSession().delete(potentialCont);
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
    public List<PotentialCont> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from PotentialCont");
            List<PotentialCont> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
//    @Override
//    public List<FinalDetectionResult> listBySampletime(Timestamp start, Timestamp end) throws AppException {
//        try{			
//            Query q = getSession().createQuery("from FinalDetectionResult  f where f.sampleTime >= :start and f.sampleTime <= :end");
//            q.setTimestamp("start", start);
//            q.setTimestamp("end", end);
//            List<FinalDetectionResult> list = q.list();
//            return list; 
//        } catch(HibernateException e){
//            throw new AppException(e.getCause().getMessage());
//        }
//    }
    
    @Override
    public List<PotentialCont> getLastContaminantListBySampletime(Timestamp sampleTime) throws AppException{
        try{	
            Query q = getSession().createQuery("from PotentialCont p " + 
                    "where p.spectraDetection.sampleTime <= :sampleTime " +
                    "order by p.id desc ");
            q.setTimestamp("sampleTime", sampleTime);
            q.setMaxResults(1);
            List<PotentialCont> result = q.list();

            if ((result!=null) && (result.size() > 0)) {
                Long detectionId = ((PotentialCont)q.list().get(0)).getSpectraDetection().getId();
                q = getSession().createQuery("from PotentialCont p " + 
                        "where p.spectraDetection.id = :detectionId " );
                q.setLong("detectionId", detectionId);
                List<PotentialCont> list = q.list();
                return list;
            } else {
                return null;
            }
        } catch(HibernateException e){
            e.printStackTrace();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from PotentialCont");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<PotentialCont> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from PotentialCont s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<PotentialCont> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
