/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.SpectraBaselineSquare;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class SpectraBaselineSquareDAOImpl extends DAO implements SpectraBaselineSquareDAO {
    @Override
    public SpectraBaselineSquare create(SpectraBaselineSquare spectraBaselineSquare) throws AppException {
        try {
            begin();
            getSession().save(spectraBaselineSquare);
            commit();
            return spectraBaselineSquare;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<SpectraBaselineSquare> list) throws AppException {
        try {
            begin();
            for(SpectraBaselineSquare s: list)
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
    public SpectraBaselineSquare get(int id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from SpectraBaselineSquare s where s.id = :id");
            q.setInteger("id", id);
            SpectraBaselineSquare spectraBaselineSquare = (SpectraBaselineSquare) q.uniqueResult();
            return spectraBaselineSquare;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(SpectraBaselineSquare spectraBaselineSquare) throws AppException {
        try {
            begin();
            getSession().update(spectraBaselineSquare);
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
    public void delete(SpectraBaselineSquare spectraBaselineSquare) throws AppException {
        try {
            begin();
            getSession().delete(spectraBaselineSquare);
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
    public List<SpectraBaselineSquare> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from SpectraBaselineSquare ORDER BY rowWavelength, columnWavelength");
            List<SpectraBaselineSquare> list = q.list();			
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
              			"select max(id) from SpectraBaselineSquare");
        int s = (int)0;
        if(q.uniqueResult() != null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<SpectraBaselineSquare> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from SpectraBaselineSquare s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<SpectraBaselineSquare> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
