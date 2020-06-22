package DogBreedTestCases;

import Utilities.Helper;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {

    ExtentReports test;
    public ExtentTest ext;

    public void report(){

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports" + File.separator + "DogBreedAPI+"+ Helper.getCurrentDateTime() +".html");
        htmlReporter.config().setReportName("");
        htmlReporter.config().setDocumentTitle("");
        htmlReporter.config().setTheme(Theme.DARK);
        test = new ExtentReports();
        test.attachReporter(htmlReporter);

        ext = test.createTest("Report");
        ext.assignAuthor("Mpumelelo Dube");
        ext.info("Loading Test cases");
        ext.log(Status.INFO, "Dog Breed Test Cases are starting");

    }

    @AfterMethod
    public void getResults(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE){

            ext.fail(result.getThrowable().getMessage());
            ext.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));

        }else if (result.getStatus() == ITestResult.SUCCESS){

            ext.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));

        }else {

            //ext.skip(result.getThrowable().getMessage());
            ext.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " Test Case SKIPPED", ExtentColor.YELLOW));
        }
    }



}