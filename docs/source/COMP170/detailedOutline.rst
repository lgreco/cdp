*******************************************************************************
Detailed outline
*******************************************************************************

The Fall 2026 semester is 15 weeks long, but only 13 of them are technical-
content weeks. **Week 01** is small-group check-ins rather than full-class
sessions — no terminal, no Vim, no Python. **Weeks 02–14** are the 13
technical weeks. **Week 14** doubles as the capstone week and oral exams.
**Week 15** is finals: a nominal written exam, with no new content.

.. list-table::
   :header-rows: 1
   :widths: 15 85

   * - Week
     - Topic
   * - **Week 01**
     - Small-group check-ins *(no technical content)*
   * - **Week 02**
     - Reading code, the shell, and your first program
   * - **Week 03**
     - Data, types, and git
   * - **Week 04**
     - Strings, ASCII, and number systems
   * - **Week 05**
     - Loops and pattern-making
   * - **Week 06**
     - Conditionals and modular arithmetic
   * - **Week 07**
     - Lists, the cumulative pattern, and the first ``assert``
   * - **Week 08**
     - Dictionaries, right after lists
   * - **Week 09**
     - Splitting strings and writing methods
   * - **Week 10**
     - Organizing code across files
   * - **Week 11**
     - Accumulators, recursion, reinventing ``split()``, and searching strings
   * - **Week 12**
     - Validating input: ``try``/``except`` and the ATM
   * - **Week 13**
     - Designing and testing a method, in depth
   * - **Week 14**
     - Files, a capstone that reuses the dictionary, and oral exams
   * - **Week 15**
     - Finals *(no new content)*


Fall 2026 — detailed topics
-----------------------------------

* Week 01: Small-group check-ins.

  * No technical content. Logistics that are easier to absorb in a small group: the ungrading scale, the attendance policy, the AI-use policy, how Sakai submissions work — and the expectation that reading closely is the habit this course rewards most.

* Week 02: Reading code, the shell, and your first program.

  * Two matched recipes (scrambled eggs vs. French omelette) that share every ingredient and step but one, bridged into two Python snippets that share every character but one (``print("Hello,", name)`` vs. ``print("Hello, name")``) — predict the output before running either.
  * ``pwd``, ``ls``, ``cd``, ``mkdir``; Vim's two modes.
  * ``python3 file.py``, ``print()``, comments.
  * A program as a literal sequence of instructions performed on data; the shell as where every one of them runs this term.

* Week 03: Data, types, and git.

  * ``str``, ``int``, ``float``, ``type()``, conversion, variables, arithmetic and precedence.
  * The compound-interest program (``interest.py`` → ``interest_pro.py``) as the vehicle for separating input, logic, and output.
  * ``git init``/``add``/``commit``/``status``, introduced at the moment two versions of the same idea already exist. Every assignment from here forward is submitted via git.

* Week 04: Strings, ASCII, and number systems.

  * ``ord()``/``chr()``, four anchor values (32, 48, 65, 97).
  * String repetition vs. arithmetic multiplication.
  * Decimal, binary, and hex by hand; drawing shapes with hard-coded prints.

* Week 05: Loops and pattern-making.

  * ``for``, ``range()``.
  * Staircase, triangle, diamond, and bar-chart patterns — discovered from a table of examples first, pseudocode second, loop third.
  * For a triangle of height :math:`N`, row :math:`i` has :math:`N-i` spaces and :math:`i` stars.

* Week 06: Conditionals and modular arithmetic.

  * ``if``/``elif``/``else``, ``and``/``or``/``not``, ``==`` vs. ``=``.
  * The modulo operator; the airplane-seating problem.
  * Modular arithmetic: :math:`n \bmod m` cycles through :math:`0, 1, \dots, m-1`.

* Week 07: Lists, the cumulative pattern, and the first ``assert``.

  * List creation, zero-based indexing, ``len()``.
  * The cumulative algorithm (running sum/average): :math:`\bar{a} = \frac{1}{n}\sum_{i=0}^{n-1} a_i`.
  * **New this week:** before running a script, write one ``assert`` that states what you expect it to do — the seed of the testing habit that later weeks build on.

* Week 08: Dictionaries, right after lists.

  * ``dict`` creation, lookup, ``in``, ``.items()``.
  * First use case: counting a small in-memory list of words by hand, then with a dictionary — framed explicitly against "two synchronized lists" as the fragile alternative.

* Week 09: Splitting strings and writing methods.

  * ``sentence.split()``, the enhanced ``for`` loop.
  * Packaging logic into a method with type hints, a docstring, and input validation.
  * **Testing habit continues:** every method gets a docstring *and* a one-line ``assert``-based check before it's considered done.

* Week 10: Organizing code across files.

  * Running a script directly vs. importing its methods from another file; ``if __name__ == "__main__":``.
  * A module's namespace as a set of unique names — no two ``def``\ s can share a name.

* Week 11: Accumulators, recursion, reinventing ``split()``, and searching strings.

  * Loop-variable naming, the accumulator pattern.
  * Factorial and a first look at recursion (:math:`n! = n \cdot (n-1)!`, :math:`0! = 1`).
  * Reinventing ``str.split()`` character by character and debugging the classic consecutive-delimiter bug, including method headers with default parameter values.
  * Writing ``.find()``/``.index()`` from scratch; definite vs. indefinite loops; the multiplication-table nested-loop exercise.

* Week 12: Validating input: ``try``/``except`` and the ATM.

  * ``try``/``except`` around ``int(input())``; a ``max_tries`` cap.
  * Separate ``if`` statements (fall-through) vs. ``elif`` (mutually exclusive).
  * The retry-loop pattern, organized into ``withdraw()`` / ``attempt_withdrawal()`` / ``main()``.

* Week 13: Designing and testing a method, in depth.

  * The quadratic formula and discriminant :math:`b^2-4ac`; complex numbers as ``(real, imaginary)`` tuples.
  * Designing ``solve_quadratic()`` case by case with a flow chart.
  * Three levels of testing — naive prints, plain assertion functions, ``unittest`` — applied to a real, published package.

* Week 14: Files, a capstone that reuses the dictionary, and oral exams.

  * What a file is, why writes buffer until ``.close()``, the three file modes, reading line by line.
  * Capstone: read a public-domain book from a URL, strip punctuation, and count words — with the dictionary from Week 8.
  * This is also the week before finals: the capstone doubles as the material students are expected to speak to during oral exams.

* Week 15: Finals.

  * Nominal written exam. Nothing new is taught this week.
