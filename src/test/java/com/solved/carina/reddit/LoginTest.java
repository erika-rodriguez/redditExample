package com.solved.carina.reddit;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    @Test
    public void loginTest() {
        //disable popup notifications
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--disable-notifications");

        HomePageBase home=initPage(getDriver(), HomePageBase.class);
        home.open();
        LoginPageBase login =home.clickOnLoginBtn();
        login.submitCredentials();
    }
}
