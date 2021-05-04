
/**
 * This simple class builds a double-linked list, to emulate a train itinerary
 * between stations. The double linkage allows us to have back-and-forth
 * train service. For example, Amtrak's Lincoln Service, calls at these
 * stations, outbout of Chicago:<br/>
 *
 *    <center>Chicago - Joliet - Dwight - Pontiac - Normal - Springfield</center><br/>
 *
 *  then it returns to Chicago making the same stops. (Train aficionados:
 *  notice that for brevity I am not including all stops in the
 *  Lincoln Service).
 */
public class TrainLine {

    /**
     * The first Station in a train line.
     */
    Station head;

    /**
     * The last Station of a train line.
     */
    Station tail;

    /**
     * Add a Station. It is added to the end of a line, thus extending the
     * line one more Station.
     * @param cityName
     */
    public void add(String cityName) {
        Station newStation = new Station(cityName);
        if (head == null) {              // TrainLine is empty; make this the first
            head = newStation;           // and last Station
            tail = newStation;
        } else {                         // TrainLine is not empty, so we make this
            tail.next = newStation;      // Station its last one. As the last Station
            newStation.previous = tail;  // it has to have a previous Station.
            tail = newStation;
        }
    }

    /**
     * Class station comprises the city of the station as well as the
     * stations prior and after it.
     */
    class Station {
        String stationCity;
        Station next;
        Station previous;

        Station(String name) {
            stationCity = name;
            next = null;
            previous = null;
        }
    }

    /**
     * Simple test.
     */
    public static void main(String[] args) {
        TrainLine demo = new TrainLine();
        demo.add("Chicago");
        demo.add("Joliet");
        demo.add("Dwight");
        demo.add("Pontiac");
        demo.add("Normal");
        demo.add("Springfield");

        System.out.println("Outbound service:");
        Station currentStation = demo.head;
        System.out.println("\t Train originates in "+currentStation.stationCity);
        while (currentStation.next != null) {
            System.out.println("\t Train stops at "+currentStation.next.stationCity);
            currentStation = currentStation.next;
        }

        System.out.println("\nInbound service:");
         currentStation = demo.tail;
        System.out.println("\t Train returns from "+currentStation.stationCity);
        while (currentStation.previous != null) {
            System.out.println("\t Train stops at " + currentStation.previous.stationCity);
            currentStation = currentStation.previous;
        }
    }
}
