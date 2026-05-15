Outlines
============================

Sets
++++

* Notion of set as a collection of items with some relevance to each other. No order. No duplicates.
* Explicit and implicit definition of sets. How to evaluate set membership conditions (ie how to read and apply a condition like :math:`\{x|x^2-4=0\}`).
* Special sets: :math:`\mathbb{Z, Q, R}`. Also :math:`\mathbb{N}` versus :math:`\mathbb{N}_0`.
* Cardinality.
* Equal sets. :math:`A=B\Leftrightarrow \forall x\in A, x\in B\ \textrm{and}\ \forall x\in B, x\in A`. Universal quantifier.
* Subsets and proper subsets. Powerset. :math:`|\mathcal{P}(A)|=2^{|A|}`.
* Union. :math:`A\cup B = \{x|x\in A\ \textrm{or}\ x\in B\}`. Examples: if :math:`A=\{x|x \textrm{is a vowel}\}, B=\{x|x \textrm{is a consonant}\}`, then what is :math:`A\cup B`? If :math:`A=\{x|x \textrm{resident of IL}\}` and :math:`B=\{x|x \textrm{resident of WI}\}`, then describe :math:`A\cup B`.
* Intersection. :math:`A\cap B = \{x|x\in A\ \textrm{and}\ x\in B\}`. Examples. If :math:`A=\{x|x\ \textrm{actor in ST:TOS}\}` and :math:`B=\{x|x\ \textrm{actor in ST:TNG}\}`, what is :math:`A\cap B` (cross overs from TOS to TNG include Majel Barrett, Diana Muldaur, DeForest Kelley, Mark Lenard, Leonard Nimoy, and James Doohan).
* Venn diagrams.
* Cartesian product. :math:`A\times B`: set of all ordered pairs :math:`(x,y): x\in A\ \textrm{and}\ y\in B`. Focus on ordered pairs, :math:`(a,b) \neq (b,a)` and :math:`(a,b) = (c,d) \Leftrightarrow a=c\ \textrm{and}\ b=d`. Examples. :math:`F=\{\textrm{John},\ \textrm{Jane}\}`, :math:`L=\{\textrm{Smith},\ \textrm{Taylor}\}` then :math:`F\times L = \{\textrm{(John,Smith)},\ \textrm{(John,Taylor)},\ \textrm{(Jane,Smith)},\ \textrm{(Jane,Taylor)} \}`. Cardinality of a product :math:`|F\times L| = |F|\times |L|`; and in general: :math:`|A\times B\times C\times \ldots| = |A|\times |B|\times |C|\times \ldots`.
* Cartesian products as the basis of database queries; the join operation: combine seemingly irrelevant sets based on some common property.

Direct proofs
+++++++++++++

* Mathematical systems: axioms, definitions, undefined terms. Theorems, lemmas, corollaries. Examples.
* Direct proofs. 

.. math::

 \textrm{for all}\ x_1, x_2, \ldots, x_n,\ \textrm{if}\ p(x_1, x_2,\ldots, x_n)\ \textrm{then}\ q(x_1, x_2, \ldots, x_n)

* Focus on :math:`p\ \textrm{then}\ q`: we assume :math:`p` is true and we work our way to show that :math:`q` is true, using the mathematical systems' axioms, definitions, and already proven theorems.

Examples
........

* if :math:`m` is odd and :math:`n` is even then :math:`m+n` is odd. Here it is implied that we want to prove this for all :math:`n,m\in\mathbb{Z}`. Use *definition* of odd and even numbers. :math:`m=2k, n=2j+1` and see what happens when applying these into the expression we want to prove: :math:`m+n = 2k+2j+1 = 2(k+j)+1=2l+1` with :math:`l=k+j`; showing that :math:`n+m` is written in the form of an odd number definition (multiple of two plus 1).
 
* the sum of two odd integers is an even integer. Since :math:`a=2m+1` and :math:`a=2n+1`, their sum can be written as :math:`a+b = (2m+1) + (2n+1) = 2m+2n+2 = 2(m+n+1)`, i.e., a multiple of 2.

* If :math:`X\cap Y = X\cap Z` and :math:`X\cup Y = X\cup Z` then :math:`Y=Z`. (*Hint:* if :math:`Y=Z` then :math:`Y\subseteq Z` and :math:`Z\subseteq Y`).

* :math:`\mathcal{P}(A\cap B)= \mathcal{P}(A)\cap \mathcal{P}(B)`

