package Thing;

import org.junit.Test;

import static org.junit.Assert.*;


public class ThingTest {


    Thing thing = new Thing("Pen", 2);

    @Test
    public void testGetName() {
        assertEquals("Penn", thing.getName());
    }

    @Test
    public void testGetQuantity() {
        assertNotNull(thing.getQuantity());//варианты проверок
        assertFalse(thing.getQuantity()<-1 && thing.getQuantity()>10);//варианты проверок
        assertEquals(3, thing.getQuantity());
    }

}