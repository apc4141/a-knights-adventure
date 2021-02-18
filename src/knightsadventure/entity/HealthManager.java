package knightsadventure.entity;

import knightsadventure.entity.inventory.ArmorItem;

import java.util.Arrays;
import java.util.Random;

/**
 * Rules the way an entity will manage hits taken and its own health
 */
public class HealthManager {

    private int maxHealth;
    private int health;

    public HealthManager(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public boolean isDead()
    {
        return health <= 0;
    }

    /**
     * For each Attack in compound attack, the flat defense for its respective type is subtracted,
     * then base damage absorption is taken off as a percentage e.g. 5.7 absorption -> damage*=1-(5.7/100)
     * @param cattack CompoundAttack to handle
     */
    public int handleAttack(CompoundAttack cattack, ArmorItem[] armors) throws Exception {
        if(armors.length != 5)
            throw new Exception("Array of armors must be of length 5 exactly!");

        int totalDamage = 0;

        // Calculate absorption
        float absorption = 1;
        float temp = 1;
        for(ArmorItem armor : armors) {
            if(armor != null) {
                temp *= (1 - (absorption / 100));
            }
        }
        absorption -= temp;

        // Calculate defenses
        int[] defenses = new int[DamageType.values().length];
        Arrays.fill(defenses, 0);
        for(ArmorItem armor : armors) {
            if(armor == null)
                continue;

            for(int i = 0; i < armor.defenses.length; i++) {
                defenses[i] += armor.defenses[i];
            }
        }

        // Calculate damage to take
        for(Attack attack : cattack) {
            int damage = attack.attackPower;
            DamageType type = attack.damageType;

            damage -= defenses[type.id];
            damage = (int) Math.floor(damage * (1 - (absorption/100)));

            health -= damage;
            totalDamage += damage;
            if (health < 0) health = 0;
        }

        return totalDamage;
    }

    @Override
    public String toString()
    {
        return health+"/"+maxHealth+"HP";
    }
}
