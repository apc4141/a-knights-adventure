package knightsadventure.game;

import knightsadventure.entity.Entity;
import knightsadventure.entity.stats.Stat;

import java.io.PrintStream;

/**
 * A battle will ask both enemies to handle their move
 * every round in a loop till either one is dead.
 */
public class Battle {

    public Entity entity1;
    public Entity entity2;

    public Battle(Entity entity1, Entity entity2) {
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    /**
     * Will ask both enemies to handle their move
     * every round in a loop till either one is dead.
     * @return The winner of the battle
     */
    public Entity start() {

        while (!entity1.isDead() && !entity2.isDead()) {

            System.out.println();
            System.out.println("====================================");
            System.out.println(entity1.toString()+" - "+entity2.toString());

            if(entity1.moveBefore(entity2)) {
                entity1.handleNextMove(entity2);
                if(entity2.isDead()) continue;
                entity2.handleNextMove(entity1);
                if(entity1.isDead()) continue;
            } else {
                entity2.handleNextMove(entity1);
                if(entity1.isDead()) continue;
                entity1.handleNextMove(entity2);
                if(entity2.isDead()) continue;
            }
        }

        if(entity1.isDead()) {
            return entity1;
        } else {
            return entity2;
        }

    }
}
