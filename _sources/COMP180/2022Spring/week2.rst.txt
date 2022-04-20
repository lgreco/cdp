:orphan:




Variables
============

Variables are nicknames for data. Data can be numbers, sequences of symbols (letters *are* symbols), images, etc. For example can have a variable for the year a person was born

.. code-block:: python

   birth_year = 2000

A variable has two parts, two components: its name and its content. In the example above, ``birth_year`` is the name of the variable. The content, in the example above, is ``2000``. 

Variable names can be descriptive, as in the example above, or obscure like ``y=2000``. There was a time when programmers had to work with really annoying limits regarding the names of variables. This is no longer the case: we can name a variable just about anything we want to. There are still a few restrictions, but as long as a variable name doesn't begin with a number or a silly symbol like an exclamation point, the sky is the limit. For example, ``yob``, ``year_of_birth``, ``birthYear``, ``yearThis_person_was_Born``, are all valid names. 

Naming variables is one of the hardest thing in computing. Thankfully, there are style guides for just about every language, including `Python <https://google.github.io/styleguide/pyguide.html#316-naming>`__. The important thing to remember is that, in Python, we prefer to name variables using lower-case letters with words separated by underscores.

Variables and memory
--------------------

When we write on a piece of paper a simple expression like :math:`x=2`, we use a the paper as a storage device. Indeed, prior to computers, paper, in the form of books, was humanity's main information storage. And on that piece of paper we commit variable :math:`x` to hold the value 2. And so in programming we use variables to store information. These variable are, in fact, locations in memory where the information is stored. A mechanical equivalent of variables is apartment numbers in a building. Over time, different tenants live in those apartments, but the apartment number (essentially, the name of the apartment) remains the same. Same with classrooms on campus. Cuneo Hall Room 218, abbreviated as CH218 is like a variable. Its contents vary over time.

Variables and data types
------------------------

In most programming languages, variables come with restrictions. In Java, for example, we must tell upfront what kind of data a variable will hold:

.. code-block:: java

   int numberOfApples;
   numberOfApples = 3.5;  // This will cause a compilation error

Any attempts to assign a non-integer value to this variable will result to a compilation error, i.e., the program cannot be accepted for further processing. 

Python is a bit more forgiving that Java. In Python, the type of the variable changes as needed through the program (technically, this makes Python a dynamically typed language). For example,

.. code-block:: python

   number_of_apples = 3
   number_of_apples = 3.2  # same variable, different data type
   
Both approaches have their advantages and disadvantages. For now, we'll enjoy the flexibility that Python offers, and we will not worry (much) about any restrictions on the range of values a variable can take.

Kinds of variables
------------------

Most programming languages support at least two kinds of numbers: integers and real numbers. Python is no exception to that. In addition to numbers, Python supports strings, sequences of alphanumeric characters, like names, email addresses, etc. For example:

.. code-block:: python

   first_name = "John"
   last_name = "Smith"
   email_address = "JSmith@UnderWaterBasketWeaving.com"  # this may not be a real address
   string = "string"
   john = "first_name"
   
are all legal variable names and legal string contents in Python. Some of these variables and assignments are meaningless of course. It is more likely to see a variable called ``first_name`` than a variable called ``john``. Nothing, but common sense, prevents such variable names.

Assignment of variables
-----------------------------------

Variables get their value through the assignment operator. That operator is identical to the equal sign (``=``). Prior to taking a programming course, most people have seen and used the equal sign in mathematical expressions like :math:`a=b`. In mathematics, "=" means that the variables on both sides are the same. By writing :math:`a=b` we state a fact, a certainty, that :math:`a` is the same as :math:`b`.

In programming, the symbol "=" is called the *assignment operator*. When we write an assignment expression

.. code-block:: python

   a = 12
   
we are *not* expressing the certainty that ``a`` is equal to 12, but that the value 12 is assigned to variable ``a``, even if the variable held a different value previously. Assignments can be direct and simple like the one above. Or more complicated like the one below:

.. code-block:: python

   a = b + c + d
   
where ``a``, ``b``, and ``c`` are also variables.

The following expression is also a valid (and very useful) assignment:

.. code-block:: python

   a = a + 1
   
It translates to the following operation: add 1 to the *current* value of ``a`` and *then* assign that quantity to variable ``a``.

