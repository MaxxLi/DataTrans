/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.remotedao;

import com.aug.triton.db.remoteentity.EventLog;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.sql.Timestamp;

/**
 *
 * @author AUG
 */
public class EventLogDAOImpl extends DAO implements EventLogDAO {

    @Override
    public EventLog create(EventLog eventLog) throws AppException {
        try {
            begin();
            getSession().save(eventLog);
            commit();
            return eventLog;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    @Override
    public void bulkCreate(List<EventLog> list) throws AppException {
        try {
            begin();
            for(EventLog s: list)
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
    public EventLog get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from EventLog e where e.id = :id");
            q.setLong("id", id);
            EventLog eventLog = (EventLog) q.uniqueResult();
            return eventLog;
        } catch (HibernateException e) {			
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(EventLog eventLog) throws AppException {
        try {
            begin();
            getSession().update(eventLog);
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
    public void delete(EventLog eventLog) throws AppException {
        try {
            begin();
            getSession().delete(eventLog);
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
    public List<EventLog> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from EventLog");
            List<EventLog> list = q.list();			
            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }
    
    public List<EventLog> listByTime(Timestamp from, Timestamp to) throws AppException{
        try{
            Query q = getSession().createQuery("from EventLog where logType='result' and logTime>'" + from + "' and logTime<'" + to + "')");
            List<EventLog> list = q.list();
            q = null;
            return list;
        }
        catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public Long maxID(){
        Query q = getSession().createQuery(
              			"select max(id) from EventLog");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<EventLog> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from EventLog s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<EventLog> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
