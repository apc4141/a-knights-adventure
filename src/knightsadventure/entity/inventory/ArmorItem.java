package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;
import knightsadventure.entity.HealthManager;

import java.util.Arrays;

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

    /**
     *
     * @param name Name of armor piece
     * @param defense Every defense will equal this
     * @param absorption Percentage of health that will be taken off
     * @param armorType Type of armor piece
     * @throws Exception if defenses is not of size DamageType.values().length
     */
    public ArmorItem(String name, int defense, float absorption, ArmorType armorType) throws Exception {
        super(name, ItemType.ARMOR, false);
        this.defenses = new int[DamageType.values().length];
        Arrays.fill(this.defenses, defense);
        this.absorption = absorption;
        this.armorType = armorType;
    }

    /**
     * Sets a specific damage defense
     */
    public void setDefense(int defense, DamageType type) {
        defenses[type.id] = defense;
    }
}
