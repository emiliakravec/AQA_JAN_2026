package org.prog.session14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


//TODO: write testng tests to go to allo.ua
//TODO: find seach input
//TODO: search for iphone 17 pro max

public class WebTests {

    private WebDriver driver;



    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

   // @Test
    public void myWebTest() {
    driver.get("https://rozetka.com.ua/");
        WebElement element = driver.findElement(By.name("search"));
        element.sendKeys("Xiaomi");
        element.sendKeys(Keys.ENTER);
        System.out.println("done!");
    }
    @Test
    public void alloTest() {
        driver.get("https://allo.ua/ua/products/mobile/apple/");

        String title = driver.getTitle();
        org.testng.Assert.assertTrue(title.toLowerCase().contains("apple"));
    }
}
