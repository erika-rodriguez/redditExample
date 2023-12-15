package com.solved.carina.reddit.pages;

import com.solved.carina.reddit.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='masthead']/descendant::h1[@id='search-results-header']")
    private ExtendedWebElement searchResultsTxt;

    @Override
    public boolean isSearchResultPresent() {
        return searchResultsTxt.isElementPresent();
    }
}
