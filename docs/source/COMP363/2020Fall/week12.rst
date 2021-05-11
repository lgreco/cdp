:orphan:


Review of Weeks 12: course review and Turing machines
=====================================================


Solutions for last homework assignment
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Problem 1
+++++++++

The cardinality :math:`|S|` of :math:`S = \{x|\sin{(mx)} = 0\}`, where :math:`m \geq 0` and :math:`0 
\leq x \leq 2\pi`:


.. math::

   |S| = \begin{cases} \infty, m=0 \\ 2m+1, m>0 \end{cases}



Problem 2
+++++++++

Prove that the sum of a rational number and an irrational number, is an irrational number.

The sum of two rational numbers is:


.. math::

 \frac{a}{b} + \frac{c}{d}
 
where :math:`a, b, c, d` are integers. Working out the fraction we get 


.. math::

 \frac{ad+bc}{bd}

where both numerators and denominators are integer numbers and the sum/products of integers, and thus the fraction is a rational number.
 
Problem 3
+++++++++

If :math:`a, b, c` are odd integers, show that :math:`ax^2+ bx + c = 0` has no rational solutions.

The solutions to the quadratic equation are


.. math::

 x = \frac{-b\pm\sqrt{b^2-4ac}}{2a}
 
These solutions are rational, if both the numerator and demominator are integer numbers. The denominator is an integer number as the product of two integer numbers. For the numerator to be an integer number, the square root must be an integer, therefore the quantity :math:`b^2-4ac` (known as the *discriminant,* :math:`\delta`) must be a perfect square, i.e :math:`\delta^2=b^2-4ac`. Manipulating this requirement yields:


.. math::

 b^2-\delta^2 &= 4ac \\
 (b-\delta)(b+\delta) &= 4ac

This leaves us with two scenarios:

.. math::
 
 b-\delta = 4a\ \ &\text{and}\ \ b+\delta=c \\ &\text{or}\\ b-\delta = c\ \ &\text{and}\ \ b+\delta=4a 
 

Looking at the first scenario and adding its two equations together: :math:`2b=4a+c`. If :math:`a,b,c` are odd, then :math:`2b` is even, :math:`4a` is even, and :math:`4a+c` is odd, leading to even=odd which cannot be true. The same can be shown for the second scenario.

Problem 4
+++++++++

You are standing at the bottom of a long stair, with a friend. You do not know how many
steps are there, nor are you allowed to count them. But you tell your friend that you can find
the middle step, without counting the number of steps, and only by moving up the stairs.
How can you accomplish that?

You start climbing the stairs, but for every step you take, your friend takes two. When your friend reaches the top of the staircase, you've reached the middle. (This is a popular interview question for software engineers: the actual question asks them how to find the middle of a linked list -- a data structure very similar to a staircase -- in a single pass.)

Problem 5 
+++++++++

A bag contains four quarters, one nickel, one dime, and five pennies. We reach with our hand
and pull out two coins at random. What are the chances that we pull $0.15 worth of coins?

You may obtain $0.15 by drawing a dime first and a nickel second, or vice versa. In other words:


.. math::

 P[\text{\$0.15}] &=	P[\text{dime}] \cdot P[\text{nickel}] + P[\text{nickel}] \cdot P[\text{dime}] \\
    &= \left(\frac{1}{11}\right)\left(\frac{1}{10}\right)+\left(\frac{1}{11}\right)\left(\frac{1}{10}\right) \\
    &=\frac{2}{110} = \frac{1}{55} = 1.818\%


Problem 6
+++++++++

A person takes a test to detect the occurence of a disease. The test’s characteristics are
such that a person testing positive has actually a 70% chance actually having contracted the
disease. Meaning that a person not having contracted the disease has a 30% chance of testing
positive to it.
The test’s results are used to allow a person to exit a quarantine – because having the disease
makes them immune to it and they are no longer in risk of being infected. But as we saw,
30% of those presumed to have had the disease, have not actually gone through it. If they
allowed into the general population, they risk being infected.
What would you do to ensure that a smaller number of those “false positives”, i.e., people
who test positive without having contracted the disease, are allowed to exit the quarantine?

Administer two tests, allow those two test positive to both tests to return to the general population.
 