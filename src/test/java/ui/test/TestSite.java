package ui.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.helper.PageUtils;
import ui.helper.TestUtils;

public class TestSite extends TestUtils {

    private PageUtils pageUtils = new PageUtils(driver);

    @Before
    public void verifySignIn() {
        String expectText1 = "Sign out";

        //Login
        pageUtils.clickOnElement(By.className("login"));

        pageUtils.everythingClear(By.id("email"));
        pageUtils.setTest(By.id("email"), "123@me.com");

        pageUtils.everythingClear(By.id("passwd"));
        pageUtils.setTest(By.id("passwd"), "123mecom");

        pageUtils.clickOnElement(By.id("SubmitLogin"));
        String actualText1 = pageUtils.getText(By.className("logout"));

        Assert.assertEquals("Did not sign in", expectText1, actualText1);
    }

    @Test
    public void verifyMyAccount() {

        pageUtils.clickOnElement(By.cssSelector("[title='My orders']"));
        String orderHistory = pageUtils.getText(By.className("page-heading"));
        Assert.assertEquals("Did not click orders", "ORDER HISTORY", orderHistory);

        pageUtils.clickOnElement(By.cssSelector("[title='My credit slips']"));
        String creditSlips = pageUtils.getText(By.className("page-heading"));
        Assert.assertEquals("Did not click credit slips", "CREDIT SLIPS", creditSlips);

        pageUtils.clickOnElement(By.cssSelector("[title='My addresses']"));
        String addresses = pageUtils.getText(By.className("page-heading"));
        Assert.assertEquals("Did not click my addresses", "MY ADDRESSES", addresses);

        pageUtils.clickOnElement(By.cssSelector("[title='Manage my personal information']"));
        String personalInformation = pageUtils.getText(By.className("page-subheading"));
        Assert.assertEquals("Did not click personal information", "YOUR PERSONAL INFORMATION" , personalInformation);
    }

    @Test
    public void verifyHover() {
        //Women hover
        pageUtils.onHover(By.xpath("//*[@id='block_top_menu']/ul/li[1]"));
        pageUtils.clickOnElement(By.cssSelector("[title='Evening Dresses']"));
        String eveningDresses = pageUtils.getText(By.className("cat-name"));
        Assert.assertEquals("Did not go to evening dresses", "EVENING DRESSES " , eveningDresses);
    }

    @After
    public void verifySignOut() {
        String expectText2 = "Sign in";

        //Logout
        pageUtils.clickOnElement(By.className("logout"));
        String actualText2 = pageUtils.getText(By.className("login"));
        Assert.assertEquals("Did not sign out", expectText2, actualText2);
    }
}
