package com.yogesh.nipte.listeners;

import com.yogesh.nipte.utils.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v135.page.model.Screenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListeners implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure ....");
        TakesScreenshot driver =  (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
        String screenshot = driver.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=1000px src='data:image/png;base64, %s'/>";
        String htmlImage = String.format(htmlImageFormat,screenshot);
        Reporter.log(htmlImage);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" Started .....");
    }
}
