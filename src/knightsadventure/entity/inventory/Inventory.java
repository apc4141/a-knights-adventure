package knightsadventure.entity.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds a players items/weapons/armors
 */
public class Inventory {

    private final ArrayList<ItemStack> items;

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

    //Equipped weapon
    private WeaponItem weapon;

    public Inventory() {
        items = new ArrayList<ItemStack>();
        armors = new ArmorItem[ArmorType.values().length];
        weapon = (WeaponItem) ItemRegistry.getItem(ItemRegistry.FISTS_ID);
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

    //region Equipping
    /**
     * Equips an equippable item
     * @param item Must be either armor or a weapon
     * @return If was not able to be equipped, will return false
     */
    public boolean equip(Item item) {
        if(!item.isEquippable())
            return false;
        if(item.itemType == ItemType.WEAPON) {
            equipWeapon((WeaponItem)item);
        } else {
            equipArmor((ArmorItem)item);
        }
        return true;
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
     * Equips a weapon at specified index
     * @param index Index of weapon in inventory
     */
    public void equipWeapon(int index) {
        Item item = items.get(index).getItem();
        if(item.getClass() != WeaponItem.class || item.itemType != ItemType.WEAPON)
            return;
        this.weapon = (WeaponItem)item;
    }

    /**
     * Equips a weapon
     * @param weapon Weapon to equip
     */
    public void equipWeapon(WeaponItem weapon) {
        int index = indexOf(weapon);
        if(index == -1) {
            items.add(new ItemStack(weapon, 1));
            index = items.size()-1;
        }

        equipWeapon(index);
    }

    /**
     * Unequips weapon and equips fists
     */
    public void unequipWeapon() {
        weapon = (WeaponItem) ItemRegistry.getItem(ItemRegistry.FISTS_ID);
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
     * @return Returns true if item is equipped as armor or weapon else returns false
     */
    public boolean isEquipped(Item item) {
        if(item.itemType == ItemType.WEAPON) {
            WeaponItem weaponItem = (WeaponItem) item;
            return weapon.equals(weaponItem);
        } else if(item.itemType == ItemType.ARMOR) {
            ArmorItem armorItem = (ArmorItem) item;
            for(ArmorItem armorPiece : armors)
                if(armorItem.equals(armorPiece))
                    return true;
        }
        return false;
    }

    //endregion

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

    /**
     * Returns the equipped weapon item
     * @return Weapon
     */
    public WeaponItem getWeapon() { return weapon; }

    /**
     * Returns a list of all the weapons in the inventory
     * @return all weapons
     */
    public HashMap<Integer, WeaponItem> getWeapons() {
        HashMap<Integer, WeaponItem> weaponsMap = new HashMap<Integer, WeaponItem>();

        for(int i = 0; i < items.size(); i++) {
            Item item = items.get(i).getItem();
            if(item.itemType == ItemType.WEAPON) {
                WeaponItem weapon = (WeaponItem) item;
                weaponsMap.put(i, weapon);
            }
        }
        return weaponsMap;
    }
}
