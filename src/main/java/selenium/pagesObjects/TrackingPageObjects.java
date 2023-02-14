/**
 *Holding the web elements after opening the tracking section
 */
package selenium.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackingPageObjects {

    @FindBy(xpath = "//button[@data-analyticsid='order search']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@data-key='search_input_placeholder']")
    public WebElement searchBox;
    @FindBy(xpath = "//*[@class='ReactVirtualized__Grid__innerScrollContainer']")
    public WebElement trackingTable;
    public String trackingTableNRow =  "//*[@class='ReactVirtualized__Grid__innerScrollContainer']/div[@aria-rowindex='%s']";
    public String trackingTableCell = "//*[@class='ReactVirtualized__Grid__innerScrollContainer']/div[@aria-rowindex='%s']//div[@aria-colindex='%s']/div";
}
