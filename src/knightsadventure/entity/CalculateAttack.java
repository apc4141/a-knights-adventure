package knightsadventure.entity;

import knightsadventure.entity.inventory.Inventory;
import knightsadventure.entity.inventory.WeaponItem;
import knightsadventure.entity.stats.Stat;
import knightsadventure.entity.stats.StatsManager;
import knightsadventure.tools.MathTools;

public class CalculateAttack {

    private StatsManager stats;
    private Inventory inventory;

    public CalculateAttack(StatsManager stats, Inventory inventory) {
        this.stats = stats;
        this.inventory = inventory;
    }

    /**
     * Calculates attack based on stats
     * @return Calculated attack
     */
    public CompoundAttack calculate() {
        WeaponItem weapon = inventory.getWeapon();
        int[] damages = weapon.damages;
        CompoundAttack cattack = new CompoundAttack();

        for(int i = 0; i < damages.length; i++) {
            if(damages[i] > 0) {

                DamageType type = DamageType.values()[i];
                int damage = damages[i];

                if(type == DamageType.PHYSICAL) {
                    int max = StatsManager.STAT_MAX/2;

                    // If scaling should be activated map values from
                    // 0 to the stat cap to the range 0 to weapons scale max
                    // then multiply that value by the damage
                    for(int s = 0; s < Stat.values().length; s++) {
                        Stat stat = Stat.values()[s];
                        float[] scaling = weapon.type.scaling;

                        damage *= MathTools.map((float) stats.getStat(stat), 0, max, 1, scaling[stat.id]);
                    }
                }

                cattack.addAttack(damage, type);
            }
        }

        return cattack;
    }

}
