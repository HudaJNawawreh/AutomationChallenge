/**
 *Holding the web elements of an order page
 */
package selenium.pagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageObjects {
    @FindBy(xpath = "//div[@testid='tracking-id']")
    public WebElement trackingID;

    @FindBy(xpath = "//button//span[text()='Print Proof of Delivery']")
    public WebElement printProofButton;

    @FindBy(xpath = "//button[contains(.,'Print Airway Bill')]")
    public WebElement printAirWayBillButton;

    @FindBy(xpath = "//div[@data-analyticsid='selectAWBLayout'][contains(.,'1 bills per page')]")
    public WebElement oneBillPerPage;

    //@FindBy(xpath = "//span[@data-key='print']")
    @FindBy(xpath = "//a[contains(.,'print')]")
    public WebElement printBillButton;


}
