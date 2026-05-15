*******************************************************************************
Detailed outline
*******************************************************************************

* Week 01: Tools and Basic Techniques

  * The Colab environment: code cells v. text cells.
  * Basic Python syntax. Java-to-Python transition.
  * Markup languages: SGML, HTML, XML, TeX, LaTeX, MarkDown.
  * MarkDown syntax.
  * LaTeX syntax.
  * A simple algorithm described in ``md``, LaTeX, and Python. 
  * Discuss the nature of a *numerical* algorithm.
  * A simple algorithm to solve a 2x2 system of equations, then for a 3x3 system of equations. 
  * :math:`n\times n` with :math:`n>3` and Gaussian elimination; performance analysis.
  * **Assignment:** implement Gaussian elimination in Python.


* Week 02: String Alignment

  * Character mismatch penalties.
  * Gap penalties.
  * Contrived example: ``---CAT`` and ``DOG---``, with :math:`\alpha_\text{gap}<0`.
  * Brute force time performance.
  * Observation towards optimal substructure (focus on the "last column").
  * Needleman-Wunch algorithm and performance analysis.
  * **Assignment:** backtrace Needleman-Wunch scores to construct alignment. 


* Week 03: Recurrence Relations 

  * Review of mergesort.
  * Identify the *divide* and *conquer* components of the algorithm.
  * Measure its time complexity.
  * Generalize the concept of recurrence as :math:`T(n)=rT(n/c)+f(n)`
  * Derivation of the *Master Theorem.* 
  * Good recursion. Bad recursion. 
  * Factorial and Fibonacci computations. 
  * Multiplying *very* large integers.
  * **Assignment:** Karatsuba multiplication performance measurements.


* Week 04: Memoization and Dynamic Programming

  * 0/1 Knapsack. 
  * Minimum Weight Independent Set. 
  * **Assignment:** tbd


* Week 05: Simple Graphs 

  * Review of graph definition and basic properties. 
  * Graph types. 
  * Parts of a graph. 
  * Representing a graph with arrays. 
  * Graph traversals. 
  * Stack v. queue-based traversals of a graph. 
  * Labeling and counting components.
  * **Assignment:** tbd


* Week 06: Minimum Spanning Trees

  * Boruvka's algorithm. Relaxing tense edges. 
  * Correctness and complexity considerations. 
  * Evolution of Boruvka to Kruskal, Dijkstra and other variations.
  * **Assignment:** implement Boruvka's algorith.
  

* Week 07: Directed Graphs

  * Adjacency matrix. 
  * Reachability of a vertex. 
  * Shortest paths. 
  * Tense and relaxed edges.
  * Topological sorting
  * **Assignment:** Detecting cycles.


* Week 08: Maximum Flows / Minimum Cut

  * Conservation of flow.
  * Residual graph.
  * Residual capacity.
  * Operating on the residual graph.
  * Augmented paths.
  * Computing the maximum flow across a graph.
  * **Assignment:** determine the minimum cut of a graph.


* Week 09: Greedy Algorithms

  * Greedy algorithms that work: Huffman encoding.
  * Greedy algorithms that do not work: MWIS.
  * **Assignment:** tbd


* Week 10: Tree Algorithms


* Week 11: tbd


* Week 12: P versus NP

   * Complexity theory. 
   * The SAT3 problem.
   * Reductions


* Week 13: Neural Networks


**Coding:** You may use any language you wish in the course. Classroom examples are written in Python as `Jupyter Notebooks <https://en.wikipedia.org/wiki/Project_Jupyter>`__. The preferred platform for these notebooks is Google Colab.