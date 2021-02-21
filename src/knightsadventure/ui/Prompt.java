package knightsadventure.ui;

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

    public InputStream in;
    public OutputStream out;

    public Prompt(String... prompts) {
        this.prompts = new ArrayList<String>(Arrays.asList(prompts));

        this.in = System.in;
        this.out = System.out;
    }

    public Prompt(boolean hasExitOption, String... prompts) {
        this.prompts = new ArrayList<String>(Arrays.asList(prompts));
        if(hasExitOption) this.prompts.add("exit");

        this.in = System.in;
        this.out = System.out;
    }

    /**
     * Sets the stream to which this is printed
     */
    public void setOut(OutputStream out) {
        this.out = out;
    }

    /**
     * Sets the stream to which this object reads from
     */
    public void setIn(InputStream in) {
        this.in = in;
    }

    /**
     * Prompts the user and returns the numerical index of the prompt selected
     * by the user. Returns -1 if the user chose exit
     * @return Index of prompt
     */
    public int prompt() throws IOException {

        int i;
        for(i = 1; i <= prompts.size(); i++) {
            println(i+".) "+ prompts.get(i - 1));
        }

        Scanner scanner = new Scanner(in);

        while(true) {
            println(PROMPT_MESSAGE);
            String input = scanner.next();
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

            println("Unknown option: '"+input+"'!");

        }
    }

    /**
     * Prints to out
     */
    private void print(String toPrint) throws IOException {
        for(byte bite : toPrint.getBytes()) out.write(bite);
    }

    /**
     * Prints with newline
     */
    private void println(String toPrint) throws IOException {
        print(toPrint);
        out.write('\n');
    }
}
