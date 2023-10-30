package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(xpath = "//span[@id='login-username-container']/descendant::input[@id='login-username']")
    private ExtendedWebElement username;
    @FindBy(xpath = "//span[@id='login-password-container']/descendant::input[@id='login-password']")
    private ExtendedWebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void submitCredentials(){
        username.type(R.TESTDATA.get("username"));
        password.type(R.TESTDATA.get("password"));

        //Option 1: Using JavaScriptExecutor
        //the login btn is inside 3 nested shadow DOM tag
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        WebElement loginBtn=(WebElement) jse.executeScript("return document.querySelector('shreddit-overlay-display[class=\"theme-beta\"]').shadowRoot.querySelector('shreddit-signup-drawer').shadowRoot.querySelector('shreddit-slotter[slot-name=\"login\"]').shadowRoot.querySelector('shreddit-async-loader:nth-child(1) > auth-flow-login:nth-child(1) > faceplate-form:nth-child(1) > faceplate-tabpanel:nth-child(1) > auth-flow-modal:nth-child(1) > div:nth-child(3) > faceplate-tracker:nth-child(1) > button:nth-child(1)')");
        loginBtn.click();

        //Option 2: Using Selenium WebDriver’s getShadowDom() method.
        //This Element is inside 3 nested shadow DOM.
//        String cssSelectorForHost1 = "shreddit-overlay-display[class='theme-beta']";
//        String cssSelectorForHost2 = "shreddit-signup-drawer";
//        String cssSelectorForHost3 = "shreddit-slotter[slot-name='login']";
//        Thread.sleep(1000);
//        SearchContext shadow0 = driver.findElement(By.cssSelector("shreddit-overlay-display[class='theme-beta']")).getShadowRoot();
//        Thread.sleep(1000);
//        SearchContext shadow1 = shadow0.findElement(By.cssSelector("shreddit-signup-drawer")).getShadowRoot();
//        Thread.sleep(1000);
//        SearchContext shadow2 = shadow1.findElement(By.cssSelector("shreddit-slotter[slot-name='login']")).getShadowRoot();
//        Thread.sleep(1000);
//        WebElement loginBtn= shadow2.findElement(By.cssSelector(" shreddit-async-loader:nth-child(1) > auth-flow-login:nth-child(1) > faceplate-form:nth-child(1) > faceplate-tabpanel:nth-child(1) > auth-flow-modal:nth-child(1) > div:nth-child(3) > faceplate-tracker:nth-child(1) > button:nth-child(1)"));
//        loginBtn.click();
    }

    @Override
    public void switchToIFrame() throws InterruptedException {
        Thread.sleep(3000);
        //if the iframe is inside a shadow DOM tag:
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        ExtendedWebElement iframe=(ExtendedWebElement) jse.executeScript("return document.querySelector('shreddit-app>shreddit-overlay-display').shadowRoot.querySelector('shreddit-signup-drawer').shadowRoot.querySelector('shreddit-drawer>div>shreddit-async-loader>div>shreddit-slotter').shadowRoot.querySelector('shreddit-async-loader>auth-flow-login>faceplate-form>faceplate-tabpanel>auth-flow-modal').shadowRoot.querySelector('div')");
        driver.switchTo().frame(iframe.getElement());
    }

    @Override
    public boolean areCredentialsIncorrect() {
        //the incorrect credentials message is inside 5 nested shadow DOM tag:
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        WebElement incorrectMessage=(WebElement) jse.executeScript("return document.querySelector('shreddit-overlay-display[class=\"theme-beta\"]').shadowRoot.querySelector('shreddit-signup-drawer').shadowRoot.querySelector('shreddit-slotter[slot-name=\"login\"]').shadowRoot.querySelector('#login-username').shadowRoot.querySelector('faceplate-form-helper-text[placeholder=\" \"]').shadowRoot.querySelector('#helper-text')");
        return incorrectMessage.isDisplayed();
    }
}
