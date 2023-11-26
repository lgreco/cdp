
public class CarWash {

    /**
     * Method to assess when a car arrives at the carwash (not
     * necessarily entering the queue, just driving up).
     * Assumes that time starts at 0 minutes.
     * @param atTime current simulation time
     * @param arrivalPeriod period for car arrival
     * @return true if it's time for a car arrival; false otherwise
     */
    public boolean carArrives(int atTime, int arrivalPeriod) {
        return ( atTime % arrivalPeriod == 0);
    } // method carArrive

    /**
     * Method to assess if a Q object is empty or not.
     * An empty Q object is characterized by Q.size = 0.
     * @param q Q object to assess emptiness
     * @return true is object empty.
     */
    public boolean queueEmpty(Q q) {
        return (q.getSize() == 0);
    } // method queueEmpty

    /**
     * Method to drive simulation. The method is setup to run
     * a simulation for a car wash with queue capacity = qCapacity,
     * a fixed period between can arrivals, and a total legth of
     * simuation set to simulationTime.
     * @param qCapacity queue capacity at the car wash
     * @param period fixed time interval between car arrivals
     * @param simulationTime how long to run simulation
     */
    public void simulate(int qCapacity, int period, int timeToWash, int simulationTime) {

        /**
         * The Q object for the simulation
         */
        Q q = new Q(qCapacity);

        /**
         * The main time keeper for the simulation
         */
        int minute;

        /**
         * A "flag" to indicate when the car wash machine is
         * busy (ie a car is being washed) or idle and therefore
         * ready to accept the next car in line. By default,
         * we assume that the machine is idle.
         */
        boolean carWashBusy = false;

        int timeRemainingInWash = 0; // If wash bay empty, no wash in progress, right?
        int timeWashStarted = 0;      // Variable to catch when a new wash begins.

        /**
         * Variables for computing avg and max values
         */
        double avgWaitTime = 0.0;
        double maxWaitTime = 0.0;
        int carCounter = 0;

        /**
         * Varaibles for estimating waiting conditiions
         */
        int waitTimeForThisCar;
        int carsInFront;

        /**
         * The simulation loop. We go, minute by minute, up to however
         * long the simulation runs, determined by simulationTime.
         * Every minute we check for two events:
         *   a. Is it time for a new car to arrive?
         *   b. Is the car wash machine available for the next car
         *      in line, and if yes, are there any cars in line?
         *   c. Car wash completed? If so, can we mark the car wash
         *      machine as available for the next car in line (if there
         *      is anyone waiting for a wash)
         */
        for (minute = 0; minute < simulationTime; minute++) {

            /**
             * First event: is there a new car arriving?
             */
            if (carArrives(minute, period)) {
                /**
                 * A new car is arriving. Can the queue accomodate it?
                 * Remember Q.arrival() returns false if the queue is
                 * full and cannot accept new entries. The arrival()
                 * methods requires a String, and we name cars as "CarX"
                 * where X is the minute of their arrival.
                 */
                if (q.arrival("Car "+minute)) {
                    /**
                     * How long does this car have to wait?
                     *
                     *   as long as             (  number           time   )        time
                     *   it takes for          (       of           it      )       remaining
                     *   the cars           = (      cars      X    takes    )  +   for car
                     *   ahead of it           ( in front           to wash )       currently
                     *   to get washed          (   of it           a car  )        washed
                     *
                     *
                     *                         ( current                      )
                     *                      = (    queue       X    timeToWash ) + timeRemainingInWash
                     *                         (    size                      )
                     *
                     *
                     *                      = (q.getSize()-1   X    timeToWash)  + timeRemainingInWash
                     *
                     *
                     * We subtract 1 from q.getSize() because the queue's size includes that car
                     * that just arrived, e.g., if you are the 4th car in there there are (4-1)
                     * cars in front of you.
                     *
                     * timeRemainingInWash can be evaluated if we know: what time the car currently
                     * being washed enter the washer, what time it is now, and how long it takes for a wash.
                     * The time now is given by variable minutes.
                     * minute - timeWashStared is how long the car being washed is in the washer so far.
                     *
                     */
                    timeRemainingInWash = timeToWash - (minute - timeWashStarted);
                    carsInFront = q.getSize() - 1;
                    waitTimeForThisCar = ( carsInFront * timeToWash ) + timeRemainingInWash;

                    if (waitTimeForThisCar < 0) { waitTimeForThisCar = 0; }
                    avgWaitTime = avgWaitTime + waitTimeForThisCar;
                    carCounter = carCounter + 1;
                    maxWaitTime = (waitTimeForThisCar > maxWaitTime) ? waitTimeForThisCar : maxWaitTime;

                    System.out.println("\nNEW EVENT!\n\tCar joining queue at t = " + minute);
                    System.out.println("\tTime remaining in wash is " + timeRemainingInWash + " minutes");
                    System.out.println("\tThere are " + carsInFront + " cars in front; wait time is: "+ waitTimeForThisCar + " minutes");
                    System.out.println("\tAverage wait time is " + avgWaitTime/carCounter);
                    System.out.println("\tMax wait time is "+ maxWaitTime);
                }
            }

            /**
             * Second event: is the machine available to wash the
             * next car, and is there a next car?
             */
            if ( !carWashBusy ) {
                /**
                 * Machine is idle. Let's see if there is anyone waiting in line for a wash
                 */
                if (q.departure()) {
                    /**
                     * There is a car waiting to be washed. Remove it from the queue and
                     * set the machine's status to busy, indicating that it is now washing a car.
                     * Also capture the time this happens, so that we can keep track when the
                     * wash will be over, or how much time is left in the wash cycle.
                     */
                    carWashBusy = true;
                    timeWashStarted = minute;
                    System.out.println("\nNEW EVENT!\n\tCar wash idle; next car in line enters bay at t = " + minute);
                }
            }

            /**
             * Third event: if S minutes have lapsed since a wash started, vacate
             * the bay and set machine to idle status
             */

            if (minute == (timeToWash+timeWashStarted)) {
                carWashBusy = false;
                System.out.println("\nNEW EVENT!\n\tCar leaves wash bay at t = " + minute);
            }
        }
    } // method simulate

    public static void main(String[] args) {
        CarWash demo = new CarWash();
        demo.simulate(16,6,3,360);
    }
} // CarWash