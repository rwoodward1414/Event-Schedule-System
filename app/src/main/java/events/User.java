package events;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String name;
    private Schedule schedule;

    public User(String name) {
        this.name = name;
        schedule = new Schedule();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event createEvent(String title, LocalDateTime time, String location, String type) {
        if(type == "Personal") {
            PersonalEvent event = new PersonalEvent(title, time, location, this.name);
            addToSchedule(event);
            return event;
        } else {
            GroupEvent event = new GroupEvent(title, time, location, this);
            addToSchedule(event);
            return event;
        }
    }

    public boolean addToSchedule(Event event) {
        return schedule.addEvent(event);
    }

    public void removeFromSchedule(Event event) {
        schedule.removeEvent(event);
    }

    public List<Event> printSchedule() {
        return schedule.printSchedule();
    }

    public void invitationAlert(Event event) {
        if(addToSchedule(event)){
            System.out.println(this.name + " has been invited to " + event.getTitle() + 
            ". \nThis event was automatically added to the schedule. Please remove event if you wish to cancel.");
        }
    }

}
