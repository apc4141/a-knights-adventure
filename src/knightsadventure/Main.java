package knightsadventure;

import knightsadventure.entity.*;
import knightsadventure.entity.inventory.ArmorItem;
import knightsadventure.entity.inventory.ItemRegistry;
import knightsadventure.entity.stats.Stat;
import knightsadventure.entity.stats.StatsManager;

import java.util.Arrays;

import static knightsadventure.entity.inventory.ArmorType.CHESTPLATE;

public class Main {
    public static void main(String[] args) throws Exception {

        init();

        int[] defenses = new int[DamageType.values().length];
        Arrays.fill(defenses, 0);
        float absorption = 0;

        ArmorItem aidenArmor = new ArmorItem("Aiden's Chestplate", defenses, absorption, CHESTPLATE);
        Entity aiden = new Entity("Aiden",300);
        aiden.getInventory().equipArmor(aidenArmor);
        StatsManager stats = aiden.getStatsManger();

        for(int i = 0; i < 15; i++) stats.levelUp(Stat.VITALITY);
        for(int i = 0; i < 99; i++) stats.levelUp(Stat.STRENGTH);

        stats.health.fullHeal();

        Entity naruto = new Entity("Naruto", 300);

        while(!(aiden.isDead()) && !(naruto.isDead()))
        {
            printInteraction(aiden.doAttack(naruto));
            System.out.println();
            printInteraction(naruto.doAttack(aiden));

            System.out.println("===========================================");
            System.out.println("\n");
        }
    }

    /**
     * Temporary function that formats an interaction data object and prints to stdout
     * @param data
     */
    public static void printInteraction(InteractionData data)
    {
        System.out.println(data.attacker.getName()+" attacking "+data.receiver.getName()+":");
        System.out.print("Damages:");
        for(Attack attack : data.attack)
            System.out.print("  "+attack.damageType.sym+"+"+attack.attackPower);
        System.out.println();
        System.out.println("Damage Taken: "+data.healthTaken);
        System.out.println(data.receiver);
    }


    private static void init() {
        ItemRegistry.init();
    }
}
