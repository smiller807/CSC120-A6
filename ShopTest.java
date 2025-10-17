import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ShopTest {
    @Test
    public void testBuy() throws Exception{
        Computer computer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500);
        
        ResaleShop shop = new ResaleShop();
        
        shop.buy(computer);
        assertEquals("Computer is already in the inventory", computer,  computer);
    }

    @Test
    public void testSell() throws Exception{
        Computer computer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500);
        
        ResaleShop shop = new ResaleShop();

        shop.buy(computer);
        shop.sell(computer);
        assertFalse("Computer should be removed from inventory", 
            shop.inventory.contains(computer));
        
        shop.sell(computer);
        assertEquals("Computer is not in the inventory", computer, computer);
    }

    public void main(String args[]) throws Exception{
        testBuy();
        testSell();
    }
    
}
