import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

    @Test
    public void testConstructorAndGetters() {
        Smoothie smoothie = new Smoothie("Test Smoothie", Size.SMALL, 2, true);
        
        assertEquals("Test Smoothie", smoothie.getBevName());
        assertEquals(Size.SMALL, smoothie.getSize());
        assertEquals(2, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    public void testSetters() {
        Smoothie smoothie = new Smoothie("Test Smoothie", Size.SMALL, 2, true);

        smoothie.setNumofFruits(3);
        smoothie.setAddProtein(false);

        assertEquals(3, smoothie.getNumOfFruits());
        assertFalse(smoothie.getAddProtein());
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Test Smoothie", Size.MEDIUM, 3, false);
        String expected = "Test Smoothie, MEDIUM, 3fruits, $5.0";
        assertEquals(expected, smoothie.toString());
    }

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Test Smoothie", Size.LARGE, 4, true);
        double expectedPrice = 5.50 + (4 - 1) * 0.50 + 3 * 3.0 + 1.50;
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.001);
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Test Smoothie", Size.MEDIUM, 2, true);
        Smoothie smoothie2 = new Smoothie("Test Smoothie", Size.MEDIUM, 2, true);
        Smoothie smoothie3 = new Smoothie("Test Smoothie", Size.LARGE, 3, false);

        assertTrue(smoothie1.equals(smoothie2));
        assertFalse(smoothie1.equals(smoothie3));
    }
}