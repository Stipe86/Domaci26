package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class LogoutTest extends BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;

    private ProductsPage productsPage;

    private CartPage cartPage;

    private CommonPage commonPage;

    private CheckoutPage checkoutPage;

    private Faker faker;



    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, driverWait);
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(driver, driverWait);
        productsPage.getButtonAddRemove("add-to-cart-sauce-labs-backpack").click();
        cartPage = new CartPage(driver, driverWait);
        commonPage = new CommonPage(driver, driverWait);
        commonPage.getButtonCart().click();
        checkoutPage = new CheckoutPage(driver, driverWait);
        faker = new Faker();
    }

    @AfterClass
    public void afterClass() {
        super.sleep(5000);
        driver.quit();
    }

    @Test
    public void checkoutTest() {
        cartPage.getButtonCheckout().click();
        checkoutPage.submitInformation(faker.name().firstName(), faker.name().lastName(), faker.address().zipCode());
        String totalLabel = checkoutPage.getTotalLabel().getText().trim();
        String total = totalLabel.substring(8);
        System.out.println(total);
        checkoutPage.getButtonFinish().click();
        commonPage.buttonMenu().click();
        commonPage.logout().click();
        driver.get("https://www.saucedemo.com/cart.html");
        Assert.assertTrue(loginPage.getAuthCartError().isDisplayed());




    }


}
