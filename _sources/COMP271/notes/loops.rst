:orphan:

Loops
------

When to use the for-loop and when *not* to use it?


This is bad
===========

Often, we are tempted to use the ``break`` statement to exit a loop before it runs its full cycle. For example, the code snippet below finds if an array contains some value. The idea is to stop the search as soon as we find a match or when we reach the end of the array; whichever happens first.

.. code-block:: java

   for (int i = 0; i < someArray.length; i++) {
     if (someArray[i].equals(whatEver)) {
       someBoolean = true;
       break;
     }
   }
   

The moment we find a match, we issue a ``break`` statement to stop the loop. It works but it's poor coding. And sometimes we run into an obsessed instructor or manager who doesn't want us to use the ``break`` statement.


This is bad too
================

To placate the obsessed instructor (or manager) we may try the following trick.

.. code-block:: java

   for (int i = 0; i < someArray.length; i++) {
     if (someArray[i].equals(whatEver)) {
       someBoolean = true;
       i = someArray.length; // Really? :-)
     }
   }

See, no ``break``! Well, this is worst!  It *is* a break statement, masquerading as an assignment for the loop variable. It assings a value that will terminate the loop. Again, it works but this is poor coding. (Maybe it was *state of the art* programming, back in my day, in languages that only supported the for-loops and did not have while-loops; FORTRAN77 for example.).


What's the alternative?
=======================

There is a simple rule: if we know beforehand how many times a loop repeats, we use the for loop. If the number of repetitions varies, it's best to use a while loop. The example above can be implemented nicely with a while loop.

.. code-block:: java

   int i = 0;
   boolean someBoolean = false;
   while (!someBoolean && i < someArray.length) {  // Notice the !
     someBoolean = someArray[i].equals(whatEver);
     i++;
   }

And here's another rule: if a for-loop needs to end prematurely, convert it to a while-loop.
