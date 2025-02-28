package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.GenericUtils;
import utils.TestContextSetUp;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public String offerPageProductName;
    public TestContextSetUp testContextSetUp;
    PageObjectManager pageObjectManager;
    OffersPage offersPage;

    public OfferPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp=testContextSetUp;
        this.offersPage =testContextSetUp.pageObjectManager.getOffersPage();
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName=offersPage.getProductName();
    }

    public void switchToOffersPage(){
//        if(testContextSetUp.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
        LandingPage landingPage=testContextSetUp.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetUp.genericUtils.switchWindowToChild();
    }

    @Then("validate product name in offers page matches with landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName,testContextSetUp.landingPageProductName);
    }


}
