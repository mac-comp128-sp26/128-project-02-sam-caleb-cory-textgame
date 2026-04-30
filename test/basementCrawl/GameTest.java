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
        inventory.addItem("wallet");
        assertEquals(inventory.toString(), "[wallet, ]"); 

        // Check to ensure we can't add to a full inventory
        inventory.addItem("keys");
        inventory.addItem("phone");
        assertFalse(inventory.addItem("book"));
    }
    
    @Test
    public void testInventoryRemoveLastItem(){
        inventory = new Inventory(3);
        inventory.addItem("wallet");
        inventory.addItem("keys");
        assertTrue(inventory.getItems().containsKey("keys"));
        inventory.removeItem("keys"); // Remove "keys"
        System.out.println(inventory.getItems().toString());
        assertFalse(inventory.getItems().containsKey("keys"));

        // Check to ensure we can't remove from an empty inventory
        inventory.removeItem("wallet"); // Remove "wallet"
        assertFalse(inventory.removeItem("wallet"));
    }

    @Test
    public void testInventoryClear(){
        inventory = new Inventory(3);
        inventory.addItem("wallet");
        assertEquals(inventory.toString(), "[wallet, ]");
        inventory.clearInventory();
        assertEquals(inventory.toString(), "[]");
    }
}
