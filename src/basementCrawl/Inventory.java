package basementCrawl;

public class Inventory {
    private Item[] inventory;

    public Inventory(Item[] inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds item to inventory.
     * 
     * @return false if inventory full
     */
    public boolean addItem() {
        return false;
    }

    /**
     * Removes item from inventory.
     * 
     * @return false if inventory empty
     */
    public boolean removeItem() {
        return false;
    }
}
