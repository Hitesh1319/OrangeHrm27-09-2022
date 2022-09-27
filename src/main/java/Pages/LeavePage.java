package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class LeavePage {
    WebDriver driver;
    WebDriverWait wait;

    By apply = By.linkText("Apply");
    By leaveType = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveTypeDrop = By.xpath("//*[contains(text(),'CAN')]");
    By fromDate = By.xpath("(//input[@placeholder='yyyy-mm-dd'])[1]");
    By comments = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By myLeave = By.linkText("My Leave");
    By fromDateMyLeave = By.xpath("(//div[@class='oxd-date-wrapper']//input[@class='oxd-input oxd-input--active'])[1]");
    By submitButton = By.xpath("//button[@type='submit']");
    By verifyLeave = By.xpath("//div[contains(text(),'I am applying for leave')]");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void apply() {
        driver.findElement(apply).click();
    }

    public void applyingLeave() throws IOException {
        String path = System.getProperty("user.dir") + "//src//main//java//TestData//OrangeLeaveData.xlsx";
        FileInputStream propertyPath = null;
        try {
            propertyPath = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(propertyPath);
        XSSFSheet sheet = wb.getSheet("Leave");
        wait.until(ExpectedConditions.elementToBeClickable(leaveType));
        driver.findElement(leaveType).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDrop));
        driver.findElement(leaveTypeDrop).click();
        String inputComments = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(fromDate).sendKeys("2022-09-30");
        driver.findElement(comments).sendKeys(inputComments);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }

    public void myLeaveVerification() {
        driver.findElement(myLeave).click();
        driver.findElement(fromDateMyLeave).sendKeys("2022-09-30");
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'I am applying for leave')]")));
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", "I am applying for leave"))).isDisplayed();
        Assert.isTrue(isAdminDisplayed, "Leave is not added");
    }
}
