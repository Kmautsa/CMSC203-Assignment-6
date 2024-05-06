import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	@Test
    public void testCalcPrice() {
        Coffee coffee1 = new Coffee("Latte", Size.SMALL, false, false);
        assertEquals(1.5, coffee1.calcPrice(), 0.01);

        Coffee coffee2 = new Coffee("Mocha",Size.MEDIUM, true, false);
        assertEquals(3.0, coffee2.calcPrice(), 0.01);

        Coffee coffee3 = new Coffee("Cappuccino", Size.LARGE, false, true);
        assertEquals(3.5, coffee3.calcPrice(), 0.01);

        Coffee coffee4 = new Coffee("Americano", Size.SMALL, true, true);
        assertEquals(2.5, coffee4.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Latte ", Size.SMALL, true, false);
        String expected = "Latte size : SMALL\nExtra Shot :true\nExtra Syrup: false";
        assertEquals(expected, coffee.toString());
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Latte", Size.SMALL, true, false);
        Coffee coffee2 = new Coffee("Latte",Size.SMALL, true, false);
        Coffee coffee3 = new Coffee("Cappuccino", Size.LARGE, false, true);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(coffee3));
    }
}
