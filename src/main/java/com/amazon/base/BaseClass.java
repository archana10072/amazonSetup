package com.amazon.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties config = new Properties();
    public static Properties locators = new Properties();
    public static WebDriver driver;
    public static String browser;
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger(BaseClass.class);
    public static WebDriverWait wait;


    public BaseClass() {
        DOMConfigurator.configure("./src/main/java/com/amazon/utils/log4j.xml");
        if (driver == null) {
            try {
                fis = new FileInputStream("./src/main/resources/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fis = new FileInputStream("./src/main/resources/Locator.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                locators.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (config.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                log.info("Chrome driver initiating");
                driver = new ChromeDriver();
            } else if (config.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                log.info("Firefox driver initiating");
                driver = new FirefoxDriver();
            }

            driver.get(config.getProperty("testUrl"));
            log.debug("Navigated to : " + config.getProperty("testUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
        }

    }

    public static void tearDown(){
        driver.quit();
    }

    public static void click(String locator) {
        log.debug("Clicking on an Element : "+locator);
        driver.findElement(By.xpath(locators.getProperty(locator))).click();
    }

    public static void type(String locator, String value) {
        log.debug("Typing in an Element : "+locator+" entered value as : "+value);
        driver.findElement(By.xpath(locators.getProperty(locator))).sendKeys(value);
    }

    public static void dropdown(String locator, int value) {
        log.debug("Select an Element : "+locator+"select value as : "+value);
        WebElement testDropDown =driver.findElement(By.xpath(locators.getProperty(locator)));
        Select dropdown = new Select(testDropDown);
        dropdown.selectByIndex(value);
    }

    public static void scrollToView(String locator){
        WebElement element = driver.findElement(By.xpath(locators.getProperty(locator)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public static void switchtoChildWindow(){
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
    }

    public static void switchto2ndChildWindow(){
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId = it.next();
        String childId = it.next();
        String secondChildId = it.next();
        driver.switchTo().window(secondChildId);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }

    }

    public void gotoAnyPage(String url){
        driver.get(url);
    }

}
