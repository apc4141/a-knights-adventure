package knightsadventure;

import knightsadventure.entity.*;
import knightsadventure.entity.inventory.ArmorItem;

import java.util.Arrays;

import static knightsadventure.entity.inventory.ArmorType.CHESTPLATE;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] defenses = new int[DamageType.values().length];
        Arrays.fill(defenses, 50);
        float absorption = 25;

        ArmorItem aidenArmor = new ArmorItem("Aiden's Chestplate", defenses, absorption, CHESTPLATE);
        Entity aiden = new Entity("Aiden",3000, 100);
        aiden.getInventory().equipArmor(aidenArmor);
        Entity narun = new Entity("Narun", 3000, 100);

        while(!(aiden.isDead()) && !(narun.isDead()))
        {
            printInteraction(aiden.doAttack(narun));
            System.out.println();
            printInteraction(narun.doAttack(aiden));

            System.out.println("===========================================");
            System.out.println("\n");
        }
    }

    /**
     * Temporary function that formats an interaction data object and prints to stdout
     * @param data
     */
    static void printInteraction(InteractionData data)
    {
        System.out.println(data.attacker.getName()+" attacking "+data.receiver.getName()+":");
        System.out.print("Damages:");
        for(Attack attack : data.attack)
            System.out.print("  "+attack.damageType.sym+"+"+attack.attackPower);
        System.out.println();
        System.out.println("Damage Taken: "+data.healthTaken);
        System.out.println(data.receiver);
    }
}
