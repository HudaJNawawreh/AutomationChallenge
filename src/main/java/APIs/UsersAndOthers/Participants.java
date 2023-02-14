/**
 * This Class for holding the senders and receivers information
 */
package APIs.UsersAndOthers;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;

public class Participants {
    String name ="";
    String email="";
    String phone_number;
    Address address;

    public Participants(String name, String phone_number,String email, Address address)
    {
        this.name=name;
        this.email=email;
        this.phone_number=phone_number;
        this.address=address;
    }

    /**
     * returning the JsonObject of the participants to be used in the body of the request
     * @return
     */
    public JsonObject getParticipantObject()
    {
        JsonObject participant=new JsonObject();
        participant.add("name",name);
        participant.add("phone_number",phone_number);
        participant.add("email",email);
        participant.add("address", address.getAddressObject());
        return participant;
    }



}
