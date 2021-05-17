package com.miro.base;

import com.miro.utils.PropertyReader;
import com.miro.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BasePage {

    //Navigate
    //Wait for Element
    //Wait for Item
    //Click
    //Write Text
    //Read Text
    //Move to Element

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver; //Whatever driver is assigned to Webdriver will be used here,driver instance
    }
    //open url method
    public void gotoURL(String url) {
        driver.get(url);
    }

    //wait method
    public void waitForElementToAppear(By elementLocation) {
        //Conditional wait for one of the elements on the search results page to be present
        new WaitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    public void waitForTime() {
        //Conditional wait for one of the elements on the search results page to be present
        new WaitForHelper(driver).implicitwait( );
    }

    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click( );
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).clear( );
        driver.findElement(elementLocation).sendKeys(text);
    }


    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText( );
    }

    // Move to Element
    public void moveToElement(By elementLocation) {

        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build( ).perform( );

    }

    //Window/Tab handle
    public void windowHandle(By elementLocation, String text){
        String ParentWindowHandle = driver.getWindowHandle();
        driver.findElement(elementLocation).click();
        for(String childTab:driver.getWindowHandles()){
            driver.switchTo().window(childTab);
        }
        Assert.assertEquals(driver.getTitle(), text);
        driver.close();
        driver.switchTo().window(ParentWindowHandle);
    }


}