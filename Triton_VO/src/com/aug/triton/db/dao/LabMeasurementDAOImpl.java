/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.dao;

import com.aug.triton.db.remoteentity.LabMeasurement;
import com.aug.triton.db.exception.AppException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author AUG
 */
public class LabMeasurementDAOImpl extends DAO implements LabMeasurementDAO {
    @Override
    public LabMeasurement create(LabMeasurement labMeasurement) throws AppException {
        try {
            begin();
            getSession().save(labMeasurement);
            commit();
            return labMeasurement;
        } catch (HibernateException e) {
            rollback();
            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public LabMeasurement get(Short id) throws AppException {
        try {
            Query q = getSession().createQuery(
                            "from LabMeasurement l where l.id = :id");
            q.setShort("id", id);
            LabMeasurement labMeasurement = (LabMeasurement) q.uniqueResult();
            return labMeasurement;
        } catch (HibernateException e) {






            throw new AppException(e.getCause().getMessage());
        }
        finally{
            close();
        }
    }

    @Override
    public void save(LabMeasurement labMeasurement) throws AppException {
        try {
            begin();
            getSession().update(labMeasurement);
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
    public void delete(LabMeasurement labMeasurement) throws AppException {
        try {
            begin();
            getSession().delete(labMeasurement);
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
    public List<LabMeasurement> listAll() throws AppException {
        try{
            Query q = getSession().createQuery("from LabMeasurement");
            List<LabMeasurement> list = q.list();






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
              			"select max(id) from LabMeasurement");
        Short s = (short)0;
        if(q.uniqueResult() != null)
        {
            s = (Short)q.uniqueResult();
        }
        return s;
    }

    @Override
    public List<LabMeasurement> listByID(Short firstID, Short lastID )
        {
        try{
            Query q = getSession().createQuery("from LabMeasurement s where s.id >= :first and "
                                               + "s.id <= :last");
            q.setShort("first", firstID);
            q.setShort("last", lastID);
            List<LabMeasurement> list = q.list();
            return list; 
        } catch (HibernateException he) {
            throw he;
        }
        finally{
            close();
        }
    }
}
