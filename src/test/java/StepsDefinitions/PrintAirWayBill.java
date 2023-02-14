/**
 * This Class is holding the steps for the Printing Airway bill feature
 */
package StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import selenium.buisnessFlows.HomePageLogics;
import selenium.utils.SeleniumActions;

import java.io.IOException;

public class PrintAirWayBill extends SeleniumActions {
    String firstTrackingID;


    @Given("Shipper opened the Ninja Dashboard login page at https:\\/\\/dashboard-qa.ninjavan.co\\/login-v2")
    public void shipper_opened_the_ninja_dashboard_login_page_at_https_dashboard_qa_ninjavan_co_login_v2() {
        
        loginPageLogics.openWebsite(loginPg.url);
    }
    @Given("shipper had an order created under his account")
    public void shipper_had_an_order_created_under_his_account() {
        Assert.assertTrue("Make sure the login page opened",isElementPresent(loginPg.loginButton));
    }
    @When("shipper login by using credentials challenge2@ninjavan.co and Ninjavan1234")
    public void shipper_login_by_using_credentials_challenge2_ninjavan_co_and_ninjavan1234() {
        loginPageLogics.login("challenge2@ninjavan.co", "Ninjavan1234");
        waitForElementNotPresent(loginPg.loginButton);
    }
    @Then("shipper arrived at landing page")
    public void shipper_arrived_at_landing_page() {
        Assert.assertEquals("Verify it is navigated to the home page",homePg.url,getURL());
    }
    @When("shipper go to the tracking page")
    public void shipper_go_to_the_tracking_page() {
        homePageLogics.navigateToSection(HomePageLogics.Section.Tracking);
        Assert.assertTrue(isElementPresent(trackPg.searchButton));
    }
    @When("shipper click search button")
    public void shipper_click_search_button() {
        trackingPageLogics.searchForParcel("");
    }
    @When("shipper select the first tracking ID in the table")
    public void shipper_select_the_first_tracking_id_in_the_table() {
        firstTrackingID= trackingPageLogics.getTrackingIDForNRow(1);
        trackingPageLogics.clickOnNRowInTrackingTable(1);
        waitForElementPresent(orderPg.trackingID);
    }
    @Then("QA verify that the Order Details page is shown")
    public void qa_verify_that_the_order_details_page_is_shown() {
        
        Assert.assertEquals("Check that the order opened is really the first one in the table",
                firstTrackingID,orderPg.trackingID.getText());

    }
    @When("shipper click Print Airway Bill button")
    public void shipper_click_print_airway_bill_button() {
       // orderPageLogics.printAirwayBill(OrderPageLogics.AirwayBillType.onePerPage); TODO: this can be used instead of this step and the following 2
        waitForElementPresent(orderPg.printAirWayBillButton);
        click(orderPg.printAirWayBillButton);

    }
    @When("shipper select \"1\" bills per page in Print Airway Bills dialog")
    public void shipper_select_bills_per_page_in_print_airway_bills_dialog() {
        waitForElementPresent(orderPg.oneBillPerPage);
        click(orderPg.oneBillPerPage);
    }
    @When("shipper click print button in Print Airway Bills dialog")
    public void shipper_click_print_button_in_print_airway_bills_dialog() {
        waitForElementPresent(orderPg.printBillButton);
        click(orderPg.printBillButton);
    }
    @Then("QA verify that the tracking ID text in the pdf is the same as in the step \"7\"")
    public void qa_verify_that_the_tracking_id_text_in_the_pdf_is_the_same_as_in_the_step7() throws IOException {
        switchTab();
        String pdfContent = orderPageLogics.getPdfContent(driver.getCurrentUrl());
        Assert.assertTrue(pdfContent.contains(firstTrackingID));
    }


}
