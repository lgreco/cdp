:orphan:

Fencepost techniques
=======================================

**Key points**

 * Fencepost affects mostly visual outputs (e.g., printouts).
 * Overcoming fencepost artifacts requires code duplication.

Fencepost is an loop artifact that becomes apparent usually when we require consistent or uniform presentation of data. For example, the code:

.. code-block:: java

  int N = 10;
  for ( int i = 0; i < N; i++ ) {
    System.out.print(i + ", ");
  }

will produce the output

.. code-block:: java

  0, 1, 2, 3, 4, 5, 6, 7, 8, 9,

That last comma needs to go! The solution usually is to print the last (or the first) item separately. For example,

.. code-block:: java

  int N = 10;
  for ( int i = 0; i < N - 1; i++ ) {
    System.out.print(i + ", ");
  }
  System.out.print(N-1);

will produce the desired output, without a comma dangling after the last number.

.. code-block:: java

  0, 1, 2, 3, 4, 5, 6, 7, 8, 9

We obtain the desired output at the cost of duplicating the ``print`` statement, to display the last value of the loop (``N-1``) outside the loop. This way, we allow the ``print`` statement inside the loop to print the commas separating the numbers. And the last statement to print a number without a comma following it. 

Sometimes, the duplication of code can be problematic. Consider, for example, a method that parses the digits of an integer number and prints them in the form of a sum, e.g.,

.. code-block:: java

  23458 ---> 8 + 5 + 4 + 3 + 2
  
We start with the following code:

.. code-block:: java
  :linenos:

  public static void showDigits(int n) {
    int r = n % 10;
    n = n / 10;
    System.out.print( r );
    while ( n != 0 ) {
      r = n % 10;
      n = n / 10;
      System.out.print( " + " + r );
    }
  }

Notice, how lines 2 and 3 outside the loop above repeat as lines 6 and 7, within the loop. When we begin to see such duplication, it may be a good away to "factor" it away: move the repeating code into a method, and use that method in its place. In this example, if we move the repeating code in its own method, we'll run to a fundamental Java problem. Let's try it anyway.

.. code-block:: java
  :linenos:

  public static void showDigits(int n) {
    doTheMath();
    System.out.print( r );
    while ( n != 0 ) {
      doTheMath();
      System.out.print( " + " + r );
    }
  }
  
  public static ??? doTheMath(???) {
    int r = n % 10;
    n = n / 10;
    return ???
  }
  
We can move the repeating operations in the new method ``doTheMath()``, but how shall the method pass the results back? Java methods can return one and only one value. We cannot simply write

``return r, n;``

Java methods cannot return multiple values. In time, we learn to live with this limitation. And even come up with tricks to overcome it (e.g., we can return multiple values masquerading as an array which Java considers as a single value). For now, our only option is to make variables ``r`` and ``n`` accessible from every method in the class:

.. code-block:: java
  :linenos:
  
  public class FencePost {
  
  private static int n, r;

    public static void showDigits() {
      doTheMath();
      System.out.print( r );
      while ( n != 0 ) {
        doTheMath();
        System.out.print( " + " + r );
      }
    }
  
    public static void doTheMath() {
      r = n % 10;
      n = n / 10;
    }
  }
