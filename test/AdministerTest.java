import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministerTest {
   Administer administer=new Administer("Abby","4089999999",123456789);
    @Test
    void getName() {
        assertEquals(administer.getName(),"Abby");
    }

    @Test
    void getPhone() {
        assertEquals(administer.getPhone(),"4089999999");
    }
}