package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {
    @FindBy(xpath = "//div[@id='email-verification-tooltip-id']/..//a")
    private ExtendedWebElement loginBtn;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginBtn() {
        loginBtn.click();
        return new LoginPage(getDriver());
    }
}
