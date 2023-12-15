package com.solved.carina.reddit.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsPageBase extends AbstractPage {
    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSearchResultPresent();
}
