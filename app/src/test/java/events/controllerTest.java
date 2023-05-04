package events;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class controllerTest {
    @Test
    public void userTest(){
        EventController ec = new EventController();
        ec.createUser("Test");
        assertNotEquals(null, ec.findUser("Test"));
    }

    @Test
    public void eventTest(){
        EventController ec = new EventController();
        ec.createUser("one");
        ec.createPersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "one");
        ec.createGroupEvent("Testing", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        assertNotEquals(null, ec.findEvent("Test"));
        assertNotEquals(null, ec.findEvent("Testing"));
    }

    @Test
    public void guestListTest(){
        EventController ec = new EventController();
        ec.createUser("one");
        ec.createGroupEvent("Testing", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        ec.addToGuestlist("Testing", "one");
        ec.printGuestList("Testing");
        ec.removeGuest("Testing", "one");
        ec.printGuestList("Testing");
    }

    @Test
    public void invitesTest(){
        EventController ec = new EventController();
        ec.createUser("one");
        ec.createGroupEvent("Testing", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        ec.addToGuestlist("Testing", "one");
        ec.sentInvites("Testing");
        ec.printSchedule("one");
    }

    @Test
    public void removeTest(){
        EventController ec = new EventController();
        ec.createUser("one");
        ec.createPersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "one");
        ec.removeFromSchedule("Test", "one");
        ec.printSchedule("one");
    }

    @Test
    public void notExistTest(){
        EventController ec = new EventController();
        assertEquals(null, ec.findUser("Test"));
        assertEquals(null, ec.findGroupEvent("Test"));
        assertEquals(null, ec.findEvent("Test"));
        ec.createPersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "one");
        ec.addToGuestlist("Testing", "one");

    }

    @Test
    public void alreadyExistTest(){
        EventController ec = new EventController();
        ec.createUser("one");
        ec.createUser("one");
        ec.createPersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "one");
        ec.createGroupEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place");
        ec.createPersonalEvent("Test", LocalDateTime.of(2023, 5, 03, 8, 30, 00), "Place", "one");
        assertEquals(null, ec.findGroupEvent("Test"));

    }
}
