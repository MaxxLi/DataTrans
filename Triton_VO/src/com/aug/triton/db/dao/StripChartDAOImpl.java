/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.StripChart;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class StripChartDAOImpl extends DAO implements StripChartDAO {

    @Override
    public StripChart create(StripChart stripChart) throws AppException {
        try {
            begin();
            getSession().save(stripChart);
            commit();
            return stripChart;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public StripChart get(Long id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from StripChart s where s.id = :id ");
            q.setLong("id", id);
            
            StripChart stripChart = (StripChart) q.uniqueResult();
            return stripChart;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(StripChart stripChart) throws AppException {
        try {
            begin();
            getSession().update(stripChart);
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
    public void delete(StripChart stripChart) throws AppException {
        try {
            begin();
            getSession().delete(stripChart);
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
    public List<StripChart> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from StripChart");
            List<StripChart> list = q.list();






            return list; 
        }catch(HibernateException e){
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    public List<StripChart> listStripChartByTimeAndChannel(Timestamp startTime, Timestamp endTime, Short channelNo) throws AppException {
        try {
            Query q = getSession().createQuery(
                    "from StripChart s where s.sampleTime >= :startTime "
                    + " and s.sampleTime <= :endTime and s.channel = :channelNo");
            q.setTimestamp("startTime", startTime);
            q.setTimestamp("endTime", endTime);
            q.setShort("channelNo", channelNo);
            List<StripChart> list = q.list();
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
              			"select max(id) from StripChart");
        Long s = (long)0;
        if(q.uniqueResult() != null)
        {
            s = (Long)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<StripChart> listByID(Long firstID, Long lastID )
        {
        try{
            Query q = getSession().createQuery("from StripChart s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setLong("first", firstID);
            q.setLong("last", lastID);
            List<StripChart> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
