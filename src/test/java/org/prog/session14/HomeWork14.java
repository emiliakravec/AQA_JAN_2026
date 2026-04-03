package org.prog.session14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class HomeWork14 {

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

    @Test
    public void alloTest() {

        driver.get("https://allo.ua/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // закрити банер якщо є
        try {
            WebElement closeBtn = driver.findElement(By.cssSelector("button[aria-label='Закрити']"));
            closeBtn.click();
        } catch (Exception e) {}

        // знайти пошук
        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Пошук товарів']")
                )
        );

        // вводимо текст
        searchInput.sendKeys("iphone 17 pro max");
        searchInput.sendKeys(Keys.ENTER);

        // чекаємо результат
        wait.until(ExpectedConditions.titleContains("iphone"));

        // перевірка
        String title = driver.getTitle();
        Assert.assertTrue(title.toLowerCase().contains("iphone"));
    }
}