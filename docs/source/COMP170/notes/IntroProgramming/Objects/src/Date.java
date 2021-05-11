public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Not always a good idea to have a constructor like the following, but legal nevertheless
    public Date(Date other){
        this.year = other.year; // modifier "this" is not required
        this.month = other.month; //  here since there is no ambiguity,
        this.day = other.day; // but I am including it for illustration.
    }

    public static void main(String[] args) {
        Date independenceDate = new Date(1776,7,4);
        Date usIndependence = new Date(independenceDate);
    }
}
