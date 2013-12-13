/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.Cont;
import org.hibernate.HibernateException;
import org.junit.Assert;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import com.aug.triton.db.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import com.aug.triton.db.dao.ContDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class ContTest {
    private ContDAOImpl dao = null;
    
    public ContTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new ContDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        Cont cont = new Cont();
        cont.setContName("Chromate");
        cont.setUnits("ppb");
        cont = dao.create(cont);
        Assert.assertNotNull("Created successfully", cont);

        // Clean up after test  
        dao.delete(cont);          
    }

    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        Cont cont = new Cont();
        cont.setContName("Nitrite");
        cont.setUnits("unit");
        cont = dao.create(cont);

        dao.delete(cont);
        cont = dao.get(cont.getId());
        Assert.assertNull(cont);
    }
    
    @Test
    public void testGet() throws Exception {
        // Prepare before test
        Cont cont = new Cont();
        cont.setContName("Nitrite");
        cont.setUnits("unit");
        cont = dao.create(cont);

        Cont contGot = dao.get(Short.valueOf(cont.getId()));        
        Assert.assertNotNull(contGot);
        
        // Clean up after test  
        dao.delete(cont);           
    }
    
    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        Cont cont = new Cont();
        cont.setContName("Nitrite");
        cont.setUnits("unit");
        cont = dao.create(cont);

        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);

        // Clean up after test  
        dao.delete(cont);           
    }
    
    @Test 
    public void testList() throws Exception {
        // Prepare before test
        Cont cont = new Cont();
        cont.setContName("Nitrite");
        cont.setUnits("unit");
        cont = dao.create(cont);

        List l = dao.list(0, 1);
        Assert.assertTrue(l.size()== 1);

        // Clean up after test  
        dao.delete(cont);           
    }
    
}
