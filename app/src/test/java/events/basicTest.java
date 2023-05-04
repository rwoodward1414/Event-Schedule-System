package events;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class basicTest {
    @Test
    public void userTest(){
        // User can be created and name can be changed
        User one = new User("One");
        assertEquals(one.getName(), "One");
        one.setName("two");
        assertEquals(one.getName(), "two");
    }

    @Test
    public void scheduleTest(){
        // Personal event with User as owner is added to user's schedule
        User one = new User("One");
        PersonalEvent event = new PersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one);
        assertEquals(event.getOwner(), one);
        assertEquals(one.printSchedule().size(), 1);

        // Schedule empty once event removed
        one.removeFromSchedule(event);
        assertEquals(one.printSchedule().size(), 0);
    }

    @Test
    public void changeEventsTest(){
        // Event details can be updated
        Event eventTwo = new GroupEvent("Test", LocalDateTime.of(2023, 6, 03, 8, 30, 00), "Place");
        eventTwo.setTitle("Hi");
        eventTwo.setTime(LocalDateTime.of(2023, 6, 03, 8, 30, 00));
        eventTwo.setLocation("Here");
        assertEquals("Hi", eventTwo.getTitle());
        assertEquals("Here", eventTwo.getLocation());
    }

    @Test
    public void groupEventsTest(){
        // Users can be added and removed from a group event's guest list
        User one = new User("One");
        GroupEvent event = new GroupEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        User two = new User("Two");
        event.addGuest(one);
        event.addGuest(two);
        assertEquals(event.getGuestList().size(), 2);
        event.removeGuest(two);
        assertEquals(event.getGuestList().size(), 1);
    }

    @Test
    public void failAddTest(){
        // Duplicate events or events with same start time are not added to a user's schedule
        User one = new User("One");
        PersonalEvent event = new PersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one);
        one.addToSchedule(event);
        PersonalEvent eventTwo = new PersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one);
        one.addToSchedule(eventTwo);
        assertEquals(one.printSchedule().size(), 1);
        PersonalEvent eventThree = new PersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one);
        assertEquals(one.printSchedule().size(), 1);        
        one.removeFromSchedule(eventThree);
        assertEquals(one.printSchedule().size(), 1);

    }

    @Test 
    public void invites(){
        // Users' schedules are updated after invites are sent
        User two = new User("Two");
        GroupEvent event = new GroupEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        event.addGuest(two);
        assertEquals(two.printSchedule().size(), 0);
        event.sendInvites();
        assertEquals(two.printSchedule().size(), 1);

        // Duplicate invites do not create duplicate events in schedule
        event.sendInvites();
        assertEquals(two.printSchedule().size(), 1);
    }

}
