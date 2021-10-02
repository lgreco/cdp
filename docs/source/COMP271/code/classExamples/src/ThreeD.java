public class ThreeD {

    public static void main(String[] args) {
        int a[][][] = new int[2][2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    a[i][j][k] = i*j*k;
                    System.out.println(a[i][j][k]);
                }
            }
        }
    }


}
