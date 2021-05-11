import com.sun.jdi.connect.Connector;

import java.util.Iterator;
import java.util.LinkedList;

public class Iterarararators {

    private LinkedList<String> LL = new LinkedList<String> ();
    private int numberOfElements = 10000;
    private String element;
    long startTime, endTime, totalTime;

    public void showTime(long b, long e, String process) {
        System.out.printf("\n"+process+" took %.3f msec to complete", (e-b)/1000000.0);
    }

    public void populateLL() {
        int i = 0;
        while (i < numberOfElements) {
            element = i%2 == 0 ? "Even" : "Odd";
            LL.add(element);
            i++;
        }
    }

    public void removeByTraversing() {
        startTime = System.nanoTime();
        int i = 0;
        while (i < LL.size()) {
            element = LL.get(i);
            if ( element.length()%2 == 0) {
                LL.remove();
            } else {
                i++;
            }
        }
        endTime = System.nanoTime();
    }

    public void removeByIterator() {
        startTime = System.nanoTime();
        Iterator<String> i = LL.iterator();
        while (i.hasNext()) {
            element = i.next();
            if (element.length()%2 == 0) {
                i.remove();
            }
        }
        endTime = System.nanoTime();
    }

    public static void main(String[] args) {
        Iterarararators demo = new Iterarararators();
        demo.populateLL();
        demo.removeByTraversing();
        demo.showTime(demo.startTime, demo.endTime, "Remove by travesal" );
        demo.populateLL();
        demo.removeByIterator();
        demo.showTime(demo.startTime, demo.endTime, "Remove by iterator" );
    }
}