* :math:`(A\cup B)\cup C = A\cup(B\cup C)`

* :math:`A\cap B =B\cap A`

* If :math:`|A\times B|=1`, what is :math:`|A|` and :math:`|B|`?
* If :math:`|A\times B|=\textit{prime}`, what is :math:`|A|` and :math:`|B|`?
* If :math:`|A\times B|=0`, what is :math:`|A|` and :math:`|B|`?
* If :math:`|A\times B|=n`, with :math:`n>1` and not a prime number, what is :math:`|A|` and :math:`|B|`?
* Prove that :math:`100\ldots1`, i.e., a number that begins and ends with 1 and has at least :math:`3n-1` zeros inbetween, with :math:`n>0`, is a composite number. A composite number is the product of other natural numbers, all greater than 1. *Hint:* :math:`x^3+y^3=(x+y)(x^2-xy+y^2)`.
* Show that if :math:`x_1, x_2` are distinct roots of the polynomial :math:`p(x) = x^2+bx+c`, then :math:`x_1+x_2=-b` and :math:`x_1 x_2=c`.
* If :math:`a` divides :math:`b` and :math:`a` divides :math:`c` then :math:`a` divides :math:`b+c`, where :math:`a,b,c\in\mathbb{N}_{>0}`. Remember that for :math:`x,y\in\mathbb{N}` and :math:`x>0`, we say that :math:`x` divides :math:`y` (and we write :math:`x\backslash y`), when :math:`\exists z\in\mathbb{N}: xz=y`.
* Prove that an integer divisible by 4 is the difference of two perfect squares.
* Prove that :math:`\forall x,y\in\mathbb{R}, x^2+y^2\geq 2xy`.
* Prove that the sum of two rational numbers is a rational number.
* Prove that if :math:`x_1, x_2, x_3` are three distinct roots of the polynomial :math:`p(x)= x^3+bx^2+cx+d` then :math:`x_1 x_2 + x_1 x_3 + x_2 x_3 = c`.

Proof by counterexample
.......................

The statement :math:`\forall n \in\mathbb{Z}^+: 2^n+1\ \textrm{is prime}`, can be proven wrong with just one counterexample: for :math:`n=3, 2^3+1 = 9` which is not a prime.

Common mistakes in proofs
.........................

Stoping short of a definition
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

Definitions are not negotiable! For example, an odd number is :math:`2n+1`, with :math:`n\in\mathbb{Z}`, i.e., a multiple of two plus 1. So if you arrive at the conclusion that some number equals :math:`2n+3` and you then state this is an odd number, you have not met the rigor of proof. Yes, :math:`2n+3` *looks* like an odd number. But within the mathematical system of integer numbers it is not proven to be odd until you can demonstrate that it's a multiple of two plus one, i.e., :math:`2n+3 = 2n+2+1=2(n+1)+1`.

Of course, in the interest of time you may end up with :math:`2n+5` and then simply state that "by further factorization, this is :math:`2k+1`". That's fine too, as long as you communicate that there is one more step needed, what it involves ("further factorization", in this example), and where it leads (:math:`2k+1`, the definition of an odd number). In such case, the further step that you narrate instead of executing, needs to be trivial. For example, further factorization of :math:`2n+5` leads to :math:`2(n+2)+1` and this is -- or should be -- obvious to everyone.

Symbology issues
,,,,,,,,,,,,,,,,

You are asked to prove that the sum of two odd numbers is an even number. You proceed in defining the odd numbers as:

.. math::

 a = 2n+1 \\
 b = 2n+1
 
thinking that because you use different symbols (:math:`a,b`), the two numbers are different. They are not. In fact :math:`a=b`. Yes, they are both odd. More precisely, they are the same odd number. You work through your proof finally concluding that :math:`a+b=2(2n+1)`. Great! You just proved that an odd number, multiplied be two, is an even number. But this is not the same as proving that *any two odd numbers* add to an even number. Therefore, you need to define your :math:`a` and  :math:`b` as different numbers, e.g.


.. math::

 a = 2n+1,\ \textit{or}\ a = 2n_a+1 \\
 b = 2m+1,\ \textit{or}\ b = 2n_b+1

In other words: do not hesitate to use different symbols. 

Attempts at proofs by miracle
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

Miraculous proofs are known to happen late at night or within seconds before an assignment deadline. Such proofs should be avoided at all cost as they are considered harmful to one's reputation and detrimental for a final grade.

