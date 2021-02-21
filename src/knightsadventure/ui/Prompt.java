package knightsadventure.ui;

import knightsadventure.io.Input;
import knightsadventure.io.Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Prompts the user and returns the numerical
 * representation of the option the user chose
 */
public class Prompt {

    private static final String PROMPT_MESSAGE = "Please choose an option: ";

    public ArrayList<String> prompts;

    public Prompt(String... prompts) {
        this.prompts = new ArrayList<String>(Arrays.asList(prompts));
    }

    public Prompt(boolean hasExitOption, String... prompts) {
        this.prompts = new ArrayList<String>(Arrays.asList(prompts));
        if(hasExitOption) this.prompts.add("exit");
    }

    /**
     * Prompts the user and returns the numerical index of the prompt selected
     * by the user. Returns -1 if the user chose exit
     * @return Index of prompt
     */
    public int prompt() throws IOException {

        int i;
        for(i = 1; i <= prompts.size(); i++) {
            Output.println(i+".) "+ prompts.get(i - 1));
        }

        while(true) {
            Output.println(PROMPT_MESSAGE);
            String input = Input.next();
            input = input.strip();

            // Check if they typed the word instead of number
            for(int p = 0; p < prompts.size(); p++) {
                if(input.equalsIgnoreCase(prompts.get(p))) {
                    return p;
                }
            }

            // Check if it was a number that they entered
            try {
                int num = Integer.parseInt(input)-1;
                if(num>=0&&num<prompts.size()) {
                    return num;
                }
            } catch (NumberFormatException ignore) { }

            Output.println("Unknown option: '"+input+"'!");
        }
    }
}
