package knightsadventure.entity.stats;

/**
 * Represents all players stats
 */
public enum Stat {
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

    public int id;
    public String name;
    public char sym;

    Stat(int id, String name, char sym) {
        this.id = id;
        this.name = name;
        this.sym = sym;
    }
}
