/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

/**
 *
 * @author AUG
 */
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.aug.triton.db.remoteentity.Location;
import com.aug.triton.db.exception.AppException;

public class LocationDAOImpl extends DAO implements LocationDAO {

    public Location create(Location loc) throws AppException {
        try {
            begin();
            getSession().save(loc);
            commit();
            return loc;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<Location> list) throws AppException {
        try {
            begin();
            for(Location s: list)
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

    public void delete(Location loc) throws AppException {
        try {
            begin();
            getSession().delete(loc);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }

    }

    public Location get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from Location l where l.id = :id" );
            q.setShort("id", id);
            Location loc = (Location) q.uniqueResult();
            return loc;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    public void save(Location loc) throws AppException {
        try {
            begin();
            getSession().update(loc);
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

    @SuppressWarnings("unchecked")
    public List<Location> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from Location");
            List<Location> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    public List<Location> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from Location");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<Location> list = q.list();
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public Short maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from Location");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<Location> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from Location s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<Location> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
