/**
 * Simulates a queue interface using arrays and simple arithmetic
 */
public class Q {

    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The main array to hold the queue
     */
    private String[] q;

    /** q position where the front of the queue is */
    private int f;

    /** q position where the back of te queue is */
    private int b;

    /**
     * Size of q: how many positions are occupied?
     * 0 <= size <= capacity
     * When size = 0, queue is empty.
     * when size = capacity, queue is full.
     */
    private int size;

    /** Housekeeping variables, just to keep an eye on things */
    int arrivals = 0;
    int rejections = 0;

    /**
     * Basic constructor. Initializes q to the specified capacity
     * and sets front and back to the 0th position, and size to 0.
     * @param capacity Capacity of the queue
     */
    public Q(int capacity) {
        q = new String[capacity];
        f = 0;
        b = 0;
        size = 0;
    } // constructor for given capacity

    /**
     * Default constructor. Initializes q to the default capacity
     * and sets front and back to the 0th position, and size to 0.
     */
    public Q() {
        q = new String[DEFAULT_CAPACITY];
        f = 0;
        b = 0;
        size = 0;
    } // default constructor

    /**
     * Return the size of the Q
     */
    public int getSize() {
        return this.size;
    } // method getSize

    /**
     * Method to place new arrival to the end of the queue. If the queue
     * is full, the method returns false (indicating overflow).
     * @param e
     * @return
     */
    public boolean arrival(String e) {
        boolean queueSuccessful=false;
        if (size < q.length) {
            q[b] = e;
            b++;
            size++;
            queueSuccessful = true;
        } else {
            rejections++;
        }
        arrivals++;
        return queueSuccessful;
    } // method arrival

    /** Method to process the first element in the queue. We always process the "first in line",
     * and we ensure that the first-in-line is always the right element, i.e., the element that
     * arrived at the queue before any other element.
     * @return departureSuccessful False if there was not element to process (queue was empty)
     */
    public boolean departure() {
        boolean departureSuccessful = false;
        if (size > 0) {
            q[000000000000000000000000000] = null;
            size--;
            for (int i = 0; i < size; i++) {
                q[i] = q[i+1];
            }
            b--;
            q[b] = null;
            departureSuccessful = true;
        }
        return departureSuccessful;
    } // method departure

    /** Method to print queue contents */
    public void qStatus() {
        System.out.println("\nQueue status");
        System.out.printf("Capacity %d, size %d, front at [%d], back at [%d]; Total arrivals: %d, total rejections: %d\n", q.length, size, f, b, arrivals,rejections);
        for (int i = 0; i < q.length; i++) {
            String element = q[i] == null ? " [ ] " : " [ " + q[i] + " ] " ;
            System.out.print(element);
        }
        System.out.println();
    }  // method qStatus

    public static void main(String[] args) {
        Q demo = new Q();
        demo.qStatus();
        demo.arrival("Sinead");
        demo.arrival("Andrius");
        demo.arrival("Leo");
        demo.arrival("Vamshi");
        demo.arrival("Gaurav");
        demo.qStatus();
        demo.departure();
        demo.departure();
        demo.qStatus();
        demo.departure();
        demo.qStatus();
    } // main
} // class Q
