:orphan:

Riddler's next caper
=======================

In the assignment *Holy Digits Batman* we are trying to guess the street number for for Riddler's next caper on Pennsylvania Avenue. We are told that the address on Pennsylvania is a four-digit number; all four digits are different; the digit in the thousands place is three times the digit in the tens place; the number is odd; and the sum of the digits is 27. Based on that information, can we find the street number?

A novice programmer may attack this problem with brute force:

.. code-block:: java
  :linenos:


  public static void useBruteForce() {
    for (int number = 0; number < 10000; number++) {
      int n = number;
      int u = n % 10; n = n / 10;
      int d = n % 10; n = n / 10;
      int h = n % 10; n = n / 10;
      int k = n % 10;
      if ( (k != h && h != d && d != u && k != u && h != u) // diff digits
          && (k == 3 * d) // multiple of three
          && (number % 2 == 1) // odd
          && (k + h + d + u == 27)) { // add up to 27
        System.out.println("The street number is " + number);
      }
    }
  }  // method useBruteForce
  
The loop in the code above, works every possible address number up to 9999. The lines 3-7 disassemble the address number to digits for units (``u``), tens (``d``), hundreds (``h``), and thousands (``k``),. For example, if ``number=1234``, the corresponding values will be: ::

 k = 1
 h = 2
 d = 3
 u = 4
  
The variables ``k, h, d`` are in reference to the metric (SI) prefixes kilo for multiples of 1000, hecto for multiples of 100, and deca for multiples of 10. Variable ``u`` is named after unit.

The **if** statement in line 8 (spread across lines 9, 10, and 11 as well), performs all the necessary tests. The condition on line 8 ensures that the digits are different. The condition in line 9 ensures that the digit for the ``k`` is three times the digit for the ``d``. The condition in line 10 ensures that the number is odd. And the condition in line 11 ensures that the digits add up to 27. If all four conditions are satisfied, the result is printed out with line 12.

The code in method **useBruteForce** takes 9837 steps to find the address number. Our novice programmer soon realizes that about 1000 of those steps are not necessary, because the numbers from 0 to 999 are not four-digit numbers. So the loop of line 2 is rewritten as

.. code-block:: java

  for (int number = 1000; number < 10000; number++) { ... }
  
and the code speeds up a bit. Next, we turn our attention to lines 3-7. Is there a better way to obtain the various digits for the street address? It is at this moment that a novice programmer becomes an intrepid programmer. By replacing the plain loop with four loops as shown below.


.. code-block:: java
  :linenos:

  public static void useSomeBruceForce() {
    for (int k = 1; k < 10; k++) {
      for (int h = 0; h < 10; h++) {
        for (int d = 0; d < 10; d++) {
          for (int u = 0; u < 10; u++) {
            boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
            boolean thrice = ( k == 3 * d );
            boolean odd = ( u % 2 == 1 );
            boolean addsUp = ( (k + h + d + u) == 27 );
            if (differentDigits && thrice && odd && addsUp) {
              System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
            }
          }
        }
      }
    }
  }
  
Here, the plain loop that run from 1000 to 9999 is replaced by four loops, each running through the single digits we need. For example, the loop in line 2 produces the digits from 1 to 9 that will form the thousands of the street address. The loop in line 3 produces the digits 0 to 9 for the hundreds of the street address, and so on. Using the variables from these loops we can form the street address number as

.. math::

 \texttt{k}\cdot 10^3 + \texttt{h}\cdot 10^2 + \texttt{d}\cdot 10^1 + \texttt{u}\cdot 10^0
 
The intrepid programmer has delegated the decomposition of a number from integer arithmetic to four single-digit loops. The multiline **if** statement was also simplified creating four boolean variables for each of the conditions given. This improved code performs 8837 steps before finding the only possible answer.

Things are now getting interesting. If we can reduce the number of necessary steps from 9837 to 8837, can we do better? One of the requirements is that street number must be odd. An odd number always ends with the digits 1, 3, 5, 7, or 9. Therefore, we do not need the loop in line 5 (the ``u`` loop) to go through all digits. We can instruct that loop to skip the even digits, thus rendering the test of line 8 obsolete. Every number will be odd. The revised code will be:

