/**
 * A class to contain all methods needed after going to the tracking section
 */
package selenium.buisnessFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.utils.SeleniumActions;

public class TrackingPageLogics extends SeleniumActions {

    /**
     * Searching for an order to track
     * @param valueToSearch the order id\name ... you need to search
     */
    public void searchForParcel(String valueToSearch)
    {
        updateText(trackPg.searchBox, valueToSearch, true);
        click(trackPg.searchButton);
        waitForElementPresent(trackPg.trackingTable);
    }

    /**
     * clicking on a specific row of the tracking table
     * @param rowNumber
     */
    public void clickOnNRowInTrackingTable(int rowNumber)
    {

        WebElement row=driver.findElement(By.xpath(String.format(trackPg.trackingTableNRow,rowNumber)));
        click(row);
        switchTab();
    }

    /**
     * Getting the ID of the order in a specific row
     * @param rowNumber
     * @return
     */
    public String getTrackingIDForNRow(int rowNumber)
    {
        WebElement cell = driver.findElement(By.xpath(String.format(trackPg.trackingTableCell,rowNumber,2)));
        return cell.getText();
    }

}
