package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(HomePage.class));
    @FindBy(xpath = "//a[contains(@href,'login')]")
    //"//div[@id='email-verification-tooltip-id']/..//a"
    private ExtendedWebElement loginBtn;
    @FindBy(xpath = "(//shreddit-post/a[contains(@id,'post-title')])[1]")
    private ExtendedWebElement firstPostTitle;
    @FindBy(xpath = "//faceplate-tracker/button")
    private ExtendedWebElement getAppBtn;
    @FindBy(xpath = "//section/h3")
    private ExtendedWebElement getAppTxt;
    //searchBar is inside 2 nested shadow DOM.



    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPageBase clickOnLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(),LoginPageBase.class);
    }
    @Override
    public String getPostTitle() {
        LOGGER.info(firstPostTitle.getText());
        return firstPostTitle.getText();
    }

    @Override
    public String clickOnGetAppBtn() {
        getAppBtn.click();
        LOGGER. info(getAppTxt.getText());
        return getAppTxt.getText();
    }

    @Override
    public void clickOnSearchBar() {
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        WebElement searchBar=(WebElement) jse.executeScript("return document.querySelector('reddit-search-large').shadowRoot.querySelector('#search-input').shadowRoot.querySelector('input[placeholder=\"Search Reddit\"]')");
        searchBar.click();
        searchBar.sendKeys("Hello");
    }
}
