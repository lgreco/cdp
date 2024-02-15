A *set* is a collection of distinct objects. For example the colors *red, green,* and *blue*, together form the set :math:`C=\{\text{red},\text{green},\text{blue}\}`. A set can also be defined in *set-builder* notation:

.. math::

   B = \{ x|x^2-4=0\}

The notation above means that :math:`B` is a set with two elements only: :math:`\{-2,2\}`.

Sets can also be denoted by pattern, e.g., :math:`A=\{1,3,5,\ldots, 1001\}` implies a set of odd numbers from  1 to 1001.

A very important property of a set is its *cardinality*. The cardinality is the size of the set, a number that tells us how many elements are in the set. For the sets in the previous examples, the cardinalities are:

.. math::

   |C|&=3 \\
   |B|&=2 \\
   |A|&=501
   
Sets exhibit two interesting behaviors: first, order is irrelevant. For example, :math:`\{1,2\}` is the same set as :math:`\{2,1\}`. And second, duplicate elements count only once. For example, :math:`\{1,2,2,2,2\}` and :math:`\{1,1,2\}` have the same number of elements, i.e., their cardinality is 2. And they are also equal sets because they have identical elements.

A set may be contained in another set. For example, set :math:`D` below is contained in set :math:`E`:

.. math::

   D &= \{0,1\} \\
   E &= \{0,1,2,3,4\}

When this happens, we say that :math:`D` is a subset of :math:`E`. The notation is :math:`D\subset E`. Conversely, :math:`E` is a superset of :math:`D`, i.e., :math:`E\supset D`.

Sets are fundamental constructs that affect every branch of mathematics and science. In computer science, sets are of particular interest because they form the mathematical foundation for relational databases. Since the 1980s, these databases are the dominant paradigm for collecting, organizing, and processing information.



Set operations
++++++++++++++

We looked at three set operations that can be very useful in the context of data analysis.

Set union
---------

The union of two sets is a set that contains all their elements. For example, if :math:`S=\{1,3,5\}` and :math:`T=\{2,4\}`, their union :math:`S\cup T` is the set :math:`\{1,2,3,4,5\}`. Here, :math:`\cup` is the union operator.

Set intersection
----------------

The intersection of two sets is a set that contains only the elements that are common to both sets. For example, if :math:`V=\{0,1,2,3,4\}` and :math:`X=\{0,1\}`, their intersection :math:`V\cap X` is the set :math:`\{0,1\}`.

Cartesian product
-----------------

The Cartesian product of two sets is a set that contains ordered pairs of all combinations of elements from the first set with elements of the second set. For example, if :math:`Y=\{a,b\}` and :math:`Z=\{c,d\}`, their Cartesian product is:

.. math::
   Y\times Z = \{ (a,c), (a,d), (b,c), (b,d) \}
   
Cartesian products contain ordered pairs (in case of a two sets product) or ordered tuples (in case of a three or more sets product). An ordered pair is a collection of two items whose order is significant, i.e., the pair :math:`(a,b)` is not the same as the pair :math:`(b,a)`. 

Cardinalities for union, intersection, and Cartesian product
------------------------------------------------------------

Given two sets :math:`R` and :math:`W`, the following rule (known as the *inclusion-exclusion* principle) applies:

.. math::
   |R\cup W| = |R| + |W| - |R\cap W|
   
The cardinality of their (Cartesian) product is: :math:`|R\times W|=|R|\cdot |W|`.

Operations with three or more sets
----------------------------------

The operations above can be generalized to three or more sets. For example, :math:`A\cup B\cup C` is the union of three sets, i.e., a set that contains all the elements of sets :math:`A, B` and :math:`C`. Similarly, :math:`A\cap B\cap C` is the set that contains only elements that are common on all three sets. And :math:`A\times B\times C` is a set that contains ordered triplets with all possible combinations of elements from :math:`A`, with elements from :math:`B`, with elements from :math:`C`. For example, if

.. math::

   A & = \{i,j\} \\
   B & = \{m,n\} \\
   C & = \{x,y\} \\

then

.. math::

   A\times B\times C = \{ &(i,m,x), (i,m,y), \\
                          &(i,n,x), (i,n,y), \\
						  &(j,m,x), (j,m,y), \\
						  &(j,n,x), (j,n,y) \}
						  
						  
In general we can expect that :math:`A\times B\times C = (A\times B)\times C = A\times (B\times C)`; :math:`A\cup B\cup C=(A\cup B)\cup C=A\cup (B\cup C)`, etc.