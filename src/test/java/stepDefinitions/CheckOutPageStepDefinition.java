package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TestContextSetUp;

import java.io.IOException;

public class CheckOutPageStepDefinition {
    public WebDriver driver;
    TestContextSetUp testContextSetUp;
    CheckOutPage checkOutPage;

    public CheckOutPageStepDefinition(TestContextSetUp testContextSetUp){
        this.testContextSetUp=testContextSetUp;
        this.checkOutPage=testContextSetUp.pageObjectManager.getCheckOutPage();
    }

    @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) {
        checkOutPage.checkOutItems();
    }

    @And("^verify user has ability to enter promo code and place the order$")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order(){
        Assert.assertTrue(checkOutPage.verifyPromoBtn());
        Assert.assertTrue(checkOutPage.verifyPlaceOrder());
    }
}
