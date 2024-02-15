:orphan:

On multiple returns
=========================

The ``return`` statement serves two purposes. First it passes data to the outside of a method. And second, it stops executing that method and returns control to the part of the program that called the method.

Methods in Java (and in most languages, for that matter) have a single point of entry. Let's write  a method to return the largest of two integers.

.. code-block:: java

   public static int largestOf(int a, int b) { 
     // ... magnificent code will be added here ...
   }
   
We started by declaring the method name (``largestOf``) and by listing two parameters. This declaration is the method's single point of entry. Data enter the method as values for its two parameters when the method is called, e.g.

.. code-block:: java

   int x = largestOf(10, 20);
   
If methods have a single point of entry, shouldn't they also have a single point of exit? This question stirs as much controversy as the placement of pineapple on pizza!

It all started in August 1969, when Edsger W. Dijkstra published one of   
the most influential technical notes on programming. In his `Notes on Structured Programming <https://www.cs.utexas.edu/users/EWD/ewd02xx/EWD249.PDF>`__, Dijkstra introduced the requirement of single-entry, single-exit for program modules -- today, we call these modules *methods* in Java and *functions* in Python. 

Many programers take this requirement literally, writing methods that have one and only one return statement. I strive to write methods with a single return statement, recognizing that in some cases I may need two and, rarely, more. 

Earlier, above, we started writing a method called ``largestOf``, so let's see a couple of ways we can build it. First let's write it with two ``return`` statements.

.. code-block:: java

   public static int largestOf(int a, int b) { 
     if (a > b)
       return a;
     else
       return b;
   }

In my opinion, there is no need for both ``return`` statements above. The method can be written with a single return:

.. code-block:: java

   public static int largestOf(int a, int b) { 
     int largest = a;
     if (b > a)
       largest = b;
     return largest;
   }
   
   
And even more compactly, we can write

.. code-block:: java

   public static int largestOf(int a, int b) { 
     return (a > b) ? a : b;
   }

Is there a technique for single returns?
----------------------------------------------

As I mentioned earlier, I strive to write methods with just one return statements, every time that I can justify the effort and the need. My technique is simple. Before I write any other code, I create a return variable and I return it. Usually I call that variable ``result`` and often I rename it to something more appropriate when I am done. For example,

.. code-block:: java
   :emphasize-lines: 3
   
   public static int largestOf(int a, int b) { 
     int result;     // The int that the method will return.
                     // Placeholder for code that assigns value to result.
     return result;  // The return statement.
   }

Then all I have to do is to figure out the code that goes between the declaration of ``result`` and its return, without writing another ``return`` statement. In this case:

.. code-block:: java
   :emphasize-lines: 3-5
   
   public static int largestOf(int a, int b) { 
     int result;     // The int that the method will return.
     result = a;     // Assume a is the largest number.
     if (b > a)      // Validate the assumption and ...
       result = b;   // ... correct if assumption was wrong.
     return result;  // result now is correct and we return it.
   }

When are multiple returns acceptable?
----------------------------------------

To ask when is something acceptable is to imply that sometimes it is not acceptable. There is no universal rule stating that multiple returns are unacceptable. Also, there is no universal rule prohibiting ketchup on pasta, or pineapple on pizza, or fish sticks and custard.

Personal (and questionable) taste aside, there are times when the use of multiple returns can be justified in a convincing manner. Consider the following method.

.. code-block:: java
   :linenos:

   /**
    * Returns the season of the year for a given month number
    * @param month int value of month, 1-12
    * @return String with corresponding season
    */
   public static String season(int month) {
     String result;
     if (month > 2 && month < 6)
       result = "Spring";
     else if (month > 5 && month < 9)
       result = "Summer";
     else if (month > 8 && month < 12)
       result = "Autumn";
     else if (month == 12 || month == 1 || month == 2)
       result = "Winter";
     else
       result = "Invalid data";
     return result;
   }  // method season

It looks reasonable -- not a masterpiece, but adequate -- and as long as we feed it with the *correct* input, it will provide the correct season. And yet, the presence of lines 16 and 17 shows that we don't always expect proper values to to passed to the method. That's when a second return statement makes sense, as shown below.

.. code-block:: java
   :linenos:
   
   public static String season(int month) {
     if (month < 1 || month > 12)
       return "Invalid data";
     String result;
     if (month > 2 && month < 6)
       result = "Spring";
     else if (month > 5 && month < 9)
       result = "Summer";
     else if (month > 8 && month < 12)
       result = "Autumn";
     else
       result = "Winter";
     return result;
   }  // method season

The first ``return`` above, in line 3, protects the rest of the method from invalid data. If the program continues past line 3, we can be certain that :math:`1\leq\texttt{month}\leq 12`. Because of this guarantee, we can simplify the rest of the if-statements to default to winter, when a month is not in spring, summer, or autumn.

For the price of an extra return statement, we protect the method from invalid data **and** we simplify the logic to process valid data.

Like everything else in computing, lines 2 and 3 above have a special name: *guard statement*.

If you are committed to writing single returns, there is a way to protect the method with just one return statement. This is shown below.

.. code-block:: java
   :linenos:
   
   public static String season(int month) {
     String result = "Invalid data";
     if (month >= 1 && month <= 12) {
       if (month > 2 && month < 6)
         result = "Spring";
       else if (month > 5 && month < 9)
         result = "Summer";
       else if (month > 8 && month < 12)
         result = "Autumn";
       else
         result = "Winter";
     }
     return result;
   }  // method season

This version begins pessimistically: it assumes that the data passed to it are invalid. Then, in line 3, it checks the value of ``month``. If it is within the acceptable range, then it allows us to change the value of ``result`` to a specific season. The price we pay here is the nested if-statements. They may reduce the readability of the code.  Personally, I believe that we can compensate for the loss of readability, with some well written and placed comments.