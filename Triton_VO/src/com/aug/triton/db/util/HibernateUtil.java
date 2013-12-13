/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aug.triton.db.util;


import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author AUG
 */
public class HibernateUtil {

    private static final SessionFactory local_sessionFactory;
    private static final SessionFactory remote_sessionFactory;
    static {
        try {
                String driver = "org.postgresql.Driver";
        	String dialect = "org.hibernate.dialect.PostgreSQLDialect";
        	String local_url = "jdbc:postgresql://localhost:5432/iwm";
                //static server ip : 76.10.159.52:5432
                String remote_url = "jdbc:postgresql://192.168.1.204:5432/E15";
        	String username = "iwm";
        	String password = "iwm001asdf";
                
                
                Configuration local_cfg = new Configuration();
                Configuration remote_cfg = new Configuration();
        	local_cfg.setProperty("hibernate.connection.driver_class", driver);
        	local_cfg.setProperty("hibernate.dialect", dialect);
        	local_cfg.setProperty("hibernate.connection.url", local_url);
        	local_cfg.setProperty("hibernate.connection.username", username);
        	local_cfg.setProperty("hibernate.connection.password", password);
        	
        	local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraReading.hbm.xml");
           	local_cfg.addResource("com/aug/triton/db/remoteentity/SensorReading.hbm.xml");         	
           	local_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionResult.hbm.xml");
           	local_cfg.addResource("com/aug/triton/db/remoteentity/Cont.hbm.xml");           	
           	local_cfg.addResource("com/aug/triton/db/remoteentity/Sensor.hbm.xml");
          	local_cfg.addResource("com/aug/triton/db/remoteentity/TapRef.hbm.xml");
           	local_cfg.addResource("com/aug/triton/db/remoteentity/TapRefData.hbm.xml");    	
           	local_cfg.addResource("com/aug/triton/db/remoteentity/PotentialCont.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraDetection.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/EventLog.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraConfig.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SystemConfig.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/LabMeasurement.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SensorBaseline.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SensorBaselineSquare.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/StripChart.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliGroup.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliGroupSample.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliSampleData.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraBaseline.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SpectraBaselineSquare.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SensorReadingGroup.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionSensorGroup.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionSpectraDetection.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SensorCali.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/SensorError.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/DAQUtilConfig.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/DAQUtilConfigLineName.hbm.xml");
                local_cfg.addResource("com/aug/triton/db/remoteentity/TocReading.hbm.xml");  
                
                local_sessionFactory = local_cfg.buildSessionFactory();
                
                
                
                
                remote_cfg.setProperty("hibernate.connection.driver_class", driver);
        	remote_cfg.setProperty("hibernate.dialect", dialect);
        	remote_cfg.setProperty("hibernate.connection.url", remote_url);
        	remote_cfg.setProperty("hibernate.connection.username", username);
        	remote_cfg.setProperty("hibernate.connection.password", password);
        	remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraReading.hbm.xml");
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorReading.hbm.xml");         	
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionResult.hbm.xml");
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/Cont.hbm.xml");           	
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/Sensor.hbm.xml");
          	remote_cfg.addResource("com/aug/triton/db/remoteentity/TapRef.hbm.xml");
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/TapRefData.hbm.xml");    	
           	remote_cfg.addResource("com/aug/triton/db/remoteentity/PotentialCont.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraDetection.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/EventLog.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraConfig.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SystemConfig.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/LabMeasurement.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorBaseline.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorBaselineSquare.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/StripChart.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliGroup.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliGroupSample.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraCaliSampleData.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraBaseline.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SpectraBaselineSquare.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorReadingGroup.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionSensorGroup.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/FinalDetectionSpectraDetection.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorCali.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/SensorError.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/DAQUtilConfig.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/DAQUtilConfigLineName.hbm.xml");
                remote_cfg.addResource("com/aug/triton/db/remoteentity/TocReading.hbm.xml");
                          	

                remote_sessionFactory = remote_cfg.buildSessionFactory();
                
                
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory local_GetSessionFactory() {
        return local_sessionFactory;
    }
    
    public static SessionFactory remote_GetSessionFactory() {
        return remote_sessionFactory;
    }
}
