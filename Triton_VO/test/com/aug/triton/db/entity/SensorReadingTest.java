/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SensorReadingGroup;
import com.aug.triton.db.remoteentity.Sensor;
import com.aug.triton.db.remoteentity.SensorReading;
import com.aug.triton.db.dao.SensorReadingGroupDAOImpl;
import java.util.List;
import org.junit.Assert;
import com.aug.triton.db.dao.SensorDAOImpl;
import java.sql.Timestamp;
import org.junit.Before;
import org.junit.After;
import com.aug.triton.db.dao.SensorReadingDAOImpl;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class SensorReadingTest {
    
    private SensorReadingDAOImpl dao = null;
    
    public SensorReadingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new SensorReadingDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN); 
        sensorReading.setRead(Boolean.TRUE);
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);
        Assert.assertNotNull("Created successfully", sensorReading);
        
        // Clean up after test  
        dao.delete(sensorReading);  
        groupDao.delete(group);
    }
    
    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
        
        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN); 
        sensorReading.setRead(Boolean.TRUE);        
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);

        dao.delete(sensorReading);
        groupDao.delete(group);
        sensorReading = dao.get(sensorReading.getId());
        Assert.assertNull(sensorReading);
    }

    @Test
    public void testGet() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);

        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN); 
        sensorReading.setRead(Boolean.TRUE);
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);
        
        SensorReading sensorReadingGot = dao.get(sensorReading.getId());        
        Assert.assertNotNull(sensorReadingGot);
        Short id  = sensorReadingGot.getSensor().getId();
        Assert.assertTrue(id>0);
        // Clean up after test  
        dao.delete(sensorReading);        
        groupDao.delete(group);
    }

    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
        
        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN);
        sensorReading.setRead(Boolean.TRUE);
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);

        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);

        // Clean up after test  
        dao.delete(sensorReading);           
        groupDao.delete(group);
    }
    
    @Test 
    public void testList() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
        
        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN);
        sensorReading.setRead(Boolean.TRUE);
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);

        List l = dao.list(0, 1);
        Assert.assertTrue(l.size()> 0);

        // Clean up after test  
        dao.delete(sensorReading);           
        groupDao.delete(group);
    }
    
    @Test
    public void testGetLatestReadingByName() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
        
        SensorReading sensorReading = new SensorReading();
        sensorReading.setConfidence(Double.NaN);
        sensorReading.setReading(Double.NaN);
        sensorReading.setRead(Boolean.TRUE);
        sensorReading.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading.setSensor(sensor);
        sensorReading = dao.create(sensorReading);    
        
        Timestamp now = new Timestamp (Calendar.getInstance().getTimeInMillis());
        sensorReading = dao.getLatestReadingByName("pH", now);
        Assert.assertTrue(sensorReading.getSensor().getName().equalsIgnoreCase("pH"));
       
        // Clean up after test  
        dao.delete(sensorReading);           
        groupDao.delete(group);
    }

    @Test
    public void testGetLatestReading() throws Exception {
        // Prepare before test
        SensorReadingGroup group = new SensorReadingGroup();
        group.setSampleTime(new Timestamp(System.currentTimeMillis()));
        SensorReadingGroupDAOImpl groupDao = new SensorReadingGroupDAOImpl();
        group = groupDao.create(group);
                
        SensorReading sensorReading1 = new SensorReading();
        sensorReading1.setConfidence(Double.parseDouble("100.01"));
        sensorReading1.setReading(Double.parseDouble("100.01")); 
        sensorReading1.setSensorReadingGroup(group);
        SensorDAOImpl sensorDAO = new SensorDAOImpl();
        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
        sensorReading1.setSensor(sensor);
        sensorReading1 = dao.create(sensorReading1); 
        SensorReading sensorReading2 = new SensorReading();
        sensorReading2.setConfidence(Double.parseDouble("200.02"));
        sensorReading2.setReading(Double.parseDouble("200.02")); 
        sensorReading2.setSensorReadingGroup(group);
        sensorDAO = new SensorDAOImpl();
        sensor = sensorDAO.get(Short.valueOf("2"));
        sensorReading2.setSensor(sensor);
        
        Timestamp now = new Timestamp (Calendar.getInstance().getTimeInMillis());
        List<SensorReading> readings = dao.getLatestReading(now);
        Assert.assertTrue(readings.size()==1);
        
        dao.delete(sensorReading1);
        dao.delete(sensorReading2);
        groupDao.delete(group);
    }
}
