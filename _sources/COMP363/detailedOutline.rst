*******************************************************************************
Detailed outline
*******************************************************************************

**Week 01** is not technical content — it's dedicated to small-group meetings
with students to discuss plans and ideas for the term. The 13 technical weeks
below run Week 02 through Week 14. Where a week's topic maps onto a chapter of
the assigned textbook — Jeff Erickson's *Algorithms*, 1st edition — that
chapter is noted; a few weeks (Tree Algorithms, String Matching and
Computational Geometry, Neural Networks) draw on the course's own learning
outcomes instead, since the book's 1st edition doesn't cover that material.

*The outline is tentative and is shown here as a guideline for the course. The
actual material to be covered depends on the group's interests and dynamics*

.. list-table::
   :header-rows: 1
   :widths: 10 30 20 40

   * - Week
     - Topic
     - Book chapter(s)
     - Key concepts
   * - **Week 01**
     - Small-group meetings
     - —
     - No technical content; individual/small-group check-ins on plans and ideas for the term
   * - **Week 02**
     - Tools and basic techniques
     - Ch. 00 — *Algorithms*
     - Colab/Python/Markdown/LaTeX setup; the Newton-Raphson method; complexity/performance analysis
   * - **Week 03**
     - String alignment
     - Ch. 03 — *Dynamic Programming* (edit-distance)
     - Character mismatch/gap penalties; Needleman-Wunsch; backtrace to recover the alignment
   * - **Week 04**
     - Recurrence relations
     - Ch. 01 — *Recursion*
     - Mergesort/divide-and-conquer; Master Theorem derivation; Karatsuba multiplication
   * - **Week 05**
     - Memoization and dynamic programming
     - Ch. 03 — *Dynamic Programming*
     - 0/1 Knapsack; Minimum Weight Independent Set; top-down vs. bottom-up tradeoffs
   * - **Week 06**
     - Simple graphs
     - Ch. 05 — *Graphs*
     - Representations (adjacency list/matrix); generalized "whatever-first search"; connected-component labeling
   * - **Week 07**
     - Minimum spanning trees
     - Ch. 07 — *Minimum Spanning Trees*
     - Distinct-edge-weight uniqueness argument; the generic cut/cycle rule unifying Borůvka's/Kruskal's/Prim's; Dijkstra's for comparison
   * - **Week 08**
     - Directed graphs
     - Ch. 06 — *Depth-First Search*
     - Preorder/postorder traversal; cycle detection; topological sort; strong connectivity (Tarjan/Kosaraju)
   * - **Week 09**
     - Maximum flows / minimum cut
     - Ch. 10 — *Maximum Flows and Minimum Cuts*
     - Residual graphs; augmenting paths; max-flow–min-cut theorem
   * - **Week 10**
     - Greedy algorithms
     - Ch. 04 — *Greedy Algorithms*
     - Huffman codes; interval/class scheduling; exchange-argument proofs
   * - **Week 11**
     - Tree algorithms
     - *Not in Erickson 1st ed. — supplementary*
     - Segment trees, Fenwick trees, disjoint-set union (union-by-rank + path compression)
   * - **Week 12**
     - String matching and computational geometry
     - *Not in Erickson 1st ed. — supplementary*
     - Naive vs. linear-time substring search (KMP or equivalent); suffix arrays; convex hull (divide-and-conquer); line intersection; Voronoi diagrams (awareness-level)
   * - **Week 13**
     - P versus NP
     - Ch. 12 — *NP-Hardness*
     - P vs. NP; polynomial-time reductions; 3-SAT
   * - **Week 14**
     - Neural networks
     - *Not in Erickson — outside the algorithms textbook entirely*
     - Feedforward networks, backpropagation, gradient descent


Fall 2026 — detailed topics
-----------------------------------

* Week 01: Small-group meetings.

  * No technical content; individual/small-group check-ins with students on plans and ideas for the term.

