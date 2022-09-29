package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait );
    }

    public WebElement getUserName() {
        return getDriver().findElement(userName);
    }

    public WebElement getPassword () {
        return getDriver().findElement(password);
    }

    public WebElement getLogin() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getAuthCartError() {
        return getDriver().findElement(By.xpath("//h3[text()=\"Epic sadface: You can only access '/cart.html' when you are logged in.\"]"));
    }

    public void login (String userName, String password) {
        getUserName().clear();
        getPassword().clear();
        getUserName().sendKeys(userName);
        getPassword().sendKeys(password);
        getLogin().click();
        try
        {
            getDriver().switchTo().alert();

        }
        catch (NoAlertPresentException Ex)
        {

        }
    }

}
