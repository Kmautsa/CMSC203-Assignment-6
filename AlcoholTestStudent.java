import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlcoholTestStudent {


    @Test
    public void testCalcPrice() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        assertEquals(5.0, alcohol1.calcPrice());
        
        Alcohol alcohol2 = new Alcohol("Wine", Size.MEDIUM, false);
        assertEquals(6.0, alcohol2.calcPrice());
        
        Alcohol alcohol3 = new Alcohol("Whiskey", Size.LARGE, true);
        assertEquals(7.2, alcohol3.calcPrice());
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, false);
        assertEquals("The beverage name is Beer size SMALL\nWeekend Price: false", alcohol.toString());
    }

    @Test
    public void testEquals() {
        Alcohol alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol alcohol3 = new Alcohol("Wine", Size.MEDIUM, true);

        assertTrue(alcohol1.equals(alcohol2));
        assertFalse(alcohol1.equals(alcohol3));
    }

    @Test
    public void testGetIsWeekend() {
        Alcohol alcohol = new Alcohol("Beer", Size.SMALL, true);
        assertTrue(alcohol.getIsWeekend());
    }
}
