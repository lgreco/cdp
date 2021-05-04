public class Friend {

    private String firstName;
    private String lastName;
    private String phone;

    /** Full constructor */
    public Friend(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    /** Default constructor */
    public Friend() {
        this("","",""); // calls full constructor with empty strings
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    /** Name-only constructor */
    public Friend(String fn, String ln) {
        this( // calls full constructor with empty phone and processed strings for names
                fn.substring(0, 1).toUpperCase() + fn.substring(1).toLowerCase(),
                ln.substring(0, 1).toUpperCase() + ln.substring(1).toUpperCase(),
                "");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public String getFirstName() {
        return firstName;
    }

}
