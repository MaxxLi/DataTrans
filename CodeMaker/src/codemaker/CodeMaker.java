/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codemaker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author IWM
 */
public class CodeMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String srcFolder = "Z:/Max/newLoad/dao";
        //FileParser(srcFolder, destFolder);
        CodeParser(srcFolder);
        FileParser("Z:/Max/Copied/", "Z:/Max/NewCode/dao");
        
    }

    public static void FileParser(String filePath, String copyPath) {

        final File folder = new File(filePath);
        File[] files = folder.listFiles();
        new File(copyPath).mkdir();

        for (File f : files) {
            File destFile = new File(copyPath + "/" + f.getName());
            try {
                FileUtils.copyFile(f, destFile);
            } catch (Exception e) {
            }
        }
    }

    public static void CodeParser(String filePath) {
        final File folder = new File(filePath);
        File[] files = folder.listFiles();
        File[] implFiles = new File[files.length];
        File[] daoFiles = new File[files.length];
        int implCounter = 1;
        int daoCounter = 1;

        for (File f : files) {
            if (f.getName().contains("DAOImpl.java")) {
                implFiles[implCounter] = f;
                implCounter++;
            }
            if (f.getName().contains("DAO.java") && !(f.getName().contentEquals("DAO.java"))) {
                daoFiles[daoCounter] = f;
                daoCounter++;
            }

        }

        ImplParser(implFiles);
        DAOParser(daoFiles);

        //MainParser(daoFiles);






    }

    public static void ImplParser(File[] implFiles) {
        int lineCounter = 0;
        int writeCounter = 0;
        File writeFile;
        FileInputStream is;
        BufferedReader reader;
        InputStreamReader isr;
        FileOutputStream os;
        OutputStreamWriter osr;
        BufferedWriter writer;
        String typeArr[];
        String Type, type;

        for (File f : implFiles) {
            try {
                typeArr = TypeGetter(f);
                Type = typeArr[0];
                type = typeArr[1];
                writeFile = new File("Z:/Max/Copied/" + f.getName());
                writeCounter = 0;
                is = new FileInputStream(f);
                isr = new InputStreamReader(is);
                reader = new BufferedReader(isr);
                while (reader.readLine() != null) {
                    lineCounter++;
                }
                is.close();
                isr.close();
                reader.close();

                is = new FileInputStream(f);
                isr = new InputStreamReader(is);
                reader = new BufferedReader(isr);

                os = new FileOutputStream(writeFile);
                osr = new OutputStreamWriter(os);
                writer = new BufferedWriter(osr);
                String i;
                String objName;

                while ((i = reader.readLine()) != null) {
                    writeCounter++;
                    if (writeCounter == lineCounter) {
                        objName = f.getName().replace("DAOImpl.java", "");
                        writer.newLine();
                        writer.write("    @Override");
                        writer.newLine();
                        writer.write("    public " + Type + " minID(){");
                        writer.newLine();
                        writer.write("        Query q = getSession().createQuery(");
                        writer.newLine();
                        writer.write("              			\"select min(id) from " + objName + "\");");
                        writer.write("        "+Type+" s = ("+type+")0;");
                        writer.newLine();
                        writer.newLine();
                        writer.write("        if(q.uniqueResult() != null)");
                        writer.newLine();
                        writer.write("        {");
                        writer.newLine();
                        writer.write("         s = ("+Type+")q.uniqueResult();");
                        writer.newLine();
                        writer.write("        }");
                        writer.newLine();
                        writer.write("         return s;");
                        writer.newLine();
                        writer.write("    }");
                        writer.newLine();
                    }
                    writer.write(i);
                    writer.newLine();
                }

                writer.close();
                lineCounter = 0;

            } catch (Exception e) {
            }
        }
    }

    public static void DAOParser(File[] implFiles) {
        int lineCounter = 0;
        int writeCounter = 0;
        File writeFile;
        FileInputStream is;
        BufferedReader reader;
        InputStreamReader isr;
        FileOutputStream os;
        OutputStreamWriter osr;
        BufferedWriter writer;
        String typeArr[];
        String Type, type;
        for (File f : implFiles) {
            try {
                typeArr = TypeGetter(f);
                Type = typeArr[0];
                type = typeArr[1];
                writeFile = new File("Z:/Max/Copied/" + f.getName());
                writeCounter = 0;
                is = new FileInputStream(f);
                isr = new InputStreamReader(is);
                reader = new BufferedReader(isr);
                while (reader.readLine() != null) {
                    lineCounter++;
                }
                is.close();
                isr.close();
                reader.close();

                is = new FileInputStream(f);
                isr = new InputStreamReader(is);
                reader = new BufferedReader(isr);

                os = new FileOutputStream(writeFile);
                osr = new OutputStreamWriter(os);
                writer = new BufferedWriter(osr);
                String i;
                String objName;
                while ((i = reader.readLine()) != null) {
                    writeCounter++;
                    if (writeCounter == lineCounter) {
                        objName = f.getName().replace("DAO.java", "");
                        writer.newLine();
                        writer.write("    " + Type + " minID() throws AppException;");
                        writer.newLine();
                    }
                    writer.write(i);
                    writer.newLine();
                }

                writer.close();
                lineCounter = 0;

            } catch (Exception e) {
            }
        }

    }

    public static void MainParser(File[] implFiles) {
        File writeFile;
        FileOutputStream os;
        OutputStreamWriter osr;
        BufferedWriter writer;
        String objName;
        String typeArr[] = new String[2];
        String Type, type;
        try {
            writeFile = new File("Z:/Max/Copied/DataTrans.java");
            os = new FileOutputStream(writeFile);
            osr = new OutputStreamWriter(os);
            writer = new BufferedWriter(osr);
            writer.write("package datatrans;");
            writer.newLine();
            writer.newLine();
            writer.write("import com.aug.triton.db.entity.*;");
            writer.newLine();
            writer.write("import java.util.Date;");
            writer.newLine();
            writer.write("import java.util.List;");
            writer.newLine();
            writer.write("import java.lang.Class;");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write("public class DataTrans {");
            writer.newLine();
            writer.write("    public static void main(String[] args){");
            writer.newLine();
            for (File f : implFiles) {
                if (f != null) {
                    objName = f.getName().replace("DAO.java", "");
                    writer.write("        " + objName + "_Transfer();");
                    writer.newLine();
                }
            }
            writer.write("    }");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.newLine();

            for (File f : implFiles) {
                if (f != null) {
                    typeArr = TypeGetter(f);
                    Type = typeArr[0];
                    type = typeArr[1];
                    objName = f.getName().replace("DAO.java", "");
                    writer.write("public static void " + objName + "_Transfer() {");
                    writer.newLine();
                    writer.write("        com.aug.triton.db.remotedao." + objName + "DAOImpl serverDat = new com.aug.triton.db.remotedao." + objName + "DAOImpl();");
                    writer.newLine();
                    writer.write("        com.aug.triton.db.dao." + objName + "DAOImpl localDat = new com.aug.triton.db.dao." + objName + "DAOImpl();");
                    writer.newLine();
                    writer.write("        try {");
                    writer.newLine();
                    writer.write("            " + Type + " local_maxID = (localDat.maxID());");
                    writer.newLine();
                    writer.write("            " + Type + " server_maxID = (serverDat.maxID());");
                    writer.newLine();
                    writer.write("            if (local_maxID > server_maxID) {");
                    writer.newLine();
                    writer.write("                double DataNum = (double)(local_maxID - server_maxID);");
                    writer.newLine();
                    writer.write("                System.out.println(\"" + objName + " Transferring: \" +(local_maxID - server_maxID)+\" rows\");");
                    writer.newLine();
                    writer.write("		    LoadBar(0);");
                    writer.newLine();
                    writer.write("			if(local_maxID - server_maxID >= (" + type + ")1000){");
                    writer.newLine();
                    writer.write("			    while (local_maxID > server_maxID) {");
                    writer.newLine();
                    writer.write("				  List<" + objName + "> list = localDat.listByID((" + type + ") (server_maxID + 1), (" + type + ") Math.min(server_maxID + 1000, local_maxID));");
                    writer.newLine();
                    writer.write("				  serverDat.bulkCreate(list);");
                    writer.newLine();
                    writer.write("				  server_maxID = (serverDat.maxID());");
                    writer.newLine();
                    writer.write("				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));");
                    writer.newLine();
                    writer.write("				  }");
                    writer.newLine();
                    writer.write("				}");
                    writer.newLine();
                    writer.newLine();
                    writer.write("			else");
                    writer.newLine();
                    writer.write("			{");
                    writer.newLine();
                    writer.write("				while (local_maxID > server_maxID) {");
                    writer.newLine();
                    writer.write("				  List<" + objName + "> list = localDat.listByID((" + type + ") (server_maxID + 1), (" + type + ") Math.min(server_maxID + 1000, local_maxID));");
                    writer.newLine();
                    writer.write("				  for (" + objName + " s : list) {");
                    writer.newLine();
                    writer.write("					if (s != null) {");
                    writer.newLine();
                    writer.write("					    serverDat.create(s);");
                    writer.newLine();
                    writer.write("					}");
                    writer.newLine();
                    writer.write("				  }");
                    writer.newLine();
                    writer.write("				  server_maxID = (serverDat.maxID());");
                    writer.newLine();
                    writer.write("				LoadBar((double)1 - ((local_maxID - server_maxID)/DataNum));");
                    writer.newLine();
                    writer.write("			    }");
                    writer.newLine();
                    writer.write("			}");
                    writer.newLine();
                    writer.write("                 System.out.println();");
                    writer.newLine();
                    writer.write("		}");
                    writer.newLine();
                    writer.write("        } catch (Exception e) {");
                    writer.newLine();
                    writer.write("            System.out.println(e);");
                    writer.newLine();
                    writer.write("        }");
                    writer.newLine();
                    writer.write("    }");
                    writer.newLine();
                    writer.newLine();
                    writer.newLine();
                    writer.newLine();
                }
            }
            writer.write("}");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String[] TypeGetter(File f) {
        FileInputStream is;
        BufferedReader reader;
        InputStreamReader isr;
        boolean flag = false;
        String buff;
        String retVal[] = new String[2];
        try {
            is = new FileInputStream(f);
            isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);
            while (flag != true) {
                buff = reader.readLine();
                if (buff == null) {
                    break;
                }
                if (buff.contains("get(")) {
                    if (buff.contains("Short") | buff.contains("short")) {
                        retVal[0] = "Short";
                        retVal[1] = "short";
                        return retVal;
                    }
                    if (buff.contains("Long")) {
                        retVal[0] = "Long";
                        retVal[1] = "long";
                        return retVal;
                    }
                    if (buff.contains("int")) {
                        retVal[0] = "int";
                        retVal[1] = "int";
                        return retVal;
                    }

                }
            }
            isr.close();
            is.close();
            reader.close();

        } catch (Exception e) {
        }
        return retVal;


    }

    public static void CodeInsert(BufferedWriter w, String objName) {
//        String[] table = {"Cont", "DAQUtilConfig", "DAQUtilConfigLineName", "EventLog",
//                            "FinalDetectionResult", "FinalDetectionSensorGroup", "FinalDetectionSpectraDetection",
//                            "LabMeasurement", "Location", "PotentialCont", "Sensor", "SensorBaseline","SensorBaselineSquare",
//                            "SensorCali", "SensorError", "SensorReading", "SensorReadingGroup", "SpectraBaseline",
//                            "SpectraBaselineSquare", "SpectraCaliGroup", "SpectraCaliGroupSample", "SpectraCaliSampleData", "SpectraConfig",
//                            "SpectraDetection", "SpectraReading", "StripChart", "SystemConfig", "TapRef", "TapRefData", "TocReading"};
        try {

            w.write("@Override");
            w.newLine();
            w.write("public Long maxID(){");
            w.newLine();
            w.write("Query q = getSession().createQuery(");
            w.newLine();
            w.write("					\"select max(id) from " + objName + "\");");
            w.newLine();
            w.write("	Long s = (Long)q.uniqueResult();");
            w.newLine();
            w.write("	return s;");
            w.newLine();
            w.write("}");
            w.newLine();

        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }

    }
}
