package model;

import java.util.HashMap;
import java.util.Map;

public class ItemMap {
    private Map<String,String> itemMap = new HashMap<>();

    public Map<String,String> getItemMap() {
        return itemMap;
    }

    public boolean checkEmpty() {
        if (itemMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkContainsKey(String name) {
        if (itemMap.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    public void addItem(String name, String location) {
        itemMap.put(name,location);
    }

    public String showValue(String name) {
        return itemMap.get(name);
    }

    public void removeItem(String name) {
        itemMap.remove(name);
    }
}
