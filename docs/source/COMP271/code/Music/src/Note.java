
/**
 * A class to define musical notes as a data structure. The class borrows
 * elements from linked lists, and introduces techniques for transposition,
 * and automatic derivation of major and minor scales. The class uses a
 * standard 88-key piano as a basis.
 */

public class Note {

    private static final String SCALE="CDEFGAB";
    private static final double LOWEST_FREQUENCY = 27.5;
    private static final double HIGHEST_FREQUENCY = 4186.0;
    private static final int LOWEST_OCTAVE = 0;
    private static final int HIGHEST_OCTAVE = 8;
    private static final String DEFAULT_NAME = "A";
    private static final int DEFAULT_TIME = 4;
    private static final int DEFAULT_OCTAVE = 4;
    private static final double DEFAULT_FREQUENCY = 440.0;

    private String name;
    private int time;
    private int octave;
    double frequency;

    /**
     * Default constructor creates a note at A4
     */
    public Note() {
        name = DEFAULT_NAME;
        time = DEFAULT_TIME;
        octave = DEFAULT_OCTAVE;
        frequency = DEFAULT_FREQUENCY;
    }

    /**
     * Full arguments constructor performs basic check before creating a new
     * object. If checks fail, the corresponding fields are assigned values
     * related to note A4.
     *
     * @param name
     * @param time int denominator for note length (e.g., 4 for 1/4, etc)
     * @param octave
     * @param frequency
     */
    public Note(String name, int time, int octave, double frequency) {
        // name must be valid note, single character; otherwise assign default
        this.name = DEFAULT_NAME;
        if (name.length()==1 && SCALE.indexOf(name)>-1)
            this.name = name;
        // Time must be a mutiple of two, otherwise default
        this.time = DEFAULT_TIME;
        if (time%2==0)
            this.time = time;
        // octave must be within 88-key piano range; otherwise default
        this.octave = DEFAULT_OCTAVE;
        if (octave>= LOWEST_OCTAVE && octave<=HIGHEST_OCTAVE)
            this.octave = octave;
        // frequency must be within piano's range; otherwise default
        this.frequency = DEFAULT_FREQUENCY;
        if (frequency >= LOWEST_FREQUENCY && frequency <= HIGHEST_FREQUENCY)
            this.frequency = frequency;
    }

    public String noteInfo() {
        return name + ": ( 1/" + time + "), f=" + frequency;
    }

    public boolean validNote() {
        return name.length()==1 && SCALE.indexOf(name)>-1;
    }

}
