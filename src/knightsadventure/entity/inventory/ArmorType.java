package knightsadventure.entity.inventory;

/**
 * Type of armor
 */
public enum ArmorType
{
    HELMET(0, "helmet", 'H'),
    CHESTPLATE(1, "chestplate", 'C'),
    GAUNTLETS(2, "gauntlets", 'G'),
    LEGGINGS(3, "leggings", 'L'),
    BOOTS(4, "boots", 'B');

    public int id;
    public String name;
    public char sym;

    ArmorType(int id, String name, char sym) {
        this.id = id;
        this.name = name;
        this.sym = sym;
    }
}