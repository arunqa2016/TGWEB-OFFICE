package com.tgweb.extentReportListener;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReporterNG implements IReporter {

	private ExtentReports extent;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		System.out.println("Extent Report Listener.");
		
		
		
	}

}
