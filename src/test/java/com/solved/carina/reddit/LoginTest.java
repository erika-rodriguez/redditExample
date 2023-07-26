package com.solved.carina.reddit;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.LoginPageBase;
import com.solved.carina.reddit.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {
    @Test
    public void loginTest(){
        HomePage home=new HomePage(getDriver());
        home.open();
        LoginPageBase login =home.clickOnLoginBtn();
        login.cancelAlert();
        login.submitCredentials();

    }
}
