:orphan:

Six weeks of Data Structures
------------------------------

In the first six weeks of the course, we covered the following topics.

Palindromes
===========

The course started with writing `methods to determine if a string is a palindrome <https://github.com/lgreco/DataStructures/blob/master/ClassroomCoding/ThePalindromeSaga/src/StringUtilities.java>`__. This was a refresher of basic programming techniques including class `String and some of its methods <https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html>`__. We looked at code efficiency asking ourselves if we really need a *for-loop* or are we better off with a *while-loop*. 


Breaking and mending arrays
===========================

We put our palindrome method to test, scanning an actual book, and storing its palindromes to a String array. `Project Gutenberg <https://www.gutenberg.org/>`__ offers a great variety of books to use. We implemented a `Scanner` object to access the plain text of a book, via a web datastream (employing instances of classes ``URL`` and ``InputStream`` along the way), writing ``try``/``catch`` blocks to prevent embarrassing program failures. Soon we run into a major issue with arrays: we cannot resize them, and if we run out of space, bad things happen. And so we set off to design our own array storage mechanism, that changes its size on demand. The mechanisms we developed for `our Enchanted Arrays <https://github.com/lgreco/DataStructures/blob/master/TodaysLab/src/EnchantedArray.java>`__ are simpler but accurate representations of how Java's `ArrayList class <https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html>`__ works.


Binary search trees
===================

Enchanted Arrays and ArrayLists are fine, but we run into another problem now that we have a size-on-demand storage mechanism: duplicates. We want every palindrome found in a book to be stored only once. And also we want to have them sorted alphabetically. Certainly we can write additional methods in our ``EnchantedArrary`` class to add only unique data; for example a method ``addUnique(String palindrome)``. And another method to sort the palindromes alphabetically. Together, these two tasks may take some time to complete. Maybe resizeable arrays are not the right data structure for this problem. And so we turned our attention to the *binary search tree,* the computational equivalent of how we record and search for information in a printed dictionary or phone book.

Here we discovered something *major:* `cooperating classes <https://github.com/lgreco/DataStructures/tree/master/Assignments/TreesAndNodes>`__. A binary search tree comprises two classes: ``Node`` and ``Tree``. A Tree object is built on a single Node object; we name that Node ``root``. This root branches out to other nodes within the Tree object. A tree may have thousands of nodes branching out from its root and yet it still have only one field: that root. Pretty wild, huh?

Interfaces and Inheritance
===========================

Right after trees, it was a good time to take a different direction and talk about `interfaces <https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html>`__ and `inheritance <https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html>`__. We discussed how the interface is a contract for the methods a class will have and what they'll do. The ``String`` class, for example, implements the ``Comparable`` interface. The class promises (and delivers) a method to compares its objects. The comparison is described by an integer number that the method returns. The method's name is specified in the interface; in this case it is the ``compareTo`` method. We even implemented the ``Comparable`` interface on a `class that we wrote <https://github.com/lgreco/DataStructures/blob/master/LabSessions/The%20CTA/src/CTALocation.java>`__ for the next topic in our adventure.

The CTA project
===============

The `CTA project <https://github.com/lgreco/DataStructures/tree/master/LabSessions/The%20CTA/src>`__ is the most ambitious adventure we had in the course so far. The project focuses on sequential data structures and introduces the concepts of *linked lists.* Prior to exploring linked lists however, we use the premises of this project to build our own inherited classes (``CTAStation`` and ``CTAStop`` are extensions of ``CTALocation``), implement the ``Comparable`` interface, and extract actual data from the Chicago Data Portal, tranform them, and load them into ``CTAStation`` objects held together in an ArrayList or even a humble array.