package knightsadventure.tools;

import java.util.Random;

/**
 * Class for tools concerning IDs
 */
public class ID {

    /**
     * Generates a random id as string
     * @param len Length of id
     * @return Id
     */
    public static String generate(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+`-={}|[]\\:\";'<>?,./";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

}
