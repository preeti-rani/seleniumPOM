package com.miro.pages;

import com.miro.base.BasePage;
import com.miro.utils.Log;
import com.miro.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);   //Parent constructor to call driver from waitforhelper
        this.driver = driver;
    }
    // Page Locators

    By name = By.id("name" );
    By email = By.id("email" );
    By password = By.id("password" );
    By checkboxTerms = By.cssSelector(".mr-checkbox-1__check[for=signup-terms]");
    By checkboxNews = By.cssSelector(".mr-checkbox-1__check[for=signup-subscribe]");
    By getStartedNow = By.cssSelector("button.signup__submit");
    By ErrorEmail = By.cssSelector("div.signup__error-item");
    By ErrorPwd = By.cssSelector(("div.signup__input-hint-text"));
    By Terms = By.linkText("Terms");
    By TermsOfService = By.cssSelector("h2. click(checkboxTerms)");
    By Policy = By.linkText("Privacy Policy");
    By PrivacyPolicy = By.cssSelector("h2.legal-features-1__sectiontitle");
    By SuccessMsg = By.cssSelector("h1.signup__title-form" );
    By DropDown = By.xpath(".//*[@class='cxl-dropdown__title-wrap']");
    By Select = By.xpath(".//*[@class='cxl-dropdown__menu-item'][3]");

    // Page Actions

    public void OpenRegistractionPage(){
        gotoURL(PropertyReader.readItem("url"));
        Assert.assertEquals(driver.getTitle(),PropertyReader.readItem("expectedLoginPageTitle"));
    }

    public void RegistrationWithValidCredentials() {
        writeText(name,PropertyReader.readItem("name"));
        writeText(email,PropertyReader.readItem("email"));
        writeText(password,PropertyReader.readItem("password"));

    //Web element "How did you hear about us?" is not always present hence using try/catch
        boolean present;
        try {
            click(DropDown);
            click(Select);
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        //Handle multiple tabs
        windowHandle(Terms,PropertyReader.readItem("expectedTermsTitle"));
        windowHandle(Policy,PropertyReader.readItem("expectedPrivacyTitle"));
        click(checkboxTerms);
        click(checkboxNews);
        click(getStartedNow);

        //driver.findElement(getStartedNow).click();

        //Assertion for Success registration msg
        String msg = readText(SuccessMsg);
        Assert.assertEquals(msg,PropertyReader.readItem("successMessage"));
    }

    public void EmailError(){
        writeText(name,PropertyReader.readItem("name"));
        writeText(email,PropertyReader.readItem("email1"));
        writeText(password,PropertyReader.readItem("password"));
        click(checkboxTerms);
        click(getStartedNow);
        //Assertion for error msg
        String msg = readText(ErrorEmail);
        Assert.assertEquals(msg,PropertyReader.readItem("expectedEmailError"));
    }

    public void PasswordError(){
        writeText(name,PropertyReader.readItem("name"));
        writeText(email,PropertyReader.readItem("email"));
        writeText(password,PropertyReader.readItem("password1"));
        //Assertion for error msg
        waitForElementToAppear(ErrorPwd);
        String msg = readText(ErrorPwd);
        Assert.assertEquals(msg,PropertyReader.readItem("expectedPasswordError"));

    }

}