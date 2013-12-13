/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.Location;
import org.junit.Assert;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.aug.triton.db.dao.LocationDAOImpl;
/**
 *
 * @author AUG
 */
public class LocationTest {
    private LocationDAOImpl dao = null;

    public LocationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new LocationDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
      
    @Test
    public void testCreate() throws Exception {
        Location loc = new Location();
        loc.setAddress("test");
        loc.setSystemName("test");
        loc = dao.create(loc);
        Assert.assertNotNull("Created successfully", loc); 

        // Clean up after test  
        dao.delete(loc);       
    }
    
    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        Location loc = new Location();
        loc.setAddress("test");
        loc.setSystemName("test");
        loc = dao.create(loc);

        dao.delete(loc);
        loc = dao.get(loc.getId());
        Assert.assertNull(loc);
    }

    @Test
    public void testGet() throws Exception {
        // Prepare before test
        Location loc = new Location();
        loc.setAddress("test");
        loc.setSystemName("test");
        loc = dao.create(loc);
        
        Location locGot = dao.get(Short.valueOf(loc.getId()));
        Assert.assertNotNull(locGot);
        
        // Clean up after test
        dao.delete(loc); 
    }

    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        Location loc = new Location();
        loc.setAddress("test");
        loc.setSystemName("test");
        loc = dao.create(loc);
        
        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);
        
        // Clean up after test
        dao.delete(loc); 
    }
    
    @Test 
    public void testList() throws Exception {
        // Prepare before test
        Location loc = new Location();
        loc.setAddress("test");
        loc.setSystemName("test");
        loc = dao.create(loc);

        List l = dao.list(0, 1);
        Assert.assertTrue(l.size()== 1);
        
        // Clean up after test
        dao.delete(loc); 
    }
    
}
