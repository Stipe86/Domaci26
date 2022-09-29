package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
    private WebElement firstName;
    private WebElement lastName;
    private WebElement zipCode;
    private WebElement buttonContinue;
    private WebElement totalLabel;
    private WebElement buttonFinish;
    private WebElement confirmationTitle;

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(By.id("first-name"));
    }

    public WebElement getLastName() {
        return getDriver().findElement(By.id("last-name"));
    }

    public WebElement getZipCode() {
        return getDriver().findElement(By.id("postal-code"));
    }

    public WebElement getButtonContinue() {
        return getDriver().findElement(By.id("continue"));
    }

    public WebElement getTotalLabel() {
        return getDriver().findElement(By.className("summary_total_label"));
    }

    public WebElement getButtonFinish() {
        return getDriver().findElement(By.id("finish"));
    }

    public WebElement getConfirmationTitle() {
        return getDriver().findElement(By.className("complete-header"));
    }

    public void submitInformation(String firstName, String lastName, String zipCode) {
        getFirstName().clear();
        getLastName().clear();
        getZipCode().clear();

        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(lastName);
        getZipCode().sendKeys(zipCode);

        getButtonContinue().click();

    }
}
