/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SystemConfig;
import com.aug.triton.db.dao.SystemConfigDAOImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AUG
 */
public class SystemConfigTest {
    private SystemConfigDAOImpl dao = null;
    
    public SystemConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new SystemConfigDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setParameterName("autosample");
        systemConfig.setParameterValue("false");
        systemConfig = dao.create(systemConfig);
        Assert.assertNotNull("Created successfully", systemConfig);

        // Clean up after test  
        dao.delete(systemConfig);          
    }

    @Test
    public void testDelete() throws Exception {
        // Prepare before test
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setParameterName("autosample");
        systemConfig.setParameterValue("false");
        systemConfig = dao.create(systemConfig);

        dao.delete(systemConfig);
        systemConfig = dao.get(systemConfig.getId());
        Assert.assertNull(systemConfig);
    }
    
    @Test
    public void testGet() throws Exception {
        // Prepare before test
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setParameterName("autosample");
        systemConfig.setParameterValue("false");
        systemConfig = dao.create(systemConfig);

        SystemConfig systemConfigGot = dao.get(Short.valueOf(systemConfig.getId()));        
        Assert.assertNotNull(systemConfigGot);
        
        // Clean up after test  
        dao.delete(systemConfig);           
    }
    
    @Test
    public void testListAll() throws Exception {
        // Prepare before test
        SystemConfig systemConfig = new SystemConfig();
        systemConfig.setParameterName("autosample");
        systemConfig.setParameterValue("false");
        systemConfig = dao.create(systemConfig);

        List l = dao.listAll();
        Assert.assertTrue(l.size() > 0);

        // Clean up after test  
        dao.delete(systemConfig);           
    }

}
