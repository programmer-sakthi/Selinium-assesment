package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    ExtentReports er;

    public ExtentReports log() {
        File file = new File("reports/report.html");
        ExtentSparkReporter ers = new ExtentSparkReporter(file);
        er = new ExtentReports();
        er.attachReporter(ers);
        return er;

    }
}
