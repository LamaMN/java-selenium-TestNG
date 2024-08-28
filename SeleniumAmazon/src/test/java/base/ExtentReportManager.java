package base;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		String fileName, directory, path;

		fileName = getReportName();

		directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();

		path = directory + fileName;

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle("AutomationReports");
		sparkReporter.config().setReportName("Test Results");
		sparkReporter.config().setDocumentTitle("AutomationReports");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Lama", "AmazonTest");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(sparkReporter);

		return extent;

	}

	public static String getReportName() {

		Date date = new Date();

		String fileName = "AutomationReport_" + "_" + date.toString().replace(":", "_").replace("\\s", "_") + ".png";

		return fileName;

	}

	
}
