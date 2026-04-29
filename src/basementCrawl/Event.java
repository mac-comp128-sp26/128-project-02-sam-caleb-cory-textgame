package basementCrawl;

public class Event {
    String description;
    String[] options;
    int eventID;
    Item item;

    public Event(String blurb, String[] options, int id, Item item) {
        this.description = blurb;
        this.options = options;
        this.eventID = id;
        this.item = item;
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

    public Item getItem() {
        return item;
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
