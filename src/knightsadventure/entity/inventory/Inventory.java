package knightsadventure.entity.inventory;

import java.util.ArrayList;

/**
 * Holds a players items/weapons/armors
 */
public class Inventory {

    private ArrayList<ItemStack> items;

    /*
    * Armors:
    * Helmet 0
    * Chestplate 1
    * Gauntlets 2
    * Leggings 3
    * Boots 4
    */
    //Equipped items
    private final ArmorItem[] armors;
    

    public Inventory() {
        super();
        items = new ArrayList<ItemStack>();
        armors = new ArmorItem[ArmorType.values().length];
    }

    /**
     * Adds an item to the inventory
     * If the item stack is already contained in the inventory it will
     * add the amount to the existing item stack
     * @param itemStack ItemStack to add
     */
    public void addItem(ItemStack itemStack)
    {
        for(ItemStack is : items) {
            if((is.getItem().equals(itemStack.getItem())) && (is.isStackable())) {
                is.changeAmount(itemStack.getAmount());
                return;
            }
        }
        items.add(itemStack);
    }

    /**
     * Equips the item in a specified index in armor type slot
     * @param index Index of item
     * @param type Armor slot to equip
     */
    public void equipArmor(int index, ArmorType type) {
        if(index >= items.size())
            return;
        if(items.get(index).getItem().itemType != ItemType.ARMOR) // Items only have itemType == ARMOR if they extend ArmorItem
            return;
        ArmorItem armorItem = (ArmorItem)items.get(index).getItem();
        if(armorItem.armorType != type)
            return;
        armors[type.id] = armorItem;
    }

    /**
     * Equips the item in armor type slot
     * @param armor Armor to equip
     */
    public void equipArmor(ArmorItem armor) {
        int index = indexOf(armor);
        if(index == -1) {
            items.add(new ItemStack(armor, 1));
            index = items.size()-1;
        }

        equipArmor(index, armor.armorType);
    }

    /**
     * Unequips armor in specified slot
     * @param slot Slot to unequip armor from
     */
    public void unequip(ArmorType slot) {
        if(armors[slot.id] != null) {
            armors[slot.id] = null;
        }
    }

    /**
     * Checks if this inventory contains specified armor
     * @param item Item that checks if contained
     * @return Whether or not it is contained
     */
    public boolean contains(Item item) {
        for(ItemStack itemStack : items) {
            if(itemStack.getItem().equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns index of specifies item, -1 if not contained
     * @param item Item to check for index
     * @return Index of item
     */
    public int indexOf(Item item) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getItem().equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns an array of equipped armors
     * @return Armors
     */
    public ArmorItem[] getArmors() {
        return armors;
    }
}
