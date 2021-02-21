package knightsadventure.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Prompts the user for their action and accordingly
 * links them up to their next event
 */
public abstract class LinkEvent extends Event {

    public ArrayList<Event> events;

    public LinkEvent(String eventName, Event... events) {
        super(eventName);
        this.events = new ArrayList<Event>(Arrays.asList(events));
    }

    /**
     * Action that is run pre-link
     */
    public abstract void preLink();

    /**
     * Executes this Events function
     */
    @Override
    public void execute() {
        preLink();

        // Prompt the user for what event they would like to access next
        String[] eventNames = new String[events.size()];
        for(int i = 0; i < events.size(); i++) eventNames[i] = events.get(i).eventName;
        Prompt prompt = new Prompt(eventNames);

        int choice;
        try {
            choice = prompt.prompt();
        } catch (IOException ignore) {
            System.err.println("IOException in prompt.prompt()!");
            return;
        }

        Event event = events.get(choice);
        event.execute();

    }
}
