package Entity;

public class Attack {

    public int attackPower;
    public DamageType damageType;

    public Attack(int attackPower, DamageType damageType) {
        this.attackPower = attackPower;
        this.damageType = damageType;
    }

    /**
     *  Converts attack to compound attack
     * @return Converted compound attack
     */
    public CompoundAttack toCompound()
    {
        CompoundAttack compoundAttack = new CompoundAttack();
        compoundAttack.add(this);
        return compoundAttack;
    }
}
