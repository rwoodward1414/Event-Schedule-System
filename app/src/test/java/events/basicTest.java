package events;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class basicTest {
    @Test
    public void userTest(){
        User one = new User("One");
        assertEquals(one.getName(), "One");
        one.setName("two");
        assertEquals(one.getName(), "two");
    }

    @Test
    public void scheduleTest(){
        User one = new User("One");
        PersonalEvent event = new PersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one.getName());
        one.addToSchedule(event);
        assertEquals(one.printSchedule().size(), 1);
        one.removeFromSchedule(event);
        assertEquals(one.printSchedule().size(), 0);
    }

    @Test
    public void createEventsTest(){
        User one = new User("One");
        one.createEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "Personal");
        one.createEvent("Test", LocalDateTime.of(2023, 6, 03, 8, 30, 00), "Place", "Group");
        assertEquals(one.printSchedule().size(), 0);
    }

    @Test
    public void groupEventsTest(){
        User one = new User("One");
        GroupEvent event = new GroupEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", one);
        User two = new User("Two");
        event.addGuest(two);
        assertEquals(event.getGuestList().size(), 2);
        event.removeGuest(two);
        assertEquals(event.getGuestList().size(), 1);
    }

}
