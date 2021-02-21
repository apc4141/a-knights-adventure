package knightsadventure.entity;

import knightsadventure.ui.Event;
import knightsadventure.ui.LinkEvent;
import knightsadventure.ui.events.AttackEvent;

public class PlayerEntity extends Entity {

    public PlayerEntity(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void handleNextMove(Entity target) {
        AttackEvent attackEvent = new AttackEvent("attack", this, target);
        LinkEvent linkEvent = new LinkEvent("main", attackEvent) {
            @Override
            public void preLink() {
                System.out.println();
                System.out.println("====================================");
                System.out.println("What would you like to do?");
            }
        };
        linkEvent.execute();
    }
}