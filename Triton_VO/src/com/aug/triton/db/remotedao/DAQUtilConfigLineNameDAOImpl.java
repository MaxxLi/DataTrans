/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.DAQUtilConfigLineName;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class DAQUtilConfigLineNameDAOImpl extends DAO implements DAQUtilConfigLineNameDAO {

    @Override
    public DAQUtilConfigLineName create(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException {
        try {
            begin();
            getSession().save(daqUtilConfigLineName);
            commit();
            return daqUtilConfigLineName;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<DAQUtilConfigLineName> list) throws AppException {
        try {
            begin();
            for(DAQUtilConfigLineName s: list)
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
    public DAQUtilConfigLineName get(int id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from DAQUtilConfigLineName n where n.id = :id");
            q.setInteger("id", id);
            DAQUtilConfigLineName daqUtilConfigLineName = (DAQUtilConfigLineName) q.uniqueResult();
            return daqUtilConfigLineName;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException {
        try {
            begin();
            getSession().update(daqUtilConfigLineName);
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
    public void delete(DAQUtilConfigLineName daqUtilConfigLineName) throws AppException {
        try {
            begin();
            getSession().delete(daqUtilConfigLineName);
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
    public List<DAQUtilConfigLineName> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from DAQUtilConfigLineName");
            List<DAQUtilConfigLineName> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public List<DAQUtilConfigLineName> list(int firstResult, int maxResults) throws AppException {
        try{			
            Query q = getSession().createQuery("from DAQUtilConfigLineName");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<DAQUtilConfigLineName> list = q.list();
            return list; 
        } catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public List<DAQUtilConfigLineName> getUtilConfigLineNamesByUtilName(String name) throws AppException {
        try {
            Query q = getSession().createQuery("from DAQUtilConfigLineName n where n.DAQUtilConfig.utilName = :utilName " +
                    "order by index ASC");
            q.setString("utilName", name);
            List<DAQUtilConfigLineName> list = q.list();
            return list;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }        
    }
    
    @Override
    public DAQUtilConfigLineName getUtilConfigLineNameByUtilNameAndLineName(String utilName, String lineName) throws AppException {
        try {
            Query q = getSession().createQuery("from DAQUtilConfigLineName n " + 
                    "where n.DAQUtilConfig.utilName = :utilName and " + 
                    "n.lineName = :lineName");
            q.setString("utilName", utilName);
            q.setString("lineName", lineName);
            DAQUtilConfigLineName rtn = (DAQUtilConfigLineName) q.uniqueResult();
            return rtn;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }        
    }
    
    public void deleteAllByUtil(String utilName){
        try{
            List<DAQUtilConfigLineName> lines = getUtilConfigLineNamesByUtilName(utilName);
            for (int i = 0; i < lines.size(); i++){
                delete(lines.get(i));
            }
        } catch (AppException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from DAQUtilConfigLineName");
        int s = 0;
        if (q.uniqueResult()!= null)
        {
            s = (Integer)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<DAQUtilConfigLineName> listByID(int firstID, int lastID )
        {
        try{
            Query q = getSession().createQuery("from DAQUtilConfigLineName s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<DAQUtilConfigLineName> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
