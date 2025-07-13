package com.yogesh.nipte.pages.flightservation;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id="passengers")
    private WebElement passengerSelect;

    @FindBy(id="search-flights")
    private WebElement searchflighsButtont;

    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(d->this.searchflighsButtont.isDisplayed());
        return true;
    }

    public void selectFlight(String data){
        Select passegngerSelectList = new Select(this.passengerSelect);
        passegngerSelectList.selectByVisibleText(data);
    }
}
