import java.util.Random;

public class RAM {

    public static void main(String[] args) {
        int N = 100;
        int E = 100000;
        Random r = new Random();
        int[] a = new int[N];
        for (int i=0;i<N;i++)
            a[i] = i;
        int totalCount = 0;
        for (int i=0;i<E;i++) {
            int find = r.nextInt(N);
            int count = 0;
            int randomIndex = r.nextInt(N);
            while (a[randomIndex] != find) {
                randomIndex = r.nextInt(N);
                count++;
                //System.out.print(count+" ");
            }
//            System.out.print("\n\n");
            totalCount = totalCount+ count;
        }
        System.out.println(totalCount/E);
    }
}
