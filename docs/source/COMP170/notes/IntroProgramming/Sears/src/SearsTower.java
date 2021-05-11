/**
 * Class with parameterized methods drawing the Sears tower.
 *
 * The class assembles a tower with three tiers: bottom, middle, and top. Each tier
 * is build in proportion to the total height of the tower -- specified in number
 * of lines to print. The proportions are captured in three groups of class variables.
 *
 * Class variables for height (suffixed _HEIGHT_FACTOR) specify the height of
 * each tier as a percentage of the tower's height, based on realistic measurements.
 *
 * Class variables for width (suffixed _WIDTH_FACTOR) specify the width of
 * each tier as a percentage of the tower's height, based on a realistic aspect
 * ratio of 1/6.45 (see https://skyscraperpage.com/cities/?buildingID=5).
 *
 * A third group of class variables is used for the symbols used in the drawing.
 *
 */
public class SearsTower {

    // Class variables for height
    public static final double BOTTOM_HEIGHT_FACTOR = 0.45;
    public static final double MIDDLE_HEIGHT_FACTOR = 0.36;
    public static final double TOP_HEIGHT_FACTOR = 0.18;
    public static final double WEST_ANTENNA_HEIGHT_FACTOR = 0.19;
    public static final double EAST_ANTENNA_HEIGHT_FACTOR = 0.19;

    // Class variables for width
    public static final double BOTTOM_WIDTH_FACTOR = 1.0/6.45; // aspect ratio
    public static final double MIDDLE_WIDTH_FACTOR = BOTTOM_WIDTH_FACTOR/2.0; // half aspect
    public static final double TOP_WIDTH_FACTOR = MIDDLE_WIDTH_FACTOR/2.0; // quarter aspect

    // Class variables for the symbols used in the drawing
    public static final String BUILDING_ELEMENT = "H";
    public static final String ANTENNA_ELEMENT = "|";

    /**
     * Prints the bottom tier of the tower, in proportion to a
     * user specified height.
     * @param towerHeight the height of the tower in number of lines to print
     */
    public static void bottomTier(int towerHeight) {
        // How tall is this section in proportion to the tower's height?
        int bottomTierHeight = (int) (BOTTOM_HEIGHT_FACTOR * towerHeight);
        // How wide is this section in proportion to the tower's height?
        int bottomTierWidth = (int) (BOTTOM_WIDTH_FACTOR * towerHeight);
        for (int i = 0; i < bottomTierHeight; i++) {
            System.out.println(BUILDING_ELEMENT.repeat(bottomTierWidth));
        }
    } // method bottomTier

    public static void middleTier(int towerHeight) {
        int middleTierHeight = (int) (MIDDLE_HEIGHT_FACTOR * towerHeight);
        int middleTierWidth = (int) (MIDDLE_WIDTH_FACTOR * towerHeight);
        for (int i = 0; i < middleTierHeight; i++) {
            System.out.println(BUILDING_ELEMENT.repeat(middleTierWidth));
        }
    } // method middleTier

    public static void topTier(int towerHeight) {
        int topTierHeight = (int) (TOP_HEIGHT_FACTOR * towerHeight);
        int topTierWidth = (int) (TOP_WIDTH_FACTOR * towerHeight);
        for (int i = 0; i < topTierHeight; i++) {
            System.out.println(BUILDING_ELEMENT.repeat(topTierWidth));
        }
    } // method topTier

    // driver method (main)
    public static void main(String[] args) {
        int N = 40; // desired height
        topTier(N); // top tier for the desired height
        middleTier(N); // middle tier for the desired height
        bottomTier(N); // bottom tier for the desired height
    }
}
