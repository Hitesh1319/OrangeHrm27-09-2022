package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeftMenu {
    WebDriver driver;

    By leave = By.linkText("Leave");
    public LeftMenu(WebDriver driver) {
        this.driver = driver;
        }

        public void leave() {
        driver.findElement(leave).click();
        }
}
