package com.yogesh.nipte.pages.amazon;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//a[contains(text(),'Mobiles')]")
    private WebElement mobileLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clikckOnMobile(){
        this.mobileLink.click();
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(d-> this.searchBox.isDisplayed());
        this.webDriverWait.until(d->this.mobileLink.isDisplayed());
        return true;
    }
}
