
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
   \text{if}\ m,n\ \text{odd} \rightarrow m+n\ \text{even}
   
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

   n^2=2x \rightarrow n=\sqrt{2x}

There is no way to tell if :math:`\sqrt{2x}` is an odd or even number. Clearly, a direct proof approach does not work in this case. What if we took a different approach and assumed that if  :math:`n^2` is even then :math:`n` is **odd?** If :math:`n` is odd, then :math:`n=2x+1`. And by squaring both sizes of the equation, 

.. math::
 
   n^2&=(2x+1)^2\\ &=4x^2+4x+1\\ &=2(2x^2+2x)+1\\ &=2z+1

with :math:`z=2x^2+2x`. Therefore :math:`n^2` is an odd number though our initial assumption is that :math:`n^2` is even. By assuming the opposite conclusion of the statement we tried to prove, we reach a contradiction and that allows us to conclude that the initial statement was actually true.

In general, a proof by contradiction works when a statement of the form

.. math::

   h\ \rightarrow \  c

cannot be proved directly; here :math:`h` and :math:`c` are the hypothesis and conclusion parts of the statement and ":math:`\rightarrow`" means "implies". In this case, the proof by contradiction can be established as follows.

First, we assume that the opposite conclusion is true, i.e., that :math:`h\rightarrow\neg c` is true. Remember, ":math:`\neg`" is the negation operator and therefore :math:`\neg c` is the opposite of :math:`c`. 

Next, given that we accept :math:`h\rightarrow\neg c` as true, we can now focus on its conclusion and test if we can derive :math:`h` from :math:`\neg c`. In other words, given that :math:`h\rightarrow\neg c` is true can we show that :math:`\neg c\rightarrow h`? Attempting to do so will yield a result other than :math:`h`. Therefore the assumption :math:`h\rightarrow\neg c` that allowed us to test if  :math:`\neg c\rightarrow h`, is false. If :math:`h\rightarrow\neg c` is false, then :math:`h\rightarrow c` must be true. And that concludes our proof!

To illustrate this method, let's look at the earlier example:

