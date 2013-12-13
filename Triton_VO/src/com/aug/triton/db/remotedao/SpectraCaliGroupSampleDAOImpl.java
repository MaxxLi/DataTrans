/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraCaliGroupSample;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraCaliGroupSampleDAOImpl extends DAO implements SpectraCaliGroupSampleDAO{
    @Override
    public SpectraCaliGroupSample create(SpectraCaliGroupSample spectraCaliGroupSample) throws AppException {
        try {
            begin();
            getSession().save(spectraCaliGroupSample);
            commit();
            return spectraCaliGroupSample;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SpectraCaliGroupSample> list) throws AppException {
        try {
            begin();
            for(SpectraCaliGroupSample s: list)
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
    public SpectraCaliGroupSample get(int id) throws AppException{
        try {
            Query q = getSession().createQuery(
                            "from SpectraCaliGroupSample s where s.id = :id ");
            q.setLong("id", id);
            
            SpectraCaliGroupSample spectraCaliGroupSample = (SpectraCaliGroupSample) q.uniqueResult();
            return spectraCaliGroupSample;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void save(SpectraCaliGroupSample spectraCaliGroupSample) throws AppException{
        try {
            begin();
            getSession().update(spectraCaliGroupSample);
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
    public void delete(SpectraCaliGroupSample spectraCaliGroupSample) throws AppException{
        try {
            begin();
            getSession().delete(spectraCaliGroupSample);
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
    public List<SpectraCaliGroupSample> listAll() throws AppException{
        try{
            Query q = getSession().createQuery("from SpectraCaliGroupSample");
            List<SpectraCaliGroupSample> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<SpectraCaliGroupSample> listByGroupId(int groupId) throws AppException {
        try {
            Query q = getSession().createQuery("from SpectraCaliGroupSample s " +
                    " where s.spectraCaliGroup.id = :groupId");
            q.setInteger("groupId", groupId);
            List<SpectraCaliGroupSample> groupSamples = q.list();
            return groupSamples;
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
              			"select max(id) from SpectraCaliGroupSample");
        int s = 0;
        if (q.uniqueResult() != null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraCaliGroupSample> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraCaliGroupSample s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<SpectraCaliGroupSample> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
