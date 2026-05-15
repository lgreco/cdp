:orphan:

.. |check|   unicode:: U+1f539
.. |read|   unicode:: U+1F4D6
 


Checklist before starting the course
------------------------------------

This checklist comprises four sections: *Do, Know, Demonstrate,* and *Read.* It is important that you work through this checklist before the first class meeting.


Do
++

* Review the `course policies and expectations <https://lgreco.github.io/cdp/COMP271/introduction.html>`__.

* Install IntelliJ on your computer. If you still have access to your virtual machine from COMP 170 you can use that. At this course level, however, it is a good idea to have your own installation of IntelliJ. With your LUC email address you can `apply and obtain a license for the high-end version of IntelliJ <https://www.jetbrains.com/shop/eform/students>`__. If you need a virtual machine for the course, please let me know.


* Write three items you found most challenging in COMP 170 (or equivalent introductory course you took to make it to COMP 271). These should be specific items (e..g., "It took me a while to understand constructors"). You will be asked to share these items with the rest of the class, during the first meeting.

* Write two items you found intuitive in COMP 170 (or any other introductory course you took to make it to COMP 271). These should be specific items (e..g., "Strings are awesome"). You will be asked to share these items with the rest of the class, during the first meeting.

* `Bookmark this site <https://lgreco.github.io/cdp/COMP271/introduction.html>`__.

* Bookmark and review `Google's code style guide for Java <https://google.github.io/styleguide/javaguide.html>`__.

* Bookmark and review (but don't expect to grasp everything right away) the `Collections Framework Overview <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>`__ from Oracle's Java Documentation.

* Download, install, and configure Microsoft Teams on your computer (if it is not already installed). Use your LUC UVID to log in to Teams. `Contacting me through Teams <https://teams.microsoft.com/l/chat/0/0?users=lirakliotis@luc.edu>`__ may be faster than email. 

* Optionally, `sign up for a GitHub account <https://github.com/>`__. It's free and it's cool. You can sign up for GitHub with your personal email address, i.e., an address you expect to use even after you graduate from LUC. Once you establish your GitHub account, you can always receive the student benefits the site offers, by adding your LUC email address to the account.


Know
++++

* How to `change the working directory for the Run/Debug Configuration <https://intellij-support.jetbrains.com/hc/en-us/community/posts/360008228879-Change-current-working-directory>`__, in IntelliJ.

* How to access your computer's command line (the Terminal app in Apple, the Command app in Windows).

* How to use Microsoft Teams with your LUC UVID.

* Learn something new, before the course starts. Can you `figure out how to use ENUMerations <https://blogs.oracle.com/javamagazine/java-quiz-enums-initialization>`__, for example?


Demonstrate
+++++++++++

Understanding basic elements of the language
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

|check| What is scope? Can you explain why the following code is wrong?
 
 .. code-block:: java
 
    int a = 5;
    int b = 6;
    if (a>b) {
      String s = "a";
    } else {
      String s = "b";
    }
    System.out.println(s);
    
    
|check| Do you know how to use the printf method? (You can review the `Java Documentation tutorial <https://docs.oracle.com/javase/tutorial/java/data/numberformat.html>`__).

|check| Can you write a method that returns true is a string is composed only of letters? E.g., ``hasLetters("COMP170")`` will return ``false`` but ``hasLetters("polymorphism")`` shall return ``true``.

Understanding of loops
,,,,,,,,,,,,,,,,,,,,,,

|read| Reading material on the Java Documentation site: `The while and do-while Statements <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html>`__ and `The for Statement <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html>`__

|check| Can you write a method that returns a given string in reverse? Using the for-loop? Using the while-loop?
 
|check| Can you write a method that prints multiples of a given number, over a range of numbers? For example, ``printMultiples(5,20,50);`` prints all multiples of 5 from 20 to 50.
 
Understanding of arrays
,,,,,,,,,,,,,,,,,,,,,,,

|read| Reading material on the Java Documentation site: `Arrays  <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html>`__


|check| Can you write a method that swaps two elements of an int array? 
 
|check| Can you write a method to copy one String array into another?
 
Understanding of Conditional Execution
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

|read| Reading material on the Java Documentation site: `If-then statements <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html>`__, and `switch statement <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html>`__

|check| Do you know how to use the `ternary operator <https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html>`__? (This may not have been covered in COMP 170 but it's quite useful and straightforward to explore).
 
|check| Can you explain the difference between
 
 .. code-block:: java
 
    if (a>10) {
      // Code block A
    } else {
      // Code block B
    }
    
 and
 
 .. code-block:: java
 
    if (a>10) {
      // Code block C
    } else if (a<10) {
      // Code block D
    }
    
Read
+++++

In addition to the reading material referenced above, read as much of the following as you can.

* From time-to-time browse Oracle's `Java Magazine <https://blogs.oracle.com/javamagazine/>`__.

* Ilya Suzdalnitski's *spirited* `article about the shortcomings of OOP <https://betterprogramming.pub/object-oriented-programming-the-trillion-dollar-disaster-92a4b666c7c7>`__. The article is harsh on Java and OOP in general; however it presents some good ideas about resilient programming frameworks. It is a well-written opinion. Part of the article's polemic is based on an *originalist's* interpretation of what OOP means. Suzdalnitski  goes back to Alan Kay's definition of OOP and concludes that based on *that* definition, OOP has failed. Maybe. At the same time, OOP is one of the best programming paradigms available to us. And with all its shortcomings -- many of which are described in Suzdalnitski's article -- OOP has solved more problems than it has created.

* In 1971, `Niklaus Wirth <https://en.wikipedia.org/wiki/Niklaus_Wirth>`__ published his influential paper about `Program development by stepwise refinement <https://github.com/lgreco/cdp/blob/master/source/COMP271/notes/stepwiseRefinement.pdf>`__. The paper is quite technical but readable with a bit of effort. Its main point is that sometimes (well, frequently) we get distracted by the features and the syntax of a language and we don't spend enough time working on understanding and internalizing the design process for new programs.