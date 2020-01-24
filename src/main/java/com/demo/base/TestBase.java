package com.demo.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static AppiumDriver appiumDriver = null;
    public static String platform = null;
    private static ExtentReports extent;

    @Parameters({"OS", "deviceName", "version", "udid", "host", "port"})
    @BeforeMethod
    public static AppiumDriver setupDriver(String OS, String deviceName, String version, String udid,
                                           @Optional("localhost") String host, @Optional("4723") String port) throws IOException {
        platform = OS;
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        if (OS.equalsIgnoreCase("android")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            cap.setCapability(MobileCapabilityType.APP_PACKAGE, "");
            cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "");
            cap.setCapability(MobileCapabilityType.APP, System.getProperty("") + "");
            appiumDriver = new AndroidDriver(new URL("http://" + host + ":" + port + "/wd/hub"), cap);
        } else {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            cap.setCapability(MobileCapabilityType.UDID, udid);
            cap.setCapability("bundleId", "");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
            appiumDriver = new IOSDriver(new URL("http://" + host + ":" + port + "/wd/hub"), cap);
        }
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return appiumDriver;
    }


    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentTestManager.setOutputDirectory(context);
        extent = ExtentTestManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(ExtentTestManager.getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(ExtentTestManager.getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED : " + result.getName());
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED : " + result.getName() + " :: " + ExtentTestManager.getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED : " + result.getName());
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.captureScreenshot(appiumDriver, result.getName());
        }
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    @AfterMethod
    public void cleanUp() {
        appiumDriver.quit();
    }

    public void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) {
        }
    }


}