* Week 02: Tools and basic techniques.

  * The Colab environment: code cells v. text cells.
  * Basic Python syntax.
  * Markup languages: Markdown and LaTeX.
  * A simple algorithm described in Markdown, LaTeX, and Python.
  * Root-finding by tangent-line approximation: deriving the Newton-Raphson update rule :math:`x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}` from a first-order Taylor argument.
  * Quadratic convergence near a simple root; standard failure modes (:math:`f'(x_n) \approx 0`, poor initial guess, repeated roots) and stopping criteria; performance analysis.
  * **Assignment:** implement Newton-Raphson root-finding in Python.

* Week 03: String alignment.

  * Character mismatch and gap penalties.
  * Brute-force time performance; the observation towards optimal substructure (focus on the "last column").
  * Needleman-Wunsch algorithm and performance analysis.
  * **Assignment:** implement global alignment with a full backtrace; report the optimal score and one optimal alignment.

* Week 04: Recurrence relations.

  * Review of mergesort; identifying the *divide* and *conquer* components; measuring its time complexity.
  * Generalizing the concept of recurrence as :math:`T(n) = rT(n/c) + f(n)`; derivation of the Master Theorem.
  * Good recursion, bad recursion; factorial and Fibonacci computations; multiplying very large integers.
  * **Assignment:** implement Karatsuba multiplication; derive and verify its recurrence bound empirically.

* Week 05: Memoization and dynamic programming.

  * 0/1 Knapsack.
  * Minimum Weight Independent Set.
  * **Assignment:** a knapsack-style DP problem (e.g. "museum heist").

* Week 06: Simple graphs.

  * Review of graph definition and basic properties; graph types; parts of a graph.
  * Representing a graph with adjacency lists and adjacency matrices.
  * Graph traversals; labeling and counting connected components.
  * **Assignment:** build both representations; implement component labeling via BFS/DFS.

* Week 07: Minimum spanning trees.

  * The distinct-edge-weight uniqueness argument.
  * The generic cut/cycle rule unifying Borůvka's, Kruskal's, and Prim's algorithms.
  * Dijkstra's algorithm, for comparison.
  * **Assignment:** implement Borůvka's algorithm.

* Week 08: Directed graphs.

  * Preorder/postorder traversal; cycle detection.
  * Topological sorting.
  * Strong connectivity (Tarjan's/Kosaraju's algorithms).
  * **Assignment:** topological sort with cycle detection.

* Week 09: Maximum flows / minimum cut.

  * Conservation of flow; the residual graph and residual capacity.
  * Augmenting paths; the max-flow–min-cut theorem.
  * **Assignment:** implement augmenting-path max flow; report the corresponding minimum cut.

* Week 10: Greedy algorithms.

  * Greedy algorithms that work: Huffman encoding.
  * Greedy algorithms that do not work: Minimum Weight Independent Set.
  * Exchange-argument proofs; interval/class scheduling.
  * **Assignment:** Huffman encoding with a heap-based priority queue.

* Week 11: Tree algorithms.

  * Segment trees and Fenwick trees.
  * Disjoint-set union: union-by-rank and path compression.
  * **Assignment:** Kruskal's algorithm built on a from-scratch disjoint-set-union implementation.

* Week 12: String matching and computational geometry.

  * Naive vs. linear-time substring search (KMP or equivalent); suffix arrays.
  * Convex hull via divide-and-conquer, reusing Week 4's Master Theorem machinery.
  * Line intersection; Voronoi diagrams (awareness-level only).
  * **Assignment:** implement one string-matching algorithm and convex hull.

* Week 13: P versus NP.

  * Complexity theory; the SAT-3 problem.
  * Polynomial-time reductions.
  * **Assignment:** an NP-completeness reduction exercise — reduce a known NP-complete problem to a target problem via 3-SAT.

* Week 14: Neural networks.

  * Feedforward networks, backpropagation, gradient descent.
  * **Assignment:** implement backpropagation for a small feedforward network from scratch.

**Coding:** You may use any language you wish in the course. Classroom examples are written in Python as `Jupyter Notebooks <https://en.wikipedia.org/wiki/Project_Jupyter>`__. The preferred platform for these notebooks is Google Colab.
