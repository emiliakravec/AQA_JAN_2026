package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MySteps {

    @Given("Preconditions are {string}")
    public void preconditionsAreOK(String value) {
        System.out.println(">>>> Preconditions are " + value);
    }

    @Given("Set user password to {string}")
    public void setUserPassword(String value) {
        System.out.println(">>>> User password is set to " + value);
    }

    @Given("There parameters are {string} and {string}")
    public void parametersDemo(String value1, String value2) {
        System.out.println(">>>> There parameters are " + value1 + " and " + value2);
    }

    @When("I do something {int} times")
    public void iDoSomething(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.println(">>>> I do something " + j + " times");
        }
    }

    @Then("Something happens with {}")
    public void somethingHappens(MyEnum myEnum) {
        System.out.println("Something happens with " + myEnum.name());
    }
    @Given("open allo")
    public void openAllo() {
        GoogleSteps.driver.get("https://allo.ua");
    }

    @When("search for iphone")
    public void searchIphone() {

        WebDriverWait wait = new WebDriverWait(GoogleSteps.driver, Duration.ofSeconds(10));

        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='search']"))
        );

        search.sendKeys("iphone");
        search.submit();
    }

    @Then("check first 3 phones")
    public void checkPhones() throws Exception {

        List<WebElement> products = GoogleSteps.driver.findElements(By.cssSelector("div[class*='product']"));

        if (products.size() == 0) {
            throw new RuntimeException("Немає товарів!");
        }

        for (int i = 0; i < 3; i++) {

            String fullName = products.get(i).getText();
            String name = fullName.length() > 50 ? fullName.substring(0, 50) : fullName;

            List<WebElement> prices = products.get(i).findElements(By.cssSelector("[class*='price']"));

            if (prices.size() == 0) {
                continue;
            }

            String price = prices.get(0)
                    .getText()
                    .replaceAll("[^0-9]", "");

            if (DBSteps.isPhoneExists(name)) {
                DBSteps.checkPrice(name, price);
            } else {
                DBSteps.insertPhone(name, price);
            }
        }
    }
}

