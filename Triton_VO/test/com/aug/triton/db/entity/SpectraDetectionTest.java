/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SpectraDetection;
import com.aug.triton.db.remoteentity.TapRef;
import java.sql.Timestamp;
import com.aug.triton.db.dao.TapRefDAOImpl;
import org.junit.Assert;
import com.aug.triton.db.dao.SpectraDetectionDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class SpectraDetectionTest {
    
    private static SpectraDetectionDAOImpl dao = null;
    
    public SpectraDetectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        dao = new SpectraDetectionDAOImpl();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        SpectraDetection spectraDetection = new SpectraDetection();
        
        spectraDetection.setAnomaly(Boolean.TRUE);
        spectraDetection.setConfidence(Float.NaN);
//        spectraDetection.setFinalDetectionResults(null);
        spectraDetection.setSampleTime(new Timestamp(System.currentTimeMillis()));
        
        TapRefDAOImpl tapRefDao = new TapRefDAOImpl();
        TapRef tapRef = new TapRef();
        tapRef.setSampleTime(new Timestamp(System.currentTimeMillis()));
        tapRefDao.create(tapRef);
        spectraDetection.setTapRef(tapRef);
        spectraDetection = dao.create(spectraDetection);
        Assert.assertNotNull("Created successfully", spectraDetection);

        // Clean up after test
        dao.delete(spectraDetection);
    }

}
