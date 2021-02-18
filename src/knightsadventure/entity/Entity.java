package knightsadventure.entity;

import knightsadventure.entity.inventory.ArmorItem;
import knightsadventure.entity.inventory.Inventory;
import knightsadventure.entity.stats.Stat;
import knightsadventure.entity.stats.StatsManager;

/**
 *  Class that represents basic unit that will fight and have health, inventory and stats
 */
public class Entity {

    private final String name;

    private final StatsManager statsManager;
    private final Inventory inventory;

    public Entity(String name, int maxHealth)
    {
        this.name = name;
        this.statsManager = new StatsManager(maxHealth, 1);
        this.inventory = new Inventory();
    }

    public boolean isDead()
    {
        return statsManager.health.isDead();
    }

    /**
     *  Has entity handle basic attack
     * @param attack CompoundAttack that consists of the damage the entity should handle
     * @return Amount of damage actually taken by entity
     */
    private int handleAttack(CompoundAttack attack)
    {
        ArmorItem[] armors = inventory.getArmors();
        try {
            return statsManager.health.handleAttack(attack, armors);
        } catch(Exception e) {
            return -6969; // Important to return this
        }
    }

    /**
     *  Will calculate correct attack it will do based on stats and equiptment
     *  and with call handleAttack() with paramater of calculated compound attack
     * @param ent Entity that handleAttack() should be called on
     * @return InteractionData object based on the event
     */
    public InteractionData doAttack(Entity ent)
    {
        //For testing purposes this is for now set to a non calculated value
        CompoundAttack attack = new Attack(statsManager.getStat(Stat.STRENGTH), DamageType.PHYSICAL).toCompound();
        attack.addAttack(statsManager.getStat(Stat.BEAUTY), DamageType.FIRE);

        int healthTaken = ent.handleAttack(attack);
        return new InteractionData(this, ent, attack, healthTaken);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public StatsManager getStatsManger() {
        return statsManager;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name+": "+statsManager.health.toString();
    }
}
