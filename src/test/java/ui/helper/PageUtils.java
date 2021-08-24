package ui.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//explicit wait
public class PageUtils {
    private WebDriver driver;

    public PageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void everythingClear(By by) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
    }

    public void setTest(By by, String input) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(input);
    }

    public String getText(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    public void clickOnElement(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void onHover(By by) {
        WebElement anyHover = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(by));
        new Actions(driver).moveToElement(anyHover).build().perform();
    }
}
