:orphan:

Vieta's formula
===============

Vieta's formula relates the coefficients of a polynomial to its roots. The formula was developed by Franciscus Vieta, a 16th century French lawyer who dabbled in algebra.

In general, a polynomial of *n*-th degree is written as

.. math::

 p_n(x) = a_n x^n + a_{n-1} x^{n-1} +\ldots + a_1 x + a_0
 
with :math:`a_n\neq 0`. In a compact summation form the polynomial is written as


.. math::

 p_n(x) = \sum_{i=0}^{n} a_i x^i

For example, :math:`p_2(x)=0` is the familiar quadratic equation :math:`a_2 x^2+a_1 x + a_0=0`. Usually we see it in the form :math:`ax^2+bx+c=0`. In *serious* mathematical notation we drop the different letters used as coefficients of variable :math:`x` and use a subscripted symbol like :math:`a_j`. This makes sense for large polynomials, because we may run out of letters at some point. Imagine a polynomial of 50th degree: :math:`ax^{50}+bx^{49}+\ldots`. By the time we get to :math:`x^{26}`, we run out of letters! It's so much more convenient to write :math:`a_{50}x^{50}+a_{49}x^{49}+\ldots +a_1x+a_0`

If a polynomial :math:`p_n(x)` has *n* distinct roots :math:`r_0, r_1,\ldots, r_{n-1}, r_n`, there is a predictable relation between them and the coefficients :math:`a_j`. For example, we showed already that if :math:`r_1` and :math:`r_2` are the distinct roots of :math:`x^2+a_1 x+a_0`, then :math:`r_1+r_2=-a_1` and :math:`r_1r_2=a_0`. Vieta noticed this relation and explored it further.

You can say that Vieta took this to the *n*-th degree! He factored a polynomial over its roots, e.g. :math:`(x-r_1)(x-r_2)`, did the multiplications, and found the relation between roots and coefficients. As he tried this factoring for different degrees, the pattern emerged. The pattern is now known as Vieta's formula:


.. math::

 \sum_{1\leq i_1 < i_2 < \ldots < i_k \leq n} \left( \prod_{j=1}^{k} r_{i_j} \right) = (-1)^k \frac{a_{n-k}}{a_n},\ k=1,2,\ldots,n
 
This is quite the formula, but broken down, it's rather manageable.


.. math::

 r_1 + r_2 + \ldots + r_{n-1} +r_n &=& -\frac{a_{n-1}}{a_n} \\
 (r_1 r_2 + r_1 r_3 + \ldots r_1 r_n) + (r_2 r_3 +\ldots r_2 r_n) +\ldots r_{n-1} r_n &=& \frac{a_{n-2}}{a_n} \\
 \ldots \\
 r_1 r_2 \ldots r_n &=& (-1)^n \frac{a_0}{a_n}