:orphan:

Traversing in sequence
---------------------------------------------------


The easiest way to traverse an array, maybe to print its elements, is to write a for-loop as follows.

.. code-block:: java

   for (int i = 0; i < a.length; i++)
     System.out.println(a[i]);
     

We can rewrite this traversal in a rather verbose, yet illustrative, manner:

.. code-block:: java

   int head = 0;                     // the starting position
   int current = head;               // initialize cursor
   while (current+1 < a.length) {    // repeat while there are elements
     System.out.println(a[current])  // print element
     current = current+1;            // advance cursor to next element
   }

We can even write these little, cutesy functions 

.. code-block:: java

   boolean hasNext(int current) { 
     return current+1 < a.length; 
   }
   
   int getNext(int current) { 
     return current+1; 
   }

and place them in our code:

.. code-block:: java

   int head = 0;                     // the starting position
   int current = head;               // initialize cursor
   while (hasNext(current)) {        // repeat while there are elements
     System.out.println(a[current])  // print an element
     current = getNext(current);     // advance cursor to next element
   }

Preposterous as the code above may be, it illustrates the traversal of an array, in full detail. It also allows us to get a better understanding of sequential traversal.

A sequential traversal moves from one item to another, based on our knowledge about the structure of the sequence. In an array with :math:`n` elements, the structure of the sequence is described by the array index: we traverse the elements from the first element (at position index 0) to the last element (at position index :math:`n-1`). The transition from one item in the sequence to another is based on obtaining the next position index, as long as there is one.

In a linked list, the structure of the sequence is encoded in its nodes. The node is an object that can be as simple as:

.. code-block:: java

   class Node {
     String data;
     Node next;
   }

Then we add nodes one after another, forming a chain (that we call linked list). The linked list is defined only by its starting node that we call ``head``. Everything else can be accessed through that node.

.. code-block:: java

   class LinkedList {
     Node head;
   }

Much like an integer index for an array that points to the next position (by adding 1 to itself), a node in a linked list points to the next node.


.. figure:: images/linkedList.png
   :scale: 50%
   :align: center
   
   A simple linked list with :math:`n` nodes.

And so the traversal becomes very similar to that of an array. In an array, we start with its first element (given by position index 0). In a linked list, we start from its first node, which is called ``head``.

.. code-block:: java

   Node current = head;                // initialize cursor
   while (hasNext(current)) {          // repeat while there are elements
     System.out.println(current)       // prints the node
     current = getNext(current);       // advance cursor to next element
   }

Methods ``hasNext`` and ``getNext`` above are different than those we used for the array traversal:

.. code-block:: java

   boolean hasNext(int current) { 
     return current.next != null; 
   }
   
   int getNext(int current) { 
     return current.next; 
   }

Using classes ``Node`` and ``LinkedList`` above, we can build a simple linked list as an example:

.. code-block:: java

   Node chi = new Node(); // Create node object called chi
   Node smt = new Node(); // Create node object called smt
   Node jol = new Node(); // Create node object called jol
   Node dwi = new Node(); // Create node object called dwi
   
   chi.data = "Chicago";  // Assign value to chi's data string
   smt.data = "Summit";   // Assign value to smt's data string
   jol.data = "Joliet";   // Assign value to jol's data string
   dwi.data = "Dwight";   // Assign value to dwi's data string
   
   chi.next = smt;        // Assign smt as chi's next node
   smt.next = jol;        // Assign jol as smt's next node
   jol.next = dwi;        // Assign dwi as jol's next node

For the code above, we dropped the requirement that all class fields must be private, to keep the example simple. If the Node fields were private and we had a basic constructor:

.. code-block:: java

   public Node(String data) { this.data = data; }


the code would be as follows.


.. code-block:: java

   Node chi = new Node("Chicago"); // Create node object called chi and assign string field
   Node smt = new Node("Summit");  // Create node object called smt and assign string field
   Node jol = new Node("Joliet");  // Create node object called jol and assign string field
   Node dwi = new Node("Dwight");  // Create node object called dwi and assign string field
   
   chi.setNExt(smt);               // Assign smt as chi's next node
   smt.setNExt(jol);               // Assign jol as smt's next node
   jol.setNExt(dwi);               // Assign dwi as jol's next node



