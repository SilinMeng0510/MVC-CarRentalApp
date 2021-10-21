import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer=new Customer("Bob","6099999999",123456780);
    @Test
    void getName() {
        assertEquals(customer.getName(),"Bob");
    }

    @Test
    void getPhone() {
        assertEquals(customer.getPhone(),"6099999999");
    }

}