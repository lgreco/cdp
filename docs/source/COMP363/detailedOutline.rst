:orphan:

Detailed outline
----------------

* Week 01: Tools and Basic Techniques

  * The Colab environment: code cells v. text cells.
  * Basic Python syntax. Java-to-Python transition.
  * Markup languages: SGML, HTML, XML, TeX, LaTeX, MarkDown.
  * MarkDown syntax.
  * LaTeX syntax.
  * A simple algorithm described in `md`, LaTeX, and Python. 
  * Discuss the nature of a *numerical* algorithm.
  * A simple algorithm to solve a 2x2 system of equations, then for a 3x3 system of equations. 
  * :math:`n\times n` with :math:`n>3` and Gaussian elimination; performance analysis.
  * **Assignment:** implement Gaussian elimination in Python.<br/>


* Week 02: String Alignment

  * Character mismatch penalties.
  * Gap penalties.
  * Contrived example: ``---CAT`` and ``DOG---``, with :math:`\alpha_\text{gap}<0`.
  * Brute force time performance.
  * Observation towards optimal substructure (focus on the "last column").
  * Needleman-Wunch algorithm and performance analysis.
  * **Assignment:** backtrace Needleman-Wunch scores to construct alignment. 
  | 


* Week 03: Recurrence Relations 

  * Review of mergesort.
  * Identify the *divide* and *conquer* components of the algorithm.
  * Measure its time complexity.
  * Generalize the concept of recurrence as :math:`T(n)=rT(n/c)+f(n)`
  * Derivation of the *Master Theorem.* 
  * Good recursion. Bad recursion. 
  * Factorial and Fibonacci computations. 
  * Multiplying *very* large integers.
  * **Assignment:** Karatsuba multiplication performance measurements.<br/>


* Week 04: Memoization and Dynamic Programming

  * 0/1 Knapsack (or, how to plan a museum heist). 
  * Minimum Weight Independent Set. 
  * **Assignment:** tbd<br/>

* Week 05: Simple Graphs 

  * Review of graph definition and basic properties. 
  * Graph types. 
  * Parts of a graph. 
  * Representing a graph with arrays. 
  * Graph traversals. 
  * Stack v. queue-based traversals of a graph. 
  * Labeling and counting components.
  * **Assignment:** tbd<br/>

* Week 06: Minimum Spanning Trees

  * Boruvka's algorithm. Relaxing tense edges. 
  * Correctness and complexity considerations. 
  * Evolution of Boruvka to Kruskal, Dijkstra and other variations.
  * **Assignment:** implement Boruvka's algorith.<br/>
  

- Unit 7: Directed graphs. Adjacency matrix. Determining the reachability of a vertex. Shortest paths. Detecting cycles.

- Unit 8: Maximum flows and minimum cuts or why Chicago is a more important strategic target than NYC. 

- Unit 9: (two header): Greedy algorithms: Huffman encoding. Topological ordering.

- Unit 10: Tree algorithms.

- Unit 11: tbd

- Week 12: P versus NP and complexity theory. The SAT3 problem.

- Week 13: A gentle introduction to neural networks.

The graduate course (COMP 460) comprises a review/refresh part and an advanced part. In the review part, we combine topics as follows:

- Week 1: units 1 and 3
- Week 2: units 2 and 4
- Week 3: units 5, 7, 7, and 10
- Week 4: unit 8, by itself
- Week 5: unit 9, by itself
- Week 6: unit 11, by itself

Depending on everyone's background and prior experience in the graduate class, we could condense the review part even more. Then, for the last part of the term (weeks 6-12) we focus on advanced and special topics, including

- Artificial neural networks
- Large language models
- Signal processing
- Quantum computing
- Cryptography
- Hypergraphs
- Complexity spaces
- Numerical methods, etc.

The precise mix of advanced topics depends on students' preferences and the overall group dynamic of the class.

**Coding:** You may use any language you wish in the course. Classroom examples are written in Python as `Jupyter Notebooks <https://en.wikipedia.org/wiki/Project_Jupyter>`__. The preferred platform for these notebooks is Google Colab.