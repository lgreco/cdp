public class LinearTo2D {

    public static int row(int position, int seatsPerRow) {
        return position / seatsPerRow;
    }

    public static int column(int position, int seatsPerRow) {
        return position % seatsPerRow;
    }

    public static void main(String[] args) {
        int SEAT_PER_ROW = 4;
        int POSITION_IN_LINE = 14;
        int row = row(POSITION_IN_LINE,SEAT_PER_ROW);
        int col = column(POSITION_IN_LINE, SEAT_PER_ROW);
        System.out.printf("The person at position %d will be seated at row %d, column %d", POSITION_IN_LINE,row, col);
    }

}
