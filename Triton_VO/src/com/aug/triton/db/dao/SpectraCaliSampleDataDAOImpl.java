/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraCaliSampleData;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraCaliSampleDataDAOImpl extends DAO implements SpectraCaliSampleDataDAO {
    @Override
    public SpectraCaliSampleData create(SpectraCaliSampleData spectraCaliSampleData) throws AppException {
        try {
            begin();
            getSession().save(spectraCaliSampleData);
            commit();
            return spectraCaliSampleData;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public SpectraCaliSampleData get(long id) throws AppException{
        try {
            Query q = getSession().createQuery(
                            "from SpectraCaliSampleData s where s.id = :id ");
            q.setLong("id", id);
            
            SpectraCaliSampleData spectraCaliSampleData = (SpectraCaliSampleData) q.uniqueResult();
            return spectraCaliSampleData;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void save(SpectraCaliSampleData spectraCaliSampleData) throws AppException{
        try {
            begin();
            getSession().update(spectraCaliSampleData);
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
    public void delete(SpectraCaliSampleData spectraCaliSampleData) throws AppException{
        try {
            begin();
            getSession().delete(spectraCaliSampleData);
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
    public List<SpectraCaliSampleData> listAll() throws AppException{
        try{
            Query q = getSession().createQuery("from SpectraCaliSampleData");
            List<SpectraCaliSampleData> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<SpectraCaliSampleData> listSampleDataBySampleId(long sampleId) throws AppException {
        try {
            Query q = getSession().createQuery("from SpectraCaliSampleData s " +
                    "where s.spectraCaliGroupSample.id = :sampleId");
            q.setLong("sampleId", sampleId);
            List<SpectraCaliSampleData> list = q.list();
            return list;
        } catch(HibernateException e) {
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
              			"select max(id) from SpectraCaliSampleData");
        Long s = (long) 0;
        if (q.uniqueResult() != null) {
            s = (Long) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraCaliSampleData> listByID(long firstID, long lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraCaliSampleData s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<SpectraCaliSampleData> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
