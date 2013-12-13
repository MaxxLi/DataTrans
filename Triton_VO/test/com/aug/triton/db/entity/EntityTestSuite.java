/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author AUG
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class EntityTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testLocation(){

        Session session = null;
        try {
	        session = HibernateUtil.getSessionFactory().openSession();

	        Transaction transaction = session.beginTransaction();
	        String myQuery = "FROM location order by ID desc limit 1";
			Query tempQuery = session.createQuery(myQuery);
			List result = tempQuery.list();
			transaction.commit();
			Assert.assertTrue(result.size()>2);
			session.close();
	    } catch (HibernateException e) {
        	if (session!=null)
        		session.close();
        	e.printStackTrace();
        }
    }
}
