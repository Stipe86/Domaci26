package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {
    private WebElement buttonAddRemove;

    private WebElement productPageTitle;

    private WebElement buttonCart;

    public ProductsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getButtonAddRemove(String id) {
        return getDriver().findElement(By.id(id));
    }



    public WebElement getProductPageTitle() {
        return getDriver().findElement(By.xpath("//span[text()='Products']"));
    }

    public WebElement getButtonCart() {
        return getDriver().findElement(By.className("shopping_cart_link"));
    }
}
