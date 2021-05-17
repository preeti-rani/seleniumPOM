package com.miro.tests;

import com.miro.base.TestBase;
import com.miro.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
//driver from testbase is getting from driver manager , in test base from reader file
public class TestLogin extends TestBase {
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Successfull Registration")
    @Test
    public void login() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.OpenRegistractionPage( );
        loginPage.RegistrationWithValidCredentials( );
        takeScreenshot("Successfull registration: Check your email");
    }

}
