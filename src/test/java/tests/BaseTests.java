package tests;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;

//    @BeforeClass
//    public void beforeClass(){
//       System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe" );
//       driver = new ChromeDriver();
//       driver.get("https://www.saucedemo.com");
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       loginPage = new LoginPage(driver, driverWait);
//    }
    public void sleep (int miliseconds) {
        try {
            Thread.sleep(miliseconds);

        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }   // isAlertPresent()

//    @AfterClass
//    public void afterClass() {
//        sleep(5000);
//        driver.quit();
//    }



}

