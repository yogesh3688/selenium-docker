package com.yogesh.nipte.pages.flightservation;

import com.yogesh.nipte.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {


    @FindBy(id="departure-flight")
    private List<WebElement> departureFlightOptions;

    @FindBy(id="arrival-flight")
    private List<WebElement> arrivallightOptions;

    @FindBy(id="confirm-flight")
    private WebElement confirmButton;

    public FlightSelectionPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until((d->confirmButton.isDisplayed()));
        return true;
    }

    public void selectFlight(){
        int random = ThreadLocalRandom.current().nextInt(0,this.departureFlightOptions.size());
        this.departureFlightOptions.get(random).click();
        this.arrivallightOptions.get(random).click();

    }

    public void confirmFlight(){
        this.confirmButton.click();
    }
}
