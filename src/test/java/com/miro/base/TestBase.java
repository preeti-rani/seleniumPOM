package com.miro.base;

import com.miro.utils.DriverManager;
import com.miro.utils.PropertyReader;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.miro.utils.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class TestBase extends DriverManager {

    public WebDriver driver;
    PropertyReader pr = new PropertyReader( );

    public TestBase() {

        this.driver = super.getDriver( );
        Log.info("Getting WebDriver Settings");

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {

            if (PropertyReader.readItem("browser").equals("chrome")) {
                Log.info("Found chrome as Browser");
                System.setProperty("webdriver.chrome.driver","/Users/preetirani/Downloads/selenium/chromedriver");
                driver = new ChromeDriver( );
                driver.manage( ).window( ).maximize( );

            } else {
                try {
                    throw new Exception("Browser or Browser Driver is not supported yet.");
                } catch (Exception e) {
                    Log.error("Browser Launch Failure: ", e);
                }
            }
        } catch (Exception e) {
            Log.error("Chrome Launch Failure: ", e);

        }
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        Log.info("Closing Webdriver Windows");
        driver.quit( );
    }

    //Take Screenshot
    public void takeScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
