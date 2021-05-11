
/** A simple implementation of a linked list in the form of an itinerary
 * for an airplane traveling along routes identified by their airport of
 * origin and the destination airport. For example, the Itinerary<br/>
 *      <center>ORD - DEN - SLC - SEA - LAX</center><br/>
 * comprises the following routes<br/>
 *      <center>ORD -> DEN</center>
 *      <center>DEN -> SLC</center>
 *      <center>SLC -> SEA</center>
 *      <center>SEA -> LAX</center><br/>
 * Class Itinerary includes the definition of class Route.
 */
public class Itinerary {

    /**
     * head is the first Route of the Itinerary
     */
    Route head;

    /**
     * tail is the last Route of the Itinerary; by specifying this field
     * we avoid the tedious search of the last Route in an Itinerary.
     */
    Route tail;

    /**
     * Method to add a Route to an Itinerary. The Route is added always to the end of
     * the Itinerary.
     * @param airport Airport where Route originates.
     */
    public void add(String airport) {
        Route newSegment = new Route(airport);
        if (head==null) {            // Itinerary is empty: this is the first Route added to it.
            head = newSegment;       // head and tail of Itinerary are the same
            tail = newSegment;       //
        } else {                     // Itinerary is not empty. Route is added to the
            tail.next = newSegment;  // tail of the itinerary. Thanks to this filed (tail)
            tail = newSegment;       // we don't have to scan Itinerary to find its end.
        }
    } // method add

    /**
     * Method to find the last Route in an Itinerary. This method is needed if
     * our Itinerary does not have a dedicated field (tail) to point to its
     * last Route. The method assumes that the Itinerary is not empty.
     * @return Last Route in an Itinerary.
     */
    public Route findLastSegment() {
        Route currentNode = head; // assumes that head != null
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    } // method findLastSegment


    /**
     * Method to check if a route exists.
     */
    public boolean routeExists(Route routeToCheck) {
        Route currentRoute;
        boolean routeFound = false;
        if (head != null) {
            currentRoute = head;
            while (currentRoute.next != null) {
                if ((currentRoute.airportCode == routeToCheck.airportCode) && (currentRoute.next.airportCode == routeToCheck.next.airportCode)) {
                    routeFound=true;
                } else {
                    routeFound = ((currentRoute.airportCode == routeToCheck.airportCode) && routeToCheck.next == null);
                }
                currentRoute = currentRoute.next;
            }
        }
        return routeFound;
    } // method routeExists

    /**
     * Method to insert an airport within a Route, splitting that Route into two. Writing
     * this method presented me a dilemma. Use a different method to determine first if
     * the Route segment we wish to split, exists already? Or scan the list, find
     * the Route, and split it? I started writing method routeExists() above, as a
     * boolean, but then I realized once I know a Route exists, I will have to repeat
     * a list scan to arrive at that Route to split it by inserting a new airport.
     * So it may be better if I did the scan in his method, and if the Route is found,
     * split. So I am turning method insert() below into a boolean, returning TRUE if
     * the insertion is successful and false otherwise.
     */
    public boolean insert(String newAirport, String routeOriginatingAirport) {
        boolean successfullyInserted = false;
        //let's find where the Route intoRoute is
        if (head != null) {
            Route currentRoute = head;
            while (currentRoute.next != null) {
                if (currentRoute.airportCode == routeOriginatingAirport) {
                    // route found, let's split it with newAirport spliced in the middle
                    Route splicedIn = new Route(newAirport);
                    Route afterSplice = currentRoute.next;
                    currentRoute.next = splicedIn;
                    splicedIn.next = afterSplice;
                    successfullyInserted = true;
                }
                currentRoute = currentRoute.next;
            }
        }
        return successfullyInserted;
    } // method insert

    /**
     * Method to remove a Route from itinerary. Returns true if the removal
     * was successful, false otherwise. The functionality is described
     * below. The method effectively takes two consecutive routes, Rt1 and Rt2
     * and splices them together, by removing their shared airport and
     * thus eliminating Rt2.
     *
     * Rt1 originates at A1 and ends at A2. Rt2 originates at A2 and ends at A3.
     * Airport A3 is the origin of Rt3 to somewhere else.
     *
     * The removal is done from the perspective of Rt1. From this point the
     * relations between Rt1, Rt2, and Rt3 can be written as:
     *
     *
     *     Rt1    Rt2    Rt3
     *     ====== ====== =====
     *     A1 --> A2 --> A3 --> ...
     *     |      |      |
     *     |      |      +----- Route following the Route to remove.
     *     |      |
     *     |      +------------ Airport at the origin of Route to remove
     *     |
     *     +------------------- Route prior to Route to remove.
     *
     * The removal is done from the perspective of Rt1. From this point the
     * relations between Rt1, Rt2, and Rt3 can be written as:
     *
     *    Rt2 = Rt1.next
     *    Rt3 = Rt1.next.next
     *
     * We want to "disconnect" Rt1 from Rt2 and connect it to Rt3. It is
     * straight-forward:
     *
     *    Rt1.next = Rt1.next.next
     */
    public boolean remove(String routeOriginatingAirport) {
        boolean removalSuccessful = false;
        //let's find the Route to remove
        if (head != null) {
            Route currentRoute = head;
            while (currentRoute.next != null) {
                if (currentRoute.airportCode == routeOriginatingAirport) {
                    // currentRoute is the route prior to the one we wish to remove;
                    // Let's make sure there is another route past the one to be
                    // deleted, so that we can splice them.
                    if (currentRoute.next.next != null) {
                        // splicing
                        currentRoute.next = currentRoute.next.next;
                        removalSuccessful = true;
                    }
                }
                currentRoute = currentRoute.next;
            }
        }
        return removalSuccessful;
    } // method remove

    public void printItinerary() {
        System.out.println("\nItinerary from " + head.airportCode + " to " + tail.airportCode);
        Route currentSegment = head;
        while (currentSegment.next != null) {
            String originatingAirport = currentSegment.airportCode;
            String destinationAirport =
                    (currentSegment.next.airportCode == null) ?
                            " (last stop) " :
                            currentSegment.next.airportCode;
            System.out.println("\tRoute from " + originatingAirport + " to " +destinationAirport);
            currentSegment = currentSegment.next;
        }
    } // method printItinerary

    /**
     * Route is a segment between two airports. The originating airport, captured as a string
     * and the destination airport referenced as a Route object.
     */
    class Route {

        /**
         * Originating airport
         */
        String airportCode;

        /**
         * The Route starting at the destination airport of this Route.
         */
        Route next;

        /**
         * Basic constructor. Creates a Route with a given airport as its originating point
         * and a null for the Route after that.
         * @param airport Originating airport for this Route.
         */
        Route(String airport) {
            airportCode = airport;
            next = null;
        } // simple Route constructor
    } // class Route


    /**
     * Quick test
     */
    public static void main(String[] args) {
        Itinerary demo = new Itinerary();
        demo.add("ORD");
        demo.add("DEN");
        demo.add("SLC");
        demo.add("SEA");
        demo.add("LAX");

        demo.printItinerary();
        boolean insertionSuccessful = demo.insert("PDX","SEA");
        demo.printItinerary();
        boolean removalSuccessful = demo.remove("DEN");
        demo.printItinerary();
    } // method main
} // class Itinerary