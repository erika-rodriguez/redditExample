package com.solved.carina.reddit;

import com.solved.carina.reddit.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest implements IAbstractTest {
    @Test
    public void getFirstPostText(){
        HomePageBase home=initPage(getDriver(), HomePageBase.class);
        home.open();
        String title=home.getPostTitle();
        Assert.assertFalse(title.isBlank());
    }

    @Test
    public void getAppBtn(){
        HomePageBase home=initPage(getDriver(), HomePageBase.class);
        home.open();
        Assert.assertFalse(home.clickOnGetAppBtn().isBlank(), "Message is not shown");
    }

}
