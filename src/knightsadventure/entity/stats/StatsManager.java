package knightsadventure.entity.stats;

import knightsadventure.entity.HealthManager;

import java.util.Arrays;

/**
 * Stats for an entity and what they affect:
 * (All stats can affect weapon damage scaling besides their main effect)
 *
 * Vitality[0] - Scales health up diminishingly
 * Strength[1] - Strength based weapons do more damage + can carry more
 * Flexibility[2] - Flexibility increases flexibility based weapons
 * Skill[3] - * for skill based weapon
 * Speed[4] - * for speed based weapons + person with higher speed stat goes first then skill
 * Beauty[5] - Lower prices for things
 * Courage[6] - Allows you to enter certain areas + use certain weapons
 * Devotion[7] - Allows you to use certain devotion based items + scalings
 * Intellect[8] - Allows you to use certain intellect based items + scalings
 * Luck[9] - Higher item drop chance + better luck with other things
 *
 */
public class StatsManager {

    private static final double HDIV = 1/2.5;//Math.log10(LOG_BASE);

    private final int baseHealth;
    public final HealthManager health;

    private final int[] stats;

    /**
     * Initialize every stat to the same thing
     *
     * @param baseHealth
     * @param statBase
     */
    public StatsManager(int baseHealth, int statBase) {
        this.baseHealth = baseHealth;
        this.health = new HealthManager(baseHealth);
        stats = new int[Stat.values().length];
        Arrays.fill(stats, statBase);
        updateHealth();
    }

    /**
     * Initialize to stats of your choosing
     *
     * @param baseHealth Base health of entity that will be scaled based on vitality stat
     * @param stats
     * @throws Exception
     */
    public StatsManager(int baseHealth, int[] stats) throws Exception {
        this.baseHealth = baseHealth;
        this.health = new HealthManager(baseHealth);

        if (stats.length != Stat.values().length)
            throw new Exception("Length of array stats must be of length Stat.values().length");

        this.stats = stats;
        updateHealth();
    }

    /**
     * Levels up specified stat by one point
     *
     * @param stat Stat to level up
     */
    public void levelUp(Stat stat) {

        stats[stat.id] += 1;

        // Update max health if stat is vitality
        if (stat == Stat.VITALITY)  updateHealth();
    }

    /**
     * Gets specified stat
     *
     * @param stat stat type from Stat enum
     * @return stat level
     */
    public int getStat(Stat stat) {
        return stats[stat.id];
    }

    /**
     * Updates health based on current vitality
     * Formula is as follows:
     *
     * newHealth = flr(baseHealth * [1 + log2(vitality)])
     *
     */
    private void updateHealth() {
        int vit = stats[Stat.VITALITY.id];
        double log2 = Math.pow(vit, HDIV);//(Math.log10(stats[Stat.VITALITY.id])/HDIV);
        int newHealth = (int)Math.floor(baseHealth*log2);
        health.setMaxHealth(newHealth);
    }
}
