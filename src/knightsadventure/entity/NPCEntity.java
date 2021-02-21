package knightsadventure.entity;

import knightsadventure.ui.events.AttackEvent;

public class NPCEntity extends Entity {

    public NPCEntity(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void handleNextMove(Entity target) {
        //TODO Implement calculate next move
        AttackEvent attackEvent = new AttackEvent("attack", this, target);
        attackEvent.execute();
    }
}
