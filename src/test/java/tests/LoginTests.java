package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public class LoginTests extends BaseTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;

    private ProductsPage productsPage;

    @BeforeClass
    public void beforeClass(){
       System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe" );
       driver = new ChromeDriver();
       driver.get("https://www.saucedemo.com");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       loginPage = new LoginPage(driver, driverWait);
       productsPage = new ProductsPage(driver, driverWait);
    }

        @AfterClass
    public void afterClass() {
        super.sleep(5000);
        driver.quit();
    }


    @Test
    public void testLogin () {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.getProductPageTitle().isDisplayed());

    }

}
