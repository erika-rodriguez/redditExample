package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(className = "_25r3t_lrPF3M6zD2YkWvZU")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//div[@data-step='username-and-password']/descendant::input[@id='loginUsername']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//*[@id='loginPassword']")
    private ExtendedWebElement password;
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    private ExtendedWebElement loginBtn;
    @FindBy(xpath = "//div[contains(text(),'Incorrect')]")
    private ExtendedWebElement incorrectMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitCredentials() {
        //switchToIFrame();
        username.type(R.TESTDATA.get("username"));
        password.type(R.TESTDATA.get("password"));
        loginBtn.click();
    }

    @Override
    public void switchToIFrame() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame(iframe.getElement());
    }

    @Override
    public boolean areCredentialsIncorrect() {
        return incorrectMessage.isElementPresent();
    }
}
