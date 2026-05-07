package basementCrawl;

/**
 * The main event class.
 */
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

    /**
     * Returns the event ID.
     * @return
     */
    public int getID() {
        return eventID;
    }

    /**
     * Returns the event description.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the options of the event.
     * @return
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Returns any items linked to the event.
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns the event as a string.
     */
    @Override
    public String toString() {
        String opString = "";
        for (String op : options) {
            opString += op + "\n";
        }
        return description + "\n" + opString;
    }
}
