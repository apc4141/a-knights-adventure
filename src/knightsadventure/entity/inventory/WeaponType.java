package knightsadventure.entity.inventory;

import knightsadventure.entity.DamageType;
import knightsadventure.entity.stats.Stat;

/**
 * WeaponTypes: Certain weapon types scale better with certain stats
 */
public enum WeaponType {

    // Must contain an array of 10 scalings
    // Snippet from Stat enum:
    /*
        VITALITY(0, "vitality", 'V'),
        STRENGTH(1, "strength", 'S'),
        FLEXIBILITY(2, "flexibility", 'F'),
        SKILL(3, "skill", 'T'), // T for technique
        SPEED(4, "speed", 'Q'), // Q for quickness
        BEAUTY(5, "beauty", 'B'),
        COURAGE(6, "courage", 'C'),
        DEVOTION(7, "devotion", 'D'),
        INTELLECT(8, "intellect", 'I'),
        LUCK(9, "luck", 'L');
    */
    
    DAGGER(0, "dagger", new float[] {1, 1.02f, 1.1f, 1.2f, 1.2f, 1, 1, 1, 1, 1}),
    STRAIGHT_SWORD(1, "straight sword", new float[] {1, 1.1f, 1.2f, 1.1f, 1.1f, 1, 1, 1, 1, 1}),
    GREAT_SWORD(2, "great sword", new float[] {1, 1.3f, 1.1f, 1.2f, 1.02f, 1, 1, 1, 1, 1}),
    ULTRA_GREAT_SWORD(3, "ultra great sword", new float[] {1, 1.5f, 1.1f, 1.15f, 1.02f, 1.05f, 1, 1, 1, 1}),
    SPEAR(4, "spear", new float[] {1, 1.1f, 1.3f, 1.1f, 1.2f, 1, 1, 1, 1, 1}),
    HALBERD(5, "halberd", new float[] {1, 1.1f, 1.2f, 1.3f, 1.05f, 1.1f, 1, 1, 1, 1}),
    SIEGE(6, "siege", new float[] {1, 1.3f, 1f, 1f, 1f, 1.2f, 1.6f, 1, 1, 1}),
    AXE(7, "axe", new float[] {1, 1.2f, 1.05f, 1.2f, 1.3f, 1, 1, 1, 1, 1}),
    GREAT_AXE(8, "great axe", new float[] {1, 1.4f, 1f, 1.1f, 1.2f, 1, 1, 1, 1, 1}),
    STAFF(9, "staff", new float[] {1, 1f, 1.2f, 1.3f, 1.1f, 1, 1, 1, 1.5f, 1}),
    BOW(10, "bow", new float[] {1, 1f, 1.4f, 1.3f, 1.1f, 1.1f, 1, 1, 1, 1}),
    RANGED_WEAPON(11, "ranged weapon", new float[] {1, 1f, 1.1f, 1.4f, 1.4f, 1, 1, 1, 1, 1}),
    LEVIATHAN(12, "leviathan", new float[] {1, 1.7f, 1.2f, 1.2f, 1.1f, 1.1f, 1.1f, 1, 1, 1}),
    FISTS(13, "fists", new float[] {1, 1.3f, 1.2f, 1.3f, 1.3f, 1, 1, 1, 1, 1}),
    GRIMOIRE(14, "grimoire", new float[] {1, 1f, 1f, 1.2f, 1f, 1.2f, 1.1f, 1.2f, 1.3f, 1}),
    SECRET(0, "dagger", new float[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1});

    public float[] scaling;

    WeaponType(int id, String name, float[] scaling) {
        if(scaling.length != Stat.values().length)
            System.out.println("ERROR: 'scaling' must be exactly equal to Stat.values().length");
        this.scaling = scaling;
    }
}
