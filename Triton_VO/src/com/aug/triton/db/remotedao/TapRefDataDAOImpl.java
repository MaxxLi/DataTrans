/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.TapRefData;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class TapRefDataDAOImpl extends DAO implements TapRefDataDAO{
    @Override
    public TapRefData create(TapRefData tapRefData) throws AppException {
        try {
            begin();
            getSession().save(tapRefData);
            commit();
            return tapRefData;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<TapRefData> list) throws AppException {
        try {
            begin();
            for(TapRefData s: list)
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
    public TapRefData get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from TapRefData t where t.id = :id");
            q.setLong("id", id);
            TapRefData systemConfig = (TapRefData) q.uniqueResult();
            return systemConfig;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(TapRefData tapRefData) throws AppException {
        try {
            begin();
            getSession().update(tapRefData);
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
    public void delete(TapRefData tapRefData) throws AppException {
        try {
            begin();
            getSession().delete(tapRefData);
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
    public List<TapRefData> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from TapRefData");
            List<TapRefData> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<TapRefData> listDataByTapRefId(int tapRefId) throws AppException{
        try {
            Query q = getSession().createQuery("from TapRefData t where t.tapRef.id = :tapRefId");
            q.setLong("tapRefId", tapRefId);
            List<TapRefData> list = q.list();
            return list;
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
              			"select max(id) from TapRefData");
        Long s = (long) 0;
        if (q.uniqueResult() != null) {
            s = (Long) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<TapRefData> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from TapRefData s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<TapRefData> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
