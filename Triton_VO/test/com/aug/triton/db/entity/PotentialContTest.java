/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.entity;

import com.aug.triton.db.remoteentity.PotentialCont;
import com.aug.triton.db.remoteentity.SpectraDetection;
import com.aug.triton.db.remoteentity.TapRef;
import com.aug.triton.db.remoteentity.Cont;
import java.util.List;
import com.aug.triton.db.dao.SpectraDetectionDAOImpl;
import com.aug.triton.db.dao.TapRefDAOImpl;
import java.sql.Timestamp;
import com.aug.triton.db.dao.ContDAOImpl;
import org.junit.Assert;
import com.aug.triton.db.dao.PotentialContDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AUG
 */
public class PotentialContTest {
    
    private static PotentialContDAOImpl dao = null;
    
    public PotentialContTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        dao = new PotentialContDAOImpl();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        dao = null;
    }
    
    @Test
    public void testCreate() throws Exception {
        PotentialCont potentialCont = new PotentialCont();
        
        potentialCont.setConfidence(Float.NaN);
        
        Cont cont = new Cont();
        cont.setContName("haha");
        cont.setUnits("hehe");
        ContDAOImpl contDao = new ContDAOImpl();
        contDao.create(cont);
        
        TapRef tapRef = new TapRef();
        tapRef.setSampleTime(new Timestamp(System.currentTimeMillis()));
        TapRefDAOImpl tapRefDao = new TapRefDAOImpl();
        tapRefDao.create(tapRef);
        
        SpectraDetection spectraDetection = new SpectraDetection();
        spectraDetection.setAnomaly(Boolean.TRUE);
        spectraDetection.setSampleTime(new Timestamp(System.currentTimeMillis()));
        spectraDetection.setTapRef(tapRef);
        SpectraDetectionDAOImpl spectraDao = new SpectraDetectionDAOImpl();
        spectraDao.create(spectraDetection);
               
        potentialCont.setCont(cont);
        potentialCont.setEstimatedValue(Float.NaN);
        potentialCont.setSpectraDetection(spectraDetection);
        potentialCont = dao.create(potentialCont);
        Assert.assertNotNull("Created successfully", potentialCont);

        // Clean up after test
        dao.delete(potentialCont);        
        contDao.delete(cont);         
        spectraDao.delete(spectraDetection);
        tapRefDao.delete(tapRef);
    }
    
    @Test
    public void testGetLastContaminantList() throws Exception {
        PotentialCont potentialCont = new PotentialCont();
        
        potentialCont.setConfidence(Float.NaN);
        
        Cont cont = new Cont();
        cont.setContName("haha");
        cont.setUnits("hehe");
        ContDAOImpl contDao = new ContDAOImpl();
        contDao.create(cont);
        
        TapRef tapRef = new TapRef();
        tapRef.setSampleTime(new Timestamp(System.currentTimeMillis()));
        TapRefDAOImpl tapRefDao = new TapRefDAOImpl();
        tapRefDao.create(tapRef);
        
        SpectraDetection spectraDetection = new SpectraDetection();
        spectraDetection.setAnomaly(Boolean.TRUE);
        spectraDetection.setSampleTime(new Timestamp(System.currentTimeMillis()));
        spectraDetection.setTapRef(tapRef);
        SpectraDetectionDAOImpl spectraDao = new SpectraDetectionDAOImpl();
        spectraDao.create(spectraDetection);
               
        potentialCont.setCont(cont);
        potentialCont.setEstimatedValue(Float.NaN);
        potentialCont.setSpectraDetection(spectraDetection);
        potentialCont = dao.create(potentialCont);
        Assert.assertNotNull("Created successfully", potentialCont);


//        PotentialContDAOImpl dao = new PotentialContDAOImpl();
        List<PotentialCont> contaminants = dao.getLastContaminantListBySampletime(new Timestamp(System.currentTimeMillis()));
        Assert.assertTrue(contaminants.size()>0);
        
        // Clean up after test
        dao.delete(potentialCont);        
        contDao.delete(cont);         
        spectraDao.delete(spectraDetection);
        tapRefDao.delete(tapRef);        
    }

}
