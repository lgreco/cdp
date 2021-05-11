public class Author {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        Author ams = new Author();
        ams.firstName = "Alexander";
        ams.lastName = "McCall Smith";
        ams.getFirstName();
    }
}
