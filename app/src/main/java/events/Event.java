package events;

import java.time.LocalDateTime;

public abstract class Event {
    private String title;
    private LocalDateTime time;
    private String location;

    public Event(String title, LocalDateTime time, String location){
        this.title = title;
        this.time = time;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
}
