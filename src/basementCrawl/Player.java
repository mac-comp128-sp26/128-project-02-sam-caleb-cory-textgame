package basementCrawl;

public class Player {
    private Inventory inventory;
    private String name;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory(5);
    }

    /**
     * Returns the player's chosen name.
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the contents of player's inventory.
     * 
     * @return
     */
    public Inventory getInventory() {
        return inventory;
    }
}
