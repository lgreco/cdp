:orphan:

Answers to knowledge test
..........................

Did you take a chance to think about the questions in advanced? If you didn't you're only cheating yourself. Learning takes time. Give yourself the time to succeed.

**What does the ``def`` keyword do in Python?**
  Answer: The ``def`` keyword is used to define a new function in Python. It marks the beginning of a function declaration.

**What is the purpose of the ``print`` statement in the code?**
  Answer: The ``print`` statement outputs the text within the parentheses to the console. In this case, it prints the string "hello world!".

**How would you describe the function's name and its naming convention?**
  Answer: The function's name is ``hello_world`, and it follows the snake_case naming convention where all letters are lowercase, and words are separated by underscores.

**What does the ``hello_world`` function do when it is called?**
  Answer: When called, the ``hello_world`` function prints the text "hello world!" to the console.

**How many parameters does the ``hello_world`` function take? Can you explain what a parameter is?**
  Answer: The ``hello_world`` function takes no parameters. A parameter is an input that a function can accept when called. It allows the function to receive data from outside and use it within the function.

**What will be the output of the code when it is run?**
  Answer: The output of the code will be the text "hello world!" printed to the console.

**In what order are the lines of code executed?**
  Answer: The lines are executed in the order they appear: the function is defined first (lines 1-2), and then it is called (line 4).

**Why is indentation important in defining the body of a function?**
  Answer: Indentation in Python is used to define the scope of code blocks, such as the body of a function. It shows what lines of code are part of the function and distinguishes them from the rest of the code.

**What is the significance of the colon ``:`` at the end of the function definition?**
  Answer: The colon ``:`` marks the beginning of the function's body. It signifies that the following indented lines are part of the function.

**Can you write a similar function that prints a different message?**

Answer: Yes, here's an example:

.. code-block:: python

  def greetings():
    print("Hi there!")

**How would you modify the ``hello_world`` function to take a name as a parameter and print "Hello, [name]!"?**
  Answer: You can add a parameter and use it in the print statement:

.. code-block:: python

  def greetings(name):
    print("Hi there!")
    print(f"Hello, {name}!")

**What would happen if you removed the indentation from line 2? Why?**
  Answer: Removing the indentation would cause a syntax error because Python uses indentation to determine the scope of code blocks, such as the body of a function.

**What would happen if you tried to call the ``hello_world`` function before defining it?**
  Answer: Calling the function before defining it would result in a ``NameError`, as Python would not recognize the name ``hello_world`` at the point where the function is called.



**What is the output of the code when ``check_age(20)`` is called?**
   Answer: The output will be:
     ```
     Age provided: 20
     You are an adult.
     Is adult? True
     Is teenager? False
     ```

**How would the output change if the age provided was 15?**
   - Answer: The output would indicate that the person is a teenager, with ``is_adult`` being ``False`` and ``is_teenager`` being ``True``.

**What are the boolean variables ``is_adult`` and ``is_teenager`, and how are they used in the code?**
   - Answer: They store the result of boolean expressions and are used in the ``if`` statement to determine the message to print.

**Can you write a similar function that checks and prints whether a number is positive, negative, or zero?**
   - Answer: *This is a homework question for this week*

* **What is the purpose of the type annotations in the function definition, and how are they used?**
  - Answer: Type annotations indicate the expected data types for the function's parameters (``number1`` as ``int``, ``number2`` as ``float``) and its return value (``str``). They enhance code readability and allow tools to provide better analysis and error checking.

* **What is a docstring, and why is it included in the code?**
  - Answer: A docstring is a multiline comment used to explain the purpose, parameters, and return value of a function. It serves as documentation and helps others understand the function's usage.

* **How does the code determine if ``number1`` is odd or even?**
  - Answer: The code uses the modulo operator ``%`` to divide ``number1`` by 2 and check the remainder. If the remainder is 1, ``number1`` is odd; otherwise, it's even.

