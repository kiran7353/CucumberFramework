package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LandingPage landingPage;
    public OffersPage offerPage;
    CheckOutPage checkOutPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver=driver;
    }

    public LandingPage getLandingPage(){
         landingPage = new LandingPage(driver);
         return landingPage;
    }

    public OffersPage getOffersPage(){
        offerPage = new OffersPage(driver);
        return offerPage;
    }

    public CheckOutPage getCheckOutPage(){
        checkOutPage = new CheckOutPage(driver);
        return checkOutPage;
    }
}
