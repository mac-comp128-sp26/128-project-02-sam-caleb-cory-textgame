package basementCrawl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class GameTest {

    private Inventory inventory;

    @Test
    public void testInventoryAdd(){
        inventory = new Inventory(3);
        inventory.addItem(new Item("wallet"));
        assertEquals(inventory.toString(), "[wallet, ]"); 

        // Check to ensure we can't add to a full inventory
        inventory.addItem(new Item("keys"));
        inventory.addItem(new Item("phone"));
        assertFalse(inventory.addItem(new Item("book")));
    }
    
    @Test
    public void testInventoryRemoveLastItem(){
        inventory = new Inventory(3);
        inventory.addItem(new Item("wallet"));
        inventory.addItem(new Item("keys"));
        assertEquals(inventory.toString(), "[wallet, keys, ]");
        inventory.removeLastItem(); // Remove "keys"
        assertEquals(inventory.toString(), "[wallet, ]");

        // Check to ensure we can't remove from an empty inventory
        inventory.removeLastItem(); // Remove "wallet"
        assertFalse(inventory.removeLastItem());
    }

    @Test
    public void testInventoryClear(){
        inventory = new Inventory(3);
        inventory.addItem(new Item("wallet"));
        assertEquals(inventory.toString(), "[wallet, ]");
        inventory.clearInventory();
        assertEquals(inventory.toString(), "[]");
    }
}
