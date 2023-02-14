/**
 *Holding the web elements of the home page
 */
package selenium.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

    public String url = "https://dashboard-qa.ninjavan.co/home";
    @FindBy(xpath = "//li[@data-analyticsid='tracking']")
    public WebElement trackingOption;

}