.. code-block:: java
  :linenos:
  
  public static void useOddUnitsOnly() {
    for (int k = 1; k < 10; k++) {
      for (int h = 0; h < 10; h++) {
        for (int d = 0; d < 10; d++) {
          for (int u = 1; u < 10; u=u+2) {
            boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
            boolean thrice = ( k == 3 * d );
            boolean addsUp = ( (k + h + d + u) == 27 );
            if (differentDigits && thrice && addsUp) {
              System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
            }
          }
        }
      }
    }
  }

The new method, **useOddUnitsOnly,** conducts only 4418 tests. The simple realization about odd digits improved the performance by 50%. That's a lot. And all the intrepid programmer had to do was to change the starting value of the ``u`` loop from 0 to 1, and its step to 2 instead of 1, therefore eliminating the need for the boolean variable ``odd``.

And we can do even better. Another condition for the street number is that the k digit must be three times the d digit, i.e.,

.. math::

 \texttt{k} = 3\cdot\texttt{d}
 
This condition allows us to loop through ``k`` beginning with 3 and stepping by 3, i.e.,

.. code-block:: java

  for ( int k = 3; k < 10; k = k + 3 ) {...}
  
The condition also allows us to restrict the values of ``d`` as follows:

.. code-block:: java

  for ( int d = 1; d < 4; d++ ) {...}
 
The improved code is below.

.. code-block:: java
  :linenos:
  
  public static void matchThree() {
    for (int k = 3; k < 10; k += 3) {
      for (int h = 0; h < 10; h++) {
        for (int d = 1; d < 4; d++) {
          for (int u = 1; u < 10; u += 2) {
            boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
            boolean addsUp = ( (k + h + d + u) == 27 );
            if (differentDigits && addsUp) {
              System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
            }
          }
        }
      }
    }
  }

We have eliminated one more boolean test and reduced the size of two loops. Method **matchThree** requires 433 steps to find the correct number. That's spectacular improvement, but there is more to come.  Given the relation :math:`\texttt{k} = 3\cdot\texttt{d}`, we can omit either the `k` loop or the `d` loop. For example, if you eliminate the the ``k`` loop, we can simply computer the corresponding digit directly from the value of the ``d`` digit. This is done in line 4 below.

.. code-block:: java
  :linenos:

  public static void removeOneLoop() {
    for (int h = 0; h < 10; h++) {
      for (int d = 1; d < 4; d++) {
        int k = 3 * d;
        for (int u = 1; u < 10; u += 2) {
          boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
          boolean addsUp = ( (k + h + d + u) == 27 );
          if (differentDigits && addsUp) {
            System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
          }
        }
      }
    }
  }

Method **removeOneLoop** above completes the search in just 133 steps. But we can do even better! By inverting the order in which we are running the loops, we need only 118 steps. The method above started with the ``h`` loop, followed by the ``d`` loop, followed by the ``u`` loop. The method below starts with the ``u`` loop, followed by the ``d`` loop, followed by the ``k`` loop.

.. code-block:: java
  :linenos:
  
  public static void inverseLoops() {
    for (int u = 1; u < 10; u += 2) {
      for (int d = 1; d < 4; d++) {
        for (int h = 0; h < 10; h++) {
          int k = 3 * d;
          boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
          boolean addsUp = ( (k + h + d + u) == 27 );
          if (differentDigits && addsUp) {
            System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
          }
        }
      }
    }
  }

Going from 133 steps to 118 steps is a small improvement, but a matter of pride. As such it is left to the meticulous programmer to explain how a "simple" reversal of the loops gives us this small improvement. Speaking of improvements, there are two more to consider. The next improvement comes by realizing that if we know the values for ``u``, ``d``, and ``k`` digits, we can compute the value for the ``h`` digit from the condition that all digits must add to 27. This is done in line 5, below. Line 6 ensures that we only accept computed values for ``h`` that are single digits.

.. code-block:: java
  :linenos:
  
  public static void useTwoLoopsOnly() {
    for (int u = 1; u < 10; u += 2) {
      for (int d = 1; d < 4; d++) {
        int k = 3 * d;
        int h = 27 - u - d - k;
        boolean singleDigit = ( h < 10 );
        boolean differentDigits = ( k != h && h != d && d != u && k != u && h != u );
        if (differentDigits && singleDigit) {
          System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
        }
      }
    }
  }
  
