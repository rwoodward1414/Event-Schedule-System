package events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupEvent extends Event{
    private List<User> guestList = new ArrayList<User>();

    public GroupEvent(String title, LocalDateTime time, String location, User owner){
        super(title, time, location);
        guestList.add(owner);
    }

    public void addGuest(User name){
        guestList.add(name);
    }

    public void removeGuest(User name){
        guestList.remove(name);
    }

    public void sendInvites(){
        return;
    }

    public List<User> getGuestList() {
        return guestList;
    }
    
}
