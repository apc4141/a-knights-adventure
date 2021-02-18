package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;

import java.util.Arrays;

/**
 * Item that is a weapon
 * Has damage and type
 */
public class WeaponItem extends Item {

    public int[] damages;
    public WeaponType type;

    public WeaponItem(String name, int[] damages, WeaponType weaponType) throws Exception {
        super(name, ItemType.WEAPON, false);
        if(damages.length != DamageType.values().length)
            throw new Exception("damages array must be of length DamageType.values().length");

        this.damages = damages;
        type = weaponType;
    }

    /**
     * Creates a weapon with 0 damage
     */
    public WeaponItem(String name, WeaponType weaponType) {
        super(name, ItemType.WEAPON, false);

        this.damages = new int[DamageType.values().length];
        Arrays.fill(this.damages, 0);

        type = weaponType;
    }

}
