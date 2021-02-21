package knightsadventure.ui.events;

import java.io.PrintStream;

/**
 * Event class that executes a task
 */
public abstract class Event {

    public String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Executes this commands task
     */
    public abstract void execute();



    @Override
    public int hashCode() {
        return eventName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
            return true;
        if(obj.getClass() != getClass())
            return false;

        Event target = (Event) obj;
        return eventName.equals(target.eventName);
    }
}
