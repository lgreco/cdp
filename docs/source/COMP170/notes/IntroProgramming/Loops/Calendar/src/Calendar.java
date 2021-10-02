/**
 * A class that delivers a printed calendar for a month whose length and first
 * Sunday are passed as parameters to the class' principal method.
 */
public class Calendar {

    public static final int DAYS_IN_WEEK = 7;

    /** Driver method (aka main) */
    public static void main(String[] args) {
        // try every month scenario (28, 29, 30, and 31 days)
        for (int daysInMonth = 28; daysInMonth <= 31; daysInMonth++) {
            // try every possible first Sunday
            for (int firstSunday = 1; firstSunday <= 7; firstSunday++) {
                printCalendar(daysInMonth, firstSunday);
                System.out.println();
            }
        }
    } // method main

    /**
     * The principal method for printing the calendar. The method has three
     * distinct parts. Its first part prints the header of the calendar along
     * with a line for its first week. The second part prints the dates for as
     * many full weeks as possible. The third part prints the last week along
     * a bottom border.
     * @param daysInMonth How many days in this month?
     * @param firstSunday What day of the month is its first Sunday?
     */
    public static void printCalendar(int daysInMonth, int firstSunday) {
        // Calendar header
        System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat   ");
        System.out.println("+------+------+------+------+------+------+------+");

        // First week
        System.out.print("|");
        /*
         Loop for empty cells in first week. If Sunday is the first day of the
         month, this loop will print 7 empty spots, effectively adding an empty
         line at the beginning of this calendar.
         */
        for (int i = 1; i <= DAYS_IN_WEEK - firstSunday + 1; i++) {
            System.out.print("      |");
        }
        /*
        Loop for dated cells in first week. Just like the loop above, this one
        will print nothing on the first line if indeed the first day of the month
        is Sunday.
         */
        for (int i = 1; i <= firstSunday - 1; i++) {
            System.out.print(padded(i, 4));
            System.out.print("  |");
        }
        System.out.println();

        /*
        Loop to print full weeks. The loop starts at the first Sunday of the month,
        increments in steps of DAYS_IN_WEEK ( = 7 ), and runs up to
        daysInMonth - DAYS_IN_WEEK. The reason we subtract DAYS_IN_WEEK from daysInMonth
        is to account for the first week we already printed.
         */
        int lastWeekPrintedStartedOn = 0;
        for (int i = firstSunday; i <= daysInMonth - DAYS_IN_WEEK; i = i + DAYS_IN_WEEK) {
            printWeek(i, i + DAYS_IN_WEEK);
            lastWeekPrintedStartedOn = i;
        }

        /*
        Loop to print last week; since the last week printed started on the date
        given by the last value of i (currently stored in lastWeekPrintedStartedOn)
        this last week starts at lastWeekPrintedStartedOn+DAYS_IN_WEEK.
         */
        printWeek(lastWeekPrintedStartedOn + DAYS_IN_WEEK, daysInMonth+1);

        // Print bottom border
        System.out.println("+------+------+------+------+------+------+------+");
    } // method printCalendar

    /**
     * Prints a full week from startingSunday to endingSaturday.
     * @param startingSunday the date for the week's Sunday
     * @param endingSaturday the date for the week's Saturday
     */
    public static void printWeek(int startingSunday, int endingSaturday) {
        System.out.print("|");
        for (int i = startingSunday; i < endingSaturday; i++) {
            System.out.print(padded(i, 4));
            System.out.print("  |");
        }
        /*
        In case this is a partial week, ie, the month ends during this week, we
        need to print empty cells for the remaining days in the week.
         */
        for (int i = endingSaturday; i < startingSunday + 7; i++) {
            System.out.print("      |");
        }
        System.out.println();
    } // method printWeek

    /**
     * Method to pad a number with spaces ensuring right-flushed printing.
     * (The method is akin to String.format() but with a simpler implementation;
     * its functionality can also be obtained with printf())
     * @param n number to pad
     * @param width width of padding
     * @return Padded string
     */
    public static String padded(int n, int width) {
        String s= "" + n;
        for (int i = s.length(); i < width; i++) {
            s = " " + s;
        }
        return s;
    } // method padded
}