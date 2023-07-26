package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends LoginPageBase {
    @FindBy(xpath = "//input[@id='loginUsername']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//input[@id='loginPassword']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    private ExtendedWebElement loginBtn;
    protected LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitCredentials() {
        username.type(R.TESTDATA.get("username"));
        password.type(R.TESTDATA.get("password"));
        loginBtn.click();
    }
}
