import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextProcessingOLL {
    public static void main(String[] args) throws IOException, URISyntaxException {
        OurLinkedList wordsList = new OurLinkedList();
        String word = new String();
        URL link = new URL("http://www.gutenberg.org/files/1952/1952-0.txt");
        InputStream website = link.openStream();
        Scanner s = new Scanner(website);
        int counter = 0;
        while (s.hasNext()) {
            word = s.next();
            counter++;
            word = word.toLowerCase();
            wordsList.addNode(word);
        }
        System.out.println("The novel has "+ counter + " words!");
        System.out.println("There are " + wordsList.getSize() + " unique words.");
        System.out.println();
    }
}
