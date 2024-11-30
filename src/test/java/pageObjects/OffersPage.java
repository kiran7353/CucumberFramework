package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    WebDriver driver;

   By search=By.xpath("//input[@type='search']");
   By productName=By.cssSelector("tr td:nth-child(1)");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String item){
        driver.findElement(search).sendKeys(item);
    }

    public void getSearchText(){
        driver.findElement(search).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

}
