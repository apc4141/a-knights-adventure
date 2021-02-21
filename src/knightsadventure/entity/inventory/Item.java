package knightsadventure.entity.inventory;

import knightsadventure.tools.*;

/**
 * Basic class for an item that contains an item name and whether it is stackable
 */
public abstract class Item {

    private static final int ID_LEN = 32;

    private final String id;

    public String name;
    public ItemType itemType;
    public boolean stackable;

    //region Constructors
    public Item(String name, ItemType itemType, String id, boolean stackable) {
        this.name = name;
        this.itemType = itemType;
        this.id = id;
        this.stackable = stackable;
    }

    public Item(String name, ItemType itemType, boolean stackable) {
        this.name = name;
        this.itemType = itemType;
        this.id = generateUniqueId();
        this.stackable = stackable;
    }

    public Item(String name, ItemType itemType, String id) {
        this.name = name;
        this.itemType = itemType;
        this.id = id;
        this.stackable = true;
    }

    public Item(String name, ItemType itemType) {
        this.name = name;
        this.itemType = itemType;
        this.id = generateUniqueId();
        this.stackable = true;
    }
    //endregion

    /**
     * @return This objects id as String
     */
    public String getId() {
        return id;
    }

    /**
     * Returns whether this item may be used with Inventory class' equip function
     * @return True if equippable
     */
    public boolean isEquippable() {
        return (itemType == ItemType.WEAPON && getClass() == WeaponItem.class) ||
                (itemType == ItemType.ARMOR && getClass() == ArmorItem.class);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;

        Item item = (Item)o;
        return item.id.equals(this.id);
    }

    /**
     * Generates a new unique ID such that no other items in the registry have it
     * @return Unique ID
     */
    private String generateUniqueId() {
        boolean check = false;
        String id = "";
        while(!check) {
            id = ID.generate(ID_LEN);
            check = ItemRegistry.addItem(id, this);
        }
        return id;
    }

    /**
     * Returns this items info in a nice to read format
     * @return This weapons info
     */
    public abstract String getInfo();
}
