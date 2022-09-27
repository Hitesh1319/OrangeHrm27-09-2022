package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By submitButton = By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() throws IOException {
        FileReader reader = new FileReader("src/main/java/PropertiesFiles/Config.properties");
        Properties data = new Properties();
        data.load(reader);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(data.getProperty("username"));
        driver.findElement(password).sendKeys(data.getProperty("password"));
        driver.findElement(submitButton).click();
    }
}
