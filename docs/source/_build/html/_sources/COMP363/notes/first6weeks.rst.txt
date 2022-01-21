:orphan:

Six weeks of Algorithms
==========================

In the first six weeks of the course we covered the following topics.

Python and Jupyter notebooks
-----------------------------------------------------------------------------

`Jupyter notebooks <https://jupyter.org/>`__ are very popular tools among data scientists. They are also extremely useful for our course because they allow us to mix `marked-up documentation <https://en.wikipedia.org/wiki/Markup_language>`__ and code together. The programming environment these notebooks offer is not as sophisticated as that of an IDE, but it provides basic functionality such as autocompletion. Of course we can always download and use a fuller integrated development environment such as `PyCharm <https://www.jetbrains.com/pycharm/download/download-thanks.html?platform=mac&code=PCC>`__ (the sibling application to IntelliJ); `Spyder <https://www.spyder-ide.org/>`__, etc; not to mention the awesomness of *vim* and *emacs*.

Trade off between code reusability and performance
------------------------------------------------------

Reusable code is elegant but not always efficient. We explored this trade off with the `Intersecting Linked Lists <https://colab.research.google.com/drive/1lq4lFjDIletiCRudys1fgJS3oHlUu7Cs?usp=sharing>`__ notebook. We saw how to write nodes and linked lists in Python, and developed techniques for telling if two lists intersect or not. One technique reused existing code but its performance was poor because it had to check every pair of possible node combinations between the two lists. The other technique duplicated existing code but performed must faster because it ended after detecting the first intersection between the linked lists.

The search for intersections was based on comparison between the string contents of nodes. The code used fixed length strings that were randomly generated. The likelihood that two noe3w intersect is directly proportional to the length of these strings. There are :math:`26` different node contents for strings with length 1, :math:`26^2` different node contents for strings with length 2, and so on. Lists with 2-letter contents and more than :math:`26^2` nodes, are certain to have an intersection. Let's consider two lists with :math:`10^3` elements each. It takes :math:`10^6` steps for the elegant method and approximately :math:`26^2` steps for the efficient method to detect an intersection.

The analysis of the trade offs above led to the discussion about asymptotic behavior: what are the time demands of each method, for sufficiently large lists. If :math:`n` is the number of nodes in each of the two lists we are checking, can the number of steps each method takes be described in terms of :math:`n`? We call this behavior asymptotic and use the big-oh (:math:`\mathcal{O}`) notation to express it. (We also use :math:`\Theta` and :math:`\Omega` expressions for asymptotic notation, but :math:`\mathcal{O}` rules them all). In terms of big-oh, the elegant method is :math:`\mathcal{O}(n^2)` and the efficient method is :math:`\mathcal{O}(26^L)` where :math:`L` is the number of letters in the string content of the node. For sufficiently large values of :math:`n`, the efficient method runs in constant time and therefore more preferable than the elegant method.

Recursion
---------

We spent a good deal of time on recursion because because it is a foundational topic in computing. It is a strategy for understanding how to solve seemingly complex problems. Even for problems whose ultimate solution is not recursive, the solving strategy evolved from a humble recursive beginning. One such problem is the computation of the Fibonacci sequence. The recursive solution is slow because it repeats computations. We can avoid repetitions by storing the results of intermediate steps.

Divide and Conquer
++++++++++++++++++

Divide and Conquer splits a problem into smaller pieces until a trivial solution can be found, then assembles these partial solutions together. Like all recursive tactics, divide and conquer works if the reduction to smaller problem eventually leads to a trivial (base) case that can be solved without further division. *Split multiplication* is a good example of divide and conquer. It is based on the observation that any number can be written as the sum of two products: :math:`x=a\cdot 10^2+b\cdot 10^0`; for example :math:`4389=43\cdot10^2+89\cdot 10^0`. For two variables with the same number of digits, :math:`x` and :math:`y=c\cdot 10O^s+d\cdot 10^0`, their product is

.. math::

 xy = a c10^{2s} + (ad+cb)10^s + bd10^0


Products :math:`ac`, :math:`ad`, :math:`cb`, and :math:`bd` above can be broken down in similar fashion, splitting the numbers into halves, until each number has a single digit. Such numbers are very easy to multiply. Beginning with these single digit products, we can go back assembling the solution back to the initial product :math:`xy`.

A faster way for split-multiply was introduced by Anatoli Karatsuba in the 1960s. As we compared the performance between the plain split multiplication and Karatsuba's approach, we saw how the interplay between recursive calls, size of subproblems passed to them, and time required for assemblying the partial results to a solution, all affect performance time. The *Master Theorem* puts together the relations between these three characteristics, to determine the asymptotic behavior of a divide and conquer algorithm.

Memoization and Dynamic Programming
+++++++++++++++++++++++++++++++++++