.. math::

   h&:\ n^2\ \text{even} \\
   c&:\ n\ \text{even} \\
   \text{prove}&:\ h\rightarrow c \\
   \text{no direct proof available;}\\
   \text{trying contradiction}\\
   \text{assume true}&:\ h\rightarrow\neg c \\
   \neg c&:\ n\ \text{not even, i.e.,}\ n\ \text{odd} \\
   h\rightarrow\neg c&:\ \text{if}\ n^2\ \text{even}\rightarrow n\ \text{odd} \\
   n&=2x+1 \\
   n^2&=(2x+1)^2 \\
   &=4x^2+4x+1\\
   &=2(2x^2+2x)+1 \\
   &=2z+1,\ (\text{where}\ z=2x^2+2x\\
   n^2&:\ \text{odd}\\
   \text{but}&:\ \text{we assumed}\ h\ (n^2\ \text{even})\\
   
Example: if :math:`n^2` is odd then :math:`n` is odd
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

If we tried direct proof here, we'll end with the expression :math:`n=\sqrt{2x+1}` which is of inconclusive parity. Therefore, a proof by contradiction may be a better strategy. Our hypothesis is :math:`h:\ n^2\ \text{odd}`. Our conclusion is :math:`c:\ n\ \text{odd}`. And since we cannot prove directly :math:`h\rightarrow c`, we will assume that :math:`h\rightarrow\neg c` is true. Given this assumption, :math:`n` is odd and therefore :math:`n=2x`. Squaring both sides of the equation:

.. math::

   n^2&=4x^2 \\
   &= 2(2x^2) \\
   &= 2z,\ (\text{where}\ z=2x^2)
   
Therefore :math:`n^2` is an even number contrary to the assumed truthfulness of :math:`h\rightarrow\neg c`. Our assumption :math:`h\rightarrow\neg c` is false, leading to the conclusion that :math:`h\rightarrow c` is true. In other words,  if :math:`n^2` is odd then :math:`n` is also odd.

Example: if :math:`a,b \in \mathbb{Z}` then :math:`a^2-4b\neq 2` 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

The hypothesis here is :math:`h:\ a,b \in \mathbb{Z}`. And the conclusion is :math:`c:\ a^2-4b\neq 2`. There is no direct way to show :math:`h\rightarrow c`, and it would seem that a proof by contradiction is the preferred strategy. We begin by assuming that :math:`h\rightarrow\neg c` is true, i.e., there are integer numbers :math:`a,b` such that :math:`a^2-4b=2`. Given that, we can write:

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

We just concluded that :math:`1` is an even number! That's because the assumption that led us to this astonishing conclusion is false. The assumption was that there are integer numbers :math:`a,b` such that :math:`a^2-4b=2`. This assumption is false which means that there are no integers :math:`a,b` such that  :math:`a^2-4b=2`. Therefore, the original statement :math:`a,b \in \mathbb{Z}\rightarrow a^2-4b\neq 2`, is true.

Example: there is no largest number 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Let's suppose that there is a largest number, :math:`L`, such that :math:`L\geq x,\ \forall x`. Given that :math:`1>0`, we can add :math:`L` to both sides, resulting to :math:`L+1 > L` which cannot be true, because we assumed that :math:`L` is the greatest number, and we just showed that it's less than :math:`L+1`.

Step-by-step template for proofs by contradiction
+++++++++++++++++++++++++++++++++++++++++++++++++

Given a theorem in the form :math:`h\rightarrow c`, where :math:`h` is a hypothesis and :math:`c` a conclusion, that cannot be proven directly, proof by contradiction may be our next best bet.

.. figure:: ./images/seattle_nyc.png
   :align: right
   :figwidth: 33%

   A road sign as a metaphor for proof by contradiction.
   
To illustrate proof by contradiction, consider this scenario. While driving to Seattle, you come to the road sign shown to the right. You decide to check if the sign is correct but in an indirect way: you turn right. After several hours, you arrive to New York City. The sign was correct: Seattle was to the left.

The theorem to prove is:


.. math::

 \textsf{get to Seattle}\rightarrow\textsf{make left turn}
 
You made the assumption that you can still get to Seattle by making the opposite of a left turn (i.e., a right turn). You assumed, in other words, that the following theorem is correct:

.. math::

 \textsf{get to Seattle}&\rightarrow&\ \textit{not}\ \textsf{make left turn}, \ \textsf{i.e.,}\\
 \textsf{get to Seattle}&\rightarrow&\ \textsf{make}\ \textit{right}\  \textsf{turn}
 
Accepting this as true, you turn right and drive until you reach NYC. Evidently, the right-turn theorem is wrong. Therefore, the left-turn theorem is the correct one.

The most important *first* step
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

When trying to prove a theorem, the first thing to do is to identify the hypothesis and the conclusion propositions. Theorems are often stated as 

.. math::

 \textit{if}\ h\ \textit{then}\ c
 
So, finding the :math:`h` and :math:`c` propositions can be done with relative ease. 

Formulate the contradicting condition
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

Using the hypothesis :math:`h` and conclusion :math:`c` from the previous step, write the contradicting condition:


.. math::

 \textit{if}\ h\ \textit{then not}\ c
 
Let's resume using mathematical notation and write the contradicting condition as :math:`h\rightarrow\neg c`.

Accept the contradicting condition as true
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

State the assumption that :math:`h\rightarrow\neg c` is true. You need to write this statement both for your benefit and also for the benefit of those reading your proof. This statement is a "contract" with yourself. You have to believe that the contradicting condition is true until you can *prove* that it is not.

Work the :math:`\neg c`
,,,,,,,,,,,,,,,,,,,,,,,

Much like you started driving after turning right earlier and kept driving until you arrived to a place other than Seattle, you need to work on :math:`\neg c` will take you. If the first step is the most important, this step is the most difficult. With practice and experience you develop intuition on the direction that you can take the :math:`\neg c`.

Examples
++++++++

Show that if :math:`n^2` is odd then :math:`n` odd
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

We worked this example before but we repeat here to focus on two things: first, how to separate :math:`h` from :math:`c` and second how to work your way from :math:`\neg c` to the contradiction. In this case, identifying :math:`h` and :math:`c` is straight forward: they are both present in the problem statement. 


.. math::

 \underbrace{\text{if}\ n^2\ \text{is odd}}_{h} 
 \rightarrow
 \underbrace{n\ \text{is odd}}_{c}
 
So it's easy to formulate the contradictory condition :math:`h\rightarrow\neg c`:

.. math::

 \underbrace{\text{if}\ n^2\ \text{is odd}}_{h} 
 \rightarrow
 \underbrace{n\ \text{is even}}_{\neg c}

The next challenge is where to take the :math:`\neg g`. One good place to start with is: definitions. What does it mean for a number to be even? It must be a multiple of two: :math:`n=2k, k\in\mathbb{Z}`. What to do with this? Well, we are interested in the properties of :math:`n^2`, so let's square it: :math:`n^2=(2k)^2=4k^2=2(2k^2)`. This is a multiple of two; in other words :math:`n^2` is even which contradicts our assumption that :math:`n^2` is odd.

Show that there is no largest integer number
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

This is also an example that we worked on above, only it is not immediately obvious what is its :math:`h` and what is its :math:`c`. When a problem is stated as a fact ("there is no largest integer number"), a good strategy is to turn the fact on its head, i.e., to accept (temporarily) that the opposite fact is true: there *is* a largest interest number.

Let's call that number :math:`L`. What does it mean to be the largest integer number. It means that there is no integer number :math:`x` such that :math:`x>L`. But can this be true? Can we not think of a number larger than :math:`L`?

Here comes the intuition. Let's take two numbers, one larger than the other, for example :math:`3 < 4`. If we add :math:`L` to both sides, we get :math:`L+3 < L+4`. This is interesting because it suggests that a number larger than :math:`L` (specifically, :math:`L+3`) is greater than another number (:math:`L+4`) also larger than :math:`L`. But this is not conclusive enough. The intuition is in the right direction, we need to experiment a bit, maybe by trying a different pair of numbers. Eventually, we come across the fact :math:`0 < 1`. Adding :math:`L` to both sides yield :math:`L<L+1`. But if :math:`L` is *the largest* number, how can it be smaller than :math:`L+1`? There shouldn't be any number greater that :math:`L`. This contradicts our assumption that there is a largest integer number and therefore the original statement must be true: there is no largest integer number.

What was the "magic" above? We started with :math:`3<4` and said we should experiment with other ordered pairs of integers. For example, we could have tried :math:`11<13` or :math:`-18 < 2`, etc. Adding :math:`L` to both sides would have given the same pattern:

.. math::

 L\ \text{plus something } < L\ \text{plus something else}
 
Eventually we come to the realization that we want just :math:`L` on the left-hand side of the expression above. And the only "something" that we can add to :math:`L` and still get :math:`L` is zero. No we need an ordered pair with 0 to the left and something greater than zero to the right. We could try :math:`0<629` but in mathematics we strive for the least necessary quantity to prove our point, so we end up with :math:`0<1`.

The square root of 2 is not a rational number
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,

It is not immediately clear what is the hypothesis and what is the conclusion here. We discussed above that when a property is stated as a fact, to look at the opposite fact and work our way from there. The opposite fact in this case is: :math:`\sqrt{2}` *is a rational number.* 

We can write the original statement as: 
 
 .. math::
 
  \underbrace{\sqrt{2}=\frac{a}{b}}_{h} 
  \rightarrow
  \underbrace{a, b\not\in\mathbb{Z}}_{c}
  
Here, :math:`h` says that :math:`\sqrt{2}` *can be writen as a fraction of two numbers.* And :math:`c` says that these two numbers *are not integers.* And we can write a contradicting condition as:

 
 .. math::
 
  \underbrace{\sqrt{2}=\frac{a}{b}}_{h} 
  \rightarrow
  \underbrace{a, b\in\mathbb{Z}}_{\neg c}

The rest goes as follows: given that :math:`a,b` are integers :math:`a\neq b`, multiplyin both sides with :math:`b` and squaring them yields: :math:`2b^2=a^2`. Therefore :math:`a^2` is a multiple of two, therefore even, and as we proved elsewhere :math:`a` is also even and can be writen as :math:`a=2k` (i.e., a multiple of two). Substituting :math:`2k` for :math:`a` we get that :math:`2b^2=4k^2\Rightarrow b^2=2k^2`, therefore :math:`b^2` is even, and so must be :math:`b`, i.e., :math:`b=2l`. Now the fraction :math:`\dfrac{a^2}{b^2}` can be re-written as :math:`\dfrac{(2k)^2}{(2l)^2}=\dfrac{k^2}{l^2}`, with :math:`k\neq l`.

Great! All we accomplished so far is to write a fraction of squared numbers (:math:`a^2/b^2`) as a fraction of two other squared numbers (:math:`k^2/l^2`). While there is no major award for our accomplishment, there is a notable difference between the two fractions. For the first fraction, we know that :math:`a^2` and :math:`b^2` are *both* even numbers. There is no such certainty about :math:`k^2` and :math:`l^2`. We can use this uncertainty to our advantage as follows.

* If both :math:`k^2` and :math:`l^2` are even, we can follow the same logic as above to reduce :math:`k^2/l^2` to :math:`m^2/n^2`, and continue doing so until we reach a fraction where either the numerator or the denominator or both are odd numbers. And that takes us to the next case.

* If either :math:`k^2` or :math:`l^2` (or both) is an odd number, then

.. math::

 \sqrt{2} &= \frac{2u}{2v+1} \Rightarrow \\
 2 &= \frac{4u^2}{4v^2+4v+1} \Rightarrow \\ \\
 \underbrace{2u^2}_{\textsf{even}} &= \underbrace{4v^2+4v+1}_{\textsf{odd}} \\
 \textsf{because:}\\
 2u^2 &= \underbrace{2(2v^2+2v)+1}_{\textsf{multiple of 2 plus 1}}

The analysis above assumes that one part of the fraction is odd and the other is even, leading to the contradiction that an odd number can be equal to an even one. What if both parts of the fraction were odd numbers? In this case, we reach a similar impossibility:

.. math::

 \sqrt{2} &= \frac{2u+1}{2v+1} \Rightarrow \\
 2 &= \frac{4u^2+4u+1}{4v^2+4v+1} \Rightarrow \\ \\
 \underbrace{4u^2+4u+1}_{\textsf{odd}} &= \underbrace{2(4v^2+4v+1)}_{\textsf{even}} \\
 \textsf{because:}\\
 \underbrace{2(2u^2+2u) +1}_{\textsf{multiple of 2 plus 1}} & =\underbrace{2(4v^2+4v+1)}_{\textsf{multiple of 2}}
 
There is a way to avoid all these different cases (now he tells us!). We can go back to the original contradicting condition and state that since :math:`\sqrt{2}=a/b`, we want :math:`a\neq b` and also we want at least one of them to be odd (so that they do not have 2 as a common factor). Then we show that both :math:`a,b` are even numbers, which cannot be true since we just specified that one of them must be odd.

How do we know to make this assumption about not sharing 2 as a common factor? By doing the *looong* analysis first, realizing that the secret is in fact to write :math:`\sqrt{2}` as a fraction where at least one part is odd, and then simplify the presentation of our proof. In other words, we still need to do the long haul but our presentation can be more elegant.