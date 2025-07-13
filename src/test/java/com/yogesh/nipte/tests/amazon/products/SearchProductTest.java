package com.yogesh.nipte.tests.amazon.products;

import com.yogesh.nipte.pages.amazon.HomePage;
import com.yogesh.nipte.pages.amazon.ProductSearchLandingPage;
import com.yogesh.nipte.pages.amazon.SearchProduct;
import com.yogesh.nipte.tests.amazon.BaseTest;
import com.yogesh.nipte.utils.Config;
import com.yogesh.nipte.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {

    private String productName;
    private String productDetails;

    @BeforeTest
    @Parameters({"productName","productDetails"})
    public void setPageObjects(String productName,String productDetails){

        this.productName = productName;
        this.productDetails = productDetails;

    }

    @Test
    public void HomePageTest(){
        HomePage homePage = new HomePage(driver);
        homePage.goTo(Config.get(Constants.AMAZON_URL));
        homePage.isAt();

    }

    @Test(dependsOnMethods = {"HomePageTest"})
    public void SearchProductTest(){
        SearchProduct searchProduct = new SearchProduct(driver);
        searchProduct.isAt();
        searchProduct.searchProduct(productName);
    }

    @Test(dependsOnMethods = {"SearchProductTest"})
    public void ProductSerachLandingPageTest(){
        ProductSearchLandingPage productSearchLandingPage = new ProductSearchLandingPage(this.driver);
        productSearchLandingPage.isAt();
        Assert.assertEquals(productSearchLandingPage.GetFirstroduct(),this.productDetails );
    }



}
