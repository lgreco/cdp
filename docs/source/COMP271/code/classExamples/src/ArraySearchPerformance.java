import java.util.Random;

public class ArraySearchPerformance {

    private static final int NUMBER_OF_EXPERIMENTS = 500000;
    private static final int SIZE_OF_ARRAY = 1001;
    private static final int MIN_VALUE_IN_ARRAY = 100;
    private static final int MAX_VALUE_IN_ARRAY = 1101;

    private int[] experiment = new int[SIZE_OF_ARRAY];
    private int[] timing = new int[NUMBER_OF_EXPERIMENTS];

    private int[] initializeArray(int[] a) {
        Random r = new Random();
        for (int i=0;i<a.length;i++) {
            a[i] = MIN_VALUE_IN_ARRAY + r.nextInt(MAX_VALUE_IN_ARRAY-MIN_VALUE_IN_ARRAY);
        }
        return a;
    }

    private int randomElement(int[] a) {
        Random r = new Random();
        return a[r.nextInt(a.length)];
    }

    private int timeToSearch(int[] a, int value) {
        int i = 0;
        while ( a[i] != value)
            i++;
        return i;
    }

    private void runExperiment() {
        for (int j=0;j<NUMBER_OF_EXPERIMENTS;j++) {
            experiment = initializeArray(experiment);
            int searchFor = randomElement(experiment);
            timing[j] = timeToSearch(experiment, searchFor);
        }
    }

    private int[] descriptive(int[] t) {
        int min, max, avg;
        min = t[0];
        max = t[0];
        avg = 0;
        for (int i=1;i<t.length;i++) {
            if (t[i]>max)
                max=t[i];
            if (t[i]<min)
                min=t[i];
            avg = avg + t[i];
        }
        int[] results = new int[3];
        results[0] = min;
        results[1] = max;
        results[2] = avg/t.length;
        return results;
    }

    private void reportDescriptive(int[] d) {
        System.out.println("After "+NUMBER_OF_EXPERIMENTS+" experiments on an array with "+SIZE_OF_ARRAY+" elements:");
        System.out.println("Min time to search: "+d[0]);
        System.out.println("Max time to search: "+d[1]);
        System.out.println("Avg time to search: "+d[2]);
    }

    public static void main(String[] args) {
        ArraySearchPerformance demo = new ArraySearchPerformance();
        demo.runExperiment();
        demo.reportDescriptive(demo.descriptive(demo.timing));
    }
}