.. figure:: images/miracle.jpg
   :figwidth: 350 px
   :width: 333 px
   :align: center
   
   (Cartoon by Sydney Harris; (C) 1977-2021. Used with the kind permission of the author.)




Attempts at proofs by brute force
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

Use of violence is often illegal, totally inappropriate, probably grounds for expulsion, and always unconvincing.

.. figure:: images/brute_force.jpg
   :figwidth: 350 px
   :width: 333 px
   :align: center
   
   (Cartoon by Sydney Harris; used with the kind permission of the author.)
   
Indirect proofs
+++++++++++++++

* The direct approach, if :math:`p` then :math:`q` does not always work.
* If :math:`n^2` is even, then :math:`n` is even too. Where to start? Writing :math:`n^2=2k` can takes us only as far as :math:`n=\sqrt{2k}`. We cannot tell if :math:`\sqrt{2k}` is a multiple of 2. Instead,  try: if :math:`(n^2:\textit{even}\Rightarrow n:\textit{odd})`.
* In general, :math:`h\Rightarrow c`. If no direct path from :math:`h` to :math:`c`, then *assume* :math:`h\Rightarrow \neg c`. Explore :math:`\neg c`. Can we go from :math:`\neg c` to :math:`h`? If not, the assumption was wrong therefore its opposite (the original statement) must be true.
* Example: :math:`n^2:\textit{odd}\Rightarrow n:\textit{odd}`. Identify :math:`h` and :math:`c` parts.
* Example: :math:`a,b\in\mathbb{Z}\Rightarrow a^2-4b\neq 2`. (Hint: 1 is not an even number).
* Example: There is a largest number. (:math:`L\geq x, \forall x\in\mathbb{R}`. Add :math:`L` to both sides of :math:`1>0`).
* Example: :math:`n^3+5:\textit{odd}\Rightarrow n:\textit{even}`.
* Example: :math:`\sqrt{2}\not\in\mathbb{Q}`.
* Example: :math:`x\in\mathbb{Q}, y\not\in\mathbb{Q} \Rightarrow (x+y)\not\in\mathbb{Q}`.
* Example: :math:`x\not\in\mathbb{Q}, m\in\mathbb{Z}\ \Rightarrow mx\not\in\mathbb{Q}`.
* Example: :math:`\forall x\in\mathbb{R}: x(1-x)\leq\dfrac{1}{4}`. (Counter example; simple).


Propositional logic
++++++++++++++++++++

* Definition of proposition: statement that can be proved to be true or false but not both.

 * Example: *Chicago is in Illinois*
 * Example: *This will be a great year*
 * Example: :math:`\pi` *is not an integer number*
 * Example: *Earth is round or Earth is flat*
 * Example: :math:`1+1=3`
 
* Notation: :math:`p:\textit{Chicago is in Illinois}`
* Notation: :math:`p:\textit{Earth is round}`, :math:`q:\textit{Earth is flat}`, together :math:`p\ \textit{or}\ q` and in full notation: :math:`p\vee q`.
* Notation: :math:`p:\textit{It's February}`, :math:`q:\textit{It is cold}`, together :math:`p\wedge q`.

* Truth tables

* More than two propositions
* The not operator :math:`\neg`, with examples :math:`\neg (\textit{Earth is flat})`.

* Conditional proposition: if :math:`p` then :math:`q`. Notation: :math:`p\rightarrow q`. Terminology: :math:`p` hypothesis, :math:`q` conclusion. (Antecendent and consequent).

 * Example: :math:`\textsf{You are born in Chicago}\rightarrow\textsf{You are from Illinois}`. 
 
 :math:`p:\textsf{You are born in Chicago}`
 
 :math:`q:\textsf{You are from Illinois}`
 
 :math:`p` can be true or false. :math:`q` can be true or false. Let's examine them.
 
Simple table:

===========================   =========================    =======================
  :math:`p`                   :math:`q`                    :math:`p\rightarrow q`
===========================   =========================    =======================
You are born in Chicago       You are from Illinois        True
You are born in Chicago       You are not from Illinois    False
You are not born in Chicago   You are from Illinois        True
You are not born in Chicago   You are not from Illinois    True
===========================   =========================    =======================

From simple logic functions to biconditional propositions
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

