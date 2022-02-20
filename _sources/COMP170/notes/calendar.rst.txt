:orphan:

The Calendar Problem
=====================

The calendar problem is seemingly a difficult one. There are several different scenarios and we do not really know how to navigate them. One way to navigate different scenarios in programming is to use conditional statements, like `if-then-else`. At this stage in the course however, we have not "discovered" conditionals. And it is worth trying to solve the problem without looking ahead in the course material.
   
Solving the calendar problem without conditional statements is a fantastic learning moment. A solution without conditional statements requires some serious analysis first, illustrating that most computing problems follow the 80-20 rule: 80% thinking, 20% coding. The analysis begins by turning off our IDE, moving our focus from coding to thinking. Next, we draw a few scenarios on paper, on a notes app, whatever works for you. 


.. figure:: images/Calendar.png
   :figwidth: 60%
   :align: right
   
   A 31-day month with Sunday as its **second** day. 

As we try different combinations, e.g., 31-day month whose first day is a Sunday, or a 28-day month whose first day is a Tuesday, etc, we begin to see a pattern like the one to the right. The lines of the calendar are separated into three groups. The first group (yellow) *may* have a few empty spaces in the front. The second group (blue) has every space filled with a date. And the third group (green) *may* have a few empty spaces at the back.

The "blue" week
+++++++++++++++

.. figure:: images/sundayDate.png
   :figwidth: 60%
   :align: left
   
   Printing the "blue" week. 

The middle group (blue), shown to the left, may be the easiest to describe. It prints the dates for a full week, starting with Sunday. It adds 1 for every subsequent day. We do this for as many days as there are in a week. This is an operation easily implemented with a for-loop. Let's call the loop's variable :math:`\texttt{day}`; its range will be :math:`0\leq\texttt{day}<7`. 

The code now becomes straight forward. We need a method that prints seven numbers, starting with the date of the starting Sunday, which we assign to ``int sundayDate``. The first value of the loop variable is 0 and so ``sundayDate+0`` prints the date of the starting Sunday. The constant ``DAYS_IN_A_WEEK`` is assigned the value 7, to make our code more descriptive.

.. code-block:: java

   public static void blueWeek(int sundayDate) {
     for ( int day = 0;  day < DAYS_IN_A_WEEK; day++ ) {
       // print the date: sundayDate + day;
     }
   }

The "yellow" week
+++++++++++++++++

.. figure:: images/yellow.png
   :figwidth: 60%
   :align: right
   
   Printing the "yellow" week. 
   
Next let's look at the first line of the calendar, the "yellow" week. After a few hours of head-scratching we observe that the yellow week comprises two groups. A group of empty cells (in orange outlines) and a group of filled cells (pink outline). The total number of cells in these two groups is always 7 (``= DAYS_IN_A_WEEK``).

Can we tell how many cells are in each group? In the example here, we see that if the first Sunday of the month is its second day, there are 6 empty cells. Pretty soon, we can see that the number of empty and filled cells for the yellow line depends on the date of the first Sunday of the month.

The analysis above necessitates two loops: one loop to print the empty cells, followed by another loop to print the filled cells. Notice that the loop for empty cells *may* not run at all (in case Sunday falls on the first of the month).

Remaining analysis and observations
+++++++++++++++++++++++++++++++++++

The analysis above can be used to determine how to print the "green" week. After that, the only thing remaining is to determine how many "blue" weeks to print. And the final code will take the following form:

::

    print yellowWeek
    print blueWeek // \
    ...            //   Do this 3 - 4 times
    print blueWeek // /
    print greenWeek



It is left as an exercise to determine the ``greenWeek`` method and the number of times we invoke ``blueWeek``.

Let's close with an **observation.** The problem starts with the requirement to not use conditional statements. To be precise, what we have avoided so far is the explicit use of `if-then-else` statements. Because our code will contain for-loops, there will be *implied* conditions: the loops' terminating conditions. 