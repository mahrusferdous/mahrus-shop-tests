package ui.helper;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestUtils {
    public static WebDriver driver;

    @BeforeClass
    public static void setupDriver() {
        driver = DriverUtils.loadWebDriver();
    }

    @AfterClass
    public static void teardownDriver() {
        driver.quit();
    }

    @Before
    public void testSetup() {
        driver.get("http://automationpractice.com/index.php");
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
