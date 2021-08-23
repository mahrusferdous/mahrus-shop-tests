package ui.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.helper.TestUtils;

public class SignInTest extends TestUtils {

    @Test
    public void verifySignIn() {
        String expectText1 = "Sign out";
        String expectText2 = "Sign in";

        //Login
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("123@me.com");

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("123mecom");

        driver.findElement(By.id("SubmitLogin")).click();

        String actualText1 = driver.findElement(By.className("logout")).getText();

        Assert.assertEquals("Did not sign in", expectText1, actualText1);

        //My account

        driver.findElement(By.cssSelector("[title='My orders']")).click();
        String orderHistory = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals("Did not click orders", "ORDER HISTORY", orderHistory);

        driver.findElement(By.cssSelector("[title='My credit slips']")).click();
        String creditSlips = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals("Did not click credit slips", "CREDIT SLIPS", creditSlips);

        driver.findElement(By.cssSelector("[title='My addresses']")).click();
        String addresses = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals("Did not click my addresses", "MY ADDRESSES", addresses);

        driver.findElement(By.cssSelector("[title='Manage my personal information']")).click();
        String personalInformation = driver.findElement(By.className("page-subheading")).getText();
        Assert.assertEquals("Did not click personal information", "YOUR PERSONAL INFORMATION" , personalInformation);

        //Women hover
        WebElement womenHover = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]"));
        new Actions(driver).moveToElement(womenHover).build().perform();
        driver.findElement(By.cssSelector("[title='Evening Dresses']")).click();
        String eveningDresses = driver.findElement(By.className("cat-name")).getText();
        Assert.assertEquals("Did not go to evening dresses", "EVENING DRESSES " , eveningDresses);

        //Logout
        driver.findElement(By.className("logout")).click();

        String actualText2 = driver.findElement(By.className("login")).getText();

        Assert.assertEquals("Did not sign out", expectText2, actualText2);
    }
}
