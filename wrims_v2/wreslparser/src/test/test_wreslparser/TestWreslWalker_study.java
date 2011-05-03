package test.test_wreslparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.antlr.runtime.RecognitionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrimsv2.commondata.wresldata.ModelDataSet;
import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.RegUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.Tools;
import wrimsv2.wreslparser.elements.WriteCSV;

public class TestWreslWalker_study
{
  public String projectPath = "src\\test\\test_wreslparser\\";
  public String inputFilePath;
  public String logFilePath;
  public String csvFolderPath;

  @Test(groups={"WRESL_elements"})
  public void timeseries()
    throws RecognitionException, IOException
  {
    this.csvFolderPath = "TestWreslWalker_study_timeseries";
    this.inputFilePath = (this.projectPath + this.csvFolderPath + ".wresl");
    this.logFilePath = (this.csvFolderPath + ".log");

    LogUtils.setLogFile(this.logFilePath);

    File absFile = new File(this.inputFilePath).getAbsoluteFile();
    String absFilePath = absFile.getCanonicalPath().toLowerCase();

    TempData td = new TempData();

    StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);

    td.model_dataset_map = StudyParser.parseModels(sc, td);

    StudyDataSet sd = StudyParser.writeWreslData(sc, td);

    LogUtils.studySummary_details(sd);

    LogUtils.closeLogFile();

    WriteCSV.study(sd, this.csvFolderPath);

    String logText = Tools.readFileAsString(this.logFilePath);

    int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
    Assert.assertEquals(totalErrs, 0);

    Set<String> s = new HashSet<String>();
    s.addAll(sd.getTimeseriesMap().keySet());
    Set<String> e = new HashSet<String>();
    e.add("first_global"); e.add("first_local"); e.add("second_local"); e.add("third_global");

