package com.solved.carina.reddit;

import com.solved.carina.reddit.common.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

import javax.ws.rs.PUT;


public class HomeTest implements IAbstractTest {
    @Test
    public void getFirstPostText(){
        HomePageBase home=initPage(getDriver(), HomePageBase.class);
        home.open();
        home.getPostTitle();
    }

}
