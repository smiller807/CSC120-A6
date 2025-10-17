import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ShopTest {
    @Test
    public void testBuy() throws Exception{
        ResaleShop shop = new ResaleShop();
        
        shop.buy(null);
        ArrayList<Computer> inventory = shop.inventory;
        Computer compInInventory = inventory.get(0);

        assertEquals("Computer is already in the inventory", compInInventory,  compInInventory);
    }

    @Test
    public void testSell() throws Exception{
        ResaleShop shop = new ResaleShop();
        
        shop.buy(null);
        ArrayList<Computer> inventory = shop.inventory;
        Computer compInInventory = inventory.get(0);

        shop.sell(compInInventory);
        assertFalse("Computer should be removed from inventory", 
            shop.inventory.contains(compInInventory));
        
        shop.sell(compInInventory);
        assertEquals("Computer is not in the inventory", compInInventory, compInInventory);
    }

    @Test
    public void testNewPrice() throws Exception{
        ResaleShop shop = new ResaleShop();

        // buy(null) will add the hardcoded computer
        shop.buy(null);

        // Access the inventory directly (same package)
        ArrayList<Computer> inventory = shop.inventory;

        // Get the actual computer added by buy()
        Computer compInInventory = inventory.get(0);

        // Refurbish the computer
        shop.refurbish(compInInventory, "None");

        // Check the price is updated as expected for 2019 model
        assertEquals("price didn't change", 1000, compInInventory.price);
    }

    @Test
    public void testNewOS() throws Exception{
        ResaleShop shop = new ResaleShop();

        shop.buy(null);

        ArrayList<Computer> inventory = shop.inventory;

        Computer compInInventory = inventory.get(0);

        shop.refurbish(compInInventory, "macOS Big Sur");

        assertEquals("OS didn't change", "macOS Big Sur", "High Sierra");
    }
    public void main(String args[]) throws Exception{
        testBuy();
        testSell();
        testNewPrice();
        testNewOS();
    }
    
}
