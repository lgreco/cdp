:orphan:

Single Variable Returns
=========================


In Java, a method with a return type can return *only one variable.* The variable itself may represent a single value or multiple values. Arrays are good at representing multiple values as a single variable.


.. figure:: images/singleVariableReturn.jpg
   :width: 400
   :align: center
   

| 


New programmers are often tempted to return multiple values of *same type* using an array. For example, consider the following code that counts the lines, words, and characters of a file represented by a ``Scanner`` object.

.. code-block:: java
   :linenos:
   
   public static int[] countLinesWordsCharacters(Scanner fileScan) {
     final int LINES = 0;  // Array position with line counter
     final int WORDS = 1;  // Array position with word counter
     final int CHARS = 2;  // Array position with char counter
     int[] counts = new int[3];  // Array with counts; to be returned
     while (fileScan.hasNextLine()) {  // Scan file, line by line
       counts[LINES]++;  // Update line count
       String line = fileScan.nextLine();  // Bring line to a string
       String[] words = line.split(" ");  // Break line into words
       counts[WORDS] += words.length;  // Update word count with words in this line
       for (String word : words) {  // Go over each word in this line
         counts[CHARS] += word.length();  // Update character count with length of this string
       }
     }  // Done scanning the file
     return counts;
   }  // Inline comments not recommended; used here to keep code compact


What if we wanted the method above to return the average value of words per line? We can increase the array size to 4 elements from 3, and then try to store the new information. An average value would neet to be a double:

.. code-block:: java
   
   double wordsPerLine = (double) counts[WORDS] / (double) counts[LINES];

The only way to fit a double value into an integer array is to cast it as ``(int)``. But we may lose precision. For example an average of 6.785 words per line will become 6 words per line.

Arrays may be useful vehicles to return multiple values, but not always. Even in the case when the values are of the same time, we need to be careful when using arrays. In the example above, we must communicate to users the order in which the values appear in the array. For various reasons, this is not a good idea.

And if arrays are not a good idea to return multiple values through a single variable, what else can we do? We can design a "container" of our own, to hold the multiple values. Such container has a special name: **object.** 

In Java, an object is a class that comprises non-static variables and non-static methods. An object class may also have static parts, but that's a different topic. For now, let's focus on a very simple object that contains four very useful variables for our file counting needs. 

.. code-block:: java
   :linenos:
   
   public class FileCounts {
     int numberOfLines;
     int numberOfWords;
     int numberOfCharacters;
     double wordsPerLine;
   }

With this object of our own creation, we can rewrite the method that scans a file and returns multiple numeric values about it. These multiple values will be assigned to the variables of the object. And the method will return one variable: a ``FileCounts`` object.

.. code-block:: java
   :linenos:
   
   public static FileCounts countLinesWordsCharacters(Scanner fileScan) {
     FileCounts counts = new FileCounts();  // Object with counts; to be returned
     while (fileScan.hasNextLine()) {  // Scan file, line by line
       counts.numberOfLines++;  // Update object's line count
       String line = fileScan.nextLine();  // Bring line to a string
       String[] words = line.split(" ");  // Break line into words
       counts.numberOfWords += words.length;  // Update object's word count 
       for (String word : words) {  // Go over each word in this line
         counts.numberOfLines += word.length();  // Update object's character count
       }
       // Compute average words per line and assign it to the dedicated object variable
       counts.wordsPerLine = (double) counts.numberOfWords / (double) counts.numberOfLines;
     }  // Done scanning the file
     return counts;
   }   // Inline comments not recommended; used here to keep code compact

If we attempt to print the variable returned by  method ``countLinesWordsCharacters``, we will be disappointed. All we'll get is something like ``FileCounts@133314b``. The printout includes the class name of the object and its memory location (in this example ``133314b``). Obviously we need something more useful. And so we have to modify the ``FileCounts`` object and provide it with instructions how to represent itself as a string.



.. code-block:: java
   :linenos:
   
   public class FileCounts {
     int numberOfLines;
     int numberOfWords;
     int numberOfCharacters;
     double wordsPerLine;
       
     public String toString() {
       return String.format("%d lines, %d words, %d characters, %.2f words per line.",
                            numberOfLines, numberOfWords, numberOfCharacters,
                            wordsPerLine);
     }
   }

The addition of method ``toString()`` provides the object ``FileCounts`` with a way to behave as String when needed - for example, when called from a ``print`` statement. To be clear: the object behaved as a String before, when called to be printed. Its behavior, however, was not very useful because all it gave us was something like ``FileCounts@133314b``. With the addition of the ``toString()`` method, we determine a more useful way to behave as a string.