The code in method **useTwoLoopsOnly** above requires only 11 steps. We can try one more improvement with the following code, replacing one for-loop with one while-loop. The for-loop below runs for the ``u`` digits which must be odd. We know there is a dependency between the ``k`` and the ``d`` digits (:math:`\texttt{k} = 3\cdot\texttt{d}`), but we also know that we don't want to have repeated digits in the number. So whatever value the ``u`` loop is, we definitely cannot use it for the ``d`` loop. That's what the condition in lines 4 and 15 ensures. We also want the ``d`` digit to be 1, 2, or 3 so that when we multiply it by 3 we get legitimate single-digit values for the ``k`` digit. We ensure that ``d`` does not exceed 3 with the condition in lines 5 and 16. 

At this point we know ``u`` from the loop in line 2, we know ``d`` from the loop in line 6, and we know ``k`` from the dependency in line 7. So we can guess the value of ``h`` in line 8.

.. code-block:: java
  :linenos:
  
  public static void useOneForLoop() {
    for (int u = 1; u < 10; u += 2) {
      int d = 1;
      boolean diffTensUnits = d != u;
      boolean dLess4 = d < 4;
      while (diffTensUnits && dLess4) {
        int k = 3 * d;
        int h = 27 - u - d - k;
        boolean singleDigit = ( h < 10 );
        boolean differentDigits = ( k != h && h != d && k != u && h != u );
        if (differentDigits && singleDigit) {
          System.out.printf("\nThe street number is %d%d%d%d.\n", k, h, d, u);
        }
        d++;
        diffTensUnits = d != u;
        dLess4 = d < 4;
      }
    }
  }
  
Method **useOneForLoop** above takes only 7 steps! Notice that since the conditions for the while loop in line 6 guarantee that ``d!=u`` we no longer need this condition in the test at line 10.

There is at least one more improvement that can bring the performance down to 5 steps. Can you guess it? Can you do better (less) than 5?

A bit of analysis: exploring efficiency
+++++++++++++++++++++++++++++++++++++++

Before we look at faster solutions, it is worth asking, why they exist. From a brute force approach that conducted 9837 tests to the latest method that takes 7 steps -- and promises to make them 5 -- we have seen dramatic reduction in the effort to compute the solution. That's because we have been trading randomness for logic. The brute force approach tests every number up to 9999 until it finds one that meets all the criteria. Soon the question arises: do we have to test all numbers? Are some that we can disqualify without even testing them? The answer is yes, and we can begin trading randomness for selectivity (and logic).

The first trade was when we realized that we do not need numbers ending in 0, 2, 4, 6, and 8. The problem asks for an odd number. In the brute force approach we looked at every number, knowning that even numbers will fail the test. We removed them from consideration all together by making the last digit loop (the ``u`` loop) start at 1 and step by 2. This simple trick reduced the numbers we tested by half. This trade is demonstrated in method **useOnlyOddUnits** that requires only 4418 steps.

The second trade was when we modified our code to observe the relation between the ``k`` and the ``d`` digits. The maximum value for the ``k`` digit is 9. That limits the maximum value of the ``d`` digit to 3, so that we can observe the restriction :math:`\texttt{k}=3\cdot\texttt{d}`. Coding this relation into the corresponding for-loops, we reduce the number of tests that the program has to conduct even more, down to 433. The ``k`` loop runs from 3 to 9, with a step of 3, producing the values 3, 6, and 9. The ``d`` loop runs from 1 to 3, producing the values 1,2 and 3. This is done with method **focusOn3000s,** in 433 steps.

The next trade focuses even more on the relation between the fourth digit (``k``) and the second digit (``d``). If :math:`\texttt{k}=3\cdot\texttt{d}`, do we really need a loop for each digit? What if we run just one loop, for ``d`` stepping through 1, 2, and 3, and used it to obtain the ``k`` digit by direct assignment:

.. code-block:: java

  k = 3 * d;

This way we eliminate one loop, as shown in method **compute1000s,** and we are down to 118 steps.

