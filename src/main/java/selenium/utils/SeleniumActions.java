/**
 * Handling Actions
 */
package selenium.utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumActions extends ManagePages{

    public void click(WebElement element)
    {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            System.out.println("Clicked on element successfully");

        }
        catch (Exception e)
        {
            Assert.fail("failed to click on element + "+ e);
        }
    }

    public void updateText(WebElement element,String value, boolean clearFirst)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        try {
            if(clearFirst)
            {
                element.clear();
            }
            element.sendKeys(value);
            System.out.println("Test updated to "+ value);
        }
        catch (Exception e)
        {
            Assert.fail("failed to update text "+ e.getMessage());
        }
    }

    public boolean isElementPresent(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void waitForElementPresent(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementNotPresent(WebElement element)
    {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void switchTab()
    {
        try
        {
            driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        }
        catch (Exception e)
        {
            Assert.fail("Failed to switch to the tab + " + e.getMessage());
        }
    }

    public String getURL()
    {
        return driver.getCurrentUrl();
    }
}
