package knightsadventure.tools;

public class MathTools {

    /**
     * Maps a number in a range of values to another range of values
     * @return Mapped value
     */
    public static float map(float value,
                                  float istart,
                                  float istop,
                                  float ostart,
                                  float ostop) {
        return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
    }

}
