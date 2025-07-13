package com.yogesh.nipte.tests.amazon;

import com.google.common.util.concurrent.Uninterruptibles;
import com.yogesh.nipte.listeners.TestListeners;
import com.yogesh.nipte.utils.Config;
import com.yogesh.nipte.utils.Constants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({TestListeners.class})
public abstract class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupConfig(){
        Config.initialize();
    }

    @BeforeTest
    public void setDriver(ITestContext ctx) throws MalformedURLException {
        // Driver Setup
//        this.driver = new ChromeDriver();
        // To avoid spelling mistake we will use Costamt
//        if(Boolean.getBoolean("selenium.grid.enabled"))
//        {
//            this.driver = getRemoteDriver();
//        }else{
//            this.driver = getLocalDriver();
//        }
        // Refactoring to ternary operator
//        if (Boolean.getBoolean(Costants.GRID_ENABLED)){
//            this.driver = getRemoteDriver();
//        }else {
//            this.driver = getLocalDriver();
//        }
        this.driver = Boolean.getBoolean(Constants.GRID_ENABLED)?getRemoteDriver():getLocalDriver();
        ctx.setAttribute(Constants.DRIVER,this.driver);
        this.driver.manage().window().maximize();

    }


    public WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities cap = null;
        // Refactoring this code using Costants Class
//        if(System.getProperty("browser").equalsIgnoreCase("chrome")){
//            cap = new ChromeOptions();
//
//        } else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
//            cap = new FirefoxOptions();
//        }
        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))){
            cap = new FirefoxOptions();
        }else if (Constants.CHROME.equalsIgnoreCase(Config.get(Constants.BROWSER))){
            cap = new ChromeOptions();
        }
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat,hubHost);
        log.info("hub url is {}",url);
        return new RemoteWebDriver(new URL(url),cap);
    }

    public WebDriver getLocalDriver(){
//        if (System.getProperty("browser").equalsIgnoreCase("chrome")){
//
//        }
        return new ChromeDriver();
    }

    @AfterTest
    public void killDriver(){
        this.driver.quit();
    }


    @AfterMethod
    public void sleep(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }


}
