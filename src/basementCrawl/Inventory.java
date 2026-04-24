package basementCrawl;

public class Inventory {
    private Item[] items;
    private int nextIdx;

    public Inventory(int size) {
        this.items = new Item[size];
        nextIdx = 0;
    }

    public Item[] getItems(){
        return items;
    }

    /**
     * Adds item to inventory at next open index.
     * 
     * @return false if inventory full
     */
    public boolean addItem(Item item) {
        if (nextIdx >= items.length){
            return false;
        }
        else{
            items[nextIdx] = item;
            nextIdx++;
            return true;
        }
    }

    /**
     * Removes the most recently added item from inventory.
     * 
     * @return false if inventory empty
     */
    public boolean removeLastItem() {
        if (nextIdx > 0){
            items[nextIdx - 1] = null;
            nextIdx--;
            return true;
        }
        else return false;
    }

    /**
     * Resets the inventory by filling it with null instances.
     * 
     */
    public void clearInventory(){
        for(int i = 0; i < items.length; i++){
            items[i] = null;
        }
        nextIdx = 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(int i = 0; i < nextIdx; i++){
            s.append(items[i].toString() + ", ");
        }
        s.append("]");
        return s.toString();
    }
}
