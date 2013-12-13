/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.Cont;
import com.aug.triton.db.exception.AppException;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class ContDAOImpl extends DAO implements ContDAO {

    @Override
    public Cont create(Cont cont) throws AppException {
        try {
            begin();
            getSession().save(cont);
            commit();
            return cont;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<Cont> list) throws AppException {
        try {
            begin();
            for(Cont s: list)
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
    public Cont get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from Cont c where c.id = :id");
            q.setShort("id", id);
            Cont cont = (Cont) q.uniqueResult();
            return cont;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(Cont cont) throws AppException {
        try {
            begin();
            getSession().update(cont);
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
    public void delete(Cont cont) throws AppException {
        try {
            begin();
            getSession().delete(cont);
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
    public List<Cont> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from Cont");
            List<Cont> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<Cont> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from Cont");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<Cont> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public Cont getContByName(String name) throws AppException {
        try {
            Query q = getSession().createQuery("from Cont c where c. contName = :contName ");
            q.setString("contName", name);
            Cont cont = (Cont) q.uniqueResult();
            return cont;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }        
    }

    @Override
    public Short maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from Cont");
        Short s = (short) 0;
        if (q.uniqueResult() != null) {
            s = (Short) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<Cont> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from Cont s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<Cont> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
