package knightsadventure;

import knightsadventure.entity.*;

public class Main {
    public static void main(String[] args)
    {
         Entity entity1 = new Entity("Aiden",2500, 150);
         Entity entity2 = new Entity("Narun", 3000, 100);

         while(!(entity1.isDead()) && !(entity2.isDead()))
         {
             printInteraction(entity1.doAttack(entity2));
             System.out.println();
             printInteraction(entity2.doAttack(entity1));

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
