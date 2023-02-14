/**
 * This for responses come from order create requests
 */
package APIs.APIsResonses;

import io.restassured.response.Response;

public class OrderCreateResponse {
    private Response response;
    public OrderCreateResponse(Response response) {
        this.response = response;
    }

    /**
     * getting the response status code
     * @return
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * getting the response body
     * @return
     */
    public String getResponseBody(){
        return response.getBody().asString();}
}
