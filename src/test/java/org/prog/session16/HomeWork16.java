package org.prog.session16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

public class HomeWork16 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {

        try {
            driver.get("https://www.w3schools.com/cssref/tryit.php?filename=trycss_sel_hover");

            Thread.sleep(3000);

            driver.switchTo().frame("iframeResult");

            Thread.sleep(2000);

            WebElement element = driver.findElement(By.tagName("a"));

            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}