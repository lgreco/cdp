public class FizzBuzz {

    private static final int N =20;

    public static void main(String[] args) {
        for (int i=0;i<N;i++) {
            if (i%5 == 0)
                System.out.println("fizz");
            else if (i%7 == 0)
                System.out.println("buzz");
            else
                System.out.println(i);
        }
    }
}
