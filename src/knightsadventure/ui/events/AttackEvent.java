package knightsadventure.ui.events;

import knightsadventure.entity.Attack;
import knightsadventure.entity.Entity;
import knightsadventure.entity.InteractionData;
import knightsadventure.io.Output;
import knightsadventure.ui.Event;

/**
 * Event for one entity attacking another
 */
public class AttackEvent extends Event {

    public Entity attacker;
    public Entity receiver;

    public AttackEvent(String eventName, Entity attacker, Entity receiver) {
        super(eventName);
        this.attacker = attacker;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        InteractionData data = attacker.doAttack(receiver);

        Output.println(data.attacker.getName()+" attacked "+data.receiver.getName()+":");
        for(Attack attack : data.attack)
            Output.println("-"+attack.attackPower+attack.damageType.sym);
        Output.println(data.receiver.getName()+" took "+data.healthTaken+" damage!");
    }
}