This operation takes place in three steps: first, the value of variable ``a`` is moved from the memory (let's say that the value of ``a`` is 10). Second, the number one is added to that value of ``a`` and the sum is evaluated to 11. And third the new value, 11, is pushed back into the memory location for ``a``. This three-step process is a simplified description of what actually happens. In reality there are a few more steps involved, but are beyond the scope of this discussion. 

Why do we need integer and real numbers?
-----------------------------------------

Mathemagicians tell us that integer numbers are part of the set of real numbers. So if a machine can handle real numbers then, mathematically, it can also handle integer numbers. Why, then, programming languages separate these two kinds of numbers? Primarily, for two reasons. 

First, integer numbers are very useful for counting indivisible items, e.g., people waiting in line, seats in a theater, books on a shelf, etc. Second, because storing an integer number is technically less demanding than storing a real number. 

Computer programs do a lot of counting. It make sense to have a more efficient and economical way to keep track of that counting. That's why we separate between integers and real numbers in programming, even though mathematically integers *are* real numbers.

Counting from Zero
------------------

Some time in the 1930s, comedians Bud Abbott and Lou Costello popularized a skit that came to be known as *Who's on first?*  Lou wants to join  Bud's baseball team, the fictitious St. Louis Wolves. And Bud begins to describe the team's players and positions. Their exchange goes like this:

- Abbott: [...] Well, let's see, we have on the bags, Who's on first, What's on second, I Don't Know is on third...

- Costello: That's what I want to find out.

- Abbott: I say Who's on first, What's on second, I Don't Know's on third.

- Costello: Are you the manager?

- Abbott: Yes.

- Costello: You gonna be the coach too?

- Abbott: Yes.

- Costello: And you don't know the fellows' names?

- Abbott: Well I should.

- Costello: Well then who's on first?

- Abbott: Yes.

- Costello: I mean the fellow's name.

- Abbott: Who.

- Costello: The guy on first.

- Abbott: Who.

- Costello: The first baseman.

- Abbott: Who.

- Costello: The guy playing...

- Abbott: Who is on first!

- Costello: I'm asking YOU who's on first.

And the skit goes on to even more bizarre and hilarious interplay between names and pronouns. The two characters seem to be out of sync. Of course it's more funny to watch or listen to it than to read the script.

Counting in computer programs feels a little bit like the *Who's on first* skit. As the figure below shows, the first person is line is not the "number one" person. In fact, the "number one" person, is the second person in line. Who's on first? It's the number zero.



.. figure:: ../figures/zeroBasedCounting.png
   :align: center
   
   Counting as humans (1st, 2nd, etc) and counting as computers (0, 1, etc)



In most programming languages, including Python, we begin counting from zero. 

There is a an apocryphal story about the origin of this practice. In the 1950s, IBM donated a powerful computer to MIT. There were strings attached to the gift. Every time IBM's CEO Thomas J. Watson Jr. wanted to take his sailboat *Palawan* out for a race, MIT had to run a special program on the donated computer. The program computed the best possible sail configuration to win the race, given the weather conditions at the boat's location. Whatever other program was running on the computer at the time the call from IBM came, had to be dropped. Back then, even powerful computers were slow. It took hours, even days, for programs to complete. The computer could execute one program at a time. The dropped program had to go to the back of the line and wait days before getting a chance to be executed again. It was in the programmers' best interest to have their program complete as fast as possible, lest the dreaded call for another sailboat race came in. And so -- goes the story -- the programming language, BCPL, was modified to start counting from zero to match the hardware architecture of the computer. That, presumably, sped things up.

In 1982, `Edsger W. Dijkstra <https://en.wikipedia.org/wiki/Edsger_W._Dijkstra>`__ offered a more nuanced justification for 0-based counting. After examining different ways to enumerate things, he wrote:

    *an element's ordinal (subscript) equals the number of elements preceding it in the sequence.*
    (`EWD paper 831 <https://www.cs.utexas.edu/users/EWD/ewd08xx/EWD831.PDF>`__)

The ordinal is the number defining the position of an item. And so, the first person in line is assigned the ordinal 0 because that's how many people are ahead in line. The second person is assigned the ordinal 1, because there is one person in front of them, and so on.