* AND, OR, NOT
* Combinations thereof: NAND, NOR
* The XOR function
* Sneak preview of logic gates
* Simple (half) adder
* Conditional proposition
* Necessary condition: a condition that does not guarantee an outcome, but without it the outcome cannot be achieved. E.g., a necessary condition to visit the Eiffel tower is to travel to France. (Another: win lotto, buy ticket).
* Sufficient condition: a condition that guarantees an outcome, even though the outcome is still possible without the condition. A sufficient condition that you traveled to France is that you've been to the Eiffel tower.
* Biconditional (truth table: TFFT) :math:`p\Leftrightarrow q: (p\rightarrow q)\wedge (q\rightarrow p)`. Example: :math:`x^2-x-12=0 \Leftrightarrow x=-3\ \text{or}\ x=4`
* De Morgan's Laws. Augustus De Morgan, 19th c. Brit. math.


.. math::

 \neg (p\vee q) &\equiv \neg p \wedge \neg q \\
 \neg (p\wedge q) &\equiv \neg p \vee \neg q

* Java: ``(x<10 || x>20)`` :math:`\equiv` ``!(x>=10 && x <= 20)``

* Quantifiers: universal :math:`\forall`; existential :math:`\exists`.

 * :math:`p: n\ \text{is an odd number}`. We cannot tell is :math:`p` is T/F without knowing :math:`n`, so as it stands, :math:`p` is not a proposition. But :math:`\forall n\in\mathbb{Z}, p(n)` can be true or false, hence :math:`p(n)`, as universaly quantified, is a proposition. In this case :math:`\mathbb{Z}` is the *domain of discourse*. To prove :math:`\forall x P(x)` we must show :math:`P` is true for *every* :math:`x`.
 
 * Existentially quantified statement: :math:`\exists x P(x)`, provable as long as we find at least one :math:`x` that satisfied :math:`P(x)`. Example: :math:`\exists x (\dfrac{x}{x^2+1}=\dfrac{2}{5})`, with :math:`x\in\mathbb{R}`

Binary relations (BR)
+++++++++++++++++++++

* BR describe how elements from one set relate to elements of another set (or the set itself)
* :math:`R: X\mapsto Y: R\subset X\times Y`.
* If :math:`(x,y)\in R` we write :math:`x\ R\ y`, i.e., :math:`x` is related to :math:`y`. 
* :math:`X` is called the domain of :math:`R`. :math:`Y` is the codomain. (Set of departure and set of destination, respectively).
* Infix notation: :math:`(x,y)\in R\equiv x\ R\ y`. Here, :math:`R` can be replaced with a symbol operationalizing the relation, e.g., if :math:`R` is the equality over elements of :math:`X`, then :math:`(x,y)\in R \equiv x=y`.
* Digraphs for :math:`R:X\mapsto X`: vertices, directed edges, loops.
* :math:`R: X\mapsto X` is reflexive if :math:`(x,x)\in R, \forall x\in X`. Examples of reflexive relations: :math:`\forall x\in\mathbb{Z}, x=x`; :math:`\forall x\in\mathbb{R}, x\geq x`; etc. Non reflexive relations: :math:`x>x`(NB: loop terminating condition); :math:`x\neq x`. Worth noting that :math:`xy:\textrm{even}` is reflexive in :math:`\mathbb{Z}_{\textrm{even}}` and irreflexive in :math:`\mathbb{Z}_{\textrm{odd}}`.
* :math:`R: X\mapsto X` is symmetric if :math:`\forall x,y \in X`, if :math:`(x,y)\in R` then :math:`(y,x)\in R`. Examples of symmetric relations: :math:`\forall x,y\in\mathbb{R}: x=y\Leftrightarrow y=x`; :math:`R=\textrm{sibling of}: x\ R\ y\Leftrightarrow y\ R\ x`. Example of non symmetric relation: :math:`R=\textrm{student of}: x\ R\ y\not\Leftrightarrow y\ R\ x`.  Special case, :math:`R=\textrm{student of Leo}: x\ R\ y\Leftrightarrow y\ R\ x` (I am learning from each and every one of my students).
* :math:`R: X\mapsto X` is antisymmetric if :math:`\forall x,y\in X`, if :math:`(x,y)\in R` and :math:`(y,x)\in R` then :math:`x=y`. Example :math:`\forall x,y\in\mathbb{Z}`, if :math:`x\setminus y` and :math:`y\setminus x` then :math:`x=y` (illustrate with :math:`9\setminus 3` true but :math:`3\setminus 9` not true. Only :math:`9\setminus 9` is true; also :math:`3\setminus 3`). Notice that if :math:`x\leq y` and :math:`y\leq x` then :math:`x=y`. So the relation :math:`\leq` is antisymmetric. 
* Alternative notation for antisymmetric relation: if :math:`x\neq y` then :math:`(x,y)\not\in R` or :math:`(y,x)\not\in R`. 
* Show that a relationship can be both symmetric and antisymmetric. :math:`A=\{1,2\}`; :math:`A\times A = \{(1,1), (1,2), (2,1), (2,2)\}`; :math:`R=\{(1,1), (2,2)\}`; :math:`R\subset A\times A`; :math:`R` is symmetric, because for every :math:`(x,y)\in R`, :math:`(y,x)` also in :math:`R`. The relation is also antisymmetric because :math:`(x,y)\in R` and :math:`(y,x)\in R` are satisfied only when :math:`x=y`.
* :math:`R: X\mapsto X` is transitive if :math:`\forall x,y,z\in X`, if :math:`(x,y)\in R` and :math:`(y,z)\in R` then :math:`(x,z)\in R`. Example: the :math:`>` operation. If :math:`x>y` and :math:`y>z` then :math:`x>z`. Also, if Dayton, Ohio is east of Chicago, Ill., and Chicago, Ill. is east of Denver, Colo., then Dayton is east of Denver. If :math:`a\setminus b` and :math:`b\setminus c` then :math:`a\setminus c`.
* A reflexive, antisymmetric, and transitive relation is called *a partial order*.
* If :math:`R:X\mapsto Y`, the inverse relation :math:`R^{-1}:Y\mapsto X` is defined as :math:`R^{-1}=\{(y,x)| (x,y)\in R\}`.
* Injective relation: :math:`\forall x,z\in X`, and :math:`\forall y\in Y`, if :math:`xRy` and :math:`zRy`, then :math:`x=z` and :math:`Y` is called the *primary key* of :math:`R`. Example: student ID in registration records. Mathemagical examples: :math:`y=x` (linear function); :math:`x=y^2` (square root).
* Functional relation: :math:`\forall x\in X` and :math:`\forall y,z\in Y` if :math:`xRy` and :math:`xRz` then :math:`y=z`. :math:`X` is a primary key for :math:`R`. Example :math:`y=x` (again!); also :math:`y=x^2`.


