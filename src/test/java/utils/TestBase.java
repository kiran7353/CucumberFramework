package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {

        String proPath=System.getProperty("user.dir");
        FileInputStream fis=new FileInputStream(proPath+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"global.properties");
        Properties prop=new Properties();
        prop.load(fis);
        String url=prop.getProperty("QAURL");
        String brower_properties=prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        String browser=browser_maven!=null?browser_maven:brower_properties;

        if(driver==null) {
            if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
