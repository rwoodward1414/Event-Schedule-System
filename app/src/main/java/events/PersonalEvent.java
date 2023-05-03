package events;

import java.time.LocalDateTime;

public class PersonalEvent extends Event {
    private String owner;

    public PersonalEvent(String title, LocalDateTime time, String location, String owner){
        super(title, time, location);
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
    
}
