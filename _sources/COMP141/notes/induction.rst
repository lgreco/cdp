Mathematical Induction
======================
 
Mathematical induction -- often, just induction -- is one of the simplest and yet most challenging concepts to master. It is also one of the most rewarding proof techniques. Induction allows us to prove a property for natural numbers, for which we have a hunch but we need solid proof. For example, we believe that the sum of the first :math:`n` numbers is :math:`n(n+1)/2`. In fact, every time we try for a different :math:`n`, our hunch turns out to be true:

.. math::

 n=3,\ \ 1+2+3 = 6 &= \frac{3(3+1)}{2}=\frac{12}{2} \\ \\
 n=4,\ \ 1+2+3+4 = 10 &= \frac{4(4+1)}{2}=\frac{20}{2} \\ \\
 n=5,\ \ 1+2+3+4+5 = 15 &= \frac{5(5+1)}{2}=\frac{30}{2} 
 
There is a story that when Gauss was 10 years old, he derived the sum formula

.. math::

 1+2+\ldots+n = \frac{n(n+1)}{2}

with a simple observation. When he was asked by a teacher to calculate the sum for :math:`n=10`, he noticed that

.. math::

 1+2+3+4+5&+6+7+8+9+10 = \\ \\
 (1+10) + (2+9) + (3&+8) + (4+7) + (5+6) = \\ \\
 11     + 11    &+ 11     + 11    + 11 = \\ \\
 5\cdot 11 & = \frac{10}{2}\cdot (10+1)= \\ \\
 \frac{n}{2}&\cdot (n+1)

But deriving a formula is not the same as proving it. We can claim that the formula :math:`1+2+\ldots+n = n(n+1)/2` works for :math:`n=3` or 4 or 5 or even 10, but that doesn't mean that it works for every natural number. We need a more rigorous tool to prove this property. The rigor, in this case, comes from the axiomatic foundation of natural numbers.

In 1889, Giuseppe Peano, an Italian mathematician, put together a few fundamental statements about natural numbers. These statements, known as Peano's Axioms, are the building blocks of the natural numbers set :math:`\mathbb{N}`. An axiom is a statement that we accept as true. Peano stated five axioms. The last one is the rigorous tool we need to prove :math:`1+2+\ldots+n = n(n+1)/2`. It is worth, however, to review all five axioms first. 

Before stating his axioms, Peano defined a *successor function,* i.e., a function that takes a natural number as input and returns the next successive natural number:

.. math::
 S(n) = n+1

Using the successor function, we can write:

.. math::

 1 &= S(0) \\
 2 &= S(S(0)) \\
 3 &= S(S(S(0)))\\
 &\vdots

Peano's Axioms
--------------

#. :math:`0` is a natural number.

#. For every natural number :math:`x`, its successor :math:`S(x)` is also a natural number.

#. For two natural numbers :math:`x, y`, if :math:`x=y \Leftrightarrow S(x)=S(y)`.

#. There is no natural number :math:`x` such that :math:`S(x)=0`.

#. If a set :math:`K` contains :math:`0`, and if for every natural number :math:`n` being in :math:`K` implies that :math:`S(n)` is also in :math:`K`, then :math:`K` contains every natural number.

The last axiom is the basis for mathematical induction. Let's demonstrate it with the summation formula :math:`1+2+\ldots+n = n(n+1)/2`. We want to show that the formula works for every natural number. So far, we have shown that it works for :math:`n=3, 4, 5` and :math:`10`.

We start by defining a set :math:`K` to contain the natural numbers that we have shown to work with the formula: :math:`K=\{3, 4, 5, 10\}`. We can show that :math:`0` also belongs to :math:`K`, because :math:`0=0\cdot(0+1)/2`. Thus, set :math:`K` fulfills the first condition of the induction axiom, i.e., :math:`0 \in K`.

