package basementCrawl;

public class Event {
    String title;
    String description;
    String[] options;
    int eventID;
    String filePath;

    public Event(String title, String description, String[] options, int eventID, String filePath) {
        this.description = description;
        this.options = options;
        this.options = options;
        this.eventID = eventID;
        this.filePath = filePath;
    }

    public int getID() {
        return eventID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getOptions() {
        return options;
    }
}
