/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.Sensor;
import com.aug.triton.db.dao.SensorDAOImpl;
import org.junit.Assert;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AUG
 */
public class SensorTest {
    
    private SensorDAOImpl dao = null;

    public SensorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new SensorDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
    
    @Test
    public void testCreate() throws Exception {
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensor.setMaxValue(new Double(7.00));
        sensor.setMinValue(new Double(3.00));
        Assert.assertNotNull(dao);
        sensor = dao.create(sensor);
        Assert.assertNotNull("Created successfully", sensor);
        
        // Clean up after test  
        dao.delete(sensor);     
    }
    
    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensor.setMaxValue(new Double(7.00));
        sensor.setMinValue(new Double(3.00));
        Assert.assertNotNull(dao);
        sensor = dao.create(sensor);

        dao.delete(sensor);
        sensor = dao.get(sensor.getId());
        Assert.assertNull(sensor);
    }

    @Test
    public void testGet() throws Exception {
        // Prepare before test
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensor.setMaxValue(new Double(7.00));
        sensor.setMinValue(new Double(3.00));
        Assert.assertNotNull(dao);
        sensor = dao.create(sensor);
        
        Sensor sensorGot = dao.get(sensor.getId());        
        Assert.assertNotNull(sensorGot);
        
        // Clean up after test  
        dao.delete(sensor);           
    }

    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensor.setMaxValue(new Double(7.00));
        sensor.setMinValue(new Double(3.00));
        Assert.assertNotNull(dao);
        sensor = dao.create(sensor);

        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);

        // Clean up after test  
        dao.delete(sensor);           
    }
    
    @Test 
    public void testList() throws Exception {
        // Prepare before test
        Sensor sensor = new Sensor();
        sensor.setName("test");
        sensor.setMaxValue(new Double(7.00));
        sensor.setMinValue(new Double(3.00));
        Assert.assertNotNull(dao);
        sensor = dao.create(sensor);

        List l = dao.list(0, 1);
        Assert.assertTrue(l.size()== 1);

        // Clean up after test  
        dao.delete(sensor);           
    }
    
}
