:orphan:

Integer division and modular arithmetic
=======================================

The "``mod``" operator is a good opportunity to discuss integer division and modular arithmetic in programming. The *modulo* operation in Java is assigned to the operator ``%``. The standard definition is that ``m%n`` returns the (integer) remainder of the (integer division) of :math:`m` by :math:`n`. The mathemagics of the operation are captured by the equation:


.. math::

 m= \left[\frac{m}{n}\right]n+r&\\ &m,n,r\in\mathbb{Z}
 
The square brackets above are the *integer* part, [#]_ e.g. :math:`[3.14] = 3`. The operator ``%`` returns :math:`r` from the equation above. It can be shown that :math:`0\leq r\leq n-1,\forall m\in\mathbb{Z}`. This is an interesting property of the remainder operation ``m%n``. For a fixed :math:`n`, as :math:`m` assumes different values, the result of ``m%n`` steps from :math:`0`, to :math:`1, \ldots` to :math:`n-1`, and then back to :math:`0`. 

We can use this modular property in many ways, computationally. A popular use is to convert a serial collection to a two-dimensional arrangement. Imagine, for example, 16 people waiting to be seated in a (very) small theater with 4 rows, each with 4 seats. How can we group these people, 4-to-row, as shown below?

.. figure:: images/linear_2d.png
   
   Simple illustration of mapping a linear collection of 16 items to a two-dimensional arrangement of 4x4.
   
We begin by assigning each person a number, showing their position in line. From now on, when counting, we'll start from 0. Initially it may feel a bit odd to assign the first person to 0, the second to 1, etc. But it makes sense. Think of the number assigned to a person as the count of people ahead in line. There are 0 people in front of the first person, 2 people ahead of the third person, etc.

Next we assign each person to the following row number.

.. math::

 \textrm{row number} = \left[\frac{\textrm{position number in line}}{\textrm{number of seats per row}}\right]

The square brackets indicate integer division. There are 4 sears per row, so:

.. math::
 \begin{align*}
 [0/4]  &=0 	&[1/4]  &=0 	&[2/4]  &=0		&[3/4]&=0\\
 [4/4]  &=1 	&[5/4]  &=1 	&[6/4]  &=1		&[7/4]&=1 \\
 [8/4]  &=2 	&[9/4]  &=2 	&[10/4] &=2		&[11/4]&=2 \\
 [12/4] &=3		&[13/4] &=3		&[14/4] &=3		&[15/4]&=3
 \end{align*}


The column for each person can be found in a similar way.

These two integer operations (division and remainder) allow us to map a linear collection (e.g., people waiting in line) to a two-dimensional structure (e.g., seats in an airplane, stadium, etc).


.. math::

  \textrm{column number} = (\textrm{position number in line})\ \%\ (\textrm{number of seats per row})
  
The column number above, will cycle through :math:`0, 1, \ldots` up to :math:`\textrm{number of seats per row}-1`.

.. figure:: images/linear_2d_box.png

   
   A simple mechanism to take a number and convert it to two numbers, representing a (row, column) reference in a two-dimensional grid.
   
The mechanism illustrated above can be implemente, naively for now, as follows.

..literalinclude:: ../codeExamples/IntroProgramming/IntegerOperations/src/NaiveLinearTo2D.java
  :linenos:
  :language: java
    
 
.. [#] Technically, the integer part :math:`[x]` is defined as:

   .. math::
      
      [x] = \left\{ \begin{align*} \lfloor x \rfloor,\ \textit{if}\  x\geq 0 \\
                                    \lceil x \rceil,\ \textit{if}\ x<0
									 \end{align*} \right.
									 									 
   with :math:`\lfloor x \rfloor = \max{\{m\in\mathbb{Z}: m\leq x\}}` and :math:`\lceil x \rceil = \min{\{n\in\mathbb{Z}: n\geq x\}}`.