* **What will be the output of the code when ``calculate_statistics(3, 4.5)`` is called?**
  - Answer:
    ```
    Sum of 3 and 4.5: 7.5
    Product of 3 and 4.5: 13.5
    3 is odd
    ```


**What are lists and dictionaries, and how are they used in Python?**
   - Answer: Lists are ordered collections of items, and dictionaries are unordered collections of key-value pairs. Lists are used for storing elements sequentially, while dictionaries provide a way to associate keys with values.

**Explain the CRUD operations performed on lists and dictionaries in the code.**
   - Answer: CRUD operations include Create, Read, Update, and Delete. For lists, items can be added (created) with ``append`, read by index, updated by index, and deleted with ``pop`. For dictionaries, key-value pairs can be created, read, updated, or deleted using key indexing.

**How can you handle situations where you attempt to read from or delete a non-existing index or key?**
   - Answer: You can use exception handling, such as try-except blocks, to catch ``IndexError`` for lists or ``KeyError`` for dictionaries. This allows graceful handling of errors when accessing non-existing indices or keys.

**What are some use cases for using lists and dictionaries in programming?**
   - Answer: Lists are commonly used to store and iterate through ordered data, such as elements in a sequence. Dictionaries are used for mapping keys to values, such as storing configuration settings or representing a sparse matrix.


**What is the purpose of the ``create_dict_from_lists`` function, and how does it ensure that the input lists are of the same length?**
   - Answer: The function's purpose is to create a dictionary using two lists, where the first list provides the keys and the second list provides the values. It ensures that the lists are of the same length by checking their lengths using ``len(keys) != len(values)`` and raising a ``ValueError`` if they differ.

**How does the ``for`` loop work in this code, and how are the keys and values retrieved using the index?**
   - Answer: The ``for`` loop iterates through the indices of the keys list using ``range(len(keys))`. Inside the loop, the keys and values are retrieved using the current index ``i`, with ``key = keys[i]`` and ``value = values[i]`. The key-value pairs are then added to the result dictionary.

**What error will be raised if the input lists have different lengths, and how can it be handled?**
   - Answer: If the input lists have different lengths, a ``ValueError`` with the message "Keys and values must be of the same length" will be raised. This error can be handled by enclosing the function call in a try-except block that catches this specific error, allowing for graceful error handling.

**How would you write a test case to verify that the function works correctly with valid input lists?**
   - Answer: A test case could involve calling the function with two lists of the same length, such as ``keys = ['a', 'b']`` and ``values = [1, 2]`, and verifying that the returned dictionary is ``{'a': 1, 'b': 2}`. Another test case could include providing lists of different lengths to ensure that the appropriate ``ValueError`` is raised.



**What is the purpose of the ``test`` function, and how does it obtain the line number of the calling code?**
   - Answer: The ``test`` function prints the result of a test (either "ok" or "FAILED"), including the line number where the test was called. It obtains the line number using ``sys._getframe(1).f_lineno`.

**Explain the use of the ``for`` loop in the ``factorial`` function.**
   - Answer: The ``for`` loop in the ``factorial`` function iterates from 1 to ``n`, multiplying the ``result`` variable by each number in the range. This calculates the factorial of ``n`.

**Describe how the ``count_odds`` function uses a ``while`` loop to achieve its goal.**
   - Answer: The ``count_odds`` function uses a ``while`` loop to iterate through the list of numbers. It checks if each number is odd (using the modulo operator ``%`) and increments the count if it is.

**What are the benefits of including docstrings and type annotations in the functions?**
   - Answer: Docstrings provide a detailed description of the function's purpose, parameters, and return value, enhancing code readability. Type annotations indicate the expected types for parameters and return values, aiding in code understanding and
error checking.

**How can you write a test to verify that the ``factorial`` function returns an error for negative input?**
   - Answer: A test for negative input could involve using a try-except block to call the ``factorial`` function with a negative argument and verifying that an expected error is raised.
