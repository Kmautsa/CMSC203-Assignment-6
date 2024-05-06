import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	@Test
    public void testConstructorAndGetters() {
        Customer customer = new Customer("Alice", 30);
        assertEquals("Alice", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Bob", 25);
        Customer copy = new Customer(original);
        assertEquals("Bob", copy.getName());
        assertEquals(25, copy.getAge());
    }

    @Test
    public void testSetters() {
        Customer customer = new Customer("Charlie", 40);
        customer.setName("David");
        customer.setAge(35);
        assertEquals("David", customer.getName());
        assertEquals(35, customer.getAge());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Eve", 20);
        String expected = "The customers age is 20\nand their name is Eve";
        assertEquals(expected, customer.toString());
    }
}