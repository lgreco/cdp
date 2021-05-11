public class Book {
    /**
     * The title of the book; can be left empty
     */
    private String title;
    /**
     * The total number of pages; <b>must be > 0</b>
     */
    private int pages;
    /**
     * The first name of the author
     */
    private String authorFirstName;
    /**
     * The last name of the author
     */
    private String authorLastName;

    public Book(String title, int pages, String authorFirstName, String authorLastName) {
        this.title = title;
        this.pages = pages;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }


    //// where i write my own code ////

    // Write a class method that tells us if letters in author name
    // are more than letters in title

    public boolean authorHasMoreLetters() {
        return authorLastName.length() + authorFirstName.length() > title.length();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getAuthorFirstName() {
        return authorFirstName;
    }
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }
    public String getAuthorLastName() {
        return authorLastName;
    }
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book sandycove = new Book("Ulyssus", 900, "James", "Joyce");
        //                         ^^^^^^^^
        //                         TYPO !!!
        Book nightmare = new Book("Infinitesimal Calculus", 200, "James", "Henle");
        sandycove.setTitle("Ulysses");

        System.out.println(sandycove.authorHasMoreLetters());
        System.out.println(nightmare.authorHasMoreLetters());

    }
}