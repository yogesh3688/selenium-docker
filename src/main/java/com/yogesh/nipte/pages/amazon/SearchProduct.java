package com.yogesh.nipte.pages.amazon;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProduct extends AbstractPage  {


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath="//input[@id='nav-search-submit-button']")
    private WebElement serachButton;

    public SearchProduct(WebDriver driver){
        super(driver);
    }

    public void searchProduct(String productName){
        this.searchField.sendKeys(productName);
        this.serachButton.click();
    }

    @Override
    public boolean isAt() {
        super.webDriverWait.until(d->this.searchField.isEnabled());
        return true;
    }
}
