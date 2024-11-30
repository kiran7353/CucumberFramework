package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetUp {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetUp() throws IOException {
        testBase=new TestBase();
        pageObjectManager=new PageObjectManager(testBase.webDriverManager());
        genericUtils=new GenericUtils(testBase.webDriverManager());
    }
}
