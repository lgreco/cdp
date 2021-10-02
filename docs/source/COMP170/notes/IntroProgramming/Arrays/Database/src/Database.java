

import java.io.*;
import java.util.Scanner;

/**
 * A naive emulator of a database app, using a space-delimited file where we
 * record the names, phones, and birthdays of people. The emulator is naive
 * in that it blurs the line between physical and logical designs. In other
 * words, our program has foreknowledge of how our data are organized -- this
 * goes against established database practices. For now, it's ok to overlook
 * this deficiency, to illustrate how use arrays.
 */
public class Database {

    /* ****************************************** *
     * CLASS VARIABLES, ACCESSIBLE TO ALL METHODS *
     * ****************************************** */


    /* Class variable with the number of records in the database */
    static int numberOfRecords;
    /* Class arrays for the String fields of the database */
    static String[] firstName, lastName, phoneNumber;
    /* Class arrays for the int fields of the database */
    static int[] birthdayMonth, birthdayDate;
    /* Class-wide scanner for keyboard input */
    static Scanner keyboard = new Scanner(System.in);
    /* Class-wide File object for database records */
    static File databaseFile;
    /* Class variables for first and last names max lengths */
    static int maxFN = 0, maxLN = 0, padding = 3;


    /* *********************************************** *
     * HELPER METHODS FOR HOUSEKEEPING AND OTHER TASKS *
     * *********************************************** */


    /**
     * Initialize the program by counting number of records in the database
     * file and calling up the menu
     */
    static void init() throws IOException {
        countLines();
        menu();
    } // method init


    /**
     * Method to manage menu
     */
    static void menu() throws IOException {
        populate();
        display(); // Show the database records
        boolean runMenu = true; // To keep the menu running until quit time
        while (runMenu) {
            System.out.printf("\n(A)dd  (E)dit  (D)elete  (Q)uit: ");
            String menuChoice = keyboard.next().toUpperCase();
            switch (menuChoice) {
                case "A":
                    addRecord();
                case "E":
                    editRecord();
                case "D":
                    deleteRecord();
                case "Q":
                    runMenu = false;
                    break;
            }
        }
    } // method menu


    /**
     * Method to obtain number of records, and max length for names
     */
    static void countLines() throws IOException {
        Scanner f = new Scanner(databaseFile);
        numberOfRecords = 0; // reset record counter
        maxFN = 0; // reset max lengths to zero
        maxLN = 0;
        while (f.hasNext()) {
            String line = f.nextLine(); // read line from file
            if (!line.isEmpty()) { // skip if blank line
                Scanner local = new Scanner(line); // pass line into a local scanner
                String fn = local.next(); // local parse for firstName token, for max length
                String ln = local.next(); // local parse for lastName token, for max length
                maxFN = (fn.length() > maxFN) ? fn.length() : maxFN; // max length, first name
                maxLN = (ln.length() > maxLN) ? ln.length() : maxLN; // max length, last name
                local.close(); // close local scanner
                numberOfRecords++; // update record count
            }
        }
        f.close(); // Be nice
    } // method countLines


    /**
     * Method to populate arrays
     */
    static void populate() throws IOException {
        countLines(); // refresh the number of records first
        // Initialize arrays
        firstName = new String[numberOfRecords];
        lastName = new String[numberOfRecords];
        phoneNumber = new String[numberOfRecords];
        birthdayDate = new int[numberOfRecords];
        birthdayMonth = new int[numberOfRecords];
        // Scan database file, parse line-by-line, assign to arrays
        int index = 0; // for array pointing
        Scanner f = new Scanner(databaseFile); // database file scanner
        while (f.hasNext()) { // read file line-by-line, tokenize, assign to arrays
            firstName[index] = f.next(); // first token is first name
            lastName[index] = f.next(); // second token is last name
            phoneNumber[index] = f.next(); // third token is phone number
            birthdayMonth[index] = f.nextInt(); // forth token is birthday month
            birthdayDate[index] = f.nextInt(); // fifth token is birthday date
            index++; // get ready for next element
        }
        f.close(); // close scanner connection to database file
    } // method populate


