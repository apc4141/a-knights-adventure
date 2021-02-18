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
     * Sets health to full
     */
    public void fullHeal() {
        health = maxHealth;
    }

    /**
     * Heals the player for
     * @param health Health to heal. Can be percentage
     * @param isPercent true if 'health' is a percent value
     */
    public void heal(int health, boolean isPercent) {
        if(isPercent) {
            float percent = health;
            health = (int)Math.floor(maxHealth*(percent/100));
        }
        health = Math.max(0, health);
        this.health += health;
        this.health = Math.min(maxHealth, this.health);
    }

    /**
     * Sets the max health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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
                temp *= (1 - (armor.absorption / 100));
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

            if(damage < 0)
                damage = 0;

            float useAbsorp = attack.damageType == DamageType.PHYSICAL ? absorption : absorption * 0.7f;
            damage = (int) Math.floor(damage * (1 - absorption));

            if(damage < 0)
                damage = 0;

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
