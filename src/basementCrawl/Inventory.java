package basementCrawl;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Item> items;
    private int max;

    public Inventory(int size) {
        this.items = new HashMap<String, Item>(size);
        max = size;
    }

    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * Add item to inventory.
     * 
     * @return false if inventory full
     */
    public boolean addItem(String itemName) {
        if (items.size() >= max){
            return false;
        }
        else{
            items.put(itemName, new Item(itemName));
            return true;
        }
    }

    /**
     * Remove specified item from inventory.
     * 
     * @return false if inventory empty
     */
    public boolean removeItem(String itemName) {
        if (items.size() > 0){
            items.remove(itemName);
            return true;
        }
        else return false;
    }

    public void clearInventory(){
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(String item : items.keySet()){
            if(items.size() == 1){
                s.append(item.toString());
            }
            else s.append(item.toString() + ", ");
        }
        s.append("]");
        return s.toString();
    }
}
