import Entity.Entity;

public class Main {
    public static void main(String[] args)
    {
         Entity entity1 = new Entity(250, 20);
         Entity entity2 = new Entity(300, 15);

         while(!(entity1.isDead()) && !(entity2.isDead()))
         {
             entity1.doAttack(entity2);
             System.out.println("Entity 2: "+entity2.healthAsString());
             entity2.doAttack(entity1);
             System.out.println("Entity 1: "+entity1.healthAsString());
             System.out.println("===========================================");
             System.out.println("\n");
         }
    }
}
