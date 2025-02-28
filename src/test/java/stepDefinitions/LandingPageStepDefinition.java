package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.jv.Lan;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetUp;


import java.io.IOException;

public class LandingPageStepDefinition {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    LandingPage landingPage;
    TestContextSetUp testContextSetUp;

    public LandingPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp=testContextSetUp;
        this.landingPage =testContextSetUp.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() throws IOException {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with shortname called (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_called_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetUp.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetUp.landingPageProductName+ " is extracted from homepage");
    }

    @And("^Added (.+) items of the selected product to cart$")
    public void Added_items_of_the_selected_product_to_cart(int quantity){
        landingPage.incrementQuantity(quantity);
        landingPage.addToCart();
    }
}
