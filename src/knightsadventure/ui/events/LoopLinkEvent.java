package knightsadventure.ui.events;

import knightsadventure.ui.Prompt;

import java.io.IOException;

public abstract class LoopLinkEvent extends LinkEvent {

    public LoopLinkEvent(String eventName, Event... events) {
        super(eventName, events);
    }

    @Override
    public void execute() {
        preLink();

        // Prompt the user for what event they would like to access next
        String[] eventNames = new String[events.size()+1];
        for(int i = 0; i < events.size(); i++) eventNames[i] = events.get(i).eventName;
        eventNames[events.size()] = "back";
        Prompt prompt = new Prompt(eventNames);

        while(true) {
            int choice;
            try {
                choice = prompt.prompt();
            } catch (IOException ignore) {
                System.err.println("IOException in prompt.prompt()!");
                return;
            }

            if(choice==events.size()) return;

            Event event = events.get(choice);
            event.execute();
        }
    }
}
