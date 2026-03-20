package org.prog.session20;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.session20.steps.DBSteps;
import org.prog.session20.steps.GoogleSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        tags = "@wip and not @skip",
        features = "src/test/resources/features",
        glue = "org.prog.session20.steps",
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber-reports/Cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

    private Connection connection;
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://mysql-db-1:3306/db",
                "root",
                "password"
        );
        DBSteps.connection = connection;

        driver = new ChromeDriver();
        GoogleSteps.driver = driver;
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        try {
            connection.close();
        } catch (Exception e) {
        }
        try {
            driver.quit();
        } catch (Exception e) {
        }
    }
}
