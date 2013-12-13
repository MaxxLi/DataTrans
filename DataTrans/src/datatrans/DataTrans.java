package datatrans;

import com.aug.triton.db.dao.DAO;
import com.aug.triton.db.remoteentity.*;
import java.util.List;

public class DataTrans {

    public static void LoadBar(double percentage) {
        double c = percentage * 60;
        long count = Math.round(c) + 1;
        System.out.print("[");
        for (int i = 1; i <= 60; i++) {
            if (i <= count) {
                System.out.print("#");
            } else {
                System.out.print(' ');
            }
        }
        System.out.print("]" + '\r');

    }
    private static boolean stop = false;

    public static void start(String[] args) {
        System.out.println("start");
        while (!stop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("running");
        }
    }

    public static void stop(String[] args) {
        System.out.println("stop");
        stop = true;
    }

    public static void main(String[] args) {
        while (true) {
            try {
                Cont_Transfer();
                TocReading_Transfer();
                DAQUtilConfig_Transfer();
                DAQUtilConfigLineName_Transfer();
                SensorError_Transfer();
                TapRef_Transfer();
                TapRefData_Transfer();
                SpectraDetection_Transfer();
                LabMeasurement_Transfer();
                SpectraConfig_Transfer();
                EventLog_Transfer();
                Sensor_Transfer();
                FinalDetectionResult_Transfer();
                SensorReadingGroup_Transfer();
                SensorReading_Transfer();
                SpectraReading_Transfer();
                SensorBaseline_Transfer();
                SpectraCaliGroup_Transfer();
                SpectraCaliGroupSample_Transfer();
                SpectraCaliSampleData_Transfer();
                FinalDetectionSpectraDetection_Transfer();
                //        Location_Transfer();
                StripChart_Transfer();
                SensorBaselineSquare_Transfer();
                SensorCali_Transfer();
                FinalDetectionSensorGroup_Transfer();
                SpectraBaseline_Transfer();
                SystemConfig_Transfer();
                SpectraBaselineSquare_Transfer();
                PotentialCont_Transfer();
                Thread.sleep(5000);

            } catch (Exception d) {
                System.out.println(d);
                DAO.close();
            }

        }
    }

