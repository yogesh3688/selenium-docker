package com.yogesh.nipte.pages.flightservation;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id="go-to-flight-search")
    private WebElement goToflightSearchButton;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(d->goToflightSearchButton.isDisplayed());
        return true;
    }

    public void setGoToflightSearch() {
        this.goToflightSearchButton.click();
    }
}