Recursion can be slow and often demanding on memory resources. For some problems, we can aleviate the pressure by using look-up tables or by exploiting optimal substructures. The use of look-up tables is called *memoization*. From an atrocious :math:`\mathcal{O}(2^n)` our computation for Fibonacci numbers went to :math:`\mathcal{O}(n)` as we moved from pure recursion to the use of a simple array, holding past results. Not only that, but we also found we don't even need an array, because there is a plain iterative way to compute Fibonacci numbers using only two storage variables, one for the previous term and one for the prior previous term:

.. code-block:: python

   def fibonacci(n):
       f = n
       if n > 1:
           p = 1  # Previous term (i.e., F(n-1))
           pp = 0  # Prior previous term (i.e., F(n-2))
           i = 2  #  We are here because n >= 2
           while i <= n:  # Iterative loop 
               f = p + pp  # Fibonacci term is sum of two past terms
               pp = p  # Previous becomes prior previous
               p = f  # Value just computed becomes previous
               i += 1  # Next iteration
       return f
       

Dynamic programming takes this technique further and allows some backtracking to provide details about a solution. The typical example is the Knapsack problem. We solved the 0/1 version of the problem: `the museum heist scenario <https://colab.research.google.com/drive/1SRcSScTx9MQA9jGCGfv_7fn8x6CGlSaq>`__. Other variants of the problem include the bounded Knapsack (more akin to a grocery store heist) and the unbounded Knapsack (where there is no limit in the quantity of each item).

Practical applications of the Knapsack problem -- other than stealing from a museum, of course -- include optimization of investment strategies, resource planning, scheduling, and design of diets among other things.

Optimal Stopping
----------------

Optimal stopping is a very practical algorithm that optimizes the outcome of certain selection searches. The algorithm works in cases when we do not know the range of rankings and also when we cannot go back and select something after we passed it. If we plan to search up to :math:`N` items, the algorithm suggests that we go through the first :math:`N/e` items and get an idea of the rankings based on some metric (e.g., quality, during an apartment hunt). Then go through the remaining :math:`N(e-1)/e` items and select the first one that is better than the best of the earlier group. We also saw that the algorithm works well only when the range of ranking is in the same range as :math:`N`. 

For example, if we rank items on a scale of 1-10, the algorithm works well for :math:`N<20`. After that, the output fails and soon becomes 0, i.e., no selection can be made. That's reasonable consider that if :math:`N=1000` then :math:`N/e\approx 368`. Among 368 items in the sample group, it is almost certain that one of them will be ranked at 10, assuming some uniform distribution. Moving to the second group of 623 items, it will be impossible to find something with a better ranking than 10.

Asymptotic Formalism
--------------------

In estimating performance of algorithms (and programs that implement them), we often look at the worst case scenario. If we can live with it, we implement the algorithm. For example, the efficient method to find the intersection of two linked lists performs reasonably fast if an intersection exists. If the two lists do not intersect, the efficient method performs as slowly as the elegant method. And if the intersection is at the last node of each list, there is no difference in the performance of the two methods. 

The worst case estimate is described with the *big-o* asymptote. Given two functions   :math:`f, g: \mathbb{N}_+ \mapsto\mathbb{R}_+` we say that :math:`f(n)` is :math:`\mathcal{O}(g(n))` if there is a positive real constant :math:`c` such that :math:`f(n)\leq c g(n)` for :math:`n>n_O`, where :math:`n_0 \geq 1`. Sometimes we write :math:`f(n)\in \mathcal{O}(g(n))`, to denote the same behavior between :math:`f` and :math:`g`.

For example, if :math:`f(n)=8n+11` and :math:`g(n)=n`, can we show that :math:`f(n) \in\mathcal{O}(g(n))`? To do so, we need to find a constant :math:`c\in\mathbb{R}_+` such that :math:`f(n)\leq cg(n)` for :math:`n>n_0`. We also need to find what is the value of :math:`n_0`.

Solving for :math:`c` we get 

.. math::

   c  \geq \frac{f(n)}{g(n)} = & \frac{8n+11}{n} \\
                               = & 8 + \frac{11}{n} 
                               
                               
 
 
For any value of :math:`n`, :math:`8+\frac{11}{n} > 8` and so any value :math:`c>8` will satisfy the condition :math:`f(c) \leq cg(n)`. For example, if :math:`c=9`, then :math:`8n+11 \leq 9n` for :math:`n>10`. Therefore, :math:`8n+11\in\mathcal{O}(n)`.

Simple exercises
++++++++++++++++

* Show that :math:`\sin^2{(n)}\in\mathcal{O}(1)`.
* Show that :math:`n\sin^2{(n)}\in\mathcal{O}(n)`.
* Show that :math:`n^x\in\mathcal{O}(n)` for :math:`0<x<1`.
* Show that :math:`(1+2+3+\ldots +(n-1)+n)\in\mathcal{O}(n^2)`.
* Explain why :math:`\cos{(n)}\not\in\mathcal{O}(g(n))` for any :math:`g(n): \mathbb{N}_+ \mapsto\mathbb{R}_+`.
