/**
 * This class for time slots needed for creating order request
 */
package APIs.UsersAndOthers;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;

public class TimeSlot {
    String start_time;
    String end_time;
    String timezone;

    public TimeSlot(String start_time,String end_time,String timezone)
    {
        this.start_time=start_time;
        this.end_time=end_time;
        this.timezone=timezone;
    }

    /**
     * returning xthe JsonObject for the timeslot to be added in the API request
     * @return
     */
    public JsonObject getTimeSlotObject()
    {
        JsonObject timeslot=new JsonObject();
        timeslot.add("start_time",start_time);
        timeslot.add("end_time",end_time);
        timeslot.add("timezone",timezone);
        return timeslot;
    }
}