    Assert.assertEquals(s, e);
  }

  @Test(groups={"WRESL_elements"})
  public void order() throws RecognitionException, IOException {
    this.csvFolderPath = "TestWreslWalker_study_order";
    this.inputFilePath = (this.projectPath + this.csvFolderPath + ".wresl");
    this.logFilePath = (this.csvFolderPath + ".log");

    LogUtils.setLogFile(this.logFilePath);

    File absFile = new File(this.inputFilePath).getAbsoluteFile();
    String absFilePath = absFile.getCanonicalPath().toLowerCase();

    TempData td = new TempData();

    StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);

    td.model_dataset_map = StudyParser.parseModels(sc, td);

    StudyDataSet sd = StudyParser.writeWreslData(sc, td);

    LogUtils.studySummary_details(sd);

    LogUtils.closeLogFile();

    String modelName = (String)sd.getModelList().get(0);

    WriteCSV.dataset((ModelDataSet)sd.getModelDataSetMap().get(modelName), this.csvFolderPath);

    String logText = Tools.readFileAsString(this.logFilePath);

    int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
    Assert.assertEquals(totalErrs, 0);

    ArrayList<?> s = ((ModelDataSet)sd.getModelDataSetMap().get(modelName)).svList;

    System.out.println("sssss " + s);

    ArrayList<String> e = new ArrayList<String>();
    e.add("zero");

    e.add("first1_include1");
    e.add("first2_include1");

    e.add("second1_include2");
    e.add("second2_include2_include");
    e.add("second3_include2_include");
    e.add("second4_include2");

    e.add("third");

    System.out.println("eeeee " + e);

    Assert.assertEquals(s, e);
  }

  @Test(groups={"WRESL_elements"})
  public void order_simple()
    throws RecognitionException, IOException
  {
    this.csvFolderPath = "TestWreslWalker_study_order_simple";
    this.inputFilePath = (this.projectPath + this.csvFolderPath + ".wresl");
    this.logFilePath = (this.csvFolderPath + ".log");

    LogUtils.setLogFile(this.logFilePath);

    File absFile = new File(this.inputFilePath).getAbsoluteFile();
    String absFilePath = absFile.getCanonicalPath().toLowerCase();

    TempData td = new TempData();

    StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);

    td.model_dataset_map = StudyParser.parseModels(sc, td);

    StudyDataSet sd = StudyParser.writeWreslData(sc, td);

    LogUtils.studySummary_details(sd);

    LogUtils.closeLogFile();

    String modelName = (String)sd.getModelList().get(0);

    WriteCSV.dataset((ModelDataSet)sd.getModelDataSetMap().get(modelName), this.csvFolderPath);

    String logText = Tools.readFileAsString(this.logFilePath);

    int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
    Assert.assertEquals(totalErrs, 0);

    ArrayList<?> s = ((ModelDataSet)sd.getModelDataSetMap().get(modelName)).svList;

    System.out.println("sssss " + s);

    ArrayList<String> e = new ArrayList<String>();

    e.add("first1_include1");
    e.add("first2_include1");
    e.add("second1_include2");
    e.add("second2_include2_include");
    e.add("second3_include2_include");
    e.add("second4_include2");
    Assert.assertEquals(s, e);
  }

  @Test(groups={"WRESL_elements"})
  public void order_case1()
    throws RecognitionException, IOException
  {
    this.csvFolderPath = "TestWreslWalker_study_order_case1";
    this.inputFilePath = (this.projectPath + this.csvFolderPath + ".wresl");
    this.logFilePath = (this.csvFolderPath + ".log");

    LogUtils.setLogFile(this.logFilePath);

    File absFile = new File(this.inputFilePath).getAbsoluteFile();
    String absFilePath = absFile.getCanonicalPath().toLowerCase();

    TempData td = new TempData();

    StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);

    td.model_dataset_map = StudyParser.parseModels(sc, td);

    StudyDataSet sd = StudyParser.writeWreslData(sc, td);

    LogUtils.studySummary_details(sd);

    LogUtils.closeLogFile();

    String modelName = (String)sd.getModelList().get(0);

    WriteCSV.dataset((ModelDataSet)sd.getModelDataSetMap().get(modelName), this.csvFolderPath);

    String logText = Tools.readFileAsString(this.logFilePath);

    int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
    Assert.assertEquals(totalErrs, 0);

    ArrayList<?> s = ((ModelDataSet)sd.getModelDataSetMap().get(modelName)).svList;

    System.out.println("sssss " + s);

    ArrayList<String> e = new ArrayList<String>();

    e.add("first1_include1");
    e.add("first2_include1");

    e.add("second1_include2_include");
    e.add("second2_include2_include");
    e.add("second3_include2");
    e.add("second4_include2");

    e.add("third");

    Assert.assertEquals(s, e);
  }
  @Test(groups={"WRESL_elements"})
  public void order_case1_globals() throws RecognitionException, IOException {
    this.csvFolderPath = "TestWreslWalker_study_order_case1";
    this.inputFilePath = (this.projectPath + this.csvFolderPath + ".wresl");
    this.logFilePath = (this.csvFolderPath + ".log");

    LogUtils.setLogFile(this.logFilePath);

    File absFile = new File(this.inputFilePath).getAbsoluteFile();
    String absFilePath = absFile.getCanonicalPath().toLowerCase();

    TempData td = new TempData();

    StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);

    td.model_dataset_map = StudyParser.parseModels(sc, td);

    StudyDataSet sd = StudyParser.writeWreslData(sc, td);

    LogUtils.studySummary_details(sd);

    LogUtils.closeLogFile();

    String modelName = (String)sd.getModelList().get(2);

    WriteCSV.dataset((ModelDataSet)sd.getModelDataSetMap().get(modelName), this.csvFolderPath);

    String logText = Tools.readFileAsString(this.logFilePath);

    int totalErrs = RegUtils.timesOfMatches(logText, "# Error");
    Assert.assertEquals(totalErrs, 0);

    ArrayList<?> s = ((ModelDataSet)sd.getModelDataSetMap().get(modelName)).svList;

    System.out.println("sssss " + s);

    ArrayList<String> e = new ArrayList<String>();

    e.add("first1_include1");
    e.add("first2_include1");

    e.add("second1_include2_include");
    e.add("second2_include2_include");
    e.add("second3_include2");
    e.add("second4_include2");

    e.add("third");

    e.add("cycle_second");
    e.add("cycle_third");

    Assert.assertEquals(s, e);
  }
}