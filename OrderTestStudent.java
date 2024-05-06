import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	@Test
    public void testConstructorAndGetters() {
        Customer customer = new Customer("Alice", 30);
        Order order = new Order(123456, Day.MONDAY, customer);
        
        assertEquals(123456, order.getOrderNo());
        assertEquals(123456, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals("Alice", order.getCustomer().getName());
        assertEquals(30, order.getCustomer().getAge());
    }

    @Test
    public void testGenerateOrder() {
        
    }

    @Test
    public void testSetters() {
        Customer customer = new Customer("Bob", 25);
        Order order = new Order(654321, Day.SATURDAY, customer);
        
        order.setOrderNo(987654);
        order.setOrderDay(Day.SUNDAY);
        Customer newCustomer = new Customer("Charlie", 35);
        order.setCustomer(newCustomer);
        
        assertEquals(987654, order.getOrderNo());
        assertEquals(Day.SUNDAY, order.getOrderDay());
        assertEquals("Charlie", order.getCustomer().getName());
        assertEquals(35, order.getCustomer().getAge());
    }

    @Test
    public void testIsWeekend() {
        Order order1 = new Order(111111, Day.MONDAY, new Customer("Alice", 30));
        Order order2 = new Order(222222, Day.SATURDAY, new Customer("Bob", 25));
        
        assertFalse(order1.isWeekend());
        assertTrue(order2.isWeekend());
    }

    @Test
    public void testAddNewBeverage() {
        Order order = new Order(333333, Day.WEDNESDAY, new Customer("Charlie", 40));
        
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Green Smoothie", Size.LARGE, 3, true);
        
        assertEquals(3, order.getTotalItems());
    }

    @Test
    public void testCalcOrderTotal() {
        Order order = new Order(444444, Day.FRIDAY, new Customer("David", 50));
        order.addNewBeverage("Latte",Size.SMALL, true, false);
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Green Smoothie", Size.LARGE, 3, true);
        
        double expectedTotal = 1.5 + 6.0 + 6.5;
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        Order order = new Order(555555, Day.SUNDAY, new Customer("Eve", 20));
        order.addNewBeverage("Latte", Size.SMALL, true, false);
        order.addNewBeverage("Beer",Size.MEDIUM);
        order.addNewBeverage("Green Smoothie", Size.LARGE, 3, true);
        
        assertEquals(2, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Alice", 30);
        Order order = new Order(123456, Day.MONDAY, customer);
        
        String expected = "The Order Info is as follows; Order Number: 123456 Order Time: 123456Order Day: MONDAY Customer Information: 30 Alice";
        assertEquals(expected, order.toString());
    }

    @Test
    public void testCompareTo() {
        Order order1 = new Order(111111, Day.MONDAY, new Customer("Alice", 30));
        Order order2 = new Order(222222, Day.TUESDAY, new Customer("Bob", 25));
        Order order3 = new Order(333333, Day.WEDNESDAY, new Customer("Charlie", 35));
        
        assertEquals(0, order1.compareTo(order1));
        assertTrue(order1.compareTo(order2) < 0);
        assertTrue(order2.compareTo(order3) < 0);
        assertTrue(order3.compareTo(order2) > 0);
    }
}