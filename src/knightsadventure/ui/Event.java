package knightsadventure.ui;

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
}
