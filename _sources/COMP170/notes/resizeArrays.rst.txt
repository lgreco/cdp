:orphan:

Resizing an array
==============================

Arrays in Java are a very useful tool. They allow us to organize and access related data in an efficient manner. But they have one limitation: once we declare a size for them, it cannot change. In some cases, the size of an array can be predictable and stable: for example the number of letters in the Greek alphabet:

.. code-block:: java

   char[] greekLetters = new char[24];
   
It is unlikely to see this number changing over the lifetime of an application that uses the array. What about the following code:

.. code-block:: java 

   String[] usStates = new String[50];
   usStates[0] = "Delaware"; // First state admitted to the union in 12/7/1787
   //...
   usStates[49] = "Hawaii"; // Last state admitted to the union in 8/21/1959
   
Would you bet your professional reputation, as a programmer, that the number of states in the US will remain 50? What if the District of Columbia gains the statehood it has been vying for? What if Puerto Rico becomes a state?

It would be nice if we can resize arrays on demand. Got a 51st state? No problem!

Practically, there is no need for resizing arrays. Because Java provides a more flexible data structure called ``ArrayList`` that grows (or shrinks) as needed. Nevertheless, it is a **good programming exercise** to design a technique for resizing arrays.

Let's consider a method that accepts a String array and returns another string array with twice the size of the first.

.. code-block:: java

   public static String[] resize(String[] inputArray) {
     return new String[2*inputArray.length];
   }

The code above does the trick, but it could do more. For example, it could return an array twice the size of the input array and with the elements of the input array in the output one.

.. code-block:: java

   public static String[] resize(String[] inputArray) {
     String[] outputArray = new String[2*inputArray.length];
     for (int i = 0; i < inputArray.length; i++)
       outputArray[i] = inputArray[i];
     return outputArray;
   }

Using the method above, we can easily change the size of an existing array and preserve its contents; for example:

.. code-block:: java

   usStates = resize(usStates);  // Now we have room for 50 more states
   usStates[50] = "District of Columbia";  // Start adding new ones!


The simplicity of method ``resize`` above is at the heart of more sophisticated tools like ``ArrayList`` mentioned earlier. The difference between our humble implementation and ``ArrayList`` is the software engineering that makes ``ArrayList`` work with just about any kind of data, not just Strings. Fundamentally, it's the same principle: take a fixed-size collection, create a temporary one with more room, copy the old stuff into the new one, and replace the old one with the new one.