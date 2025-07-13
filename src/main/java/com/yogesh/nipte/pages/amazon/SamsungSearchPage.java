package com.yogesh.nipte.pages.amazon;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SamsungSearchPage extends AbstractPage {

    private final Logger log = LoggerFactory.getLogger(SamsungSearchPage.class);

    @FindBy(xpath = "//span[@data-component-type='s-search-results']")
    private WebElement searchResult;

    public SamsungSearchPage(WebDriver driver){
        super(driver);
    }

    public String GetFirstroduct(){
        List<WebElement> links = this.searchResult.findElements(By.xpath("//a/h2/span"));
        String firstProduct = links.get(0).getText().trim();
        log.info("First item in the list is {}",firstProduct);
        return firstProduct;
    }

    @Override
    public boolean isAt() {
        List<WebElement> links = this.searchResult.findElements(By.xpath("//a/h2/span"));
        return links.size() > 0 ? true:false;
    }
}
