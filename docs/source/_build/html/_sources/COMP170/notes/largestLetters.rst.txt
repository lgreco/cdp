:orphan:

Largest letters
==============================

This is a design example we worked in class on 3/28. The specification is to write a program that asks users to type letters (one letter at a time). When the user types a number instead of a letter, the program reports the two *largest* letters typed by the user thus far, and stops. Size is defined by the position of the letter in the alphabet. We assume that only lower case letters are entered. Smallest letter is ``'a'`` and largest letter  is  ``'z'``.  The code must have at least two methods (including ``main``). We can assume that the first two items entered by the user will be letters.

The overall structure for our pseudocode is as follows.

.. code-block:: python

   initialize data
   
   while (character entered not a number)
      if letter just entered greater than either of the two largest letters so far, then:
	     replace smallest of two largest letters with letter just entered
      input a new character

   print the two largest letters
   
The pseudocode above is very broad. Let's consider some details: for example, how do we initialize data? For that matter, what are the initial data we need? How can we replace the smallest of two letters? How can we tell if a character is not a number, etc? Let's look at these questions, one at a time.

Initializing data
-----------------

What data are we tracking in this program? At the very least, the two letters we print at the end. And because we need to compare both letters with a newly entered character, we need a third variable as well. Additionally, we'll need a ``Scanner`` to accept the keyboard inputs. To complete the initialization, we need to obtain the first values for the required variables.

.. code-block:: java

   // initialize data
   Scanner sc = new Scanner("System.in");
   char largest, nextLargest, entered;
   // Obtain the first values for the required variables
   largest = sc.next().charAt(0);
   nextLargest = sc.next().charAt(0);
   entered = sc.next().charAt(0);

The use of ``next().charAt(0)`` is a substitute for ``Scanner``'s lack of a method to read ``char`` data. Instead we read a String through ``next()`` and we take the first character (``charAt(0)``) from that string.

Loop condition
-------------------

The loop runs while the the character entered is not a number. So we need a condition for that. 

.. code-block:: java

   while (entered < '0' || entered > '9')
  
We can make this condition a bit more tight. We can let the loop run only when the entered character is a lower case letter:

.. code-block:: java

   while (entered >= 'a' && entered <= 'z')

Thus the loop will end when we type a non-letter character: a number, for example.

Loop contents
-------------

The variables ``largest`` and ``nextLargest`` imply a relative order. We rely on this order when, inside the loop, we need to replace the smallest of two largest letters with the letter just entered. Therefore, at the beginning of the loop we must ensure that ``largest`` is indeed greater than ``nextLargest``; otherwise swap them.

.. code-block:: java

   // Ensure that largest > nextLargest ... if not, swap them
   if (nextLargest > largest) {
     char temporary = largest;
     largest = nextLargest;
     nextLargest = temporary;
   }
   // Now we can guarantee largest > nextLargest

Next, according to the earlier pseudocode, we should check if the letter just entered is greater than either of the two largest letters. And for that, we may think that the condition

.. code-block:: java

   entered > Math.max(largest, nextLargest))

would suffice. It does not. We guarantee that ``largest > nextLargest`` always. And so the ``max`` function above will always return ``largest``. The condition is essentially the same as

.. code-block:: java

   entered > largest

What if ``entered < largest`` and ``entered > nextLargest``? For example, if

.. code-block:: java

   largest = 'z'
   nextLargest = 'd';

and then we type the letter ``'f'`` as the next entered? The condition

.. code-block:: java

   entered > Math.max(largest, nextLargest)   
   
   
will evaluate to ``false``. And yet, in the example above, the new value (``'f'``) needs to replace ``'d'`` as one of the two largest letters. 

The condition we really need is

.. code-block:: java

   entered > nextLargest

This condition tells us if the entered letter is greater than the lesser of the two largest letter. If it is, the entered letter takes the place of the lesser of the two largest letters. Now, we can implement the last pseudocode statement:
 
.. code-block:: java

   // if letter just entered > than either of the two largest letters so far, then:
   // replace smallest of two largest letters with letter just entered
   if (entered > nextLargest)
     nextLargest = entered;

Every time we change a value in the pair of the two largest letters, we need to ensure that ``largest > nextLargest``. That's because the value we change is always the ``nextLargest``. For example, if

::

   nextLargest : f
   largest     : g
   entered     : h

we see that `` h > f `` and therefore we replace the contents of ``nextLargest`` with ``h``. Now we have:

::

   nextLargest : h
   largest     : g
   
The implied order ``largest > nextLargest`` is not longer present, and it must be restored. That's why we always check for this order at the beginning of the while loo.

Finally, we can put the code together in a method.

.. code-block:: java

   public static void findTwoLargestLetters() {
     // Set up a scanner
     Scanner sc = new Scanner(System.in);
     // Set up two variables to track the two largest letters and obtain initial values
     char largest = sc.next().charAt(0);
     char nextLargest = sc.next().charAt(0);
     // set up a variable for the recurring entries and obtain initial value
     char entered = sc.next().charAt(0);
     // Run a loop as long as entered is a lower case letter
     while (entered >= 'a' && entered <= 'z') {
       // Make sure that largest is always > nextLargest
       if (nextLargest > largest) {
         // Otherwise, swap them
         char temporary = largest;
         largest = nextLargest;
         nextLargest = temporary;
       }
       // Is newly entered letter greater than either of large letters?
       if (entered > nextLargest) {
         // replace smallest of the two largest letters with newly entered one
         nextLargest = entered;
       }
       // Get a new character and try again
       entered = sc.next().charAt(0);
     }
     // After loop ends, print the two largest letters
     System.out.printf("The two largest letters are %s and %s", largest, nextLargest);
   }
