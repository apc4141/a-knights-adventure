package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;
import knightsadventure.entity.HealthManager;

/**
 * Represents a piece of armor that can be worn
 */
public class ArmorItem extends Item {

    public int[] defenses;
    public float absorption;
    public ArmorType armorType;

    /**
     *
     * @param name Name of armor piece
     * @param defenses length must be of DamageType.values().length
     * @param absorption Percentage of health that will be taken off
     * @param armorType Type of armor piece
     * @throws Exception if defenses is not of size DamageType.values().length
     */
    public ArmorItem(String name, int[] defenses, float absorption, ArmorType armorType) throws Exception {
        super(name, ItemType.ARMOR, false);
        if(defenses.length != DamageType.values().length)
            throw new Exception("Array 'defenses' size must be size of DamageType.values().length");
        this.defenses = defenses;
        this.absorption = absorption;
        this.armorType = armorType;
    }
}
