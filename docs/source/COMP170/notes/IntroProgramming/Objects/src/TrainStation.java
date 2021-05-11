/**
 * A simple class to model train stations
 */
public class TrainStation {

    /** The three-letter designation of the station, e.g. CHI */
    private String stationCode;

    /** The full name of the station, e.g., Chicago Union Station */
    private String stationName;

    /** What is the next station? */
    TrainStation nextStation;

    /** Full constructor: spells trouble! */
    public TrainStation(String stationCode, String stationName, TrainStation nextStation) {
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.nextStation = nextStation;
    }

    /** Partial constructor: spells troub...*/
    public TrainStation(String stationCode, String stationName) {
        this.stationName = stationName;
        this.stationCode = stationCode;
        this.nextStation = null;
    }

    /** Add a nextStation pointer to an existing object */
    public void setNextStation(TrainStation nextStation) {
        this.nextStation = nextStation;
    }

}
