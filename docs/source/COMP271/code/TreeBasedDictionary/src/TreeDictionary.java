import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TreeDictionary {

    public static void main(String[] args) throws IOException {

        String word;

        /*
        Create a URL object to the Project Gutenberg edition of Les Misérables by Victor Hugo
         */
        URL link = new URL("http://www.gutenberg.org/files/135/135-0.txt");

        /*
        Create two input streams for this book. The first stream will be mapped into a
        HashSet object; the second into an instance of OurTree.
         */
        InputStream stream1 = link.openStream();
        InputStream stream2 = link.openStream();

        /*
        Map these streams into two separate scanner objects.
         */
        Scanner s1 = new Scanner(stream1);
        Scanner s2 = new Scanner(stream2);

        /*
        Set up two data structures: a set, based on HashSet, and a tree based on OurTree
         */
        Set<String> wordSet = new HashSet<>();
        OurTree wordTree = new OurTree();

        /*
        Load the contents of the book, word-by-word into the set object, using
        the first scanner object.
         */
        while (s1.hasNext()) {
            word = s1.next();
            wordSet.add(word);
        }

        /*
        Load the contents of the book, word-by-word into the tree object, using
        the second scanner object.
         */
        while (s2.hasNext()) {
            word = s2.next();
            wordTree.addNode(word);
        }
    }
}
