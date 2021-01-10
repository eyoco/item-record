import model.ItemMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestItemMap {
    private ItemMap iMapEmpty;
    private ItemMap iMapTestOne;
    private Map<String,String> mapOne = new HashMap<>();
    private Map<String,String> mapEmpty = new HashMap<>();

    @BeforeEach
    public void setup(){
        iMapEmpty = new ItemMap();
        iMapTestOne = new ItemMap();
        iMapTestOne.addItem("McDouble", "fridge");
        iMapTestOne.addItem("Pizza", "Baker");
        iMapTestOne.addItem("Rice", "desk");
        mapOne.put("McDouble", "fridge");
        mapOne.put("Pizza", "Baker");
        mapOne.put("rice", "desk");
    }

    @Test
    public void testGetItemMapNotEmpty(){
        assertFalse(iMapTestOne.getItemMap().equals(mapOne));
    }

    @Test
    public void testGetItemMapEmpty(){
        assertFalse(iMapEmpty.equals(mapEmpty));
    }

    @Test
    public void testCheckEmptyTrue(){
        assertTrue(iMapEmpty.checkEmpty());
    }

    @Test
    public void testCheckEmptyFalse(){
        assertFalse(iMapTestOne.checkEmpty());
    }

    @Test
    public void testCheckContainsKeyEmpty(){
        assertFalse(iMapEmpty.checkContainsKey("Pizza"));
    }

    @Test
    public void testCheckContainsKeyTrue(){
        assertTrue(iMapTestOne.checkContainsKey("Pizza"));
    }

    @Test
    public void testCheckContainsKeyFalse(){
        assertFalse(iMapTestOne.checkContainsKey("Noodle"));
    }

    @Test
    public void testAddItemTrue(){
        assertTrue(iMapEmpty.checkEmpty());
        assertFalse(iMapEmpty.checkContainsKey("iPhone"));
        iMapEmpty.addItem("iPhone", "backpack");
        assertFalse(iMapEmpty.checkEmpty());
        assertTrue(iMapEmpty.checkContainsKey("iPhone"));
    }

    @Test
    public void testAddItemFalse() {
        assertTrue(iMapEmpty.checkEmpty());
        assertFalse(iMapEmpty.checkContainsKey("iPhone"));
        iMapEmpty.addItem("iPhone", "backpack");
        assertFalse(iMapEmpty.checkEmpty());
        assertFalse(iMapEmpty.checkContainsKey("iPad"));
    }

    @Test
    public void testShowValueTrue(){
        assertEquals(iMapTestOne.showValue("McDouble"), "fridge");
    }

    @Test
    public void testShowValueFalse(){
        assertFalse(iMapTestOne.showValue("McDouble").equals("baker"));
    }

    @Test
    public void testRemoveItemTrue(){
        assertTrue(iMapTestOne.checkContainsKey("Rice"));
        iMapTestOne.removeItem("Rice");
        assertFalse(iMapTestOne.checkContainsKey("Rice"));
    }

    @Test
    public void testRemoveItemFalse(){
        assertTrue(iMapTestOne.checkContainsKey("Rice"));
        iMapTestOne.removeItem("Rice");
        assertTrue(iMapTestOne.checkContainsKey("Pizza"));
    }
}
