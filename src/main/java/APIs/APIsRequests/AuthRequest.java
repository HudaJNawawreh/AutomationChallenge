/**
 * This Class for authentication requests that the shipper will do, in order to do actions on the system
 */
package APIs.APIsRequests;

import APIs.APIsResonses.AuthResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class AuthRequest {
    private static final String BASE_URL = "https://v4.ninja.com/sg/oauth/access_token";

    public RequestSpecification requestSpecification;

    /**
     * The authentication request will always have the same headers and base url
     */
    public AuthRequest(){
        RestAssured.baseURI=BASE_URL;
        requestSpecification= RestAssured.given();
        requestSpecification.header("Cache-Control", "no-cache")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("accept-encoding", "gzip, deflate")
                .header("cache-control", "no-cache");
    }

    /**
     * it will append the client id and secrete to the body of the auth req then post it
     * @param clientID
     * @param clientSecret
     * @return AuthResponse object
     */
    public AuthResponse sendAuthRequest(String clientID, String clientSecret)
    {
        requestSpecification.body("{ \"client_id\": \""+clientID+"\", \"client_secret\": \""+clientSecret+"\" }");
        return new AuthResponse(requestSpecification.post());
    }
}
