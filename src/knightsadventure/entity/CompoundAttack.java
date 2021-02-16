package knightsadventure.entity;

import java.util.ArrayList;

/**
 * Will have an important function later but right now is empty
 */
public class CompoundAttack extends ArrayList<Attack> {

    /**
     * Directly adds an attack
     * @param attackPower Power of attack
     * @param damageType Damage type of the attack
     */
    public void addAttack(int attackPower, DamageType damageType)
    {
        add(new Attack(attackPower, damageType));
    }

}
