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
        this.id = ID.generate(ID_LEN);
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
        this.id = ID.generate(ID_LEN);
        this.stackable = true;
    }
    //endregion

    /**
     * @return This objects id as String
     */
    public String getId() {
        return id;
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


}
