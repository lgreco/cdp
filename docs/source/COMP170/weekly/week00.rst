Week 00
=======


Workload expectation
---------------------
In general, each credit hour in a 100-200 level course will require an average of 3 hours per week spent on work for that course, outside of the synchronous meeting time.

Homework
---------

Homework is due 7 days after assigned. No extensions. 

Learning to program takes *time.* Sometimes you read a problem, write some code, and try to figure out why the code doesn't work. You struggle with it, and go to the next problem, you sleep on it, you wrestle with it again, you go to tutoring or office hours, and you finally figure it out. To some, the process of debugging code comes naturally, for other you will need to build up a new set of skills. 




Beginning to Program in Python
--------------------------------

.. code-block:: python
  :linenos:

  def our_first_program():
    print("hello world!")
        
  our_first_program()

Dissecting a simple program
............................


* ``def``: a reserved string.
* ``hour_first_program`` a function name.
* ``()`` an empty list of parameters.
* ``print`` another reserved string. 
* ``"hello world"``: a string.
* ``our_first_program()``: invocation of a function.

**Known words above:** a, an, empty, of, another.



Syntax rules and good practices for function names
...................................................


#. **Start with a Letter or Underscore**: A function name must start with a letter (uppercase or lowercase) or an underscore (`_`). It cannot start with a number or special character.

#. **Alphanumeric and Underscore**: After the first character, a function name can contain letters, numbers, and underscores. No spaces or special characters are allowed.

#. **Case-Sensitive**: Function names in Python are case-sensitive, so ``myfunction``, ``myFunction``, and ``MYFUNCTION`` are all different functions.

#. **No Reserved Words**: You cannot use Python's reserved words as function names. These include words like ``if``, ``else``, ``while``, ``for``, ``return``, etc.

#. **Snake Case**: By convention, function names in Python are usually written in snake_case, where all letters are lowercase, and words are separated by underscores. For example, ``my_function_name``.

#. **Avoid Leading Underscores Unless Necessary**: A leading underscore in a function name (e.g., ``_my_function``) typically indicates that the function is intended for internal use within a module or class and should not be accessed from outside. It's a convention, not a strict rule, so it won't prevent access, but it signals to other developers that the function is considered "private" or "protected."

#. **Descriptive Names**: It's good practice to choose function names that clearly describe what the function does. This makes the code more readable and maintainable.

Examples of valid function names
.................................

.. code-block:: python

  def my_function():

  def _internal_use_only():

  def calculate_sum(x, y):
  

Examples of invalid function names
...................................

.. code-block:: python
    
  def 123_function(): # Starts with a number
  
  def my-function(): # Contains a special character
  
  def for(): # Uses a reserved word
  

Knowledge test
...............

* **Basic Understanding**

  * What does the ``def`` keyword do in Python?
  * What is the purpose of the ``print`` statement in the code?
  * How would you describe the function's name and its naming convention?

* **Function Concepts**

  * What does the ``hello_world`` function do when it is called?
  * How many parameters does the ``hello_world`` function take? Can you explain what a parameter is?

* **Code Execution**

  * What will be the output of the code when it is run?
  * In what order are the lines of code executed?

* **Indentation and Structure**
  * Why is indentation important in defining the body of a function?
  * What is the significance of the colon ``:`` at the end of the function definition?

* **Application and Extension**

  * Can you write a similar function that prints a different message?
  * How would you modify the ``hello_world`` function to take a name as a parameter and print "Hello, [name]!"?

* **Understanding Errors** (Advanced)

  * What would happen if you removed the indentation from line 2? Why?
  * What would happen if you tried to call the ``hello_world`` function before defining it?


(:doc:`Answers <week00-answers>`)


f-strings
.........

An f-string is created by placing an ``f`` before the opening quotation mark of a string and including expressions inside curly braces ``{}`` within the string. For example:

.. code-block:: python

  name = "John"
  age = 25
  greeting = f"Hello, {name}! You are {age} years old."
  

Here, the variables ``name`` and ``age`` are directly embedded within the string, resulting in the greeting: ``Hello, John! You are 25 years old.``

f-strings provide a concise way to include variables or expressions inside strings.By embedding values directly in the string, the code remains clean and easy to read. The expressions inside the curly braces are evaluated at runtime, allowing for dynamic string creation.

