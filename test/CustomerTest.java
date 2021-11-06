import Model.user.Customer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer=new Customer("Bob","6099999999");
    @Test
    void getName() {
        assertEquals(customer.getName(),"Bob");
    }

    @Test
    void getPhone() {
        assertEquals(customer.getPhone(),"6099999999");
    }

}