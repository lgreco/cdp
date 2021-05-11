public class Friend {

    private String firstName;
    private String lastName;
    private String eMail;

    public Friend() {
        firstName = "Give your friend a first name";
        lastName = "Give your friend a last name";
        eMail = "Give your friend an email address";
    }

    public Friend(String firstName, String lastName, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
    }

    // mutators, accessors, etc go here ...


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String geteMail() {
        return eMail;
    }

    public static void main(String[] args) {

    }
}
