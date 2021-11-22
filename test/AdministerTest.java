import model.user.Administer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministerTest {
   Administer administer=new Administer("Abby","4089999999");
    @Test
    void getName() {
        assertEquals(administer.getName(),"Abby");
    }

    @Test
    void getID() {
        assertEquals(administer.getID(),"4089999999");
    }
}