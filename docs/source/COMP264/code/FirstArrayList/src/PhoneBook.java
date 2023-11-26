import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Friend> contacts = new ArrayList<Friend>();

    /**
     * Method to search if a record with the same first name, last name, and
     * email address exists in the contacts list. The method creates a new
     * Friend objects and then uses ArrayList's contains to see if that
     * object is already in the contacts list.
     * !! Future suggestion: this method can be overloaded so that a variant
     * with a single string argument can search for a record (Friend) that
     * matches the argument through any of its class variables.
     *
     * @param f first name
     * @param l last name
     * @param e email address
     * @return true if Friend (f,l,e) already exists in contacts list.
     */
    public boolean recordExists(String f, String l, String e) {
        Friend searchForThis = new Friend(f,l,e);
        return contacts.contains(searchForThis);
    }

    // method to add a friend after verifying that there is no record for him/her
    public void addRecord(String f, String l, String e) {
        Friend newEntry = new Friend(f,l,e);
        boolean alreadyExists = contacts.contains(newEntry);
        if (!alreadyExists)
            contacts.add(newEntry);
    }

    // method to edit friend's name
    // method to edit friend's email address

    public static void main(String[] args) {

        PhoneBook myPhoneBook = new PhoneBook();

    }
}
