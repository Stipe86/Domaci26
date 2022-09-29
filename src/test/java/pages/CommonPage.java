package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage extends BasePage {
    private WebElement buttonMenu;
    private WebElement logout;
    private WebElement buttonCart;


    public CommonPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    public WebElement buttonMenu() {
        return getDriver().findElement(By.id("react-burger-menu-btn"));
    }



    public WebElement logout() {
        return getDriver().findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getButtonCart() {
        return getDriver().findElement(By.className("shopping_cart_link"));
    }

}
