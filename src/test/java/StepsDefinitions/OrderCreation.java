/**
 * This Class is holding the steps for the Order creation testing
 */
package StepsDefinitions;

import APIs.APIsRequests.AuthRequest;
import APIs.APIsRequests.OrderCreateRequest;
import APIs.APIsResonses.AuthResponse;
import APIs.APIsResonses.OrderCreateResponse;
import APIs.UsersAndOthers.Address;
import APIs.UsersAndOthers.Participants;
import APIs.UsersAndOthers.Shipper;
import APIs.UsersAndOthers.TimeSlot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class OrderCreation{

    Shipper shipper;
    AuthRequest authRequest;
    OrderCreateRequest orderCreateRequest;
    AuthResponse authResponse;
    OrderCreateResponse orderCreateResponse;
    String accessToken;


    @Given("the shipper is registered in Ninja Van")
    public void userIsRegistered() {
        System.out.println("The Users.Shipper is registered in Ninja Van");
        shipper =new Shipper("f288852c-7a4a-4d5e-8267-a83778233ad0","be2z8YU6ubykr1oJYWee5Q");
    }
    @When("shipper authenticate to ninja van System")
    public void authenticateToSystem() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Call authentication request (API) ");
        authRequest=new AuthRequest();
        authResponse = shipper.auth(authRequest);
    }
    @Then("QA verifies that the HTTP authentication response code is \'200\'")
    public void verifyTheAuthResponseCode() {
        System.out.println("Verify that the http auth request response code is 200");
        Assert.assertEquals(200,authResponse.getStatusCode());
    }
    @When("shipper retrieved its access token")
    public void retrievingAccessToken() {
        System.out.println("Read the access token from the response");
        System.out.println(authResponse.getAccessToken());
        accessToken=authResponse.getAccessToken();
    }
    @When("shipper send order create request and shipper provide the access token in the request header")
    public void sendRequest() {
        System.out.println("Send API Request");
        orderCreateRequest =new OrderCreateRequest();
        shipper.senderAddress=new Address("903 Toa Payoh North","SG","511200");
        shipper.from=new Participants("Ninja Sender Z64441290","082188889999","ninja@test.co",shipper.senderAddress);
        shipper.receiverAddress=new Address("999 Toa Payoh North","SG","318993");
        shipper.to=new Participants("Recipient X","082188889999","mickyself.com",shipper.receiverAddress);
        shipper.pickup_date="2022-02-09";
        shipper.pickUPAddress=shipper.senderAddress;
        shipper.parcel_job=new Participants("reservation-2","082188881592","reservation-1@ninjavan.co",shipper.pickUPAddress);
        shipper.pickup_timeslot=new TimeSlot("12:00","15:00","Asia/Singapore");
        shipper.delivery_timeslot=new TimeSlot("09:00","22:00","Asia/Singapore");
        orderCreateRequest=new OrderCreateRequest();
        orderCreateResponse =shipper.createOrder(accessToken,orderCreateRequest);
    }

    @Then("QA verifies that the HTTP order creation  response code is \'200\'")
    public void verifyTheOrderCreateResponseCode() {
        System.out.println("Verify that the http response code is 200");
        Assert.assertEquals(200,orderCreateResponse.getStatusCode());
    }

    @Then("QA verifies that the HTTP response body is \\{“status”:”OK”}")
    public void checkResponseBody() {
       System.out.println("Check the bode is {Status: OK}");
        Assert.assertEquals("{“status”:”OK”}",orderCreateResponse.getResponseBody());
    }
}
