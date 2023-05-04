package events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupEvent extends Event{
    private List<User> guestList = new ArrayList<User>();

    public GroupEvent(String title, LocalDateTime time, String location){
        super(title, time, location);
    }

    public void addGuest(User name){
        guestList.add(name);
    }

    public void removeGuest(User name){
        guestList.remove(name);
    }

    public void sendInvites(){
        for(User user : guestList){
            user.invitationAlert(this);
        }
        return;
    }

    public List<User> getGuestList() {
        return guestList;
    }
    
}
