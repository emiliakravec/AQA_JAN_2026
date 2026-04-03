package org.prog.session15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class HomeWork15 {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void alloTest() {

        driver.get("https://allo.ua");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // закриваємо попап (якщо є)
        try {
            WebElement closeBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(".popup__close"))
            );
            closeBtn.click();
        } catch (Exception e) {
            // якщо нема попапу — ок
        }

        // поле пошуку
        WebElement search = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@placeholder,'Пошук')]")
                )
        );

        search.click();
        search.sendKeys("iphone");
        search.submit();

        // чекаємо товари
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='product']")));

        List<WebElement> products = driver.findElements(By.cssSelector("[class*='product']"));

        // перевірка перших 3 товарів
        int count = Math.min(products.size(), 3);

        for (int i = 0; i < count; i++) {
            try {
                WebElement price = products.get(i)
                        .findElement(By.xpath(".//*[contains(text(),'₴')]"));

                Assert.assertFalse(price.getText().isEmpty());
                System.out.println(price.getText());

            } catch (Exception e) {
                System.out.println("Не знайдена ціна для товару " + i);
            }
        }
    }
}