+----------------+---------------+-------------------+
|                | injective     | not injective     |
+----------------+---------------+-------------------+
| functional     | one-to-one    | many-to-one       |
|                +---------------+-------------------+
|                | :math:`y=x`   | :math:`y=x^2`     |
+----------------+---------------+-------------------+
| not functional | one-to-many   | many to many      |
|                +---------------+-------------------+
|                | :math:`x=y^2` | :math:`x^2+y^2=1` |
+----------------+---------------+-------------------+

Induction
+++++++++
* Peano's axioms: 0 is a natural number; :math:`x=x` (equality reflexive); :math:`x=y\Rightarrow y=x` (symmetry of equality); :math:`x=y` and :math:`y=z` then :math:`x=z` (equality is transitive); if :math:`a\in\mathbb{N}` and :math:`a=b` then :math:`b\in\mathbb{N}` (closed under equality); :math:`\forall n\in\mathbb{N}, S(n)\in\mathbb{N}` (closure under :math:`S`);  :math:`\forall m,n\in\mathbb{N}`, if :math:`S(n)=S(m)` then :math:`n=m` (:math:`S` is injective); :math:`\not\exists n\in\mathbb{N}: S(n)=0`; if :math:`K` is a set such that :math:`0\in K` and :math:`\forall n\in\mathbb{N}: n\in K\Rightarrow S(n)\in\mathbb{K}` then :math:`K=\mathbb{N}` (induction).
* Climb-the-ladder analogy (Knuth).
* Traffic light analogy (unknown).
* Everyone's favorite example: :math:`1+2+\ldots+n = n(n+1)/2`.
* Any postage :math:`\geq` $0.12 with $0.05 and $0.04 stamps.
* Sum of odd numbers: :math:`1+3+\ldots + (2n-1) = n^2`.
* :math:`5|6^n-1`
* :math:`5|11^n-6`
* :math:`1^2+2^2+3^2+\ldots +n^2 = n(n+1)(2n+1)/6`
* :math:`n=3x+5y, n\geq 8`
* :math:`12|(n^4-n^2)`
* :math:`1+2+4+\ldots +2^n = 2^{n+1}-1`
* :math:`(1+x)^n\geq 1+nx`.
