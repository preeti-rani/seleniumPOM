//wrapper for functions to be used multiple times in tests
package com.miro.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitForHelper {

    public WebDriver driver;

    public WaitForHelper(WebDriver driver){
        this.driver = driver;
    }
    public void implicitwait()
    {
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.readItem("elementLoadTimeout")),TimeUnit.SECONDS);
    }

    public WebElement presenceOfTheElement(final By elementIdentifier) {
        WebElement firstResult = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return firstResult;
    }

    public WebElement elementToBeClickable(final By elementIdentifier){
        WebElement element = new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
        return element;
    }

}
