:orphan:

Drawing Sears Tower
===================

.. figure:: images/SearsTower100dpi.png
   :width: 400
   :align: right

Drawing the Sears Tower (known as Willis Tower these days) can be accomplished with four methods. The tower can be split into four distinct tiers. Each tier can then be drawn using a dedicated method. Further abstraction is possible but for now, let's go with four distinct methods as follows:

* ``masts()`` to draw the antennas on top of the tower;
* ``top()`` to draw the top tier of the tower;
* ``middle`` to draw the middle tier of the tower, and;
* ``bottom()`` to draw the bottom tier.

The only variable that needs to be determined by the user, is the heigh of the tower, expressed in lines (remember, we are doing this as `ASCII art <https://en.wikipedia.org/wiki/ASCII_art>`__.) The heigh is captured as ``static int N;`` `in our program <https://github.com/lgreco/IntroProgramming/blob/master/Sears/src/SearsTower.java>`__.

The rest of the dimensions, as shown in the schematic, are derived based on that variable ``N``. The highlighted code below shows the corresponding calculations.

.. literalinclude:: ../../../../../IntroProgramming/Sears/src/SearsTower.java 
   :linenos:
   :language: java