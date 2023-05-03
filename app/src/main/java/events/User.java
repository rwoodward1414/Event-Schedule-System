package events;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private String name;
    private Schedule schedule;

    public User(String name){
        this.name = name;
        schedule = new Schedule();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createEvent(String title, LocalDateTime time, String location, String type){
        return;
    }

    public void addToSchedule(Event event){
        schedule.addEvent(event);
    }

    public void removeFromSchedule(Event event){
        schedule.removeEvent(event);
    }

    public List<Event> printSchedule(){
        return schedule.printSchedule();
    }

}
