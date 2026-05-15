:orphan:

Finding palindromes
---------------------------------------------------

The basic strategy to tell if a string is a palindrome has two steps. The first step prepares the string according to some specifications: for example, we may to ignore case, omit punctuation, etc. The second step traverses the string looking for the symmetry of a palindrome. 

In the example we worked in class, we wrote two methods: ``sanitize`` to prepare the string, and ``isPalidrome`` to tell if it is. In our example, method ``sanitize`` treats the string on a case-insensitive basis by converting it to lower case, and removes all the characters leaving only letters. If that's all the preparation required, we can achieve the same result without the need for a separate method.

Consider the following method. The preparation of the string (convert to lower case, remove non-letter characters) is done in line 3 below. Here we use two methods from the ``String`` class, back-to-back. Method ``toLowerCase`` converts all the letters in the string to lower case. And method ``replaceAll`` replaces specific characters with the the empty string (``""``). 

In its simplest form, method ``replaceAll`` accepts two arguments: the first tells which characters to replace and the second what to replace them with. For example ``"aiplane".replaceAll("a", "x")`` will give us ``"xiplxne"``. Or ``"gastronomy".replace("g", "")`` becomes ``"astronomy"`` since we are replacing every occurrence of ``"g"`` with nothing (``""``). 

There is, however, a more advanced way to tell ``replaceAll`` what characters to process. In the example below, the string ``"[^a-z]"`` is a search pattern. It tells the method which characters to look for. Specifically, it tells it look for characters that are not in the range ``a``-``z``; the caret symbol (``^``) means *not*. These search patterns are called `regular expressions <https://en.wikipedia.org/wiki/Regular_expression>`_. They are an awesome and powerful tool in computing. They are also a bit challenging to get used to.

.. code-block:: java
   :linenos:
   :emphasize-lines: 3, 6

   public static boolean isPalindromeCompact(final String s) {
     boolean result = true;
     String t = s.toLowerCase().replaceAll("[^a-z]", "");
     int i = 0;
     while (result && i < t.length()/2)
       result = (t.charAt(i) >= LOWER_A) && (t.charAt(t.length()-1-i++) <= LOWER_Z);
     return result;
    }  // method isPalindromeCompact

Also notice that there is no separate command in the method above to increment the string index. The increment (``i++``) takes place near the end of line 6. After the curren value of ``i`` is subtracted from ``t.length()-1``, the increment operator (``++``) is applied to variable ``i``. This is **poor coding**. It is used here as an example of something to avoid, in general. If someone challenged you to write the most compact code you can, there you have it.

Speaking of poor coding, here's another instance of it in the method above. The processed string is called ``String t``. Usually it is not a good idea to give variables such simple names (single-letter names). Some variables (like loop indices, e.g., ``for (int i=...)``) can be named so, but for everything else it's a good idea to use more descriptive names. Here, I used a single-letter name (``String t``) to keep line 6 from getting too long.