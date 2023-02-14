/**
 * This class for the Shipper that will send the order requests and for all the actions needed for it
 */
package APIs.UsersAndOthers;

import APIs.APIsRequests.AuthRequest;
import APIs.APIsRequests.OrderCreateRequest;
import APIs.APIsResonses.AuthResponse;
import APIs.APIsResonses.OrderCreateResponse;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;

public class Shipper {

    private  AuthResponse authResponse;
    private OrderCreateResponse orderCreateResponse;
    private static String clientID;
    private static String clientSecret;
    public Address senderAddress;
    public Address receiverAddress;
    public Address pickUPAddress;
    public Participants from;
    public Participants to;
    public Participants parcel_job;
    public String pickup_date;
    public TimeSlot pickup_timeslot;
    public TimeSlot delivery_timeslot;

    public Shipper(String id, String secret)
    {
        clientID=id;
        clientSecret =secret;
    }


    /**
     * Sending the authentication request to get the access token
     * @param request
     * @return
     */
     public AuthResponse auth(AuthRequest request)
     {
         authResponse= request.sendAuthRequest(clientID,clientSecret);
         return authResponse;
     }

    /**
     * Creating an order
     * @param token
     * @param request
     * @return
     */
     public OrderCreateResponse createOrder(String token, OrderCreateRequest request)
     {
         orderCreateResponse = request.sendOrderCreateRequest(token,from.getParticipantObject(),to.getParticipantObject(),
                 createParcelJobObject(pickup_date,parcel_job),pickup_timeslot.getTimeSlotObject(),delivery_timeslot.getTimeSlotObject());

        return orderCreateResponse;
     }

    /**
     * creating the JsonObject for parcel_job that is needed for the request
     * @param pickup_date
     * @param parcelJob
     * @return
     */
     public JsonObject createParcelJobObject(String pickup_date,Participants parcelJob)
     {
         JsonObject parcel_job_OBJ= new JsonObject();
         parcel_job_OBJ.add("pickup_date",pickup_date);
         parcel_job_OBJ.add("pickup_address",parcelJob.getParticipantObject());
         return parcel_job_OBJ;
     }

}