    /**
     * Method to display formatted contents. The method is a helper method for menu()
     * and it is not meant to be called independently. It does not guarantee the most
     * accurate version of the database file. Method menu() invokes method populate()
     * to refresh the data, before invoking display(). To use display() outside menu()
     * call populate() prior to display(), to refresh arrays.
     */
    static void display() {
        System.out.printf("\n\tSUPERIOR DATABASE PRODUCTS\n"); // unwarranted bragging
        for (int record = 0; record < numberOfRecords; record++) {
            System.out.printf("\n[%04d]", record);
            System.out.printf(" | %s", pad(firstName[record], maxFN)); // pad() ensure left flushing
            System.out.printf(" | %s", pad(lastName[record], maxLN)); // with space according to max lengths
            System.out.printf(" | %s-%s-%s", // parse phone number to
                    phoneNumber[record].substring(0, 3), // area code
                    phoneNumber[record].substring(3, 6), // exchange
                    phoneNumber[record].substring(6)); // line number
            System.out.printf(" | %02d/%02d", birthdayMonth[record], birthdayDate[record]);
        }
        System.out.println(); // clear line after all records displayed
    } // method display


    /**
     * Method to left-flush string in given space
     */
    static String pad(String s, int length) {
        return s + " ".repeat(length - s.length());
    } // method pad


    /**
     * Method to copy arrays into file
     */
    static void saveArrays() throws IOException {
        databaseFile.delete(); // Delete existing file
        // Establish file stream and text conduit
        FileWriter fw = new FileWriter(databaseFile); // no need to append
        BufferedWriter bw = new BufferedWriter(fw);
        // Traverse arrays, form record, write it to file
        for (int record = 0; record < numberOfRecords; record++) {
            String entry = String.format("%s %s %s %d %d", // space delimited string
                    firstName[record],
                    lastName[record],
                    phoneNumber[record],
                    birthdayMonth[record], birthdayDate[record]);
            bw.write(entry); // write string in file
            bw.newLine(); // skip to next line
        }
        bw.close(); // close text-to-stream conduit
        fw.close(); // close file stream
    } // method saveArrays


