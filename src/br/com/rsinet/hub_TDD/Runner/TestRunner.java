//package br.com.rsinet.HUB_TDD.Runner;
//
//import java.io.*;
//import org.junit.AfterClass;
//import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//	features = "src/test/resources/functionalTests",
//	glue= {"stepDefinitions"},
//	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
//	monochrome = true
//	)
// 
//
//public class TestRunner {
//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(new File);
//		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//	}
//}