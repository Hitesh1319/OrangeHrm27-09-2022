package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private LeftMenu leftMenu;
    private LeavePage leavePage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public LeftMenu getLeftMenu() {
        if (leftMenu == null) {
            leftMenu = new LeftMenu(driver);
        }
        return leftMenu;
    }

    public LeavePage getLeavePage() {
        if(leavePage == null) {
            leavePage = new LeavePage(driver);
        }
        return leavePage;
    }
}
