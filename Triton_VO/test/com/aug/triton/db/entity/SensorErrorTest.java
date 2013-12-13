/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SensorError;
import com.aug.triton.db.remoteentity.Sensor;
import com.aug.triton.db.dao.SensorErrorDAOImpl;
import com.aug.triton.db.dao.SensorDAOImpl;
import org.junit.Assert;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.sql.Timestamp;
import org.junit.Test;
/**
 *
 * @author AUG
 */
public class SensorErrorTest {
    
    private SensorErrorDAOImpl dao = null;

    public SensorErrorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao.close();
        dao = new SensorErrorDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
    
    @Test
    public void testCreate() throws Exception {
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.getSensorByName("pH");
        SensorError sensorError = new SensorError();
        sensorError.setDuration(1);
        sensorError.setId(3);
        sensorError.setMessage("Test Error");
        sensorError.setStartTime(new Timestamp(1000000));
        sensorError.setSensor(sensor);
        sensorError = dao.create(sensorError);
        Assert.assertNotNull("Created successfully", sensorError);
        
        // Clean up after test  
        dao.delete(sensorError);
        //groupDao.delete(group);
    }
    
    @Test
    public void testGetBySensorIdAndTime() throws Exception{
        SensorError se = dao.getBySensorIdAndTime(1, new Timestamp(1000000));
        Assert.assertNotNull("Created successfully", se);
    }
}
