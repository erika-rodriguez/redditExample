package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(xpath = "//a[contains(@href,'login')]")
    //"//div[@id='email-verification-tooltip-id']/..//a"
    private ExtendedWebElement loginBtn;
    @FindBy(xpath = "(//shreddit-post/a[contains(@id,'post-title')])[1]")
    private ExtendedWebElement firstPostTitle;
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
        System.out.println(firstPostTitle.getText());
        return firstPostTitle.getText();
    }
}
