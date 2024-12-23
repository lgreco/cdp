:orphan:

Conditional propositions
========================

Conditional propositions can be confusing at the start. The conditional proposition involves two simple propositions :math:`p` and :math:`q` in the following expression:

 
.. math::

 p\rightarrow q

The expression above means :math:`p` implies :math:`q`. The truth table for the conditional proposition is the following, where "T" stands for true and "F" for false.

===========================   =========================    =======================
  :math:`p`                   :math:`q`                    :math:`p\rightarrow q`
===========================   =========================    =======================
T                             T                            T
T                             F                            F
F                             T                            T
F                             F                            T
===========================   =========================    =======================

The behavior of the conditional proposition as shown above is a bit puzzling, especially when proposition :math:`p` is false. The easiest way to illustrate the behavior of the conditional proposition is with a simple example. Consider the following two statements:


.. math::

 p&:\textsf{born in Chicago} \\
 q&:\textsf{born in Illinois}
 

Proposition :math:`p` can be true or false, and so can :math:`q`. All the possible combinations between :math:`p` and :math:`q` are shown below, along with the value of the conditional proposition.


===========================   =========================    =======================
  :math:`p`                   :math:`q`                    :math:`p\rightarrow q`
===========================   =========================    =======================
born in Chicago               born in Illinois              True
born in Chicago               not born in Illinois          False
not born in Chicago           born in Illinois              True
not born in Chicago           not born in Illinois          True
===========================   =========================    =======================

Let's analyse each case shown above.

* :math:`\left(\textsf{born in Chicago}\rightarrow\textsf{born in Illinois}\right)=\textsf{true}`  
  
  because Chicago is a city in Illinois, and a person born in the city is also born within the state.
  
------

* :math:`\left(\textsf{born in Chicago}\rightarrow\textsf{not born in Illinois}\right)=\textsf{false}`  
  
  because there is no way that a person born in Chicago is born outside the state of Illinois.
  
------

* :math:`\left(\textsf{not born in Chicago}\rightarrow\textsf{born in Illinois}\right)=\textsf{true}`  
  
  because there are other places in Illinois other than Chicago. 
  
------

* :math:`\left(\textsf{not born in Chicago}\rightarrow\textsf{not born in Illinois}\right)=\textsf{true}`  
  
  because there are cities outside Illinois.
  
------

Here's another example.


.. math::

 p&: \textsf{visited the Eiffel tower} \\
 q&: \textsf{traveled to France}

A person may travel to France without ever seeing the Eiffel tower, e.g. someone who flies and spends time only in Nice (:math:`(\neg p\rightarrow q)=\texttt{T}`.) A person who has not seen the tower maybe someone who has not traveled to France at all (:math:`(\neg p\rightarrow\neg q)=\texttt{T}`). But no person who has ever being to the Eiffel tower can claim they have not visited France (:math:`(p\rightarrow\neg q)=\texttt{F}`). Sorry, the Eiffel Tower in Las Vegas, or the various scaled models of the tower across other cities, are not acceptable alternatives!

One more example is always helpful.

.. math::

 p&: \textsf{major in computer science} \\
 q&: \textsf{learn to program}
 
The case :math:`p\rightarrow q = \texttt{T}` is straight forward. Every student of computer science learns to program. The  case :math:`p\rightarrow \neg q=\texttt{F}` can be explained by the fact that there is no computer science student who can skip programming. The case :math:`\neg p\rightarrow q=\texttt{T}` suggests that learning to program is not exclusive to computer science majors; physics majors for example, learn to program. Finally, the case   :math:`\neg p\rightarrow \neg q=\texttt{T}` can be explained by the fact that there are many college majors that do not include programming.

 
 
 
