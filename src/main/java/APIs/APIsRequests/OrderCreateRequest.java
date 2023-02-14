/**
 * This Class is  for order creation requests that the shipper will do
 * */
package APIs.APIsRequests;

import APIs.APIsResonses.OrderCreateResponse;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class OrderCreateRequest {

    private static final String BASE_URL = "https://v4.ninja.com/sg/order-create/orders";

    public RequestSpecification requestSpecification;
    private JsonObject bodyJsonObject=new JsonObject();

    /**
     * The order create request will always have the same base url, and some common headers
     */
    public OrderCreateRequest()
    {
        RestAssured.baseURI=BASE_URL;
        requestSpecification=RestAssured.given();
        requestSpecification.header("Content-Type", "application/json")
            .header("Accept", "*/*");

    }

    /**
     * creating the order create request according to information the shipper should provide
     * @param token the shipper will get it once he does the auth request
     * @param from The sender
     * @param to the receiver
     * @param parcel_job
     * @param pickup_timeslot
     * @param delivery_timeslot
     * @return OrderCreateResponse
     */
    public OrderCreateResponse sendOrderCreateRequest(String token, JsonObject from, JsonObject to, JsonObject parcel_job,
                                                      JsonObject pickup_timeslot, JsonObject delivery_timeslot) {
        requestSpecification.header("authorization", "Bearer "+token);
        bodyJsonObject.add("service_type", "Parcel");
        bodyJsonObject.add("service_level","Standard");
        bodyJsonObject.add("from",from);
        bodyJsonObject.add("to",to);
        bodyJsonObject.add("parcel_job",parcel_job);
        bodyJsonObject.add("pickup_timeslot",pickup_timeslot);
        bodyJsonObject.add("delivery_timeslot",delivery_timeslot);
       return new OrderCreateResponse( requestSpecification.body(bodyJsonObject).post());
    }
}
