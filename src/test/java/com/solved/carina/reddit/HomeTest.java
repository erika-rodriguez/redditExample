package com.solved.carina.reddit;

import com.solved.carina.reddit.common.HomePageBase;
import com.solved.carina.reddit.common.SearchResultsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.CsvDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class HomeTest implements IAbstractTest, IAbstractDataProvider {
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

    @Test(dataProvider="DataProvider")
    @CsvDataSourceParameters(path = "searchBar.csv", dsUid = "TUID")
    public void searchBar(HashMap<String, String> data){
        HomePageBase home=initPage(getDriver(), HomePageBase.class);
        home.open();
        home.clickOnSearchBar();
        SearchResultsPageBase results =home.searchFromCSV(data.get("Search"));

        Assert.assertTrue(results.isSearchResultPresent());
    }
}
