package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;

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

}
