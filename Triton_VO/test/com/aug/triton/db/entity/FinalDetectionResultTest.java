/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.FinalDetectionResult;
import java.util.List;
import org.junit.Assert;
import com.aug.triton.db.dao.SpectraDetectionDAOImpl;
import java.sql.Timestamp;
import org.junit.After;
import org.junit.Before;
import com.aug.triton.db.dao.FinalDetectionResultDAOImpl;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class FinalDetectionResultTest {
    
    private FinalDetectionResultDAOImpl dao = null;
    
    public FinalDetectionResultTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new FinalDetectionResultDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        FinalDetectionResult finalDetectionResult = new FinalDetectionResult();
        finalDetectionResult.setCombinedAnomaly(Boolean.FALSE);
        finalDetectionResult.setCombinedConfidence(Float.POSITIVE_INFINITY);
        Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
        finalDetectionResult.setSampleTime(now);

        finalDetectionResult = dao.create(finalDetectionResult);
        Assert.assertNotNull("Created successfully", finalDetectionResult);
        
        // Clean up after test  
        dao.delete(finalDetectionResult);
    }
    
    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        FinalDetectionResult finalDetectionResult = new FinalDetectionResult();
        finalDetectionResult.setCombinedAnomaly(Boolean.FALSE);
        finalDetectionResult.setCombinedConfidence(Float.POSITIVE_INFINITY);
        Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
        finalDetectionResult.setSampleTime(now);

        finalDetectionResult = dao.create(finalDetectionResult);

        dao.delete(finalDetectionResult);
        finalDetectionResult = dao.get(finalDetectionResult.getId());
        Assert.assertNull(finalDetectionResult);
        
        // Clean up after test  
    }

    @Test
    public void testGet() throws Exception {
        // Prepare before test
        FinalDetectionResult finalDetectionResult = new FinalDetectionResult();
        finalDetectionResult.setCombinedAnomaly(Boolean.FALSE);
        finalDetectionResult.setCombinedConfidence(Float.POSITIVE_INFINITY);
        Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
        finalDetectionResult.setSampleTime(now);

        finalDetectionResult = dao.create(finalDetectionResult);
        
        FinalDetectionResult finalDetectionResultGot = dao.get(finalDetectionResult.getId());        
        Assert.assertNotNull(finalDetectionResultGot);
        Long id  = finalDetectionResultGot.getId();
        Assert.assertTrue(id>0);
        
        // Clean up after test  
        dao.delete(finalDetectionResult);
        
    }

    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        FinalDetectionResult finalDetectionResult = new FinalDetectionResult();
        finalDetectionResult.setCombinedAnomaly(Boolean.FALSE);
        finalDetectionResult.setCombinedConfidence(Float.POSITIVE_INFINITY);
        Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
        finalDetectionResult.setSampleTime(now);

        finalDetectionResult = dao.create(finalDetectionResult);
        
        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);

        // Clean up after test  
        dao.delete(finalDetectionResult);
    }
    
//    @Test
//    public void testGetLatestReadingByName() throws Exception {
//        // Prepare before test
//        SensorReading sensorReading = new SensorReading();
//        sensorReading.setConfidence(Float.NaN);
//        sensorReading.setReading(Float.NaN); 
//        sensorReading.setSampleTime(Timestamp.valueOf("2011-11-11 11:11:11"));
//        SensorDAOImpl sensorDAO = new SensorDAOImpl();
//        Sensor sensor = sensorDAO.get(Short.valueOf("1"));
//        sensorReading.setSensor(sensor);
//        sensorReading = dao.create(sensorReading);    
//        
//        Timestamp now = new Timestamp (Calendar.getInstance().getTimeInMillis());
//        sensorReading = dao.getLatestReadingByName("pH", now);
//        Assert.assertTrue(sensorReading.getSensor().getName().equalsIgnoreCase("pH"));
//    }

}