The next step is to *assume* that a natural number :math:`n` is in :math:`K` and then *prove* that :math:`n+1` is also in :math:`K`. If we do, then we prove (based on Peano's fifth axiom) that all natural numbers are in set :math:`K`; or in other words :math:`K=\mathbb{N}`. And why is this important? Because :math:`K` is the set with the numbers for which the sum formula works. And if  :math:`K=\mathbb{N}`, then the formula works for every natural number, which is the proof we wanted!

Let's assume then that :math:`n\in K`, therefore:

.. math:: 
 1+2+\ldots + n = \frac{n(n+1)}{2}
 
Next we examine if and how we can show that :math:`n+1` is in :math:`K`. If --- and for now, that's a big if --- this is true, if :math:`n+1` is indeed in K, we expect that

.. math::

 1+2+\dots + n +(n+1) = \frac{(n+1)(n+2)}{2}

Our objective now is to start from the left side of the expression above and see if we can arrive to the right side. When we observe the left side:

.. math::

 1+2+\dots + n +(n+1) 
 
we notice that it contains the expression from the case for :math:`n`. And since we assumed that the case is true, we can substitute :math:`1+2+\ldots + n` with :math:`\frac{n(n+1)}{2}`. The substitution give us:

.. math::

 1+2+\dots + n +(n+1) =\\ \\
 \frac{n(n+1)}{2} + (n+1) = \\ \\
 \frac{n(n+1)+2(n+1)}{2} = \\ \\
 \frac{(n+1)(n+2)}{2}
 
And so, we have shown that 

.. math::

 1+2+\dots + n +(n+1) = \frac{(n+1)(n+2)}{2}

and therefore :math:`n+1\in K`. Or, in other words, every natural number belongs to :math:`K` and thus :math:`K=\mathbb{N}`. 

The "price of admission" to set :math:`K` is for a natural number :math:`n` to satisfy the formula :math:`1+2+\ldots + n = n(n+1)/2`. And since we showed that all natural numbers are in :math:`K`, we have proved that the formula works for any natural number.

A template for induction proofs
-------------------------------

Induction problems ask us to prove a property of the form

.. math::

 L(n) = R(n)

In the example above, :math:`L(n)= 1+2+\ldots+n` and :math:`R(n)=n(n+1)/2`.

Given a problem in the form :math:`L(n)=R(n)`, the induction proof can be done in three steps.

Step 1
++++++++

Show that :math:`L(n)=R(n)` holds for :math:`n=1`. (Yes, Peano says to show for :math:`n=0` but :math:`1` is just as good).

Step 2
++++++++

Assume that :math:`L(n)=R(n)` holds for :math:`n=k`, i.e., :math:`L(k)=R(k)` is true.

Step 3
++++++++

Start with :math:`L(k+1)` and show that it equals :math:`R(k+1)`. You will notice that the expression	:math:`L(k+1)` always contains :math:`L(k)`. And since you just assumed that :math:`L(k)=R(k)` in Step 2, you can write

.. math::

 L(k+1) &= L(k) + (n+1) \\
 &= R(k) + (n+1)
 
From here, the problem is reduced to simple (usually) derivations to show that 
:math:`R(k) + (n+1) = R(k+1)`. Showing that, completes the proof.

Examples
--------


The summation formula
++++++++++++++++++++++++

Prove that 

.. math:: 
 1+2+\ldots + n = \frac{n(n+1)}{2}


We worked this formula above to demonstrate the inductive method. We repeat the proof here in a more formal manner.

Step 1
******

For this step, first we need to identify the expressions :math:`L(n)` and :math:`R(n)`. In this case, it's fairly easy:

.. math::

 L(n) &= 1+2+\ldots + n \\ \\
 R(n) &= \frac{n(n+1)}{2}
  
Next we have to test if :math:`L(n)=R(n)` for a specific value of :math:`n`. Peano said to use :math:`n=0` but we prefer to test for :math:`n=1`. 

.. math::
 
 L(1)&=1  \\ \\
 R(1)&=\frac{1(1+1)}{2}=1
 
So, :math:`L(1)=R(1)`.

Step 2
******

This is a simple and quick step. We only have to state that for an arbritrary :math:`n=k` the expression :math:`L(k)=R(k)` is true; in other words:

.. math::

 1+2+\ldots +k = \frac{k(k+1)}{2}
 
Step 3
******

Here we use the next number up from the previous step. In Step 2 we looked at :math:`n=k`. The next number up is :math:`k+1`. The question we must answer in this step now is if :math:`L(k+1)` equals :math:`R(k+1)`.

.. math::

 L(k+1) = 1+2+\ldots +k + (k+1)
 
Notice that :math:`L(k+1)=L(k)+k+1`. Step 2 empowers us to replace :math:`L(k)` with :math:`R(k)`, therefore

.. math::

 L(k+1) &= \underbrace{1+2+\ldots +k}_{=L(k)=R(k)} + (k+1) \\ \\
        &= R(k)+(k+1) \\ \\
		&= \frac{k(k+1)}{2} + (k+1)\\ \\
		&= \frac{(k+1)(k+2)}{2} \\ \\
		&= R(k+1)

We just proved that given  :math:`L(k)=R(k)` the equation holds for the successor of :math:`k` as well, :math:`L(k+1)=R(k+1)`, and thefore the original expression 

.. math:: 
 1+2+\ldots + n = \frac{n(n+1)}{2}
 
is true for every natural number.

The stamps problems
++++++++++++++++++++++++

Show that any postage amount greater than $0.17 can be formed with $0.03 and $0.10 stamps. For example, $0.22 worth of postage comprises one $0.10 stamp and four $0.03 stamps.

Step 1
******

Problems like this one do not have a readily available expression of the form :math:`L(n)=R(n)`. We have to derive the formula by restating the problem. Basically, the problem says that any number greater than 17 can be written as the sum of multiples of 3 and multiples of 10:

.. math::

 n&=3a+10b
 
 n&\geq 18

Here :math:`L(n)=n` but what about :math:`R(n)`? The right side of the question does not contain :math:`n`. Or does it? We can always write :math:`3b+10b=3a+10b+0n`, and this will be our :math:`R(n)`. So the problem is restated as follows:

.. math::

 \underbrace{n}_{L(n)} = \underbrace{3a+10b+0n}_{R(n)}
 
Now that we have established :math:`L(n)` and :math:`R(n)` we have to test that they hold true. We cannot test for :math:`n=1` because the problem states that the property applies only to numbers :math:`n\geq 18`. So we should try for :math:`L(18)=R(18)`, in other words, can we write 18 as a sum of multiples of 3 and 10? Indeed we can:

.. math::

 18 =3a+10b
 
 \text{when}\ a=6, b=0
 
Step 2
******

This is the easiest step of the proof. We assume that the property holds for an arbitrary integer :math:`k`, i.e., :math:`L(k)=R(k)`.

Step 3
******

Can we now prove that the property works for :math:`S(k)`, by working our way from :math:`L(k+1)` to :math:`R(k+1)`. Just remember that for this problem, :math:`R` simply means a sum of multiples of 3 and 10.


.. math::

 L(k+1) &= k+1\ \ \ \ (\text{and from step 2,}\ k=3a+10b)
        
		&=3a+10b+1\ \ \ \ (\text{rewrite}\ 1=10-9)
		
		&=3a+10b+10-9 
		
		&=3(a-3)+10(b+1)\ \ \ \ (\text{substituting}\ a'=a-3,\ b'=b+1)
		
		&=3a'+10b'

What the expression above says is that :math:`k+1` is also a sum of multiples of 3 and 10, and therefore :math:`L(k+1)=R(k+1)`.