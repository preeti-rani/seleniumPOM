package com.miro.tests;

import com.miro.base.TestBase;
import com.miro.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
//driver from testbase is getting from driver manager , in test base from reader file
public class TestError extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test: Verify Email error")
    @Test
    public void EmailError() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenRegistractionPage( );
        loginPage.EmailError();
        takeScreenshot("Email error");

    }
    @Description("Test: Verify Password error")
    @Test
    public void PasswordError(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenRegistractionPage( );
        loginPage.PasswordError();
        takeScreenshot("Password error");
    }

}
