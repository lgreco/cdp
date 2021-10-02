:orphan:

The CTA Class
---------------------------------------------------

`The CTA class <https://github.com/lgreco/DataStructures/tree/master/LabSessions/The%20CTA/src>`__ is a nice playground to explore interfaces and inheritance. The class is based on data about the train and bus services offered by the Chicago Transit Authority. The data are available from the city's data portal. This example is based on familiarity with CTA train and bus routes.

We begin with a simple model: one superclass for locations, extended by two class one for train stations and one for bus stops. The class diagram is shown below.

.. figure:: images/TheCTA.png

The next step is to expand class ``CTALocation`` with two more fields:

.. code:: java

   private double latitude, longitude;


that capture the geographic coordinates of a location. These coordinates are part of a CSV file with station information that is `available from the Chicago Data Portal <https://data.cityofchicago.org/Transportation/CTA-System-Information-List-of-L-Stops/8pix-ypme>`__. This expansion may necessitate a new constructor for the class:

.. code-block:: java
   :emphasize-lines: 2

   public CTALocation(String name, double latitude, double longitude) {
       this(name);
       this.latitude = latitude;
       this.longitude = longitude;
    }
    
The highlighted line above is a call to the class's basic constructor. Once that basic constructor initializes the object, the constructor above assigns values to the ``latitude`` and ``longitude` fields.

The next step in this mini-project was to implement the ``Comparable`` interface in ``CTALocation``:

.. code:: java

   public class CTALocation implements Comparable<CTALocation> {...}
   
When a class **implements** an interface, it promises to include the behavior outlined in the interface. The interface is really a list of method signatures. The implementation of these methods is left to the programmer. The interface (should) provide extensive commentary for each method signature it contains, communicating to programmers how to best implement the methods.

The ``Comparable`` interface, for example, `lists only one method <https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T->`__. The documentation for that method is sufficient to help a developer write suitable code. We know that the method must return a negative integer number if the invoking object (``this``) is less than the passed object; zero if they are equal, and; a positive integer is the invoking object is greater. Based on this information we can set up a skeleton method and complete it step-by-step. 

.. code-block:: java
   :emphasize-lines: 4

   public int compareTo(CTALocation other) {
       double thisDistance = distance(this.latitude, this.longitude, ...);
       double otherDistance =  distance(other.latitude, other.longitude, ...);
       return (int) (thisDistance-otherDistance);
   }

We don't know yet how ``distanceFromDowntown`` works but we can assume that it returns the distance between downtown Chicago and a location specified by latitude and longitude. The important thing is the return line above. Consider the following invocation of the method:

.. code:: java

   int x = ohare.compareTo(western);
   
and assume that ``ohare`` and ``western`` are ``CTALocation`` objects for the CTA stations at O'Hare airport and on Western (and Lawrence) avenue. Intuitively, we know that O'Hare is further away from downtown that Western. Indeed, the O'Hare station is about 15.5 miles from downtown; the Western station, 6.5 miles. We can verify these distances with a tool like Google Earth. Based on that, we expect variable ``x`` above to be positive, with a value of ``8`` or ``9``, depending on the exact distances and their difference.

All that remains is the method that computes the distance from downtown. At this point the programming becomes highly specialized and we must ask for help. *Help is always given at Loyola to those who ask for it.* The ``distance`` method is shown in the next section. It computes the distance between any two points on earth, specified by the respective latitudes and longitudes. We need to compute distances from downtown, so we can **overload** the method as follows.

.. code-block:: java
   
   static double distance(double lat, double lon) {
       final double MADISON_STATE_LAT = 41.882067;
       final double MADISON_STATE_LON = -87.6283605;
       return distance(lat, lon, MADISON_STATE_LAT, MADISON_STATE_LON);
   }

Alternatively, we can overload ``distance`` as:


.. code-block:: java
   
   static double distance(CTALocation ctaLocation) {
       final double MADISON_STATE_LAT = 41.882067;
       final double MADISON_STATE_LON = -87.6283605;
       return distance(ctaLocation.latitude, ctaLocation.longitude, 
           MADISON_STATE_LAT, MADISON_STATE_LON);
   }

Of course, we can skip overloading altogether by writing the Madison and State coordinates as ``private``, ``static``, ``final`` variables in class ``CTALocation``, and then invoke ``distance`` in method ``compareTo`` as follows.

.. code-block:: java

   public int compareTo(CTALocation other) {
       double thisDistance = distance(this.latitude, this.longitude,
           MADISON_STATE_LAT, MADISON_STATE_LON);
       double otherDistance =  distance(other.latitude, other.longitude
           MADISON_STATE_LAT, MADISON_STATE_LON);
       return (int) (thisDistance-otherDistance);
   }
   

The ``distance`` method
========================

.. code-block:: java
   :linenos:
   

    /**
     * Compute Great Circle distance between two points on Earth.
     *
     * Usage:
     *
     *         double dist = distance(lat1, lon1, lat2, lon2)
     *                                ----------  ----------
     *                                     |           |
     *                                     |           Geographic coordinates
     *                                     |           of second point, in degrees
     *                                     |           of latitude and longitude.
     *                                     |
     *                                     Geographic coordinates
     *                                     of first point, in degrees
     *                                     of latitude and longitude.
     *
     * Based on the haversine formula (https://en.wikipedia.org/wiki/Haversine_formula):
     *
     * d = 2 * r * arcsin(sqrt(
     *                         hav(lat2-lat1) +
     *                         cos(lat1)*cos(lat2)*hav(lon2-lon1)
     *                         ))
     *
     * where hav is the haversine function, hav(x) = sin^2(x/2).
     *
     * The computed distance is subject to slight numerical errors because (a) the formula
     * assumes that Earth is a sphere, when it is not, and; (b) Math's toRadians is prone
     * to rounding errors.
     *
     * @param lat1 Latitude of first point
     * @param lon1 Longitude of first point
     * @param lat2 Latitude of second point
     * @param lon2 Longitude of second point
     * @return distance between two points
     */
    static double distance(double lat1, double lon1, double lat2, double lon2) {

        // Radius of earth, in miles. Use 6371 to compute in kilometers.
        final double EARTH_RADIUS = 3958.8;

        /*
        Convert latitudes to radians (the unit used by Math's trig functions). No such conversion
        is needed for the longitude values because they are not used individually in a trigonometric
        function. Instead, convert their different to radians to use in the second hav() function.
         */
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Latitude difference for hav function (they are already in radians)
        double deltaLatitude = lat2-lat1;
        // Longitude difference for hav function (converted to radians)
        double deltaLongitude = Math.toRadians(lon2 - lon1);

        /*
        Build haversine formula step-by-step, for clarity. First compute the haversine functions
        for latitude and longitude using the substitution hav(x) = sin^2(x/2). Next, assemble the
        trig expression that goes the square root. And finally build the formula.
         */

        double latHav = Math.pow(Math.sin(deltaLatitude/2.0), 2.0);
        double lonHav = Math.pow(Math.sin(deltaLongitude/2.0), 2.0);
        double cosines = Math.cos(lat1)*Math.cos(lat2);
        double underRoot = latHav + cosines*lonHav;

        // Return value, assigned negative in case we fail to compute formula
        double d = -1.0;
        if (underRoot >= 0.0)
            d = 2 * EARTH_RADIUS * Math.asin(Math.sqrt(underRoot));
        return d;
    } // method distance

