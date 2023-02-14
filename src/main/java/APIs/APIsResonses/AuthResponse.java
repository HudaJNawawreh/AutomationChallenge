/**
 * This class for the responses that come from the auth request API
 */
package APIs.APIsResonses;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class AuthResponse
{
    public Response authResponse;
    public AuthResponse(Response response) {
        authResponse =response;
    }

    /**
     * getting the token from the response
     * @return
     */
    public String getAccessToken()
    {
        JsonPath jsonPath = authResponse.jsonPath();
        return jsonPath.get("access_token");

    }

    /**
     * getting the response status code
     * @return
     */
    public int getStatusCode() {
        return authResponse.getStatusCode();
    }
}
