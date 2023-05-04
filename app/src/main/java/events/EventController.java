package events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventController {
    private List<Event> allEvents = new ArrayList<Event>();
    private List<GroupEvent> groupEvents = new ArrayList<GroupEvent>();
    private List<User> users = new ArrayList<User>();

    public void createUser(String name){
        if(findUser(name) != null){
            System.out.println("User with that name already exists!");
            return;
        }
        User user = new User(name);
        users.add(user);
    }

    public void createPersonalEvent(String title, LocalDateTime time, String location, String name){
        if(findEvent(title) != null){
            System.out.println("Event with that title already exists!");
            return;
        }
        User user = findUser(name);
        if(user == null){ return; };
        PersonalEvent event = new PersonalEvent(title, time, location, user);
        allEvents.add(event);
    }

    public void createGroupEvent(String title, LocalDateTime time, String location){
        if(findEvent(title) != null){
            System.out.println("Event with that title already exists!");
            return;
        }
        GroupEvent event = new GroupEvent(title, time, location);
        allEvents.add(event);
        groupEvents.add(event);
    }

    public void addToGuestlist(String title, String name){
        User user = findUser(name);
        GroupEvent event = findGroupEvent(title);
        if(user == null || event == null){ return; };
        event.addGuest(user);
    }

    public void removeGuest(String title, String name){
        User user = findUser(name);
        GroupEvent event = findGroupEvent(title);
        if(user == null || event == null){ return; };
        event.removeGuest(user);
        user.removeFromSchedule(event);
    }

    public void sentInvites(String title){
        GroupEvent event = findGroupEvent(title);
        if(event == null){ return; };
        event.sendInvites();
    }

    public void removeFromSchedule(String title, String name){
        User user = findUser(name);
        Event event = findEvent(title);
        if(user == null || event == null){ return; };
        user.removeFromSchedule(event);
    }

    public void printSchedule(String name){
        User user = findUser(name);
        if(user == null){ return; };
        user.printSchedule();
    }

    public void printGuestList(String title){
        GroupEvent event = findGroupEvent(title);
        if(event == null){ return; };
        List<User> list = event.getGuestList();
        for(User user : list){
            System.out.println(user.getName());
        }
    }

    public User findUser(String name){
        for(User user : users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public GroupEvent findGroupEvent(String title){
        for(GroupEvent event : groupEvents){
            if(event.getTitle().equals(title)){
                return event;
            }
        }
        return null;
    }

    public Event findEvent(String title){
        for(Event event : allEvents){
            if(event.getTitle().equals(title)){
                return event;
            }
        }
        return null;
    }
}
