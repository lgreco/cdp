
Proofs
======

Proofs have been an central element of our civilization for thousands of years. In Odyssey, Homer gives us proof of Ulysses identity when he describes how he is recognized by his aged, faithful dog. In Bible, the resurrected Christ allows Thomas to touch his wounds, leading to the first acclamation of Jesus as God (John 20:24–29). In the Lord of the Rings, Aragorn's rightful claim to the thrones of Arnor and Gondor is established by the Ring of Barahir and his wielding of the Andúril sword. In fiction and scripture, proofs have been used to establish veracity of deeds and royal or divine status. Proofs satisfy our doubts and skepticism and give meaning to faith and theory alike.

In mathematics, proofs are arguments that establish the truthfulness of various statements. These arguments are based on the building blocks of mathematical systems: axioms, definitions, and theorems.

Direct proofs
-------------

This is the easiest kind of proofs, relatively speaking.
In direct proofs we usually have a statement of the form: 

.. math::
   
   p\ \text{implies}\ q
   
The approach we take is to look at axioms, definitions, and theorems available to us based on :math:`p` and find the right transformations to arrive to :math:`q`. For example, let's consider

.. math::
   
   p=\text{if}\ n\ \text{is odd}
   
and

.. math::
   
   q=n^2\ \text{is odd}

In this example, if :math:`n` is odd then :math:`n=2x+1` and by squaring both sides, 

.. math::
   n^2&=(2x+1)^2\\ &=4x^2+4x+1\\ &=2(2x^2+2x)+1\\ &= 2z+1

where :math:`z=2x^2+2x`. So we showed that :math:`n^2=2z+1` which is an odd number.   


Sum of two odd numbers is an even number
++++++++++++++++++++++++++++++++++++++++

Another example of a direct proof is to show that if two numbers are odd, their sum is an even number, i.e.,

.. math::
   \text{if}\ m,n\ \text{odd} \Rightarrow m+n\ \text{even}
   
The proof is quite straight forward: if :math:`m` is odd then :math:`m=2x+1`, i.e. it is, by definition, a multiple of 2 (:math:`2x`) plus one. Similarly, :math:`n=2y+1`; where :math:`x\ \text{and}\ y` are arbitrary integer numbers. Adding them together:

.. math::
   \left.\begin{array}{c}m=2x+1\\n=2y+1\end{array}\right\} \Rightarrow m+n &= 2x+2y+2\\ &= 2(x+y+1)\\ &= 2k

with :math:`k=x+y+1`. Thus we showed that the sum of two odd numbers is a multiple of 2, which by definition is an even number.

The product of odd and even numbers is an even number
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Another direct proof is to show that the product of an odd and an even number is an even number. Assuming :math:`m=2x+1` (the odd number) and :math:`n=2y` (the even number), their product :math:`mn` is:

.. math:: 
   mn = (2x+1)2y = 4xy+2y = 2(2xy+y)
   
In other words, :math:`mn` is a multiple of 2, therefore an even number.

The square of an even number is an even number
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Can show that if :math:`n` is even, then :math:`n^2` is also even? An even number is a multiple of 2, so we can write :math:`n=2x`. Squaring both sides gives us :math:`n^2=4x^2=2(2x^2)=2z`, where :math:`z=2x^2`. By showing that :math:`n^2=2z` we have proved that :math:`n^2` is even.


Proofs by contradiction
-----------------------

Some times, a direct proof may not be possible. For example, can we prove that if :math:`n^2` is even then :math:`n` is also even? Trying a direct proof we can write:

.. math::

   n^2=2x \Rightarrow n=\sqrt{2x}

There is no way to tell if :math:`\sqrt{2x}` is an odd or even number. Clearly, a direct proof approach does not work in this case. What if we took a different approach and assumed that if  :math:`n^2` is even then :math:`n` is **odd?** If :math:`n` is odd, then :math:`n=2x+1`. And by squaring both sizes of the equation, 

.. math::
 
   n^2&=(2x+1)^2\\ &=4x^2+4x+1\\ &=2(2x^2+2x)+1\\ &=2z+1

with :math:`z=2x^2+2x`. Therefore :math:`n^2` is an odd number though our initial assumption is that :math:`n^2` is even. By assuming the opposite conclusion of the statement we tried to prove, we reach a contradiction and that allows us to conclude that the initial statement was actually true.

In general, a proof by contradiction works when a statement of the form

.. math::

   h\ \Rightarrow \  c

cannot be proved directly; here :math:`h` and :math:`c` are the hypothesis and conclusion parts of the statement and ":math:`\Rightarrow`" means "implies". In this case, the proof by contradiction can be established as follows.

