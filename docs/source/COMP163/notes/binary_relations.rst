:orphan:

Binary relations
================

A binary relation is a set that describes how two other sets relate to each other. For example, consider the following two sets with a few upper and lower case letters.


.. math::

   \mathcal{U} &= \{ A, D, G, K, S\}\ \textrm{and}\\
   \mathcal{L} &= \{ a, b, g, j, k\}
   
Their cartesian produce is the set


.. math::

  \mathcal{U} \times \mathcal{L} = \{
  &(A,a),\ &(A,b),\ &(A,g),\ &(A,j),\ &(A,k), \\
  &(D,a),\ &(D,b),\ &(D,g),\ &(D,j),\ &(D,k), \\
  &(G,a),\ &(G,b),\ &(G,g),\ &(G,j),\ &(G,k), \\
  &(K,a),\ &(K,b),\ &(K,g),\ &(K,j),\ &(K,k), \\
  &(S,a),\ &(S,b),\ &(S,g),\ &(S,j),\ &(S,k)  
  \}
  
An interesting subset of :math:`\mathcal{U} \times \mathcal{L}` above is the set


.. math::

 R = \{ (A,a), (G,g), (K,k)\}
 
How can we describe this set :math:`R`? One suitable description is: *the pairs of upper and lower cases for letters in set* :math:`\mathcal{U}` *and set* :math:`\mathcal{L}`. In other words, :math:`R` **embodies the relation** that matches an upper case letter in set :math:`\mathcal{U}` with its corresponding letter in set :math:`\mathcal{L}`. 

We notice that since :math:`R \subset (\mathcal{U} \times \mathcal{L})`, the cardinality of :math:`R` is less than the cardinality of the product, ie, :math:`|R| < |\mathcal{U} \times \mathcal{L}|`. In some way, a relationship between two sets looks at their Cartesian product (which can be a very large set) and finds smaller, more meaningful sets. Let's illustrate this with a practical example.

We'll consider two sets of ordered pairs. First a set with a few students and their ID numbers. 

.. math::

 S = \{\ 
 ( 1001,\ &\textrm{Frodo}), \\
 ( 1002,\ &\textrm{Galadriel}), \\
 ( 1003,\ &\textrm{Legolas})\ 
 \}
 
And second a set of courses with their course codes.

.. math::

 C = \{\ 
 ( \textrm{COMP 163},\ &\textrm{Discrete Mathemagics}), \\
 ( \textrm{COMP 271},\ &\textrm{Data Scriptures}), \\
 ( \textrm{COMP 363},\ &\textrm{Algorunes})\ 
 \}

The Cartesian produce of these two sets will have 9 elements, as follows:

.. math::

 S\times C = \{\ 
 (\ ( 1001,\ &\textrm{Frodo}),\ &( \textrm{COMP 163},\ &\textrm{Discrete Mathemagics})\ ), \\
 (\ ( 1001,\ &\textrm{Frodo}),\ &( \textrm{COMP 271},\ &\textrm{Data Scriptures})\ ), \\
 (\ ( 1001,\ &\textrm{Frodo}),\ &( \textrm{COMP 363},\ &\textrm{Algorunes})\ ), \\
 (\ ( 1002,\ &\textrm{Galadriel}),\ &( \textrm{COMP 163},\ &\textrm{Discrete Mathemagics})\ ), \\
 (\ ( 1002,\ &\textrm{Galadriel}),\ &( \textrm{COMP 271},\ &\textrm{Data Scriptures})\ ), \\
 (\ ( 1002,\ &\textrm{Galadriel}),\ &( \textrm{COMP 363},\ &\textrm{Algorunes})\ ), \\
 (\ ( 1003,\ &\textrm{Legolas}),\ &( \textrm{COMP 163},\ &\textrm{Discrete Mathemagics})\ ), \\
 (\ ( 1003,\ &\textrm{Legolas}),\ &( \textrm{COMP 271},\ &\textrm{Data Scriptures})\ ), \\
 (\ ( 1003,\ &\textrm{Legolas}),\ &( \textrm{COMP 363},\ &\textrm{Algorunes})\ ) \ 
 \}
 
In the example above we have only 3 students and only 3 courses, and their Cartesian product is becoming unwieldy. Imagine a Cartesian product when you have 10,000 students and 2,000 courses. Things become more cumbersone when we throw in more details, e.g., in addition to student IDs and names we also track date of birth, gender, phone number, etc. The Cartesian product of such large sets, unmanageable in size as it becomes, contains some valuable information that we may wish to isolate and examine. What if we knew that Frodo is taking *Data Scriptures* this term, Galadriel is in *Discrete Mathemagics*  and *Algorunes*, and Legolas is sitting this term out, helping his family's forestry business. This information is contained in a subset of :math:`S\times C`:

.. math::

  R = \{\ 
 (\ ( 1001,\ &\textrm{Frodo}),\ &( \textrm{COMP 271},\ &\textrm{Data Scriptures})\ ), \\
 (\ ( 1002,\ &\textrm{Galadriel}),\ &( \textrm{COMP 163},\ &\textrm{Discrete Mathemagics})\ ), \\
 (\ ( 1002,\ &\textrm{Galadriel}),\ &( \textrm{COMP 363},\ &\textrm{Algorunes})\ ) \ 
 \}

Set :math:`R` above embodies a very useful relationship: the students enrolled in this term's courses. We can write, a bit more formally,

.. math::

 R = \{
 (s,c)\ |\ s\in S, c\in C,\ \textrm{and}\ s\ \textrm{enrolled in}\ c\ \textrm{this term}
 \}

Or a little less formally, :math:`(s\ R\ c)` which reads ":math:`s` relates to :math:`c`". In plain language, this particular relation beween elements of the set :math:`S` and the set :math:`C` is called *course registration*. And if we can guarantee that each student ID is unique and that each course code is also unique, we can compact :math:`R` as follows:

.. math::

  R = \{\ 
 (\ &( 1001),\ &( \textrm{COMP 271})\ ), \\
 (\ &( 1002)\ &( \textrm{COMP 163})\ ), \\
 (\ &( 1002),\ &( \textrm{COMP 363})\ ) \ 
 \}

With the guarantee of unique student IDs and course codes, the set :math:`R` becomes a pillar of data management and engineering. In database parlance, :math:`R` is now a *transaction* between student and course records.

The simplicity of :math:`R`'s compacted form is elusive. It contains everything we need to know without repeating extraneous data (such as duplicating student names or course titles). Admittedly, the contents are not easy to ready. For example :math:`R`'s element :math:`(( 1002)\ ( \textrm{COMP 163})\)` means that the student whose ID is ``1002`` is enrolled in a course whose code is ``COMP 163``. But who is this student and what is that course? To obtain that information, we need to go over the set :math:`S`, find the element whose ID component is ``1002`` and retrieve the student name. Similarly, for the course title, we need to look in set :math:`C`, first the entry with code ``COMP 163`` and retrieve the title.

Thankfully we have a language to perform such queries.

.. code-block:: sql

   SELECT S.studentName, C.courseTitle
   FROM S, C, R
   WHERE S.ID = R.ID
     AND R.courseCode = C.courseCode
     AND R.ID = 1002
     AND C.courseCode = 'COMP 163'

The output of the query above would be ``Galadriel Discrete Mathemagics``.