package knightsadventure.entity.inventory;

import java.util.HashMap;

/**
 * Stores items by their id
 * Ids are stored dynamically unless preassigned by code
 */
public class ItemRegistry {

    private static HashMap<String, Item> registry;
    private static boolean initialized = false;

    public static void init() {
        if(initialized)
            return;

        registry = new HashMap<>();
        initialized = true;
    }

    /**
     * Adds item based on id
     * @param id Id of item
     * @param item Item to be added to registry
     * @return If id is already taken return false
     */
    public static boolean addItem(String id, Item item) {
        if(registry.containsKey(id))
            return false;

        registry.put(id, item);
        return true;
    }

}