First, we assume that the opposite conclusion is true, i.e., that :math:`h\Rightarrow\neg c` is true. Remember, ":math:`\neg`" is the negation operator and therefore :math:`\neg c` is the opposite of :math:`c`. 

Next, given that we accept :math:`h\Rightarrow\neg c` as true, we can now focus on its conclusion and test if we can derive :math:`h` from :math:`\neg c`. In other words, given that :math:`h\Rightarrow\neg c` is true can we show that :math:`\neg c\Rightarrow h`? Attempting to do so will yield a result other than :math:`h`. Therefore the assumption :math:`h\Rightarrow\neg c` that allowed us to test if  :math:`\neg c\Rightarrow h`, is false. If :math:`h\Rightarrow\neg c` is false, then :math:`h\Rightarrow c` must be true. And that concludes our proof!

To illustrate this method, let's look at the earlier example:

.. math::

   h&:\ n^2\ \text{even} \\
   c&:\ n\ \text{even} \\
   \text{prove}&:\ h\Rightarrow c \\
   \text{no direct proof available;}\\
   \text{trying contradiction}\\
   \text{assume true}&:\ h\Rightarrow\neg c \\
   \neg c&:\ n\ \text{not even, i.e.,}\ n\ \text{odd} \\
   h\Rightarrow\neg c&:\ \text{if}\ n^2\ \text{even}\Rightarrow n\ \text{odd} \\
   n&=2x+1 \\
   n^2&=(2x+1)^2 \\
   &=4x^2+4x+1\\
   &=2(2x^2+2x)+1 \\
   &=2z+1,\ (\text{where}\ z=2x^2+2x\\
   n^2&:\ \text{odd}\\
   \text{but}&:\ \text{we assumed}\ h\ (n^2\ \text{even})\\
   
Example: if :math:`n^2` is odd then :math:`n` is odd
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

If we tried direct proof here, we'll end with the expression :math:`n=\sqrt{2x+1}` which is of inconclusive parity. Therefore, a proof by contradiction may be a better strategy. Our hypothesis is :math:`h:\ n^2\ \text{odd}`. Our conclusion is :math:`c:\ n\ \text{odd}`. And since we cannot prove directly :math:`h\Rightarrow c`, we will assume that :math:`h\Rightarrow\neg c` is true. Given this assumption, :math:`n` is odd and therefore :math:`n=2x`. Squaring both sides of the equation:

.. math::

   n^2&=4x^2 \\
   &= 2(2x^2) \\
   &= 2z,\ (\text{where}\ z=2x^2)
   
Therefore :math:`n^2` is an even number contrary to the assumed truthfulness of :math:`h\Rightarrow\neg c`. Our assumption :math:`h\Rightarrow\neg c` is false, leading to the conclusion that :math:`h\Rightarrow c` is true. In other words,  if :math:`n^2` is odd then :math:`n` is also odd.

Example: if :math:`a,b \in \mathbb{Z}` then :math:`a^2-4b\neq 2` 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

The hypothesis here is :math:`h:\ a,b \in \mathbb{Z}`. And the conclusion is :math:`c:\ a^2-4b\neq 2`. There is no direct way to show :math:`h\Rightarrow c`, and it would seem that a proof by contradiction is the preferred strategy. We begin by assuming that :math:`h\Rightarrow\neg c` is true, i.e., there are integer numbers :math:`a,b` such that :math:`a^2-4b=2`. Given that, we can write:

.. math::

   a^2-4b&=2 \\
   a^2&=4b+2 \\
   &2(2b+1)
   
From the above we can tell that :math:`a^2` is even and therefore :math:`a` is also even and thus can be written as a multiple of 2: :math:`a=2x` and substituting this in the original expression:

.. math::

 a^2-4b &= 2 \\
 (2x)^2-4b &= 2 \\
 4x^2-4b &= 2 \\
 2x^2-2b &= 1 \\
 2(x^2-b) &= 1\\
 2z &=1,\ (\text{where}\ z=x^2-b)

We just concluded that :math:`1` is an even number! That's because the assumption that led us to this astonishing conclusion is false. The assumption was that there are integer numbers :math:`a,b` such that :math:`a^2-4b=2`. This assumption is false which means that there are no integers :math:`a,b` such that  :math:`a^2-4b=2`. Therefore, the original statement :math:`a,b \in \mathbb{Z}\Rightarrow a^2-4b\neq 2`, is true.

Example: there is no largest number 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Let's suppose that there is a largest number, :math:`L`, such that :math:`L\geq x,\ \forall x`. Given that :math:`1>0`, we can add :math:`L` to both sides, resulting to :math:`L+1 > L` which cannot be true, because we assumed that :math:`L` is the greatest number, and we just showed that it's less than :math:`L+1`.