  public static void TocReading_Transfer() {
        com.aug.triton.db.remotedao.TocReadingDAOImpl serverDat = new com.aug.triton.db.remotedao.TocReadingDAOImpl();
        com.aug.triton.db.dao.TocReadingDAOImpl localDat = new com.aug.triton.db.dao.TocReadingDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("TocReading Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<TocReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<TocReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (TocReading s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void DAQUtilConfigLineName_Transfer() {
        com.aug.triton.db.remotedao.DAQUtilConfigLineNameDAOImpl serverDat = new com.aug.triton.db.remotedao.DAQUtilConfigLineNameDAOImpl();
        com.aug.triton.db.dao.DAQUtilConfigLineNameDAOImpl localDat = new com.aug.triton.db.dao.DAQUtilConfigLineNameDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("DAQUtilConfigLineName Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<DAQUtilConfigLineName> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<DAQUtilConfigLineName> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (DAQUtilConfigLineName s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraDetection_Transfer() {
        com.aug.triton.db.remotedao.SpectraDetectionDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraDetectionDAOImpl();
        com.aug.triton.db.dao.SpectraDetectionDAOImpl localDat = new com.aug.triton.db.dao.SpectraDetectionDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraDetection Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraDetection> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraDetection> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraDetection s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorError_Transfer() {
        com.aug.triton.db.remotedao.SensorErrorDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorErrorDAOImpl();
        com.aug.triton.db.dao.SensorErrorDAOImpl localDat = new com.aug.triton.db.dao.SensorErrorDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorError Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorError> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorError> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorError s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void Cont_Transfer() {
        com.aug.triton.db.remotedao.ContDAOImpl serverDat = new com.aug.triton.db.remotedao.ContDAOImpl();
        com.aug.triton.db.dao.ContDAOImpl localDat = new com.aug.triton.db.dao.ContDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("Cont Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<Cont> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<Cont> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (Cont s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void LabMeasurement_Transfer() {
        com.aug.triton.db.remotedao.LabMeasurementDAOImpl serverDat = new com.aug.triton.db.remotedao.LabMeasurementDAOImpl();
        com.aug.triton.db.dao.LabMeasurementDAOImpl localDat = new com.aug.triton.db.dao.LabMeasurementDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("LabMeasurement Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<LabMeasurement> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<LabMeasurement> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (LabMeasurement s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void Sensor_Transfer() {
        com.aug.triton.db.remotedao.SensorDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorDAOImpl();
        com.aug.triton.db.dao.SensorDAOImpl localDat = new com.aug.triton.db.dao.SensorDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("Sensor Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<Sensor> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<Sensor> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (Sensor s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorReading_Transfer() {
        com.aug.triton.db.remotedao.SensorReadingDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorReadingDAOImpl();
        com.aug.triton.db.dao.SensorReadingDAOImpl localDat = new com.aug.triton.db.dao.SensorReadingDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorReading Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorReading s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraConfig_Transfer() {
        com.aug.triton.db.remotedao.SpectraConfigDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraConfigDAOImpl();
        com.aug.triton.db.dao.SpectraConfigDAOImpl localDat = new com.aug.triton.db.dao.SpectraConfigDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraConfig Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraConfig> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraConfig> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraConfig s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void EventLog_Transfer() {
        com.aug.triton.db.remotedao.EventLogDAOImpl serverDat = new com.aug.triton.db.remotedao.EventLogDAOImpl();
        com.aug.triton.db.dao.EventLogDAOImpl localDat = new com.aug.triton.db.dao.EventLogDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("EventLog Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<EventLog> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<EventLog> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (EventLog s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraReading_Transfer() {
        com.aug.triton.db.remotedao.SpectraReadingDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraReadingDAOImpl();
        com.aug.triton.db.dao.SpectraReadingDAOImpl localDat = new com.aug.triton.db.dao.SpectraReadingDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraReading Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraReading> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraReading s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorReadingGroup_Transfer() {
        com.aug.triton.db.remotedao.SensorReadingGroupDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorReadingGroupDAOImpl();
        com.aug.triton.db.dao.SensorReadingGroupDAOImpl localDat = new com.aug.triton.db.dao.SensorReadingGroupDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorReadingGroup Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorReadingGroup> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorReadingGroup> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorReadingGroup s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void TapRefData_Transfer() {
        com.aug.triton.db.remotedao.TapRefDataDAOImpl serverDat = new com.aug.triton.db.remotedao.TapRefDataDAOImpl();
        com.aug.triton.db.dao.TapRefDataDAOImpl localDat = new com.aug.triton.db.dao.TapRefDataDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("TapRefData Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<TapRefData> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<TapRefData> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (TapRefData s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorBaseline_Transfer() {
        com.aug.triton.db.remotedao.SensorBaselineDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorBaselineDAOImpl();
        com.aug.triton.db.dao.SensorBaselineDAOImpl localDat = new com.aug.triton.db.dao.SensorBaselineDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorBaseline Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorBaseline> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorBaseline> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorBaseline s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraCaliSampleData_Transfer() {
        com.aug.triton.db.remotedao.SpectraCaliSampleDataDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraCaliSampleDataDAOImpl();
        com.aug.triton.db.dao.SpectraCaliSampleDataDAOImpl localDat = new com.aug.triton.db.dao.SpectraCaliSampleDataDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraCaliSampleData Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraCaliSampleData> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraCaliSampleData> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraCaliSampleData s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void FinalDetectionSpectraDetection_Transfer() {
        com.aug.triton.db.remotedao.FinalDetectionSpectraDetectionDAOImpl serverDat = new com.aug.triton.db.remotedao.FinalDetectionSpectraDetectionDAOImpl();
        com.aug.triton.db.dao.FinalDetectionSpectraDetectionDAOImpl localDat = new com.aug.triton.db.dao.FinalDetectionSpectraDetectionDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("FinalDetectionSpectraDetection Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<FinalDetectionSpectraDetection> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<FinalDetectionSpectraDetection> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (FinalDetectionSpectraDetection s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void Location_Transfer() {
        com.aug.triton.db.remotedao.LocationDAOImpl serverDat = new com.aug.triton.db.remotedao.LocationDAOImpl();
        com.aug.triton.db.dao.LocationDAOImpl localDat = new com.aug.triton.db.dao.LocationDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("Location Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<Location> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<Location> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (Location s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void StripChart_Transfer() {
        com.aug.triton.db.remotedao.StripChartDAOImpl serverDat = new com.aug.triton.db.remotedao.StripChartDAOImpl();
        com.aug.triton.db.dao.StripChartDAOImpl localDat = new com.aug.triton.db.dao.StripChartDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("StripChart Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<StripChart> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<StripChart> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (StripChart s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorBaselineSquare_Transfer() {
        com.aug.triton.db.remotedao.SensorBaselineSquareDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorBaselineSquareDAOImpl();
        com.aug.triton.db.dao.SensorBaselineSquareDAOImpl localDat = new com.aug.triton.db.dao.SensorBaselineSquareDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorBaselineSquare Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorBaselineSquare> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorBaselineSquare> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorBaselineSquare s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SensorCali_Transfer() {
        com.aug.triton.db.remotedao.SensorCaliDAOImpl serverDat = new com.aug.triton.db.remotedao.SensorCaliDAOImpl();
        com.aug.triton.db.dao.SensorCaliDAOImpl localDat = new com.aug.triton.db.dao.SensorCaliDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SensorCali Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SensorCali> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SensorCali> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SensorCali s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void FinalDetectionSensorGroup_Transfer() {
        com.aug.triton.db.remotedao.FinalDetectionSensorGroupDAOImpl serverDat = new com.aug.triton.db.remotedao.FinalDetectionSensorGroupDAOImpl();
        com.aug.triton.db.dao.FinalDetectionSensorGroupDAOImpl localDat = new com.aug.triton.db.dao.FinalDetectionSensorGroupDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("FinalDetectionSensorGroup Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<FinalDetectionSensorGroup> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<FinalDetectionSensorGroup> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (FinalDetectionSensorGroup s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraCaliGroupSample_Transfer() {
        com.aug.triton.db.remotedao.SpectraCaliGroupSampleDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraCaliGroupSampleDAOImpl();
        com.aug.triton.db.dao.SpectraCaliGroupSampleDAOImpl localDat = new com.aug.triton.db.dao.SpectraCaliGroupSampleDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraCaliGroupSample Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraCaliGroupSample> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraCaliGroupSample> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraCaliGroupSample s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void FinalDetectionResult_Transfer() {
        com.aug.triton.db.remotedao.FinalDetectionResultDAOImpl serverDat = new com.aug.triton.db.remotedao.FinalDetectionResultDAOImpl();
        com.aug.triton.db.dao.FinalDetectionResultDAOImpl localDat = new com.aug.triton.db.dao.FinalDetectionResultDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("FinalDetectionResult Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<FinalDetectionResult> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<FinalDetectionResult> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (FinalDetectionResult s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraCaliGroup_Transfer() {
        com.aug.triton.db.remotedao.SpectraCaliGroupDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraCaliGroupDAOImpl();
        com.aug.triton.db.dao.SpectraCaliGroupDAOImpl localDat = new com.aug.triton.db.dao.SpectraCaliGroupDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraCaliGroup Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraCaliGroup> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraCaliGroup> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraCaliGroup s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraBaseline_Transfer() {
        com.aug.triton.db.remotedao.SpectraBaselineDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraBaselineDAOImpl();
        com.aug.triton.db.dao.SpectraBaselineDAOImpl localDat = new com.aug.triton.db.dao.SpectraBaselineDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraBaseline Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraBaseline> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraBaseline> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraBaseline s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void TapRef_Transfer() {
        com.aug.triton.db.remotedao.TapRefDAOImpl serverDat = new com.aug.triton.db.remotedao.TapRefDAOImpl();
        com.aug.triton.db.dao.TapRefDAOImpl localDat = new com.aug.triton.db.dao.TapRefDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("TapRef Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<TapRef> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<TapRef> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (TapRef s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SystemConfig_Transfer() {
        com.aug.triton.db.remotedao.SystemConfigDAOImpl serverDat = new com.aug.triton.db.remotedao.SystemConfigDAOImpl();
        com.aug.triton.db.dao.SystemConfigDAOImpl localDat = new com.aug.triton.db.dao.SystemConfigDAOImpl();
        try {
            Short local_maxID = (localDat.maxID());
            Short server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SystemConfig Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (short)1000){
			    while (local_maxID > server_maxID) {
				  List<SystemConfig> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SystemConfig> list = localDat.listByID((short) (server_maxID + 1), (short) Math.min(server_maxID + 1000, local_maxID));
				  for (SystemConfig s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void SpectraBaselineSquare_Transfer() {
        com.aug.triton.db.remotedao.SpectraBaselineSquareDAOImpl serverDat = new com.aug.triton.db.remotedao.SpectraBaselineSquareDAOImpl();
        com.aug.triton.db.dao.SpectraBaselineSquareDAOImpl localDat = new com.aug.triton.db.dao.SpectraBaselineSquareDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("SpectraBaselineSquare Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<SpectraBaselineSquare> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<SpectraBaselineSquare> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (SpectraBaselineSquare s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void DAQUtilConfig_Transfer() {
        com.aug.triton.db.remotedao.DAQUtilConfigDAOImpl serverDat = new com.aug.triton.db.remotedao.DAQUtilConfigDAOImpl();
        com.aug.triton.db.dao.DAQUtilConfigDAOImpl localDat = new com.aug.triton.db.dao.DAQUtilConfigDAOImpl();
        try {
            int local_maxID = (localDat.maxID());
            int server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("DAQUtilConfig Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (int)1000){
			    while (local_maxID > server_maxID) {
				  List<DAQUtilConfig> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<DAQUtilConfig> list = localDat.listByID((int) (server_maxID + 1), (int) Math.min(server_maxID + 1000, local_maxID));
				  for (DAQUtilConfig s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



public static void PotentialCont_Transfer() {
        com.aug.triton.db.remotedao.PotentialContDAOImpl serverDat = new com.aug.triton.db.remotedao.PotentialContDAOImpl();
        com.aug.triton.db.dao.PotentialContDAOImpl localDat = new com.aug.triton.db.dao.PotentialContDAOImpl();
        try {
            Long local_maxID = (localDat.maxID());
            Long server_maxID = (serverDat.maxID());
            if (local_maxID > server_maxID) {
                double DataNum = (double)(local_maxID - server_maxID);
                System.out.println("PotentialCont Transferring: " +(local_maxID - server_maxID)+" rows");
		    LoadBar(0);
			if(local_maxID - server_maxID >= (long)1000){
			    while (local_maxID > server_maxID) {
				  List<PotentialCont> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  serverDat.bulkCreate(list);
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
				  }
				}

			else
			{
				while (local_maxID > server_maxID) {
				  List<PotentialCont> list = localDat.listByID((long) (server_maxID + 1), (long) Math.min(server_maxID + 1000, local_maxID));
				  for (PotentialCont s : list) {
					if (s != null) {
					    serverDat.create(s);
					}
				  }
				  server_maxID = (serverDat.maxID());
				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));
			    }
			}
                 System.out.println();
		}
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}