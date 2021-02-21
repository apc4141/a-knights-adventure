package knightsadventure.io;

import java.util.Scanner;

public class Input {

    private static Scanner input;

    public static void init() {
        input = new Scanner(System.in);
    }

    /**
     * @return Next full line as string
     */
    public static String next() {
        return input.next();
    }

    /**
     * @return Next full line as int
     */
    public static int nextInt() {
        return input.nextInt();
    }

    /**
     * @return Next full line as float
     */
    public static float nextFloat() {
        return input.nextFloat();
    }

}
