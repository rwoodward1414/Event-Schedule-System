package events;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    private User owner;

    public PersonalEvent(String title, LocalDateTime time, String location, User owner){
        super(title, time, location);
        this.owner = owner;
        owner.addToSchedule(this);
    }

    public User getOwner() {
        return owner;
    }
    
}
