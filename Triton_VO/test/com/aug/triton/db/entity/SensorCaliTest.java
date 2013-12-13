/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SensorCali;
import com.aug.triton.db.dao.SensorCaliDAOImpl;
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
public class SensorCaliTest {
    
    private SensorCaliDAOImpl dao = null;

    public SensorCaliTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new SensorCaliDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }
    @Test
    public void testCreate() throws Exception {
//        //for(int i = 0; ;i++){
//            SensorCali sensorCali = new SensorCali();
//            sensorCali.setlastCalibrated("18/5/2012 at 16:27");
//            sensorCali.setoffset(new Double(0.0));
//            sensorCali.setreadingAdjustment(new Double(1.0));
//            sensorCali.setshuntResistance(new Double(470));
//            sensorCali.setmaxCurrent(new Double(0.02));
//            sensorCali.setmaxVal(new Double(60.2076295873236));
//            sensorCali.setminCurrent(new Double(0.004));
//            sensorCali.setminVal(new Double(-1.1952029599482041));
//            sensorCali.setdeviceChannel("Dev1/ai6");
//            SensorDAOImpl sensorDAO = new SensorDAOImpl();
//            sensorCali.setsensor(sensorDAO.getSensorByName("Temperature"));
//
//            Assert.assertNotNull(dao);
//            sensorCali = dao.create(sensorCali);
//            Assert.assertNotNull("Created successfully", sensorCali);
//            if (i % 1000 == 0)
//                Runtime.getRuntime().gc();
            //Thread.sleep(50);
        //}
        // Clean up after test  
        //dao.delete(sensorCali);
    }
//    
//    @Test
//    public void testDelete() throws Exception {
//        // Prepare before test
//        SensorCali sensorCali = new SensorCali();
//        sensorCali.setlastCalibrated("test");
//        sensorCali.setoffset(new Double(7.00));
//        sensorCali.setreadingAdjustment(new Double(3.00));
//        sensorCali.setshuntResistance(new Double(4.00));
//        sensorCali.setmaxCurrent(new Double(5.00));
//        sensorCali.setmaxVal(new Double(6.00));
//        sensorCali.setminCurrent(new Double(3.00));
//        sensorCali.setminVal(new Double(3.00));
//        sensorCali.setdeviceChannel("test2");
//        Assert.assertNotNull(dao);
//        sensorCali = dao.create(sensorCali);    
//        
//        dao.delete(sensorCali);
//        sensorCali = dao.get(sensorCali.getId());
//        Assert.assertNull(sensorCali);
//    }
//    
//    @Test
//    public void testGet() throws Exception {
//        // Prepare before test
//        SensorCali sensorCali = new SensorCali();
//        sensorCali.setlastCalibrated("test");
//        sensorCali.setoffset(new Double(7.00));
//        sensorCali.setreadingAdjustment(new Double(3.00));
//        sensorCali.setshuntResistance(new Double(4.00));
//        sensorCali.setmaxCurrent(new Double(5.00));
//        sensorCali.setmaxVal(new Double(6.00));
//        sensorCali.setminCurrent(new Double(3.00));
//        sensorCali.setminVal(new Double(3.00));
//        sensorCali.setdeviceChannel("test2");
//        Assert.assertNotNull(dao);
//        sensorCali = dao.create(sensorCali);  
//        
//        SensorCali sensorCaliGot = dao.get(sensorCali.getId());        
//        Assert.assertNotNull(sensorCaliGot);
//        Short id  = sensorCaliGot.getId();
//        Assert.assertTrue(id == sensorCali.getId());
//        // Clean up after test  
//        dao.delete(sensorCali);
//    }
//    
    @Test
    public void testGet2() throws Exception {
        // Prepare before test
        while(true){
            SensorCali sensorCaliGot = dao.get("pH");        
            Assert.assertNotNull(sensorCaliGot);
            Short id  = sensorCaliGot.getsensor().getId();
            Assert.assertTrue(id == 1);
        }
    }
//    
//    @Test
//    public void testSave() throws Exception {
//        // Prepare before test
//        SensorCali sensorCali = new SensorCali();
//        sensorCali.setlastCalibrated("test");
//        sensorCali.setoffset(new Double(7.00));
//        sensorCali.setreadingAdjustment(new Double(3.00));
//        sensorCali.setshuntResistance(new Double(4.00));
//        sensorCali.setmaxCurrent(new Double(5.00));
//        sensorCali.setmaxVal(new Double(6.00));
//        sensorCali.setminCurrent(new Double(3.00));
//        sensorCali.setminVal(new Double(3.00));
//        sensorCali.setdeviceChannel("test2");
//        Assert.assertNotNull(dao);
//        sensorCali = dao.create(sensorCali);  
//        
//        Short id  = sensorCali.getId();
//        Double tempMaxVal = sensorCali.getmaxVal();
//        
//        sensorCali.setmaxVal(1000);
//        dao.save(sensorCali);
//        
//        SensorCali sensorCaliGot = dao.get(sensorCali.getId());        
//        Assert.assertNotNull(sensorCaliGot);
//        Double newMaxVal = sensorCaliGot.getmaxVal();
//        
//        Assert.assertTrue(newMaxVal != tempMaxVal);
//
//        // Clean up after test  
//        dao.delete(sensorCali);
//    }
//    
//    @Test
//    public void testListAll() throws Exception {
//        // Prepare before test
//        SensorCali sensorCali = new SensorCali();
//        sensorCali.setlastCalibrated("test");
//        sensorCali.setoffset(new Double(7.00));
//        sensorCali.setreadingAdjustment(new Double(3.00));
//        sensorCali.setshuntResistance(new Double(4.00));
//        sensorCali.setmaxCurrent(new Double(5.00));
//        sensorCali.setmaxVal(new Double(6.00));
//        sensorCali.setminCurrent(new Double(3.00));
//        sensorCali.setminVal(new Double(3.00));
//        sensorCali.setdeviceChannel("test2");
//        Assert.assertNotNull(dao);
//        sensorCali = dao.create(sensorCali);
//
//        List l = dao.listAll();
//        Assert.assertTrue(l.size() > 0);
//
//        // Clean up after test  
//        dao.delete(sensorCali);           
//    }
//    
//    @Test 
//    public void testList() throws Exception {
//        // Prepare before test
//        SensorCali sensorCali = new SensorCali();
//        sensorCali.setlastCalibrated("test");
//        sensorCali.setoffset(new Double(7.00));
//        sensorCali.setreadingAdjustment(new Double(3.00));
//        sensorCali.setshuntResistance(new Double(4.00));
//        sensorCali.setmaxCurrent(new Double(5.00));
//        sensorCali.setmaxVal(new Double(6.00));
//        sensorCali.setminCurrent(new Double(3.00));
//        sensorCali.setminVal(new Double(3.00));
//        sensorCali.setdeviceChannel("test2");
//        Assert.assertNotNull(dao);
//        sensorCali = dao.create(sensorCali);
//
//        List l = dao.list(0, 1);
//        Assert.assertTrue(l.size()== 1);
//
//        // Clean up after test  
//        dao.delete(sensorCali);           
//    }
}
