
Review of Week 3
=================

For week 3 we started looking at realistic problems in data analysis, while we continued to sharpen our Python skills. On the Python side, we looked at manipulating arrays with ``numpy``. 

.. code-block:: python
  :linenos:
  
  import numpy as np
  
  x=np.arange(0,10,1)
  y=x**2           
  
In the code above, line 3 creates an array with 10 numbers:

.. math::
   [0,1,2,3,4,5,6,7,8,9]
   
Then, line 4 creates a second array, called ``y`` also with 10 numbers, where each number is the square of the corresponding number from ``x``.

``arange`` is a very useful command in the ``numpy`` library, because it creates an array of numbers in any interval and with any step we want. For example, if we want to produce 10 numbers in the interval between 4 and 5, the command would be

.. code-block:: python
  :linenos:
  
  import numpy as np
  
  x=np.arange(4,5,0.1) 
  
The syntax for ``arange`` is:

``arange(fromThis, upToThis, withStep)``

To create an array of values from 0 to :math:`2\pi` with a step of 0.01, we need to state

``x = np.arange(0,2*np.pi,0.01)``