f-strings are an essential tool in Python programming, and you'll often find them used to create clear and efficient string representations.


Variables and Boolean logic
............................

This next example will introduce variables, boolean values, boolean logic, and function parameters.

.. code-block:: python
  :linenos:

  def check_age(age):
    is_adult = age >= 18
    is_teenager = 13 <= age < 18
    print(f"Age provided: {age}")
    if is_adult:
      print("You are an adult.")
    elif is_teenager:
      print("You are a teenager.")
    else:
      print("You are a child.")
    print(f"Is adult? {is_adult}")
    print(f"Is teenager? {is_teenager}")
    
    check_age(20)


The function takes an input parameter, "age", and then produces text output that changes depending on the value used. Let's go through this example line by line.

Dissecting the code
.....................

* **Line 1**: ``def check_age(age):`` - Defines a function named ``check_age`` that takes one parameter, ``age``.
* **Line 2**: ``is_adult = age >= 18`` - Declares a boolean variable ``is_adult``, which is ``True`` if ``age`` is 18 or older.
* **Line 3**: ``is_teenager = 13 <= age < 18`` - Declares a boolean variable ``is_teenager``, which is ``True`` if ``age`` is between 13 and 17 (inclusive).
* **Line 4**: ``print(f"Age provided: {age}")`` - Prints the provided age using an f-string.
* **Line 5**: ``if is_adult:`` - Begins an ``if`` statement that checks if ``is_adult`` is ``True``.
* **Line 6**: ``print("You are an adult.")`` - Prints a message if ``is_adult`` is ``True``.
* **Line 7**: ``elif is_teenager:`` - Begins an ``elif`` statement that checks if ``is_teenager`` is ``True``.
* **Line 8**: ``print("You are a teenager.")`` - Prints a message if ``is_teenager`` is ``True``.
* **Line 9-10**: ``else:`` / ``print("You are a child.")`` - If neither ``is_adult`` nor ``is_teenager`` is ``True``, this message is printed.
* **Line 11-12**: ``print(f"Is adult? {is_adult}")`` / ``print(f"Is teenager? {is_teenager}")`` - Prints the values of the boolean variables.
* **Line 14**: ``check_age(20)`` - Calls the ``check_age`` function with an argument of 20.


Knowledge test
..................

* What is the output of the code when ``check_age(20)`` is called?
* How would the output change if the age provided was 15?
* What are the boolean variables ``is_adult`` and ``is_teenager``, and how are they used in the code?
*  Can you write a similar function that checks and prints whether a number is positive, negative, or zero?



(:doc:`Answers <week00-answers>`)



Working with numbers
............................


.. code-block:: python
   :linenos:

   def calculate_statistics(number1: int, number2: float) -> str:
       """Calculates and returns a summary of statistics.
       
       Args:
           number1 (int): An integer input.
           number2 (float): A decimal input.
       
       Returns:
           str: A string summary of the statistics.
       """
       sum_result = number1 + number2  # Addition
       product = number1 * number2     # Multiplication
       is_odd = number1 % 2 == 1       # Modulo operation to check odd

       summary = (f"Sum of {number1} and {number2}: {sum_result}\n"
                  f"Product of {number1} and {number2}: {product}\n"
                  f"{number1} is {'odd' if is_odd else 'even'}")

       return summary

   print(calculate_statistics(3, 4.5))



Dissecting the code
.....................

* **Line 1**: ``def calculate_statistics(number1: int, number2: float) -> str:`` - Defines a function with type annotations for the parameters and return type. This improves code readability and helps tools provide better analysis.
* **Line 2-10**: These lines form the docstring, which provides a detailed explanation of the function, its parameters, and its return value. This is essential for understanding the function's purpose and usage.
* **Line 11**: ``sum_result = number1 + number2  # Addition`` - Calculates the sum of ``number1`` and ``number2`` and stores it in ``sum_result``. The inline comment explains the operation.
* **Line 12**: ``product = number1 * number2     # Multiplication`` - Calculates the product of the numbers.
* **Line 13**: ``is_odd = number1 % 2 == 1       # Modulo operation to check odd`` - Uses the modulo operator ``%`` to check if ``number1`` is odd. If ``number1`` divided by 2 has a remainder of 1, it's odd.
* **Line 15-17**: Constructs a summary string that includes the results of the previous calculations and whether ``number1`` is odd or even.
* **Line 19**: ``return summary`` - Returns the summary string.
* **Line 21**: ``print(calculate_statistics(3, 4.5))`` - Calls the function with an integer and a float, and prints the result.



