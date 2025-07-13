package com.yogesh.nipte.pages.amazon;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MobileHomePage extends AbstractPage {


    @FindBy(xpath = "//input[@type='checkbox' and @aria-labelledby='Samsung']")
    private WebElement samsungCheckbox;

    public MobileHomePage(WebDriver driver){
        super(driver);
    }

    public void clickSamsungCheckbox(){
//        this.samsungCheckbox.click();
        Actions actions = new Actions(this.driver);
        actions.moveToElement(samsungCheckbox).click().perform();
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(d-> this.samsungCheckbox.isEnabled());
        return true;
    }
}
