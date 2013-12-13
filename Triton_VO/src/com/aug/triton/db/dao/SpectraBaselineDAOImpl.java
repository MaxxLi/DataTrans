/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.SpectraBaseline;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraBaselineDAOImpl extends DAO implements SpectraBaselineDAO {
    @Override
    public SpectraBaseline create(SpectraBaseline spectraBaseline) throws AppException {
        try {
            begin();
            getSession().save(spectraBaseline);
            commit();
            return spectraBaseline;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public SpectraBaseline get(int id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SpectraBaseline s where s.id = :id");
            q.setInteger("id", id);
            SpectraBaseline spectraBaseline = (SpectraBaseline) q.uniqueResult();
            return spectraBaseline;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SpectraBaseline spectraBaseline) throws AppException {
        try {
            begin();
            getSession().update(spectraBaseline);
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
    public void delete(SpectraBaseline spectraBaseline) throws AppException {
        try {
            begin();
            getSession().delete(spectraBaseline);
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
    public List<SpectraBaseline> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SpectraBaseline ORDER BY wavelength");
            List<SpectraBaseline> list = q.list();






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
              			"select max(id) from SpectraBaseline");
        int s = (int)0;
        if(q.uniqueResult() != null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraBaseline> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraBaseline s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<SpectraBaseline> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