Knowledge test
..................

* What is the purpose of the type annotations in the function definition, and how are they used?
* What is a docstring, and why is it included in the code?
* How does the code determine if ``number1`` is odd or even?
* What will be the output of the code when ``calculate_statistics(3, 4.5)`` is called?


(:doc:`Answers <week00-answers>`)


Booleans and truth tables
...............................


Booleans are a fundamental data type in programming that represents one of two values: ``True`` or ``False``. They are named after George Boole, who first defined an algebraic system of logic in the mid-1800s.

In Python, booleans are often used to represent the results of logical comparisons, such as equality or inequality tests.


.. code-block:: python

   x = 10
   y = 5
   is_greater = x > y  # Evaluates to True
   is_equal = x == y   # Evaluates to False


Truth Tables
...............

A truth table is a mathematical table used to represent the values of logical expressions based on their possible inputs. It's a systematic way to list every possible combination of truth values for a given logical operation, such as AND, OR, and NOT.

Here are the truth tables for the three basic logical operations:


.. list-table:: (A **AND** B) Truth Table: both must be true
   :widths: 25 25 50
   :header-rows: 1

   * - A
     - B
     - A AND B
   * - True
     - True
     - True
   * - True
     - False
     - False
   * - False
     - True
     - False
   * - False
     - False
     - False





.. list-table:: (A **OR**  B) Truth Table: at least one must be true
   :widths: 25 25 50
   :header-rows: 1

   * - A
     - B
     - A OR B
   * - True
     - True
     - True
   * - True
     - False
     - True
   * - False
     - True
     - True
   * - False
     - False
     - False



.. list-table:: (**NOT** A) Truth Table: reverses the truth value
   :widths: 50 50
   :header-rows: 1

   * - A
     - NOT A
   * - True
     - False
   * - False
     - True



Booleans and truth tables are fundamental to understanding logic in programming. They form the basis of conditional statements and control flow, allowing programs to make decisions and perform different actions depending on certain conditions. Understanding these concepts will enable you to write more complex and dynamic code.
### What does it mean for something to be evaluated in a boolean context: Truthiness and Falsiness

In programming, the concepts of truthiness and falsiness refer to how non-boolean values are treated when evaluated in a boolean context. Essentially, truthiness and falsiness determine how values are interpreted as ``True`` or ``False`` when used in conditions, such as in an ``if`` statement.

Truthiness and Falsiness in General
......................................

- **Truthiness**: A value is considered "truthy" if it evaluates to ``True`` in a boolean context, even if it is not explicitly the boolean value ``True``.
- **Falsiness**: Conversely, a value is considered "falsy" if it evaluates to ``False`` in a boolean context, even if it is not explicitly the boolean value ``False``.

Different programming languages have different rules for what values are considered truthy or falsy.

Truthiness and Falsiness in Python
........................................

In Python, the following values are considered falsy:

