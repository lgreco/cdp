:orphan:

The keyword ``this``
---------------------

Newcomers to Java are often confused by the keyword ``this`` and its use. Let's consider a simple Java class:

.. code-block:: java

   class City {
     String name;
     int population;
   }


For simplicity's sake, I am omitting access modifiers such as ``public`` and ``private`` in these examples. Members of this class can be instantiated like so:


.. code-block:: java

   City chicago = new City();
   City milwaukee = new City();
   

and assigned values as follows:


.. code-block:: java

   chicago.name = "Chicago";
   chicago.population = 2_699_000;
   milwaukee.name = "Milwaukee";
   milwaukee.population = 592_649;


Now imagine a method that compares one city to another and returns ``true`` if the first city is more populous than the second city. For example, ``morePopulousThan(chicago, milwaukee)`` will return true. A simple implementation of the method is below.


.. code-block:: java
     
   boolean morePopulousThan(City first, City second) {
     return first.population > second.population;
   }


The method above works fine and yet there may be a reason to write it differently. We may want to give objects of the ``City`` class the ability to compare themselves with other objects of their class. This ability provides a *natural* way for an object to assert its relation to another object of the same class. For example, the object ``chicago`` could answer the question "am I more populous than the ``milwaukee`` object?", in the following fashion:

.. code-block:: java
   
   amI.morePopulousThan(milwaukee);


Using this personalized approach, the method ``morePopulousThan`` can be rewritten, in the fictitious FriedlyJava language, as:


.. code-block:: java

   boolean amI.morePopulousThan(other City) {
     // if my population is more than the other city's, yes I am!
     return my.population > other.population;
   }


To give every object in class ``City`` the ability to tell if they are more populous than other objects, we need to write ``morePopulousThan(City other)`` as a class method. This way the method becomes part of every ``City`` object's behavior. Since this method is part of every object, we don't need to ask explicitly "am I?", so we can drop that designation from the beginning of the method name. And instead of the adjective "my", Java wants us to use the keyword ``this``:


.. code-block:: java

   boolean morePopulousThan(City other) {
     return this.population > other.population;
   }













