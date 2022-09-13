:orphan:

Loops
---------------------------------------------------


This is bad
===========

Often, we are tempted to use the `break` statement to exit a loop before it runs its full cycle. 

.. code-block:: java

   for (int i = 0; i < someArray.length; i++) {
     if (someArray[i].equals(whatEver)) {
       someBoolean = true;
       break;
     }
   }
   
Sometimes we run into an obsessed instructor or manager who doesn't want us to use the `break` statement.


This is bad too
================

And then we try this. Which is still a "break" statement, only hiding in an assignment for the loop variable.

.. code-block:: java

   for (int i = 0; i < someArray.length; i++) {
     if (someArray[i].equals(whatEver)) {
       someBoolean = true;
       i = someArray.length;
     }
   }


What's the alternative
======================

There is a simple rule: if we know beforehand how many times a loop repeats, we use the for loop. If the number of repetitions varies, it's best to use a while loop. The example above can be implemented nicely with a while loop.

.. code-block:: java

   int i = 0;
   boolean someBoolean = false;
   while (!someBoolean && i < someArray.length) {
     someBoolean = someArray[i].equals(whatEver);
     i++;
   }

And here's another rule: if a for-loop needs to end prematurely, convert it to a while-loop.
