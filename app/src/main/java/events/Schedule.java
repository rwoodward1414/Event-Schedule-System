package events;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Schedule {
    private List<Event> events = new ArrayList<Event>();

    public Boolean addEvent(Event event) {
        for(Event plannedEvent : events) {
            if(plannedEvent.getTime().equals(event.getTime())) {
                return false;
            }
        }
        events.add(event);
        return true;
    }

    public Boolean removeEvent(Event event) {
        for(Event plannedEvent : events) {
            if(plannedEvent.equals(event)) {
                events.remove(event);
                return true;
            }
        }
        return false;
    }

    public List<Event> printSchedule() {
        List<Event> sorted = events;
        sorted.sort(Comparator.comparing(Event::getTime));

        for(Event event : sorted) {
            System.out.println(event.getTitle() + " " + event.getTime() + " " + event.getLocation());
        }
        return events;
    }

}