- ``None``
- ``False``
- Zero of any numeric type, such as ``0``, ``0.0``, ``0j``
- Any empty sequence, such as ``''`, ``[]``, ``()``
- Any empty mapping, such as ``{}``
- Custom objects that implement a ``__bool__()`` or ``__len__()`` method that returns ``False`` or ``0``

All other values are considered truthy.

.. code-block:: python

   if 'hello':           # Truthy, because the string is not empty
       print('True')

   if []:                # Falsy, because the list is empty
       print('True')
   else:
       print('False')

   if 42:                # Truthy, because the number is not zero
       print('True')

   if 0.0:               # Falsy, because the number is zero
       print('True')
   else:
       print('False')



Understanding truthiness and falsiness is vital for writing conditional statements and working with logical operations. It allows you to leverage non-boolean values in conditions and can lead to more concise and expressive code. However, it's essential to be aware of these rules, as unexpected truthiness or falsiness can lead to subtle bugs in a program.

Variable Naming Rules in Python
..................................

Variables are used to store data in a program, and their names should be chosen to convey meaning. In Python, the rules for naming variables are:

1. **Start with a Letter or Underscore**: Variable names must start with a letter (either uppercase or lowercase) or an underscore.
2. **Contain Only Alphanumeric Characters and Underscores**: The rest of the name can consist of letters, numbers, and underscores.
3. **Cannot Be a Reserved Word**: Python's reserved words, such as ``if``, ``for``, ``while``, cannot be used as variable names.
4. **Case-Sensitive**: Variable names are case-sensitive, so ``myVariable`` and ``myvariable`` are different.
5. **Conventions**: By convention, variable names are written in snake_case (e.g., ``my_variable``), and constants are written in UPPERCASE.

Common Data Types in Python
..............................

Python has several built-in data types that can be grouped into the following categories:

1. **Numeric Types**: Integers (`int`), Floating-Point Numbers (`float`), Complex Numbers (`complex`).
2. **Sequence Types**: Lists (`list`), Tuples (`tuple`), Ranges (`range`).
3. **Text Type**: Strings (`str`).
4. **Mapping Type**: Dictionaries (`dict`).
5. **Set Types**: Sets (`set`), Frozen Sets (`frozenset`).
6. **Boolean Type**: Boolean (`bool`), with values ``True`` or ``False``.
7. **Binary Types**: Bytes (`bytes`), Byte Arrays (`bytearray`).

Type Annotations in Python
............................

Type annotations are used to indicate the expected type of a variable, parameter, or return value. They enhance code readability and can help with error checking.

Here's how you can use type annotations for different types:

- **Integers**: ``x: int = 10``
- **Floats**: ``y: float = 5.5``
- **Strings**: ``name: str = "Alice"``
- **Lists**: ``numbers: list[int] = [1, 2, 3]``
- **Dictionaries**: ``mapping: dict[str, int] = {'a': 1}``
- **Booleans**: ``is_active: bool = True``
- **Function Parameters and Return Types**:

.. code-block:: python

  def add(x: int, y: int) -> int:
    return x + y


Understanding the rules for naming variables, the common types in Python, and how to use type annotations will enable you to write clear, expressive, and maintainable code. It's an essential foundation for programming in Python.

Introduction to Data Structures
.................................

Data structures are a way of organizing and storing data in a computer. They provide a means to manage large amounts of data efficiently for uses such as large databases and internet indexing services. In Python, two fundamental data structures are lists and dictionaries.

Lists
.......

Lists are ordered collections of items and are one of the most versatile data structures in Python. They can contain items of different types, but usually, all the items in a list are of the same type.

Dictionaries
.............

Dictionaries are unordered collections where data is stored in key-value pairs. Keys must be unique and immutable, while values can be of any type.

.. code-block:: python

  def add_to_list(lst: list, item: int) -> None:
    """Add an item to the list."""
    lst.append(item)

   def read_from_list(lst: list, index: int) -> int:
       """Read an item from the list by index."""
       return lst[index]

   def update_list(lst: list, index: int, item: int) -> None:
       """Update an item in the list by index."""
       lst[index] = item

   def delete_from_list(lst: list, index: int) -> None:
       """Delete an item from the list by index."""
       lst.pop(index)

   def create_dict() -> dict:
       """Create a new dictionary."""
       return {}

   def add_to_dict(dct: dict, key: str, value: int) -> None:
       """Add a key-value pair to the dictionary."""
       dct[key] = value

   def read_from_dict(dct: dict, key: str) -> int:
       """Read a value from the dictionary by key."""
       return dct[key]

   def update_dict(dct: dict, key: str, value: int) -> None:
       """Update a value in the dictionary by key."""
       dct[key] = value

   def delete_from_dict(dct: dict, key: str) -> None:
       """Delete a key-value pair from the dictionary by key."""
       del dct[key]



Knowledge test
..................

* What are lists and dictionaries, and how are they used in Python?
* Explain the CRUD operations performed on lists and dictionaries in the code.
* How can you handle situations where you attempt to read from or delete a non-existing index or key?
* What are some use cases for using lists and dictionaries in programming?

(:doc:`Answers <week00-answers>`)


Lists and Dictionary: Example Usage
......................................

Here's a code example for a function that takes two lists as input and creates a dictionary where the keys are from the first list and the values are from the second list. The function ensures that the lists are of the same length.


.. code-block:: python
  :linenos:

  def create_dict_from_lists(keys: list[str], values: list[int]) -> dict[str, int]:
       """Create a dictionary from two lists of equal length.
       
       Args:
           keys (list[str]): A list of keys.
           values (list[int]): A list of values.
       
       Returns:
           dict[str, int]: A dictionary with keys from the first list and values from the second list.
       """
       if len(keys) != len(values):  # Check if lists are of the same length
           raise ValueError("Keys and values must be of the same length.")
       
       result_dict = {}
       for i in range(len(keys)):  # Iterate through indices of both lists
           key = keys[i]
           value = values[i]
           result_dict[key] = value
       
       return result_dict

Dissecting the code
...........................

* **Line 1**: Function definition with type annotations for parameters and return type.
* **Lines 2-10**: Docstring explaining the purpose, parameters, and return value of the function.
* **Line 11**: An inline comment mentioning the purpose of the upcoming condition.
* **Line 12**: Checks if the lengths of the keys and values lists are the same; if not, raises a ``ValueError``.
* **Line 14**: Initializes an empty dictionary to store the result.
* **Line 15**: Uses a for loop to iterate through the indices of the keys list (and implicitly, the values list since they have the same length).
* **Line 16**: Retrieves the key from the keys list using the current index.
* **Line 17**: Retrieves the value from the values list using the current index.
* **Line 18**: Assigns the value to the corresponding key in the result dictionary.
* **Line 20**: Returns the created dictionary.



Knowledge test
..................

1. What is the purpose of the ``create_dict_from_lists`` function, and how does it ensure that the input lists are of the same length?
2. How does the ``for`` loop work in this code, and how are the keys and values retrieved using the index?
3. What error will be raised if the input lists have different lengths, and how can it be handled?
4. How would you write a test case to verify that the function works correctly with valid input lists?

(:doc:`Answers <week00-answers>`)



Unit tests and loops
.......................


In this final section we'll introduce loops (although you got a sneak peak last section to the _for_ loop) and unit tests. We'll also showcase the test() function you'll use in future homework and lab assignments.

.. code-block:: python

  import sys

   def test(did_pass):
       """Print the result of a test."""
       linenum = sys._getframe(1).f_lineno
       msg = "Test at line {0} {1}.".format(linenum, "ok" if did_pass else "FAILED")
       print(msg)

   def factorial(n: int) -> int:
       """Calculate the factorial of a non-negative integer.
       
       Args:
           n (int): A non-negative integer.
       
       Returns:
           int: The factorial of n.
       """
       result = 1
       for i in range(1, n + 1):  # For loop to iterate through the range
           result *= i
       return result

   def count_odds(numbers: list[int]) -> int:
       """Count the number of odd numbers in a list.
       
       Args:
           numbers (list[int]): A list of integers.
       
       Returns:
           int: The count of odd numbers in the list.
       """
       count = 0
       i = 0
       while i < len(numbers):  # While loop to iterate through the list
           if numbers[i] % 2 == 1:
               count += 1
           i += 1
       return count

   def test_suite():
       """Run the suite of tests for code in this module (this file)."""
       test(factorial(5) == 120)
       test(factorial(0) == 1)
       test(count_odds([1, 2, 3, 4, 5]) == 3)
       test(count_odds([2, 4, 6]) == 0)

   test_suite()  # Here is the call to run the tests


Dissecting the code
........................

* **Line 1**: Imports the ``sys`` module, needed to obtain the line number of the calling code in the test function.
* **Lines 3-7**: Defines the ``test`` function, which takes a boolean and prints a success or failure message, including the line number of the test.
* **Lines 9-21**: Defines the ``factorial`` function, which calculates the factorial of a non-negative integer using a ``for`` loop. The docstring and type annotations provide details about the function.
* **Lines 23-38**: Defines the ``count_odds`` function, which counts the number of odd numbers in a list using a ``while`` loop.
* **Lines 40-46**: Defines the ``test_suite`` function, which runs a series of tests to verify the functionality of the ``factorial`` and ``count_odds`` functions.
* **Line 48**: Calls the ``test_suite`` function to run the tests.


Knowledge test
..................


1. What is the purpose of the ``test`` function, and how does it obtain the line number of the calling code?
2. Explain the use of the ``for`` loop in the ``factorial`` function.
3. Describe how the ``count_odds`` function uses a ``while`` loop to achieve its goal.
4. What are the benefits of including docstrings and type annotations in the functions?
5. How can you write a test to verify that the ``factorial`` function returns an error for negative input?

(:doc:`Answers <week00-answers>`)


