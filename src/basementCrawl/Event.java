package basementCrawl;

public class Event {
    String description;
    String[] options;
    int eventID;

    public Event(String blurb, String[] options, int id) {
        this.description = blurb;
        this.options = options;
        this.eventID = id;
    }

    public int getID() {
        return eventID;
    }

    public String getDescription() {
        return description;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public String toString() {
        String opString = "";
        for (String op : options) {
            opString += op + "\n";
        }
        return description + "\n" + opString;
    }
}
