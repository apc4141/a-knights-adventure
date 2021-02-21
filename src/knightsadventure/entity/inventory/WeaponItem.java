package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;
import knightsadventure.entity.stats.Stat;

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

    /**
     * Sets the damages of this weapon
     * @param damages damages
     */
    public void setDamages(int[] damages) {
        this.damages = damages;
    }

    /**
     * Sets a singlular damage type onto a weapon
     * @param damage Amount of damage
     * @param type Type of damage
     */
    public void setDamage(int damage, DamageType type) {
        damages[type.id] = damage;
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder("--- " + name + " ---\n");
        String indent = "   ";

        // Scaling
        info.append("Scaling:\n");
        for(int i = 0; i < Stat.values().length; i++) {
            info.append(indent);
            info.append(Stat.values()[i].name).append(": ").append(type.scaling[i]);
            info.append("\n");
        }

        // Attack Power
        info.append("Attack Power:\n");
        for(int i = 0; i < DamageType.values().length; i++) {
            info.append(indent);
            info.append(damages[i]).append(" ").append(DamageType.values()[i].name);
            info.append(i < DamageType.values().length - 1 ? "\n" : "");
        }

        return info.toString();
    }
}
