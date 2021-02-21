package knightsadventure.io;

import java.awt.*;

/**
 * Centralizes the output so that every output can be changed
 * from this class
 */
public class Output {

    /**
     * @return If output stream has the ability to color text, return true else return false
     */
    public static boolean hasColor() {
        return false;
    }


    public static void print(String toOutput) {
        System.out.print(toOutput);
    }

    public static void print(String toOutput, Color color) {
        System.out.println(toOutput);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String toOutput) {
        System.out.println(toOutput);
    }

    public static void println(String toOutput, Color color) {
        System.out.println(toOutput);
    }

}
