:orphan:

** DRAFT ** NOT READY YET **

Binary Search
================

How did we end up talking about *binary search?* We started with a simple question: what are the chances that a few random letters put together can form an actual word? Here's a simple strategy to answer this question.

.. code-block:: java
  
   form a random word
   look up that word in a dictionary
   
The first part of the strategy is straight forward. It requires a method that returns a string with a given number of letters, chosen at random. In the code below ``ASCII_a`` and ``ALPHABET`` are integer constants with values 97 and 26 respectively. Constant ``ASCII_a`` points to the lower case ``char 'a'``. And ``ALPHABET`` is the number of letters in the English alphabet.

.. code-block:: java

    static String randomWord(int howManyLetters) {
        // Initialize string to return
        String word = "";
        // Setup random number generator
        Random rng = new Random();
        // Repeat for as many letters as required
        for (int letter = 0; letter < howManyLetters; letter++) {
            // select a letter a-z at random
            char randomCharacter =  (char) (ASCII_a + rng.nextInt(ALPHABET));
            // add it to string
            word += randomCharacter;
        }
        return word;
    }

The challenge now is to check if randomly formed strings like ``"ajopw"``, ``"uyvgq"``, ``"hello"`` etc, are actual words.

Let's assume that we have a file with all the English words. We can tell if a given string is an actual word, based on the following pseudocode.

  ::
  
   while not at end-of-file:
     if wordReadFromFile == givenRandomString
       return true
   return false

The pseudocode above, can be implemented in Java, line-for-line:

.. code-block:: java

   while (file.hasNextLine()) 
     if (file.nextLine().equals(givenRandomString)) 
       return true;
   return false;

The code snippet above assumes that ``file`` is a properly declared and initialized ``Scanner`` object. This object connects to a file with all english words, accessible from the computer's filesystem.

Sometimes, often actually, the data we need are available online and they are not immediately accessible through our computer's filesystem. In this case we have two choices: copy the file to our computer (if we have permission to do so and also space to store it) or access its contents over a computer network (again, if we have permission to do so). The Internet is a readily available network for most of us. And Java, like most programming languages, has a mechanism to access remote files that are available on the Web.

Let's consider a file at the following location:

https://raw.githubusercontent.com/lgreco/IntroProgramming/main/data/words.txt

If we don't want a copy of the file on our computer, we can write a program to scan it remotely. All we need is to tell ``Scanner`` where to find the file on the web:

.. code-block:: java

   URL url = new URL("https://raw.githubusercontent.com/lgreco/IntroProgramming/main/data/words.txt");
   Scanner file = new Scanner(new InputStreamReader(url.openStream()));

The code snippet aove creates a ``Scanner`` object that connects to an ``InputStreamReader``. This reader is a conduit, over the internet, between our computer and the website with the file we wish to process. That website is identified by a ``URL`` object.

Working with files is fun, but ...
-----------------------------------

Files are, usually, slow to access. Specifically, they are slower compared to computer memory. *Ideally,* we want to read them once (maaaaybe twice) and bring their data into the computer memory (if there is room). The easiest (and often best) memory container we have at our disposal is, of course, the humble array.

How can we bring data from a file into an array? First, by making our life easier: let's assume that each line in the file contains a single piece of data. Which is the case for the file with the english words. 

How can we bring the data from the file into an array? Here, we hit a snag. Before adding data to an array, we must declare and initialize it. For that, we need to know how many elements the array will store. And so it is necessary to know how much data are stored in the file that we want to move to the array. The surrest way is to go through the file, count the data, use that number of initialize the array, and then move the data from the file to the array, i.e.:

  ::
   
   N <--- count of data in the file 
   ourArray[] <--- new array[N]
   for i = 0 to N
     ourArray[i] <--- data from file
     move to next line in the file
     

The pseudocode above suggests that we scan the file twice. First to count its data and then to move that data, one line at a time, to the array. The alternative is to anticipate the number of data we want to store, add a safety margin, and hope that we are correct. For example, we can guess that we need room for 50,000 elements in the array, double it to 100,000 to be safe, and try it. Worst case scenario, we'll run into an *out of bounds* exception. Personally, I'd rather scan the file twice: once to count the data and make a precise declaration for the array, and once more to move the data from the file to the array.

The method to count the number of lines in a file is based on the following code:

.. code-block:: java

 // assume file is a properly assigned scanner object
 int counter = 0;
 while (file.hasNextLine()) {
   String s = file.nextLine();
   counter++;
 }
 return counter;

And the method to bring the data to an array is based on the following code

.. code-block:: java

 // assume N is the number of lines in the file, obtained by previous method
 String data[] = new String[N];
 // assume file is a properly assigned scanner object
 for (int i=0; i < N; i++) 
   data[i] = file.nextLine();
 return data;

Working with sorted data
---------------------------



