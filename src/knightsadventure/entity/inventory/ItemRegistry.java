package knightsadventure.entity.inventory;

import java.util.HashMap;

/**
 * Stores items by their id
 * Ids are stored dynamically unless preassigned by code
 */
public class ItemRegistry {

    public static String FISTS_ID;

    private static HashMap<String, Item> registry;
    private static boolean initialized = false;

    public static void init() {
        if(initialized)
            return;

        registry = new HashMap<>();

        //Items
        WeaponItem fists = new WeaponItem("Fists", WeaponType.FISTS);
        fists.damages[0] = 4;
        FISTS_ID = fists.getId();
        addItem(FISTS_ID, fists);

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

    /**
     * Gets an item from the ItemRegistry
     * @param id Id of item
     * @return The item with specified registry id
     */
    public static Item getItem(String id) {
        return registry.get(id);
    }

}
