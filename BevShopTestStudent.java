import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	@Test
    public void testIsValidTime() {
        BevShop bevShop = new BevShop();
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(5));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        BevShop bevShop = new BevShop();
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        BevShop bevShop = new BevShop();
        assertEquals(21, bevShop.getMinAgeForAlcohol());
    }

  

    @Test
    public void testToString() {
        BevShop bevShop = new BevShop();
        bevShop.startNewOrder(10, Day.MONDAY, "John", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        bevShop.processAlcoholOrder("Wine", Size.SMALL);
        bevShop.processSmoothieOrder("Fruit Blast", Size.LARGE, 3, true);

        String expected = "Orders:\n" +
        		"The Order Info is as follows; Order Number: 10 Order Time: 10Order Day: MONDAY Customer Information: 25 John"+
        		"\nTotal Monthly Sale: $13.0";

        assertEquals(expected, bevShop.toString());
    }
}

