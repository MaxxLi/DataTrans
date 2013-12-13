/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.TapRef;
import com.aug.triton.db.exception.AppException;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class TapRefDAOImpl extends DAO implements TapRefDAO {

    @Override
    public TapRef create(TapRef tapRef) throws AppException {
        try {
            begin();
            getSession().save(tapRef);
            commit();
            return tapRef;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public TapRef get(int id) throws AppException {
        try {
            Query q = getSession().createQuery(
                    "from TapRef s where t.id = :id");
            q.setInteger("id", id);
            TapRef systemConfig = (TapRef) q.uniqueResult();
            return systemConfig;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void save(TapRef tapRef) throws AppException {
        try {
            begin();
            getSession().update(tapRef);
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public void delete(TapRef tapRef) throws AppException {
        try {
            begin();
            getSession().delete(tapRef);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public List<TapRef> listAll() throws AppException {
        try {
            Query q = getSession().createQuery("from TapRef");
            List<TapRef> list = q.list();






            return list;
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public TapRef getLatestTapRef(Timestamp sampleTime) throws AppException {
        try {
            Query q = getSession().createQuery("from TapRef t where t.sampleTime <= :sampleTime order by sampleTime desc ");
            q.setTimestamp("sampleTime", sampleTime);
            List<TapRef> list = q.list();
            if ((list != null) && (list.size() > 0)) {
                return list.get(0);
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new AppException(e.getCause().getMessage());
        } finally {
            close();
        }
    }

    @Override
    public int maxID() {
        Query q = getSession().createQuery(
                "select max(id) from TapRef");
        int s = 0;
        if (q.uniqueResult() != null) {
            s = (Integer) q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<TapRef> listByID(int firstID, int lastID) {
        try {
            Query q = getSession().createQuery("from TapRef s where s.id >= :first and "
                    + "s.id <= :last");
            q.setInteger("first", firstID);
            q.setInteger("last", lastID);
            List<TapRef> list = q.list();
            return list;
        } catch (HibernateException he) {
            throw he;
        } finally {
            close();
        }
    }
}
