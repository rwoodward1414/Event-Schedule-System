package events;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Event> events = new ArrayList<Event>();

    public Boolean addEvent(Event event){
        events.add(event);
        return true;
    }

    public Boolean removeEvent(Event event){
        events.remove(event);
        return true;
    }

    public List<Event> printSchedule(){
        for(Event event : events){
            System.out.println(event.getTitle() + " " + event.getTime() + " " + event.getLocation());
        }
        return events;
    }

}
