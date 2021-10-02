public class Loops {
  public static void main(String[] args) {
    for (int i = 3; i < 10; i+=3) {
      for (int j = 0; j <10; j++) {
        for (int k = 1; k < 4; k++) {
          System.out.printf("\t%d%d%d",i,j,k);
        }
      }
      System.out.println();
    }

    System.out.println("\n");
    for (int k = 1; k < 4; k++) {
      for (int j = 0; j <10; j++) {
        for (int i = 3; i < 10; i+=3) {
          System.out.printf("\t%d%d%d",i,j,k);
        }
      }
      System.out.println();
    }
  }
}
