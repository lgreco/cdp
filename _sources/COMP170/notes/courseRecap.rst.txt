:orphan:

Course Recap
=============

Here's a list of things that I wish everyone could remember from an introductory programming course.

The 80/20 rule in programming
-----------------------------

Spend 80% of your time analyzing the problem you need to solve, then 20% coding the solution. 

Document your analysis
----------------------

Use comments in the program to describe the analysis that led to the solution you are implementing.

Remember a few useful techniques
--------------------------------

The following are a few simple programming techniques that are worth memorizing.

Swap values of two variables
............................

To swap the values of two variables ``a`` and ``b``, we need to introduce a third, temporary variable.

.. code-block:: java

  temporary = a
  a = b
  b = temporary

Sequential traversal with option to stop early
..............................................

This technique allows us to search for something in a sequential fashion. Consider an array with names, e.g., ``String[] names``, in which we wish to find if the name ``"Java"`` is present. A naive search may look like this:

.. code-block:: java

  boolean found = false;
  for (int i = 0; i < names.length; i++) 
    if (names[i].equals("Java"))
      found = true;

Let's say that the name ``"Java"`` happens to be the first element of the array. We won't know if the the name is present in the array until the loop above ends. Do we really need to wait for the loop to process every element of the array *after* it finds what we are looking for? How about the more efficient approach below?

.. code-block:: java

  boolean found = false;
  int i = 0;
  while (!found && i < names.length) {
    found = names[i].equals("Java");
    i++;
  }

The ``while`` loop above stops when a match is found or when it reaches the end of the array. Because the loop stops as soon as it finds a match, it is a bit faster than a ``for`` loop as long as a match is found and it's not in the last element of the array.