At this point in our analysis we may begin to see other interesting properties of the problem. For example, the requirement that all digits add up to 27 means that if we know three of the digits we can compute the 4th without trying different number combinations. For example, if we are given the number :math:`9z37` we can tell that its second digit is :math:`z=27-(9+3+7)`. By exploiting this property, as it is done in method **subtractFrom27** we can eliminate one more loop (no need to run a loop over the ``h``). And we get rid of one more boolean test -- the sum of digits is guaranteed to be 27 and we don't have to check it. The problem is now solved in 12 steps.

We started with four for-loops and we are down to two loops: one loop for the ``u`` digits and one loop for the ``d`` digits. Everything else can be computed from these two variables. The ``k`` digit is ``3*d`` and the ``h`` digit by subtracting the other three digits from 27. Let's look at those 11 possible numbers that method **subtractFrom27** examines before finding the correct answer. For readability, I have separated the digits to show them clearly, below: ::

 3 22 1 1        6 18 2 1        9 14 3 1
 3 20 1 3        6 16 2 3        9 12 3 3
 3 18 1 5        6 14 2 5        9 10 3 5
 3 16 1 7        6 12 2 7	
 
Something's wrong with the numbers above! The ``h`` digit is supposed to be a single digit. Where are these 2-digit values coming from? They are computed by subtracting the rest of the digits from 27. For example, the "22" in the first number above is the result of the subtraction 27-(3+1+1). The test ``h < 10`` in **subtractFrom27** ensures that such values are not considered. We could use a bit of simple arithmetic to gain some insight:

.. math::

  \texttt{h}  &= 27 - \texttt{k} - \texttt{d} - \texttt{u} \\
                     &= 27 - 3\cdot\texttt{d} - \texttt{d} - \texttt{u} \\
                     &= 27-4\cdot\texttt{d}- \texttt{u}

The formula above takes into consideration the restriction that :math:`\texttt{k}=3\cdot\texttt{d}`.

Since we want ``h`` to be a single digit, we expect 

.. math::
  
  27-4\cdot\texttt{d} - \texttt{u} & \leq 9 \\
  4\cdot\texttt{d} + \texttt{u} & \geq 18 \\
  

Recalling that :math:`1\leq\texttt{d}\leq 3`, the condition above leads to three possible scenarios:


.. math::

  \texttt{d} = 1 & :   4 + \texttt{u}  \geq 18 \Rightarrow \texttt{u} \geq 12 \\
  \texttt{d} = 2 & :   8 + \texttt{u}  \geq 18 \Rightarrow \texttt{u} \geq 10 \\
  \texttt{d} = 3 & :  12 + \texttt{u}  \geq 18 \Rightarrow \texttt{u} \geq 6 \\
  
The first two scenarios are impossible because we want the ``d`` variable to be a single digit number. Only when ``d=3``, ``u`` can be 6, 7, 8, or 9. We can dismiss 6 and 8 because of the requirement for an odd number. We can also dismiss 9 because if ``d=3`` then ``k`` will be 9 and we cannot use the same digit again. Thus we conclude:

.. math::

 \texttt{u} & = 7 \\
 \texttt{d} & = 3 \\
 \texttt{k} & = 9

The value of ``h`` can be simply computed as 27-7-3-9=8.


An afterthought
+++++++++++++++

At some point it becomes evident that the problem has one solution only and that we can find it without any computer code at all. Why do we bother with a programming solution when we can work the solution numerically? Mostly for the learning experience: the *Holy Digits* problem is an opportunity to reflect on brute force solutions and seek more effective approaches. Our search for more efficient approaches may give us insight into the structure of the problem and we may even find a solution without the aid of programming. And that's absolutely fine: programming is an endeavor that sharpens our computational thinking skills. It's these skills that lead us to solutions.

Often however, we need to tackle problems that may not have a unique or numerically obtained solution. Such problems require us to find a solution to satisfy multiple Boolean conditions:

.. math::

 \texttt{condition}_1\ \&\&\  \texttt{condition}_2\ \&\&\ \dots  \&\&\   \texttt{condition}_n

These problems comprise a special type of problem known as the **satisfiability problem**. In terms of computational complexity, the satisfiability problem is an *NP-Complete* problem (NP means *non-deterministic polynomial*). This means that the problem can be solved with a brute force approach -- like we did at the beginning of this discussion. As the size of the problem grows, as the number of conditions to be satisfied increases, it may take longer to complete the brute force attack. In these cases, we seek efficiencies that may speed up our computation.