:orphan:

Throw or Catch?
================

A method that employs a ``Scanner`` to process a ``File`` item often requires an exception in its header. For example, method ``scanFile`` below accepts a string as input and returns a Scanner connected to a file with the name provided in the string:

.. code-block:: java

   public static Scanner scanFile(String fileName) throws FileNotFoundException {
     return new Scanner(new File(fileName));
   }

If the file doesn't exist or if users made an error typing the file name, the ``File`` connection cannot be established. The method will throw a fit (in Java, fits are called *exceptions*) and the program will end abruptly (in other words, the program with crash). There are many reasons that a file may not be where we expect it. And most of these reasons can be anticipated, which means that we can prevent the exception (and the subsequent program crash).

I am not a big fan of predictable and preventable crashes. We know that things can go wrong with files. Maybe users will type the wrong name. Maybe the file is located on a flash drive that is not plugged into the computer. Maybe the file is on cloud storage like Google Drive, and the computer is temporarily disconnected from the internet.

If we can predict an exception, we can prevent it. And by preventing it, we allow our program to end gracefully. That's when it is preferable to use a ``try/catch`` block than to throw a fit, sorry, an exception.

Let's rewrite method ``scanFile`` in a gentler manner:

.. code-block:: java
   :linenos:
   
   public static Scanner scanFile(String fileName) {
     scanner sc;
     try { 
       sc = new File(fileName);
     } catch (Exception e) {
       sc = null;
     }
     return sc;
   }

The method above returns either a *good* scanner or a *null* reference, but doesn't crash. What we do with the returned item is up to us. For example, we may have code somewhere else working as follows:

.. code-block:: java

   // Attempt to read a file
   Scanner myData = scanFile("precious_data.txt");
   if (myData == null) {
     System.out.println("Sorry, I cannot connect to the file");
   } else {
     // do something with myData ...
   }


Some may argue that the approach above simply postpones a program crash. Maybe so. At least, if our program crashes, it will be from an unanticipated cause. Which, once analyzed, can also be avoided.

