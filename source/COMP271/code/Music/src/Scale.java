public class Scale {

    private static final String DEFAULT_NAME = "C";
    private static final int DEFAULT_TIME = 4;
    private static final int DEFAULT_OCTAVE = 4;
    private static final double DEFAULT_FREQUENCY = 261.6;

    Note[] scaleNotes = new Note[12];

    /**
     * Default constructor assumes a key of C major
     */
    public Scale() {
        scaleNotes[0] = new Note(DEFAULT_NAME, DEFAULT_TIME, DEFAULT_OCTAVE, DEFAULT_FREQUENCY);
    }

    public Scale(Note key) {
        this.scaleNotes[0] = new Note(DEFAULT_NAME, DEFAULT_TIME, DEFAULT_OCTAVE, DEFAULT_FREQUENCY);
        if (key.validNote())
            this.scaleNotes[0] = key;
    }
}
