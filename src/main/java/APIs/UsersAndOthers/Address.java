/**
 * class for Addresses to be used for the shipping
 */
package APIs.UsersAndOthers;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;

public class Address {
    String address1 = "";
    String address2 = "";
    String country = "";
    String postcode = "";

    /**
     * if there are two addresses this constructor to be used
     * @param address1
     * @param address2
     * @param country
     * @param postcode
     */
    public Address(String address1, String address2,String country, String postcode)
    {
        this.address1 =address1;
        this.address2=address2;
        this.country=country;
        this.postcode=postcode;
    }

    /**
     * if there is only one address this constructor will be used
     * @param address1
     * @param country
     * @param postcode
     */
    public Address(String address1,String country, String postcode)
    {
        this.address1 =address1;
        this.country=country;
        this.postcode=postcode;
    }

    /**
     * Returning the JsonObject for the Address to be added to the request body
     * @return
     */
    public JsonObject getAddressObject()
    {
        JsonObject address=new JsonObject();
        address.add("address1",address1);
        address.add("address2",address2);
        address.add("country",country);
        address.add("postcode",postcode);
        return address;
    }
}