    /**
     * Method to swap two array elements -- String version
     */
    static void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    } // method swap

    /**
     * Method to swap two array elements -- int version
     */
    static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    } // method swap


    /* ************************************************** *
     * PRINCIPAL METHODS TO ADD, EDIT, AND DELETE RECORDS *
     * ************************************************** */


    /**
     * Method to add new record to the database. The method collects
     * the fields from keyboard, appends the new record to the
     * database file, and re-populates the arrays with +1 elements.
     */
    static void addRecord() throws IOException {
        // obtain fields from keyboard
        System.out.printf("\nEnter a new record.\n");
        System.out.printf("\n    First name: ");
        String f = keyboard.next();
        System.out.printf("\n     Last name: ");
        String l = keyboard.next();
        System.out.printf("\n  Phone number: ");
        String p = keyboard.next();
        System.out.printf("\nBirthday month: ");
        int m = keyboard.nextInt();
        System.out.printf("\n Birthday date: ");
        int d = keyboard.nextInt();
        // form and append new record to file
        String newRecord = String.format("%s %s %s %d %d", f, l, p, m, d);
        FileWriter fw = new FileWriter(databaseFile, true); // Stream connection to append database file
        BufferedWriter bw = new BufferedWriter(fw); // Text conduit to stream
        bw.newLine(); // enter new line
        bw.write(newRecord); // append new record to database file
        //bw.newLine(); // enter new line
        bw.close(); // close text conduit
        fw.close(); // close file stream
        populate(); // re-populate arrays
        menu(); // back to the menu
    } // method addRecord

    /**
     * Method to edit an existing record based on its index number.
     */
    static void editRecord() throws IOException {
        // Obtain index number
        numberOfRecords = firstName.length;
        System.out.printf("\nWhich record do you wish to edit [0-%d]? ", numberOfRecords - 1);
        int indexToEdit = keyboard.nextInt();
        if (indexToEdit < 0 || indexToEdit >= numberOfRecords) {
            System.out.printf("\nIndex out of range.");
            menu();
        } else {
            /*
            indexToEdit is within range. Obtain edited values and rewrite array on file.
            The code below is not efficient and can be improved significantly. It is
            however adequate for illustrative purposes. The biggest mistake here is that
            encode part of the database design into the program. Ideally, our code should
            be database-design agnostic.

            I use the ternary operator (?:;) below to decide what value to assign to an array
            element. For those unfamiliar with it, it's a short-hand version of the if-else
            statement, e.g.

              String p = (n%2 == 1) ?  "odd" : "even";

            assigns the value "odd" to String p, if the n%2 is 1, even otherwise. It's equivalent
            to

              String p;
              if (n%2 == 1) {
                p = "odd";
              } else {
                p = "even";
              }

            In other words, the ternary operator allows us to write simple if-else statements
            in a single line. In some cases, this makes the code more readable.

             */
            // Edit first name ----------------------------------------------------------
            System.out.printf("Enter new value for [%s] or . to continue: ", firstName[indexToEdit]);
            String newValue = keyboard.next();
            firstName[indexToEdit] = (newValue.equals(".")) ? firstName[indexToEdit] : newValue;
            // Edit last name -----------------------------------------------------------
            System.out.printf("Enter new value for [%s] or . to continue: ", lastName[indexToEdit]);
            newValue = keyboard.next();
            lastName[indexToEdit] = (newValue.equals(".")) ? lastName[indexToEdit] : newValue;
            // Edit phone number --------------------------------------------------------
            System.out.printf("Enter new value for [%s] or . to continue: ", phoneNumber[indexToEdit]);
            newValue = keyboard.next();
            phoneNumber[indexToEdit] = (newValue.equals(".")) ? phoneNumber[indexToEdit] : newValue;
            // Edit birthday month ------------------------------------------------------
            System.out.printf("Enter new value for [%d] or . to continue: ", birthdayMonth[indexToEdit]);
            newValue = keyboard.next();
            birthdayMonth[indexToEdit] = (newValue.equals(".")) ? birthdayMonth[indexToEdit] : Integer.valueOf(newValue);
            // Edit birthday date -------------------------------------------------------
            System.out.printf("Enter new value for [%s] or . to continue: ", birthdayDate[indexToEdit]);
            newValue = keyboard.next();
            birthdayDate[indexToEdit] = (newValue.equals(".")) ? birthdayDate[indexToEdit] : Integer.valueOf(newValue);
            saveArrays(); // Save arrays back to file
            countLines(); // Just in case there is a longer name in the file, update the info
        }
        menu(); // back to menu
    } // method editRecord


    /**
     * Method to delete a record. The method swaps the record to be deleted
     * with the last record in the away, then rewrites the database file for
     * all records but the last one -- this is easy to achieve by running
     * the arrays loop to numberofRecords-1.
     */
    static void deleteRecord() throws IOException {
        numberOfRecords = firstName.length; // Obtain index number for record to delete
        System.out.printf("\nWhich record number you wish to delete [0-%d]? ", numberOfRecords - 1);
        int indexToDelete = keyboard.nextInt(); // user input
        if (indexToDelete < 0 || indexToDelete >= numberOfRecords) { // validate index
            System.out.printf("\nIndex out of range.");
        } else { // index valid, confirm deletion
            System.out.printf("\nAre you use you want to delete record %04d [Y/N]? ", indexToDelete);
            String confirm = keyboard.next().toUpperCase(); // user input
            if (confirm.equals("Y")) {
                // swap record with last record
                if (indexToDelete != numberOfRecords - 1) {
                    swap(firstName, indexToDelete, numberOfRecords - 1);
                    swap(lastName, indexToDelete, numberOfRecords - 1);
                    swap(phoneNumber, indexToDelete, numberOfRecords - 1);
                    swap(birthdayMonth, indexToDelete, numberOfRecords - 1);
                    swap(birthdayDate, indexToDelete, numberOfRecords - 1);
                }
                numberOfRecords--; // reduce numberOfRecords by 1 so the last record will not be written on the file
                saveArrays(); // saveArrays
                countLines(); // reassess max lengths
            }
        }
        menu(); // back to the menu
    } // method deleteRecord


    /* ************* *
     * Driver method *
     * ************* */
    public static void main(String[] args) throws IOException {
        databaseFile = new File("database.txt");
        init();
    } // method main

} // Class Database
