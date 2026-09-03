*******************************************************************************
Detailed outline
*******************************************************************************

Fall 2026 is a 13-technical-week course (the two extra weeks beyond the Summer
term's 11 are spent on two additions — **sorting** and **trees** — inserted
where they fit the existing arc, not tacked onto the end). A testing habit is
seeded starting Week 3, rather than taught as a single dedicated lesson.

.. list-table::
   :header-rows: 1
   :widths: 15 85

   * - Week
     - Topic
   * - **Week 01**
     - Separating data from behavior
   * - **Week 02**
     - Arrays, objects, and the first class
   * - **Week 03**
     - Resizing, magic numbers, and encapsulation
   * - **Week 04**
     - Dunder methods, bounds checking, and delegation
   * - **Week 05**
     - Contracts, composition, and the first linked node
   * - **Week 06**
     - Linked traversal, tail pointers, and Big O
   * - **Week 07**
     - Sorting
   * - **Week 08**
     - Generic nodes and a doubly linked list
   * - **Week 09**
     - Trees
   * - **Week 10**
     - Discontinuity, cycles, and reversal
   * - **Week 11**
     - O(1) ends, recursion, and stack/queue
   * - **Week 12**
     - Circular buffers and graphs
   * - **Week 13**
     - Hashing, and a capstone


Fall 2026 — detailed topics
-----------------------------------

* Week 01: Separating data from behavior.

  * The Mississippi progression: letter shapes as data (a list of strings) versus letter shapes baked into ``print()`` calls.
  * ``pasta.py`` refactored into ``get_guests()`` / ``pasta_recipe()`` / ``display_recipe()`` / ``main()`` as a counter-example.
  * Quick vim/terminal fluency check — this course assumes COMP 170's habits.

* Week 02: Arrays, objects, and the first class.

  * True arrays (fixed size, single type) versus Python's dynamic list.
  * Classes as blueprints, objects as instances; ``__init__``, ``self``.
  * The first ``DynamicArray``, with sentinel ``-1`` slots and ``add_zip_code()``.

* Week 03: Resizing, magic numbers, and encapsulation.

  * ``resize()``'s three steps: allocate double, copy, replace.
  * The magic-number smell, replaced by ``DEFAULT_CAPACITY`` / ``RESIZE_BY``.
  * The ``int()``-truncation bug and its ``math.ceil()`` fix.
  * ``_zip_codes`` renamed to ``_underlying``; single- vs. double-underscore privacy.
  * **Testing habit starts here:** an ``assert`` against ``resize()``'s expected post-condition, checked before trusting the printed output.

* Week 04: Dunder methods, bounds checking, and delegation.

  * ``__str__``, ``__len__``.
  * The negative-index trap in ``get()``.
  * Refactoring ``contains()`` to delegate to ``index_of()``.
  * The shift-and-clear ``remove()`` algorithm.
  * Generalizing ``_underlying`` from ``list[int]`` to ``list``.

* Week 05: Contracts, composition, and the first linked node.

  * The data-structure contract (``contains``, ``index_of``, ``index_of_all``, ``count``, ``remove``) as an abstract base class.
  * ``FellowshipRoster`` as composition rather than inheritance.
  * Docstrings, ``str.join()`` over repeated concatenation.
  * ``station.py``: the first object whose field points to another object of the same class.

* Week 06: Linked traversal, tail pointers, and Big O.

  * Traversal-based ``add()`` and its :math:`\mathcal{O}(n)` cost; a ``_tail`` pointer bringing it to :math:`\mathcal{O}(1)`.
  * Big O as an upper bound vs. Big Theta as a tight bound: :math:`f(n) \in \mathcal{O}(g(n))` when :math:`f(n) \le c \cdot g(n)`.
  * The full contract implemented on ``Trainline``; ``__iter__`` via ``yield``.

* Week 07: Sorting.

  * Selection sort and insertion sort, both :math:`\mathcal{O}(n^2)`, traced by hand and implemented on the array structure built in Weeks 2–4.
  * Counting comparisons and swaps as a direct application of Week 6's :math:`\mathcal{O}(n)` vs. :math:`\mathcal{O}(n^2)` distinction.
  * A forward pointer — not a full treatment — to :math:`\mathcal{O}(n \log n)` divide-and-conquer sorts (merge sort), covered properly in COMP 363 with recurrence-relation machinery.

* Week 08: Generic nodes and a doubly linked list.

  * ``Node`` generalized with ``TypeVar``/``Generic``.
  * ``DoubleLinkedList``'s constructor.
  * The slow/fast cursor technique for finding a list's middle node in one pass, with a count field to make it :math:`\mathcal{O}(1)` to check.

* Week 09: Trees.

  * A ``TreeNode`` with ``left``/``right`` instead of ``next`` — one field short of the ``Node`` from Week 8.
  * Building a small binary search tree; implementing one traversal (in-order); insert and search.
  * Framed as a bridge to non-linear data structures — depth, balancing, and deletion are out of scope this term.

* Week 10: Discontinuity, cycles, and reversal.

  * Completing ``add()`` on the doubly linked list.
  * Detecting a broken bidirectional link.
  * Detecting a cycle in :math:`\mathcal{O}(1)` by inspecting a well-maintained ``_tail`` or a ring-wired head/tail pair.
  * Reversing a forward-only list in place by rewiring pointers.

* Week 11: O(1) ends, recursion, and stack/queue.

  * Removing the head or tail of a doubly linked list in three constant-time steps.
  * Recursion and the maximum-recursion-depth crash as a bridge to the call stack.
  * ``push``/``pop``, ``enqueue``/``dequeue``, ``peek``, ``is_empty``.
  * ``BoundedCollection`` as a shared superclass for ``Stack`` and ``Queue`` via inheritance.

* Week 12: Circular buffers and graphs.

  * Circular queues and stacks via front/back pointers and modulo arithmetic.
  * Graphs as vertices and edges; adjacency list and adjacency matrix.
  * ``naive_reachability``'s traversal loop, and the early-stopping refinement.

* Week 13: Hashing, and a capstone.

  * A file-backed queue/stack, covered as a brief demonstration.
  * Hotel-room assignment by first letter; the pigeonhole principle named explicitly as the reason collisions are unavoidable.
  * Linear probing; chaining as "an array of the linked lists from Week 8."
  * Load factor :math:`\alpha = \frac{\text{slots used}}{\text{capacity}}`; Python's ``dict`` named as exactly this structure.
  * Final assignment: ``SimpleHash``.
