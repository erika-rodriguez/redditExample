package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = LoginPageBase.class)

public class LoginPage extends LoginPageBase {
    @FindBy(xpath = "//div[@data-step='username-and-password']/descendant::input[@id='loginUsername']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//*[@id='loginPassword']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    private ExtendedWebElement loginBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitCredentials() {
        //pause(10000);
        username.type(R.TESTDATA.get("username"));
        password.type(R.TESTDATA.get("password"));
        loginBtn.click();
    }
}
