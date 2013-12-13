/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.SpectraCaliGroup;
import com.aug.triton.db.remoteentity.Cont;
import org.junit.Assert;
import com.aug.triton.db.dao.ContDAOImpl;
import org.junit.After;
import org.junit.Before;
import com.aug.triton.db.dao.SpectraCaliGroupDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class SpectraCaliGroupTest {
    
    private SpectraCaliGroupDAOImpl dao = null;
    
    public SpectraCaliGroupTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        dao = new SpectraCaliGroupDAOImpl();
    }
    
    @After
    public void tearDown() {
        dao = null;
    }

    @Test
    public void testCreate() throws Exception {
        SpectraCaliGroup group = new SpectraCaliGroup();
        
        Cont cont = new Cont();
        ContDAOImpl contDao = new ContDAOImpl();
        cont.setContName("Nitrite");
        cont.setUnits("unit");
        cont = contDao.create(cont);
        
        group.setCont(cont);
//        group.setIntercept(Double.NaN);
//        group.setIsSelected(Boolean.TRUE);
//        group.setPeakWavelength(Integer.MIN_VALUE);
//        group.setSampleTime(null);
//        group.setSlope(Double.NaN);
//        group.setTapRefId(Long.MIN_VALUE);
        dao = new SpectraCaliGroupDAOImpl();
        group = dao.create(group);
        Assert.assertNotNull("Created successfully", group);

        // Clean up after test
        dao.delete(group);
        contDao.delete(cont);       
    }
}
