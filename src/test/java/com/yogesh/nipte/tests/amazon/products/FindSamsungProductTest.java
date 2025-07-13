package com.yogesh.nipte.tests.amazon.products;

import com.yogesh.nipte.pages.amazon.HomePage;
import com.yogesh.nipte.pages.amazon.MobileHomePage;
import com.yogesh.nipte.pages.amazon.SamsungSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FindSamsungProductTest {

        private WebDriver driver;
        private String companyName;

        @BeforeTest
        @Parameters({"companyName"})
        public void setDriver(String companyName){
            this.companyName = companyName;
            // Driver Setup
            this.driver = new ChromeDriver();
            driver.manage().window().maximize();

        }

        @Test
        public void HomePageTest(){
            HomePage homePage = new HomePage(driver);
            homePage.goTo("https://www.amazon.in");

            Assert.assertTrue(homePage.isAt());
            homePage.clikckOnMobile();


        }

        @Test(dependsOnMethods = "HomePageTest")
        public void MobileHomePageTest(){
            MobileHomePage mobileHomePage = new MobileHomePage(driver);
            Assert.assertTrue(mobileHomePage.isAt());

            mobileHomePage.clickSamsungCheckbox();
        }

        @Test(dependsOnMethods = "MobileHomePageTest")
        public void SamsungSearchPageTest(){
            SamsungSearchPage samsungSearchPage = new SamsungSearchPage(driver);
            Assert.assertTrue(samsungSearchPage.isAt());

            Assert.assertEquals(samsungSearchPage.GetFirstroduct(),"Samsung Galaxy M05 (Mint Green, 4GB RAM, 64 GB Storage) | 50MP Dual Camera | Bigger 6.7\" HD+ Display | 5000mAh Battery | 25W Fast Charging | 2 Gen OS Upgrade & 4 Year Security Update | Without Charger");
        }

        @AfterTest
        public void killDriver(){
                this.driver.quit();
        }
}
