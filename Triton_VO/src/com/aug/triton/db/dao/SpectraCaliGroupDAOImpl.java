/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraCaliGroup;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author AUG
 */
public class SpectraCaliGroupDAOImpl extends DAO implements SpectraCaliGroupDAO {
    @Override
    public SpectraCaliGroup create(SpectraCaliGroup spectraCaliGroup) throws AppException {
        try {
            begin();
            Session s = getSession();
            s.save(spectraCaliGroup);
//            getSession().save(spectraCaliGroup);
            commit();
            return spectraCaliGroup;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public SpectraCaliGroup get(int id) throws AppException{
        try {
            Query q = getSession().createQuery(
                            "from SpectraCaliGroup s where s.id = :id ");
            q.setInteger("id", id);
            
            SpectraCaliGroup spectraCaliGroup = (SpectraCaliGroup) q.uniqueResult();
            return spectraCaliGroup;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void save(SpectraCaliGroup spectraCaliGroup) throws AppException{
        try {
            begin();
            getSession().update(spectraCaliGroup);
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
    public void delete(SpectraCaliGroup spectraCaliGroup) throws AppException{
        try {
            begin();
            getSession().delete(spectraCaliGroup);
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
    public List<SpectraCaliGroup> listAll() throws AppException{
        try{
            Query q = getSession().createQuery("from SpectraCaliGroup");
            List<SpectraCaliGroup> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }


    @Override
    public int maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from SpectraCaliGroup");
        int s = 0;
        if (q.uniqueResult() != null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraCaliGroup> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraCaliGroup s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<SpectraCaliGroup> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
